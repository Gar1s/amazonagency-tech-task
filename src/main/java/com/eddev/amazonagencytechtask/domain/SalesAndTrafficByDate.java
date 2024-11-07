package com.eddev.amazonagencytechtask.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class SalesAndTrafficByDate implements Serializable {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;
    private SalesByDate salesByDate;
    private TrafficByDate trafficByDate;

    public SalesAndTrafficByDate add(SalesAndTrafficByDate other){
        if(this.salesByDate == null) {
            this.salesByDate = other.salesByDate;
        } else {
            this.salesByDate.add(other.salesByDate);
        }
        if(this.trafficByDate == null){
            this.trafficByDate = other.trafficByDate;
        } else {
            this.trafficByDate.add(other.trafficByDate);
        }
        return this;
    }

    public void sum(int divideBy){
        this.salesByDate.sum(divideBy);
        this.trafficByDate.sum(divideBy);
    }

}
