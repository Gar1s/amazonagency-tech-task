package com.eddev.amazonagencytechtask.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class SalesByAsin implements Serializable {

    private Integer unitsOrdered;
    private Integer unitsOrderedB2B;
    private OrderedProductSales orderedProductSales;
    private OrderedProductSalesB2B orderedProductSalesB2B;
    private Integer totalOrderItems;
    private Integer totalOrderItemsB2B;

}
