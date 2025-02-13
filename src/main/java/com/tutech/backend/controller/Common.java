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
import static java.lang.Math.min;

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
        List<SearchEntity> rstList = new ArrayList<>();

        List weekendList = getThisWeekendDate();
        String[] categoryList = {"콘서트", "연극", "뮤지컬", "뮤지컬/연극", "전시/행사"};

        List musicalAndPlay= new ArrayList();

        for(String category : categoryList){
            if (category=="콘서트") {
                List tmp= new ArrayList();

                for(Object weekend:weekendList){
                    List<SearchEntity> rst = searchServiceImpl.findByStart_dateAndCategory((String)weekend, category);
                    tmp.addAll(rst);

                    if (tmp.size()>4){
                        break;
                    }
                }
                rstList.addAll(tmp.subList(0,4));
            } else if(category=="전시/행사") {
                List tmp= new ArrayList();
                for(Object weekend:weekendList){
                    List<SearchEntity> rst = searchServiceImpl.findByStart_dateAndCategory((String)weekend, category);
                    tmp.addAll(rst);

                    if (tmp.size()>4){
                        break;
                    }
                }
                if(tmp.size()>0){
                    rstList.addAll(tmp.subList(0,min(tmp.size(),4)));
                }
            } else {
                for(Object weekend:weekendList){
                    List<SearchEntity> rst = searchServiceImpl.findByStart_dateAndCategory((String)weekend, category);
                    musicalAndPlay.addAll(rst);

                    if (musicalAndPlay.size()>4){   // 뮤지컬에서 이미 4개가 넘더라도 공연, 뮤지컬/공연에 대해서도 add하고 숫자를 체크할 수 있음
                        break;
                    }
                }
            }
        }
        musicalAndPlay.sort(Comparator.comparing(SearchEntity::getStart_date));
        rstList.addAll(musicalAndPlay.subList(0,4));

        return rstList;
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