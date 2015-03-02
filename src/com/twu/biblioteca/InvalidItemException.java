package com.twu.biblioteca;

/**
 * Created by jyotsna on 25/02/15.
 */
public class InvalidItemException extends RuntimeException {
    public InvalidItemException(String s) {
        super(s);
    }
}
