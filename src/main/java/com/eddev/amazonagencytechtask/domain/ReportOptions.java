package com.eddev.amazonagencytechtask.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReportOptions implements Serializable {

    private DateGranularity dateGranularity;
    private AsinGranularity asinGranularity;

}
