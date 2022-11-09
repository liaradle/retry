package com.example.retry.dao;

import com.example.retry.TestException;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class EventualSuccessDao {
    @Autowired
    RestTemplate restTemplate;

    private int retries = 1;

    @SneakyThrows
    @Retry(name="eventualSuccess")
    public String getEventualSuccess(int retries) {
        log.info("Invoking dao layer for eventual success");
        String url = "http://localhost:8081/no";
        if(this.retries == retries) {
            url = "https://www.google.co.uk";
        }
        log.info("Invoking http get req");
        try {
            String result = restTemplate.getForEntity(url, String.class).getBody();
            resetCounter();
            return result;
        } catch (Exception e) {
            log.info("retry no: {}", this.retries);
            this.retries++;
            throw new RestClientException("nope");
        }
    }

    public void resetCounter() {
        this.retries = 1;
    }
}
