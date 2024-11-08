package com.eddev.amazonagencytechtask.utils;

import com.eddev.amazonagencytechtask.domain.Statistic;
import com.eddev.amazonagencytechtask.repository.StatisticRepository;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataScheduler {

    private final StatisticRepository statisticRepository;
    private final CacheManager cacheManager;

    @Scheduled(cron = "* */5 * * * *")
    public void dataScheduler() {
        Statistic statistic;
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream("src/main/resources/data/test_report.json");
            JsonReader reader = new JsonReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            Gson gson = new Gson();
            statistic = gson.fromJson(reader, Statistic.class);
            statistic.setId("672d1c555554612028e90379");

            if(!cacheManager.getCacheNames().isEmpty()){
                cacheManager.getCacheNames()
                        .parallelStream()
                        .forEach(n -> Objects.requireNonNull(cacheManager.getCache(n)).clear());
            }

            statisticRepository.save(statistic);
            log.info("Scheduled every 10 sec!");

        } catch (IOException e) {
            throw new RuntimeException("Error reading JSON file", e);

        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error("Error closing InputStream", e);
                }
            }
        }

    }
}
