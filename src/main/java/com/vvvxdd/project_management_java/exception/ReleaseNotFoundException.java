package com.vvvxdd.project_management_java.exception;

public class ReleaseNotFoundException extends RuntimeException{
    public ReleaseNotFoundException(String message) {
        super(message);
    }
}
