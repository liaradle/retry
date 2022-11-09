package com.example.retry.service;

import com.example.retry.dao.EventualSuccessDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EventualSuccessService {

    @Autowired
    private EventualSuccessDao eventualSuccessDao;

    public String getEventualSuccess(int retries) {
        log.info("Eventual success service invoked");
        eventualSuccessDao.resetCounter();
        return eventualSuccessDao.getEventualSuccess(retries);
    }
}
