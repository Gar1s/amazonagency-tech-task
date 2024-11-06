package com.eddev.amazonagencytechtask.controller;

import com.eddev.amazonagencytechtask.domain.SalesAndTrafficByAsin;
import com.eddev.amazonagencytechtask.domain.SalesAndTrafficByDate;
import com.eddev.amazonagencytechtask.service.StatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/statistics")
public class StatisticController {

    private final StatisticService statisticService;

    @GetMapping("/sales-and-traffic-by-date")
    public ResponseEntity<List<SalesAndTrafficByDate>> getByDate(@RequestParam(required = false) String startDate,
                                                                 @RequestParam(required = false) String endDate) {
        return ResponseEntity.ok(statisticService.findByDates(startDate, endDate));
    }

    @GetMapping("/sales-and-traffic-by-date/{date}")
    public ResponseEntity<SalesAndTrafficByDate> getByDate(@PathVariable String date) {
        return ResponseEntity.ok(statisticService.findByDate(date));
    }

    @GetMapping("/sales-and-traffic-by-asin")
    public ResponseEntity<List<SalesAndTrafficByAsin>> getByAsin(@RequestParam(value = "asin") List<String> asins) {
        return ResponseEntity.ok(statisticService.findByAsins(asins));
    }

    @GetMapping("/total-date")
    public ResponseEntity<SalesAndTrafficByDate> getAllByDate(){
        return ResponseEntity.ok(statisticService.supUpAllByDate());
    }

    @GetMapping("/total-asin")
    public ResponseEntity<SalesAndTrafficByAsin> getAllByAsin(){
        return ResponseEntity.ok(statisticService.supUpAllByAsin());
    }

}
