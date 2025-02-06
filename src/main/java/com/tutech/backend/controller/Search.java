package com.tutech.backend.controller;

import com.tutech.backend.dto.SearchEntity;
import com.tutech.backend.service.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
public class Search {

    private final SearchServiceImpl searchServiceImpl;

    @Autowired
    public Search(SearchServiceImpl searchServiceImpl) {
        this.searchServiceImpl = searchServiceImpl;
    }

    @GetMapping("/search")
    public List<SearchEntity> search() {
        return searchServiceImpl.getAllSearchEntities();
    }

    @GetMapping("/search/q")
    public String search(@RequestParam String query, @RequestParam int region, @RequestParam String startDate, @RequestParam String EndDate, @RequestParam String category, @RequestParam int currPage, UriComponentsBuilder uriComponentsBuilder) {
        UriComponents uri = uriComponentsBuilder.queryParam("query", query).build();
        System.out.println(uri);

        return uri.toString();
    }

    @GetMapping("/detail")
    public String detailPage(@RequestParam String id){
        // recommend 같이 받아오기
        return null;
    }

    @GetMapping("/region")
    public List<SearchEntity> region(@RequestParam String region){
        List<SearchEntity> result = searchServiceImpl.getAllSearchEntitiesByRegion(region);
        return result;
    }


}

