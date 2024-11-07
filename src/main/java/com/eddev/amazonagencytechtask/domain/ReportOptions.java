package com.eddev.amazonagencytechtask.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ReportOptions implements Serializable {

    private DateGranularity dateGranularity;
    private AsinGranularity asinGranularity;

}
