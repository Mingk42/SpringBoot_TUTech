package com.tutech.backend.repository;

import com.tutech.backend.dto.SearchEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SearchRepository extends MongoRepository<SearchEntity, String> {

    @Query(value="{ 'region' :  ?0 }")
    List<SearchEntity> findByRegion(String region);

    @Query(value="{'start_date' : {'$gt' : ?0}}")
    List<SearchEntity> findByStart_dateIsAfter(String start_date);

    @Query(value="{'hosts.site_id' : ?0}")
    List<SearchEntity> findByHostsSiteId(int hostsSiteId);
}
