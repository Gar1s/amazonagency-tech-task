package com.eddev.amazonagencytechtask.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

@Data
public class SalesAndTrafficByDate implements Serializable {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;

}
