package com.tutech.backend.controller;

import com.tutech.backend.dto.SearchEntity;
import com.tutech.backend.service.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/exclusive")
public class Exclusive {

    private final SearchServiceImpl searchServiceImpl;

    @Autowired
    public Exclusive(SearchServiceImpl searchServiceImpl) {
        this.searchServiceImpl = searchServiceImpl;
    }

    @GetMapping("/main")
    public List[] Main(){
        List[] rst = new List[3];

        for(int i = 0; i<3; i++){
            List<SearchEntity> elements = searchServiceImpl.findByHostsSiteId(i+1);

            if (elements.isEmpty()) elements=new ArrayList<>();
            else if (elements.size() < 4) elements = elements.subList(0, elements.size());
            else elements = elements.subList(0, 4);

            rst[i] = elements;
        }

        return rst;
    }

    @GetMapping("/all")
    public List<SearchEntity> ExclusiveByPlaform(@RequestParam("site_id") int id){
        List<SearchEntity> elements = searchServiceImpl.findByHostsSiteId(id);

        return elements;
    }

//    @GetMapping("/exclusive/top4/{id}")
//    public List<SearchEntity> ExclusiveTop4(@PathVariable int id){
//        List<SearchEntity> elements = searchServiceImpl.findByHostsSiteId(id).subList(0, 4);
//
//        return elements;
//    }
}