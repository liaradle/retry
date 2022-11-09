package com.example.retry.dao;

import com.example.retry.TestException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class TestDao {
    @Autowired
    RestTemplate restTemplate;

    @SneakyThrows
    public String getTestResult1(boolean isValidUrl) {
        log.info("Invoking dao layer for test1");
        String url = "http://localhost:8081/no";
        if(isValidUrl) {
            url = "https://www.google.co.uk";
        }
        log.info("Invoking http get req");
        try {
            return restTemplate.getForEntity(url, String.class).getBody();
        } catch (Exception e) {
            throw new RuntimeException("nope");
        }
    }

    @SneakyThrows
    public String getTestResult2(boolean isValidUrl) {
        log.info("Invoking dao layer for test2");
        String url = "http://localhost:8081/no";
        if(isValidUrl) {
            url = "https://www.google.co.uk";
        }
        log.info("Invoking http get req");
        try {
            return restTemplate.getForEntity(url, String.class).getBody();
        } catch (Exception e) {
            throw new TestException("nope");
        }
    }
}
