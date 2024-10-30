package com.eddev.amazonagencytechtask.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class TrafficByAsin implements Serializable {

    private Integer browserSessions;
    private Integer browserSessionsB2B;
    private Integer mobileAppSessions;
    private Integer mobileAppSessionsB2B;
    private Integer sessions;
    private Integer sessionsB2B;
    private BigDecimal browserSessionPercentage;
    private Integer browserSessionPercentageB2B;
    private BigDecimal mobileAppSessionPercentage;
    private Integer mobileAppSessionPercentageB2B;
    private BigDecimal sessionPercentage;
    private Integer sessionPercentageB2B;
    private Integer browserPageViews;
    private Integer browserPageViewsB2B;
    private Integer mobileAppPageViews;
    private Integer mobileAppPageViewsB2B;
    private Integer pageViews;
    private Integer pageViewsB2B;
    private BigDecimal browserPageViewsPercentage;
    private Integer browserPageViewsPercentageB2B;
    private BigDecimal mobileAppPageViewsPercentage;
    private Integer mobileAppPageViewsPercentageB2B;
    private BigDecimal pageViewsPercentage;
    private Integer pageViewsPercentageB2B;
    private Integer buyBoxPercentage;
    private Integer buyBoxPercentageB2B;
    private BigDecimal unitSessionPercentage;
    private Integer unitSessionPercentageB2B;

}
