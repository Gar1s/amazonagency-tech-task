package com.eddev.amazonagencytechtask.repository;

import com.eddev.amazonagencytechtask.domain.SalesAndTrafficByAsin;
import org.springframework.data.mongodb.repository.Aggregation;

import java.util.List;
import java.util.Optional;

public interface SalesAndTrafficByAsinRepository {

    @Aggregation(pipeline = {
            "{ $unwind: { path:'$salesAndTrafficByAsin' } }",
            "{ $match: { 'salesAndTrafficByAsin.parentAsin': { '$in': ?0 } } }",
            "{ $replaceRoot: { 'newRoot': '$salesAndTrafficByAsin' } }"
    })
    Optional<List<SalesAndTrafficByAsin>> findStatisticBySalesAndTrafficByAsins(List<String> asins);

    @Aggregation(pipeline = {
            "{ $unwind: { path:'$salesAndTrafficByAsin' } }",
            "{ $replaceRoot: { 'newRoot': '$salesAndTrafficByAsin' } }"
    })
    Optional<List<SalesAndTrafficByAsin>> findAllSalesAndTrafficByAsin();

}
