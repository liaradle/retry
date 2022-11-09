package com.example.retry.config;

import java.util.function.Predicate;

public class TestPredicate<T> implements Predicate<Exception> {
    @Override
    public boolean test(Exception e) {
        return e instanceof RuntimeException;
    }
}
