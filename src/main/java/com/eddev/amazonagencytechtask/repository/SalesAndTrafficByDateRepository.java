package com.eddev.amazonagencytechtask.repository;

import com.eddev.amazonagencytechtask.domain.SalesAndTrafficByDate;
import org.springframework.data.mongodb.repository.Aggregation;

import java.util.List;
import java.util.Optional;

public interface SalesAndTrafficByDateRepository {

    @Aggregation(pipeline = {
            "{ $unwind: { path:'$salesAndTrafficByDate' } }",
            "{ $match: { 'salesAndTrafficByDate.date': ?0 } }",
            "{ $replaceRoot: { 'newRoot': '$salesAndTrafficByDate' } }"
    })
    Optional<SalesAndTrafficByDate> findStatisticBySalesAndTrafficByDate(String inputDate);

    @Aggregation(pipeline = {
            "{ $unwind: { path:'$salesAndTrafficByDate' } }",
            "{ $match: { 'salesAndTrafficByDate.date': { '$gte': ?0, '$lte': ?1 } } }",
            "{ $replaceRoot: { 'newRoot': '$salesAndTrafficByDate' } }"
    })
    Optional<List<SalesAndTrafficByDate>> findStatisticBySalesAndTrafficByDates(String startDate, String endDate);

    @Aggregation(pipeline = {
            "{ $unwind: { path:'$salesAndTrafficByDate' } }",
            "{ $replaceRoot: { 'newRoot': '$salesAndTrafficByDate' } }"
    })
    Optional<List<SalesAndTrafficByDate>> findAllSalesAndTrafficByDate();

}
