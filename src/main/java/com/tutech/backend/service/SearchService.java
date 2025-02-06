package com.tutech.backend.service;

import com.tutech.backend.dto.SearchEntity;

import java.util.List;

public interface SearchService {
    SearchEntity createSearchEntity(SearchEntity searchEntity);
    List<SearchEntity> getAllSearchEntities();
    SearchEntity getSearchEntityById(String id);
    void deleteSearchEntityById(String id);
    List<SearchEntity> getAllSearchEntitiesByRegion(String region);
    List<SearchEntity> findByStart_dateIsAfter(String start_date);
    List<SearchEntity> findByHostsSiteId(String hostsSiteId);
}
