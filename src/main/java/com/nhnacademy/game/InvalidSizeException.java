package com.nhnacademy.game;

public class InvalidSizeException extends RuntimeException {// 반지름이나 크기와 관련된 오류를 처리하는데 사용됨.
        public InvalidSizeException(String message) {
            super(message); // 부모 클래스인 RuntimeException의 생성자 호출
        }
    }
