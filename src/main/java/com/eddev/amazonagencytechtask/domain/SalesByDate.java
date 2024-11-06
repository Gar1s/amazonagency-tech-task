package com.eddev.amazonagencytechtask.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
public class SalesByDate implements Serializable {

    private OrderedProductSales orderedProductSales;
    private OrderedProductSalesB2B orderedProductSalesB2B;
    private Integer unitsOrdered;
    private Integer unitsOrderedB2B;
    private Integer totalOrderItems;
    private Integer totalOrderItemsB2B;
    private AverageSalesPerOrderItem averageSalesPerOrderItem;
    private AverageSalesPerOrderItemB2B averageSalesPerOrderItemB2B;
    private BigDecimal averageUnitsPerOrderItem;
    private BigDecimal averageUnitsPerOrderItemB2B;
    private AverageSellingPrice averageSellingPrice;
    private AverageSellingPriceB2B averageSellingPriceB2B;
    private Integer unitsRefunded;
    private BigDecimal refundRate;
    private Integer claimsGranted;
    private ClaimsAmount claimsAmount;
    private ShippedProductSales shippedProductSales;
    private Integer unitsShipped;
    private Integer ordersShipped;

    public void add(SalesByDate salesByDate){
        this.orderedProductSales.add(salesByDate.getOrderedProductSales());
        this.orderedProductSalesB2B.add(salesByDate.getOrderedProductSalesB2B());
        this.unitsOrdered += salesByDate.unitsOrdered;
        this.unitsOrderedB2B += salesByDate.unitsOrderedB2B;
        this.totalOrderItems += salesByDate.totalOrderItems;
        this.totalOrderItemsB2B += salesByDate.totalOrderItemsB2B;
        this.averageSalesPerOrderItem.add(salesByDate.getAverageSalesPerOrderItem());
        this.averageSalesPerOrderItemB2B.add(salesByDate.getAverageSalesPerOrderItemB2B());
        this.averageUnitsPerOrderItem = this.averageUnitsPerOrderItem.add(salesByDate.getAverageUnitsPerOrderItem());
        this.averageUnitsPerOrderItemB2B = this.averageUnitsPerOrderItemB2B.add(salesByDate.getAverageUnitsPerOrderItemB2B());
        this.averageSellingPrice.add(salesByDate.getAverageSellingPrice());
        this.averageSellingPriceB2B.add(salesByDate.getAverageSellingPriceB2B());
        this.unitsRefunded += salesByDate.getUnitsRefunded();
        this.refundRate = this.refundRate.add(salesByDate.getRefundRate());
        this.claimsGranted += salesByDate.getClaimsGranted();
        this.claimsAmount.add(salesByDate.getClaimsAmount());
        this.shippedProductSales.add(salesByDate.getShippedProductSales());
        this.unitsShipped += salesByDate.getUnitsShipped();
        this.ordersShipped += salesByDate.getOrdersShipped();
    }

    public void sum(int divideBy){
        this.orderedProductSales.sum(divideBy);
        this.orderedProductSalesB2B.sum(divideBy);
        this.unitsOrdered /= divideBy;
        this.unitsOrderedB2B /= divideBy;
        this.totalOrderItems /= divideBy;
        this.totalOrderItemsB2B /= divideBy;
        this.averageSalesPerOrderItem.sum(divideBy);
        this.averageSalesPerOrderItemB2B.sum(divideBy);
        this.averageUnitsPerOrderItem = this.averageUnitsPerOrderItem.divide(BigDecimal.valueOf(divideBy), RoundingMode.HALF_UP);
        this.averageUnitsPerOrderItemB2B = this.averageUnitsPerOrderItemB2B.divide(BigDecimal.valueOf(divideBy), RoundingMode.HALF_UP);
        this.averageSellingPrice.sum(divideBy);
        this.averageSellingPriceB2B.sum(divideBy);
        this.unitsRefunded /= divideBy;
        this.refundRate = this.refundRate.divide(BigDecimal.valueOf(divideBy), RoundingMode.HALF_UP);
        this.claimsGranted /= divideBy;
        this.claimsAmount.sum(divideBy);
        this.shippedProductSales.sum(divideBy);
        this.unitsShipped /= divideBy;
        this.ordersShipped /= divideBy;
    }

}
