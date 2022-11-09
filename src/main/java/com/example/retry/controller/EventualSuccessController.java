package com.example.retry.controller;

import com.example.retry.service.EventualSuccessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class EventualSuccessController {

    @Autowired
    EventualSuccessService eventualSuccessService;

    @GetMapping("/eventualSuccess")
    public String getEventualSuccess(@RequestParam("retries") Integer retries) {
        log.info("Invoking eventual success endpoint");
        return eventualSuccessService.getEventualSuccess(retries);

    }

}
