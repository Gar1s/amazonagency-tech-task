package com.eddev.amazonagencytechtask.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
public class TrafficByAsin implements Serializable {

    private Integer browserSessions;
    private Integer browserSessionsB2B;
    private Integer mobileAppSessions;
    private Integer mobileAppSessionsB2B;
    private Integer sessions;
    private Integer sessionsB2B;
    private BigDecimal browserSessionPercentage;
    private BigDecimal browserSessionPercentageB2B;
    private BigDecimal mobileAppSessionPercentage;
    private BigDecimal mobileAppSessionPercentageB2B;
    private BigDecimal sessionPercentage;
    private BigDecimal sessionPercentageB2B;
    private Integer browserPageViews;
    private Integer browserPageViewsB2B;
    private Integer mobileAppPageViews;
    private Integer mobileAppPageViewsB2B;
    private Integer pageViews;
    private Integer pageViewsB2B;
    private BigDecimal browserPageViewsPercentage;
    private BigDecimal browserPageViewsPercentageB2B;
    private BigDecimal mobileAppPageViewsPercentage;
    private BigDecimal mobileAppPageViewsPercentageB2B;
    private BigDecimal pageViewsPercentage;
    private BigDecimal pageViewsPercentageB2B;
    private BigDecimal buyBoxPercentage;
    private BigDecimal buyBoxPercentageB2B;
    private BigDecimal unitSessionPercentage;
    private BigDecimal unitSessionPercentageB2B;

    public void add(TrafficByAsin other) {
        this.browserSessions += other.getBrowserSessions();
        this.browserSessionsB2B += other.getBrowserSessionsB2B();
        this.mobileAppSessions += other.getMobileAppSessions();
        this.mobileAppSessionsB2B += other.getMobileAppSessionsB2B();
        this.sessions += other.getSessions();
        this.sessionsB2B += other.getSessionsB2B();
        this.browserSessionPercentage = this.browserSessionPercentage.add(other.getBrowserSessionPercentage());
        this.browserSessionPercentageB2B = this.browserSessionPercentageB2B.add(other.getBrowserSessionPercentageB2B());
        this.mobileAppSessionPercentage = this.mobileAppSessionPercentage.add(other.getMobileAppSessionPercentage());
        this.mobileAppSessionPercentageB2B = this.mobileAppSessionPercentageB2B.add(other.getMobileAppSessionPercentageB2B());
        this.sessionPercentage = this.sessionPercentage.add(other.getSessionPercentage());
        this.sessionPercentageB2B = this.sessionPercentageB2B.add(other.getSessionPercentageB2B());
        this.browserPageViews += other.getBrowserPageViews();
        this.browserPageViewsB2B += other.getBrowserPageViewsB2B();
        this.mobileAppPageViews += other.getMobileAppPageViews();
        this.mobileAppPageViewsB2B += other.getMobileAppPageViewsB2B();
        this.pageViews += other.getPageViews();
        this.pageViewsB2B += other.getPageViewsB2B();
        this.browserPageViewsPercentage = this.browserPageViewsPercentage.add(other.getBrowserPageViewsPercentage());
        this.browserPageViewsPercentageB2B = this.browserPageViewsPercentageB2B.add(other.getBrowserPageViewsPercentageB2B());
        this.mobileAppPageViewsPercentage = this.mobileAppPageViewsPercentage.add(other.getMobileAppPageViewsPercentage());
        this.mobileAppPageViewsPercentageB2B = this.mobileAppPageViewsPercentageB2B.add(other.getMobileAppPageViewsPercentageB2B());
        this.pageViewsPercentage = this.pageViewsPercentage.add(other.getPageViewsPercentage());
        this.pageViewsPercentageB2B = this.pageViewsPercentageB2B.add(other.getPageViewsPercentageB2B());
        this.buyBoxPercentage = this.buyBoxPercentage.add(other.getBuyBoxPercentage());
        this.buyBoxPercentageB2B = this.buyBoxPercentageB2B.add(other.getBuyBoxPercentageB2B());
        this.unitSessionPercentage = this.unitSessionPercentage.add(other.getUnitSessionPercentage());
        this.unitSessionPercentageB2B = this.unitSessionPercentageB2B.add(other.getUnitSessionPercentageB2B());
    }

    public void sum(int dividedBy) {
        this.browserSessions /= dividedBy;
        this.browserSessionsB2B /= dividedBy;
        this.mobileAppSessions /= dividedBy;
        this.mobileAppSessionsB2B /= dividedBy;
        this.sessions /= dividedBy;
        this.sessionsB2B /= dividedBy;
        this.browserSessionPercentage = this.browserSessionPercentage.divide(BigDecimal.valueOf(dividedBy), RoundingMode.HALF_UP);
        this.browserSessionPercentageB2B = this.browserSessionPercentageB2B.divide(BigDecimal.valueOf(dividedBy), RoundingMode.HALF_UP);
        this.mobileAppSessionPercentage = this.mobileAppSessionPercentage.divide(BigDecimal.valueOf(dividedBy), RoundingMode.HALF_UP);
        this.mobileAppSessionPercentageB2B = this.mobileAppSessionPercentageB2B.divide(BigDecimal.valueOf(dividedBy), RoundingMode.HALF_UP);
        this.sessionPercentage = this.sessionPercentage.divide(BigDecimal.valueOf(dividedBy), RoundingMode.HALF_UP);
        this.sessionPercentageB2B = this.sessionPercentageB2B.divide(BigDecimal.valueOf(dividedBy), RoundingMode.HALF_UP);
        this.browserPageViews /= dividedBy;
        this.browserPageViewsB2B /= dividedBy;
        this.mobileAppPageViews /= dividedBy;
        this.mobileAppPageViewsB2B /= dividedBy;
        this.pageViews /= dividedBy;
        this.pageViewsB2B /= dividedBy;
        this.browserPageViewsPercentage = this.browserPageViewsPercentage.divide(BigDecimal.valueOf(dividedBy), RoundingMode.HALF_UP);
        this.browserPageViewsPercentageB2B = this.browserPageViewsPercentageB2B.divide(BigDecimal.valueOf(dividedBy), RoundingMode.HALF_UP);
        this.mobileAppPageViewsPercentage = this.mobileAppPageViewsPercentage.divide(BigDecimal.valueOf(dividedBy), RoundingMode.HALF_UP);
        this.mobileAppPageViewsPercentageB2B = this.mobileAppPageViewsPercentageB2B.divide(BigDecimal.valueOf(dividedBy), RoundingMode.HALF_UP);
        this.pageViewsPercentage = this.pageViewsPercentage.divide(BigDecimal.valueOf(dividedBy), RoundingMode.HALF_UP);
        this.pageViewsPercentageB2B = this.pageViewsPercentageB2B.divide(BigDecimal.valueOf(dividedBy), RoundingMode.HALF_UP);
        this.buyBoxPercentage = this.buyBoxPercentage.divide(BigDecimal.valueOf(dividedBy), RoundingMode.HALF_UP);
        this.buyBoxPercentageB2B = this.buyBoxPercentageB2B.divide(BigDecimal.valueOf(dividedBy), RoundingMode.HALF_UP);
        this.unitSessionPercentage = this.unitSessionPercentage.divide(BigDecimal.valueOf(dividedBy), RoundingMode.HALF_UP);
        this.unitSessionPercentageB2B = this.unitSessionPercentageB2B.divide(BigDecimal.valueOf(dividedBy), RoundingMode.HALF_UP);
    }
}
