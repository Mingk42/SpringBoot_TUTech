package com.tutech.backend.utils;

import com.tutech.backend.dto.SearchEntity;

import java.text.SimpleDateFormat;
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
}
