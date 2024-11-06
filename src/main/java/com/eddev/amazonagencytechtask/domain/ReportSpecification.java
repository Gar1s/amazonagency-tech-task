package com.eddev.amazonagencytechtask.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class ReportSpecification implements Serializable {

    private ReportType reportType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dataStartTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dataEndTime;
    private List<String> marketplaceIds;


}
