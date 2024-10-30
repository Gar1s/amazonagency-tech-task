package com.eddev.amazonagencytechtask.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public abstract class ProductSales implements Serializable {

    protected BigDecimal amount;
    protected CurrencyCode currencyCode;

}
