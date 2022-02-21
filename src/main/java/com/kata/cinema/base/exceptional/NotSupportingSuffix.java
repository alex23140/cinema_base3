package com.kata.cinema.base.exceptional;

public class NotSupportingSuffix extends RuntimeException {
    public NotSupportingSuffix(String message) {
        super(message);
    }
}
