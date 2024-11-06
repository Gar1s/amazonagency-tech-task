package com.eddev.amazonagencytechtask.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
public class TrafficByDate implements Serializable {

    private Integer browserPageViews;
    private Integer browserPageViewsB2B;
    private Integer mobileAppPageViews;
    private Integer mobileAppPageViewsB2B;
    private Integer pageViews;
    private Integer pageViewsB2B;
    private Integer browserSessions;
    private Integer browserSessionsB2B;
    private Integer mobileAppSessions;
    private Integer mobileAppSessionsB2B;
    private Integer sessions;
    private Integer sessionsB2B;
    private BigDecimal buyBoxPercentage;
    private BigDecimal buyBoxPercentageB2B;
    private BigDecimal orderItemSessionPercentage;
    private BigDecimal orderItemSessionPercentageB2B;
    private BigDecimal unitSessionPercentage;
    private BigDecimal unitSessionPercentageB2B;
    private Integer averageOfferCount;
    private Integer averageParentItems;
    private Integer feedbackReceived;
    private Integer negativeFeedbackReceived;
    private Integer receivedNegativeFeedbackRate;

    public void add(TrafficByDate other) {
        this.browserPageViews += other.getBrowserPageViews();
        this.browserPageViewsB2B += other.getBrowserPageViewsB2B();
        this.mobileAppPageViews += other.getMobileAppPageViews();
        this.mobileAppPageViewsB2B += other.getMobileAppPageViewsB2B();
        this.pageViews += other.getPageViews();
        this.pageViewsB2B += other.getPageViewsB2B();
        this.browserSessions += other.getBrowserSessions();
        this.browserSessionsB2B += other.getBrowserSessionsB2B();
        this.sessions += other.getSessions();
        this.sessionsB2B += other.getSessionsB2B();
        this.buyBoxPercentage = this.buyBoxPercentage.add(other.getBuyBoxPercentage());
        this.buyBoxPercentageB2B = this.buyBoxPercentageB2B.add(other.getBuyBoxPercentageB2B());
        this.orderItemSessionPercentage = this.orderItemSessionPercentage.add(other.getOrderItemSessionPercentage());
        this.orderItemSessionPercentageB2B = this.orderItemSessionPercentageB2B.add(other.getOrderItemSessionPercentageB2B());
        this.unitSessionPercentage = this.unitSessionPercentage.add(other.getUnitSessionPercentage());
        this.unitSessionPercentageB2B = this.unitSessionPercentageB2B.add(other.getUnitSessionPercentageB2B());
        this.averageOfferCount += other.getAverageOfferCount();
        this.averageParentItems += other.getAverageParentItems();
        this.feedbackReceived += other.getFeedbackReceived();
        this.negativeFeedbackReceived += other.getNegativeFeedbackReceived();
        this.receivedNegativeFeedbackRate += other.getReceivedNegativeFeedbackRate();
    }

    public void sum(int divideBy) {
        this.browserPageViews /= divideBy;
        this.browserPageViewsB2B /= divideBy;
        this.mobileAppPageViews/= divideBy;
        this.mobileAppPageViewsB2B/= divideBy;
        this.pageViews /= divideBy;
        this.pageViewsB2B /= divideBy;
        this.browserSessions /= divideBy;
        this.browserSessionsB2B /= divideBy;
        this.sessions /= divideBy;
        this.sessionsB2B /= divideBy;
        this.buyBoxPercentage = this.buyBoxPercentage.divide(BigDecimal.valueOf(divideBy), RoundingMode.HALF_UP);
        this.buyBoxPercentageB2B = this.buyBoxPercentageB2B.divide(BigDecimal.valueOf(divideBy), RoundingMode.HALF_UP);
        this.orderItemSessionPercentage = this.orderItemSessionPercentage.divide(BigDecimal.valueOf(divideBy), RoundingMode.HALF_UP);
        this.orderItemSessionPercentageB2B = this.orderItemSessionPercentageB2B.divide(BigDecimal.valueOf(divideBy), RoundingMode.HALF_UP);
        this.unitSessionPercentage = this.unitSessionPercentage.divide(BigDecimal.valueOf(divideBy), RoundingMode.HALF_UP);
        this.unitSessionPercentageB2B = this.unitSessionPercentageB2B.divide(BigDecimal.valueOf(divideBy), RoundingMode.HALF_UP);
        this.averageOfferCount /= divideBy;
        this.averageParentItems /= divideBy;
        this.feedbackReceived /= divideBy;
        this.negativeFeedbackReceived /= divideBy;
        this.receivedNegativeFeedbackRate /= divideBy;
    }

}
