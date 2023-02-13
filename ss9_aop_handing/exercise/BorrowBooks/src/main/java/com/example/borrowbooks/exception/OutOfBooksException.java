package com.example.borrowbooks.exception;

public class OutOfBooksException extends Exception {
    public OutOfBooksException (String message){
        super(message);
    }
}
