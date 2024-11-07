package com.eddev.amazonagencytechtask.service;

import com.eddev.amazonagencytechtask.domain.SalesAndTrafficByAsin;
import com.eddev.amazonagencytechtask.domain.SalesAndTrafficByDate;
import com.eddev.amazonagencytechtask.repository.StatisticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticService {

    private final StatisticRepository statisticRepository;

    @Cacheable(value = "findByDateCache")
    public SalesAndTrafficByDate findByDate(String date) {
        return statisticRepository.findStatisticBySalesAndTrafficByDate(date)
                .orElseThrow();
    }

    @Cacheable(value = "findByDatesCache")
    public List<SalesAndTrafficByDate> findByDates(String startDate, String endDate) {
        if(startDate == null && endDate == null){
            return statisticRepository.findAllSalesAndTrafficByDate()
                    .orElseThrow();
        }
        LocalDate first = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate second = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        if(!second.isAfter(first)){
            throw new RuntimeException();
        }
        return statisticRepository.findStatisticBySalesAndTrafficByDates(startDate, endDate)
                .orElseThrow();
    }

    @Cacheable(value = "findByAsinsCache")
    public List<SalesAndTrafficByAsin> findByAsins(List<String> asins) {
        return statisticRepository.findStatisticBySalesAndTrafficByAsins(asins)
                .orElseThrow();
    }

    @Cacheable(value = "totalDateCache")
    public SalesAndTrafficByDate supUpAllByDate() {
        var list = statisticRepository.findAllSalesAndTrafficByDate()
                .orElseThrow();
        SalesAndTrafficByDate result = new SalesAndTrafficByDate();
        for (var l : list){
            result.add(l);
        }
        result.sum(list.size());
        return result;
    }

    @Cacheable(value = "totalAsinCache")
    public SalesAndTrafficByAsin supUpAllByAsin() {
        var list = statisticRepository.findAllSalesAndTrafficByAsin()
                .orElseThrow();
        SalesAndTrafficByAsin result = new SalesAndTrafficByAsin();
        for (var l : list){
            result.add(l);
        }
        result.sum(list.size());
        return result;
    }

}
