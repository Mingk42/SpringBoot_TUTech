package com.tutech.backend.dto;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;


@Document(collection = "backup")
@Data
public class SearchEntity {

    @Id
    private String id;
    private String title;
    private String category;
    private String start_date;
    private String end_date;
    private List hosts;
    private List price;
    private String location;
    private String poster_url;
    private String region;
    private boolean onSale;
    private boolean isExclusive;
}
