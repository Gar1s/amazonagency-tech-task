package com.eddev.amazonagencytechtask.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public abstract class ProductSales implements Serializable {

    protected BigDecimal amount;
    protected CurrencyCode currencyCode;

    protected <T extends ProductSales> void add(T p){
        this.amount = this.amount.add(p.getAmount());
    }

    protected void sum(int divideBy){
        this.amount = this.amount.divide(BigDecimal.valueOf(divideBy), RoundingMode.HALF_UP);
    }

}
