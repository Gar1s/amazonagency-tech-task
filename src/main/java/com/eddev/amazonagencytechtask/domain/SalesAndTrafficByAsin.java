package com.eddev.amazonagencytechtask.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class SalesAndTrafficByAsin implements Serializable {

    private String parentAsin;
    private SalesByAsin salesByAsin;
    private TrafficByAsin trafficByAsin;

    public void add(SalesAndTrafficByAsin other) {
        if(this.salesByAsin == null){
            this.salesByAsin = other.getSalesByAsin();
        } else {
            this.salesByAsin.add(other.getSalesByAsin());
        }
        if(this.trafficByAsin == null){
            this.trafficByAsin = other.getTrafficByAsin();
        } else {
            this.trafficByAsin.add(other.getTrafficByAsin());
        }
    }

    public void sum(int dividedBy) {
        this.salesByAsin.sum(dividedBy);
        this.trafficByAsin.sum(dividedBy);
    }
}
