package com.vvvxdd.project_management_java.exception;

public class UserNotFoundException  extends  RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}