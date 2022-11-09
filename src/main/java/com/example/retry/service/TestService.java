package com.example.retry.service;

import com.example.retry.dao.TestDao;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class TestService {

    @Autowired
    TestDao testDao;

    @Retry(name="testRetry1")
    public String getTestResult1(boolean isValidUrl) {
        log.info("Invoking service layer for test 1");
        return testDao.getTestResult1(isValidUrl);
    }

    @Retry(name="testRetry2")
    public String getTestResult2(boolean isValidUrl) {
        log.info("Invoking service layer for test 2");
        return testDao.getTestResult2(isValidUrl);
    }
}
