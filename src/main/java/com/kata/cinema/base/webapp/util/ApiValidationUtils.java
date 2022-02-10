package com.kata.cinema.base.webapp.util;

import javax.validation.ConstraintViolationException;
import java.util.Collections;

public class ApiValidationUtils {
    public static void requireNotNull(Object o, String errorMessage) throws ConstraintViolationException {
        if (o == null) {
            throw new ConstraintViolationException(errorMessage, Collections.emptySet());
        }
    }

    public static void requireTrue(boolean val, String errorMessage) {
        if (val != true) {
            throw new ConstraintViolationException(errorMessage, Collections.emptySet());
        }
    }

    public static void requireFalse(boolean val, String errorMessage) {
        if (val != false) {
            throw new ConstraintViolationException(errorMessage, Collections.emptySet());
        }
    }
}
