package com.eddev.amazonagencytechtask.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class SalesByAsin implements Serializable {

    private Integer unitsOrdered;
    private Integer unitsOrderedB2B;
    private OrderedProductSales orderedProductSales;
    private OrderedProductSalesB2B orderedProductSalesB2B;
    private Integer totalOrderItems;
    private Integer totalOrderItemsB2B;

    public void add(SalesByAsin other) {
        this.unitsOrdered += other.getUnitsOrdered();
        this.unitsOrderedB2B += other.getUnitsOrderedB2B();
        this.orderedProductSales.add(other.getOrderedProductSales());
        this.orderedProductSalesB2B.add(other.getOrderedProductSalesB2B());
        this.totalOrderItems += other.getTotalOrderItems();
        this.totalOrderItemsB2B += other.getTotalOrderItemsB2B();
    }

    public void sum(int dividedBy) {
        this.unitsOrdered /= dividedBy;
        this.unitsOrderedB2B /= dividedBy;
        this.orderedProductSales.sum(dividedBy);
        this.orderedProductSalesB2B.sum(dividedBy);
        this.totalOrderItems /= dividedBy;
        this.totalOrderItemsB2B /= dividedBy;
    }
}
