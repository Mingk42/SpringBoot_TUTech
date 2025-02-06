package com.tutech.backend.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutech.backend.dto.SearchEntity;
import com.tutech.backend.service.SearchServiceImpl;

import static com.tutech.backend.utils.Common.*;

@RestController
@RequestMapping("/")
public class Common {
    private final SearchServiceImpl searchServiceImpl;

    @Autowired
    public Common(SearchServiceImpl searchServiceImpl) {
        this.searchServiceImpl = searchServiceImpl;
    }

    @GetMapping
    public static String hello(){
        return "Hello World";
    }

    @GetMapping("/banner")
    public List<SearchEntity> Banner(){
        List<SearchEntity> result = new ArrayList<>();
        List<SearchEntity> banner = searchServiceImpl.findByStart_dateIsAfter(getToday());
        banner.sort(Comparator.comparing(SearchEntity::getStart_date));

        for(int i = 0; i < 11; i++){
            result.add(banner.get(i));
        }

        return result;
    }

    @GetMapping("/thisWeekend")
    public List<SearchEntity> ThisWeekend(){
        List<SearchEntity> result = new ArrayList<>();
        List<SearchEntity> banner = searchServiceImpl.findByStart_dateIsAfter(getToday());
        banner.sort(Comparator.comparing(SearchEntity::getStart_date));

        for(int i = 0; i < 11; i++){
            result.add(banner.get(i));
        }

        return result;
    }

    @GetMapping("/weeklyBest")
    public List<SearchEntity> WeeklyBest(){
        List<SearchEntity> result = new ArrayList<>();
        List<SearchEntity> banner = searchServiceImpl.findByStart_dateIsAfter(getToday());
        banner.sort(Comparator.comparing(SearchEntity::getStart_date));

        for(int i = 0; i < 11; i++){
            result.add(banner.get(i));
        }

        return result;
    }

    @PostMapping("login")
    public static SearchEntity Login(){return null;}
    @PostMapping("logout")
    public static SearchEntity Logout(){return null;}
}