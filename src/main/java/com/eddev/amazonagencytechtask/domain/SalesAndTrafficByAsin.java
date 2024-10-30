package com.eddev.amazonagencytechtask.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class SalesAndTrafficByAsin implements Serializable {

    private String parentAsin;
    private SalesByAsin salesByAsin;
    private TrafficByAsin trafficByAsin;

}
