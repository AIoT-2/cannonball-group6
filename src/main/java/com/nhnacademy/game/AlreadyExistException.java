package com.nhnacademy.game;

public class AlreadyExistException extends Exception {
    public AlreadyExistException() {
        super("The item already exists.");
    }

    //메시지를 받을 수 있는 생성자
    public AlreadyExistException(String message) {
        super(message);
    }
}