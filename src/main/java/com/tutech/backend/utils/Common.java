package com.tutech.backend.utils;

import com.tutech.backend.dto.SearchEntity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Common {
    public static boolean isExclusive(SearchEntity searchEntity){
        return searchEntity.getHosts().size()==1;
    }
    public static boolean isOnSale(SearchEntity searchEntity){
        String startDate = searchEntity.getStart_date();
        if(startDate!=null){
            startDate=startDate.replace(".","");
        } else {
            return false;
        }
        String endDate = searchEntity.getEnd_date();
        if(endDate!=null){
            if(endDate.equals("오픈런")){
                endDate="99999999";
            } else {
                endDate=endDate.replace(".","");
            }
        } else {
            return false;
        }
        List<String> price = searchEntity.getPrice();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String today = dateFormat.format(new Date());

        if(price.isEmpty()){
            if(Integer.parseInt(today)>Integer.parseInt(startDate) && Integer.parseInt(today)<Integer.parseInt(endDate) ){
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public static String getToday(){
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd");
        return dateFormat.format(date);
    }

    public static List getThisWeekendDate(){
        List weekendList = new ArrayList();

        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd");

        if (date.getDay()==6){              // 오늘이 토요일이면, 내일+다음주 토요일
            date.setDate(date.getDate()+ 1);
            weekendList.add(dateFormat.format(date));

            date.setDate(date.getDate()+ 6);
            weekendList.add(dateFormat.format(date));
        } else {              // 그 외 이번 토요일 일요일
            date.setDate(date.getDate()+ 6-date.getDay());
            weekendList.add(dateFormat.format(date));

            date.setDate(date.getDate()+ 1);
            weekendList.add(dateFormat.format(date));
        }

        return weekendList;
    }

    public static List getWeekendDateList(int weeks){
        List weekendList = new ArrayList();

        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd");
        int todayDate=date.getDate();

        for(int i=0;i<=weeks;i++){
            if (date.getDate() > todayDate){
                date.setDate(date.getDate()+ 6-date.getDay());  // 6-getDay ====> 다음 토요일 또는 오늘(==토요일)
                weekendList.add(dateFormat.format(date));
            }

            date.setDate(date.getDate()+ 1);    // 처음 제외 반드시 일요일
            if(date.getDay()==0){
                weekendList.add(dateFormat.format(date));
            }
        }

        return weekendList;
    }
}
