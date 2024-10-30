package com.eddev.amazonagencytechtask.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

@Document(collection = "Statistics")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Statistic implements Serializable {

    @Id
    private String id;
    private ReportSpecification reportSpecification;
    @Field("salesAndTrafficByDate")
    private List<SalesAndTrafficByDate> salesAndTrafficByDates;
    @Field("salesAndTrafficByAsin")
    private List<SalesAndTrafficByAsin> salesAndTrafficByAsins;

}