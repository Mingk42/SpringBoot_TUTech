package com.tutech.backend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class KakaoToken {
    private String access_token;
    private String token_type;
    private String refresh_token;
}
