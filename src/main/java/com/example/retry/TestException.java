package com.example.retry;

import org.springframework.core.NestedRuntimeException;

public class TestException extends NestedRuntimeException {

    public TestException(String message) {
        super(message);
    }
}
