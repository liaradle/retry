package com.example.retry.controller;

import com.example.retry.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/getTestResult1")
    public String testResult1(@RequestParam("isValidUrl") Boolean isValidUrl) {
        log.info("Invoking controller layer for testResult1");
        return testService.getTestResult1(isValidUrl);
    }

    @GetMapping("/getTestResult2")
    public String testResult2(@RequestParam("isValidUrl") Boolean isValidUrl) {
        log.info("Invoking controller layer for testResult2");
        return testService.getTestResult2(isValidUrl);
    }
}
