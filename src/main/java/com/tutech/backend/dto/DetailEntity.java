package com.tutech.backend.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "backup")
@Data
public class DetailEntity {

    @Id
    private String id;
    private String title;
    private List artist;
    private List casting;
    private String category;
    private String description;
    private String duplicatekey;
    private String pre_open_date;
    private String open_date;
    private String start_date;
    private String end_date;
    private List hosts;
    private String location;
    private String poster_url;
    private List price;
    private String rating;
    private String region;
    private String running_time;
}
