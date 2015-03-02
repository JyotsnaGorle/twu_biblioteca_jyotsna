package com.twu.biblioteca;

/**
 * Created by jyotsna on 25/02/15.
 */
public class InvalidBookException extends RuntimeException {
    public InvalidBookException(String s) {
        super(s);
    }
}
