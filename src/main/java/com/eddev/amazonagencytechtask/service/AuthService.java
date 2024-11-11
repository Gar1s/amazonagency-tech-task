package com.eddev.amazonagencytechtask.service;


import com.eddev.amazonagencytechtask.domain.user.Role;
import com.eddev.amazonagencytechtask.domain.user.User;
import com.eddev.amazonagencytechtask.dto.AuthDto;
import com.eddev.amazonagencytechtask.exception.UsernameAlreadyExistsException;
import com.eddev.amazonagencytechtask.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    private final SecurityContextRepository securityContextRepository =
            new HttpSessionSecurityContextRepository();
    private final SecurityContextHolderStrategy securityContextHolderStrategy =
            SecurityContextHolder.getContextHolderStrategy();

    public void signUp(AuthDto authDto) {
        var existingUser = userRepository.findByUsername(authDto.username());
        if (existingUser.isPresent()) {
            throw new UsernameAlreadyExistsException(authDto.username());
        }
        var user = new User();
        user.setUsername(authDto.username());
        user.setPassword(passwordEncoder.encode(authDto.password()));
        user.setRole(Role.USER);
        userRepository.save(user);
    }

    public void signIn(AuthDto authDto, HttpServletRequest request, HttpServletResponse response) {
        var existingUser = userRepository.findByUsername(authDto.username())
                .orElseThrow(() -> new UsernameNotFoundException("User not found by username: " + authDto.username()));
        if (!passwordEncoder.matches(authDto.password(), existingUser.getPassword())) {
            throw new BadCredentialsException("Password is incorrect!");
        }

        UsernamePasswordAuthenticationToken token = UsernamePasswordAuthenticationToken.unauthenticated(
                authDto.username(), authDto.password());
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContext context = securityContextHolderStrategy.createEmptyContext();
        context.setAuthentication(authentication);
        securityContextHolderStrategy.setContext(context);
        securityContextRepository.saveContext(context, request, response);
    }


}
