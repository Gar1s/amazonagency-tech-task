package com.eddev.amazonagencytechtask.repository;

import com.eddev.amazonagencytechtask.domain.Statistic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepository extends MongoRepository<Statistic, String>,
        SalesAndTrafficByDateRepository, SalesAndTrafficByAsinRepository {
}
