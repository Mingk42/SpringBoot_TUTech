package com.tutech.backend.controller;

import com.tutech.backend.dto.SearchEntity;
import com.tutech.backend.service.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/exclusive")
public class Exclusive {

    private final SearchServiceImpl searchServiceImpl;

    @Autowired
    public Exclusive(SearchServiceImpl searchServiceImpl) {
        this.searchServiceImpl = searchServiceImpl;
    }

    @GetMapping("/main")
    public static SearchEntity Main(){
        SearchEntity rst=new SearchEntity();
        return rst;
    }

    @GetMapping("/{id}")
    public static SearchEntity ExclusiveByPlaform(@PathVariable String id){
        SearchEntity rst=new SearchEntity();
        return rst;
    }

    @GetMapping("/exclusive/top4/{id}")
    public List<SearchEntity> ExclusiveTop4(@PathVariable String id){
        List<SearchEntity> elements = searchServiceImpl.findByHostsSiteId(id);
        return elements;
    }
}