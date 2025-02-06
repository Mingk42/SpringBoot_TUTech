package com.tutech.backend.service;

import com.tutech.backend.dto.SearchEntity;
import com.tutech.backend.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.tutech.backend.utils.Common.*;

@Service
public class SearchServiceImpl implements SearchService {
    private final SearchRepository searchRepository;

    @Autowired
    public SearchServiceImpl(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    @Override
    public SearchEntity createSearchEntity(SearchEntity searchEntity) {
        return searchRepository.save(searchEntity);
    }

    @Override
    public List<SearchEntity> getAllSearchEntities() {
        List<SearchEntity> searchEntities = searchRepository.findAll();
        List<SearchEntity> results = new ArrayList<>();

        for (SearchEntity searchEntity : searchEntities) {
            searchEntity.setOnSale(isOnSale(searchEntity));
            searchEntity.setExclusive(isExclusive(searchEntity));

            results.add(searchEntity);
        }

        return results;
    }

    @Override
    public SearchEntity getSearchEntityById(String id) {
        return searchRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteSearchEntityById(String id) {
        searchRepository.deleteById(id);
    }

    @Override
    public List<SearchEntity> getAllSearchEntitiesByRegion(String region){
        return searchRepository.findByRegion(region);
    }

    public List<SearchEntity> findByStart_dateIsAfter(String start_date){
        return searchRepository.findByStart_dateIsAfter(start_date);
    }

    public List<SearchEntity> findByHostsSiteId(String hostsSiteId){
        return searchRepository.findByHostsSiteId(hostsSiteId);
    }
}
