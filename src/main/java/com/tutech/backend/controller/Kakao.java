package com.tutech.backend.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/kakao")
public class Kakao {
    @GetMapping("/login")
    public static ResponseEntity kakaoLogin() throws URISyntaxException {

        String url = "https://kauth.kakao.com/oauth/authorize?response_type=code" +
                "&client_id=4bab95293c16f310431bda36df65927a" +
                "&redirect_uri=http://localhost:8080/kakao/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(new URI(url));


        return new ResponseEntity(headers, HttpStatus.TEMPORARY_REDIRECT);
    }

    @GetMapping("/token")
    //public static ResponseEntity getKakaoToken(RequestParam code) throws URISyntaxException {
    public static String getKakaoToken(@RequestParam(name="code") String code, HttpSession session) throws IOException, InterruptedException {
        System.out.println("code::::::::::::" + code);

        String a="""
        curl -v -X POST "https://kauth.kakao.com/oauth/token" \
            -H "Content-Type: application/x-www-form-urlencoded;charset=utf-8" \
            -d "grant_type=authorization_code" \
            -d "client_id=4bab95293c16f310431bda36df65927a" \
            --data-urlencode "redirect_uri=http://localhost:8080/callback" \
            -d "code=41WGtVLEsPr87DIm8E4s08Sjg-x4G5Vc6fO5IUJOQGtmF3uj_drkOwAAAAQKPCKcAAABlD_ag05SGUcvaFb1Eg"
        """;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://kauth.kakao.com/oauth/token"))
                .POST(HttpRequest.BodyPublishers.ofString("grant_type=authorization_code&client_id=4bab95293c16f310431bda36df65927a&redirect_uri=http://localhost:8080/kakao/token&code="+code))
                .setHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String body = response.body();
        //body.replace("{",);
        for(String e:response.body().split(",")){
            System.out.println(e);
        }

        return response.body();
    }

    @PostMapping("/token")
    public static ResponseEntity getToken(@RequestParam(name="code") String code, HttpSession session){
        Object token = session.getAttribute(code);
        System.out.println("code::::::::::::" + code);
        System.out.println("token::::::::::::" + token);

        return null;
    }

    @PostMapping("logout")
    public static ResponseEntity logout(HttpSession session){
        return null;
    }
}
