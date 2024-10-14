package com.nhnacademy.game;

public class DisplacementVector extends Vector {

    /*
     * 크기와 뱡향으로 벡터를 생성한다.
     * 
     * @param magnitude 벡터의 크기
     * @param angle     벡터의 방향
     * 
     */
    public DisplacementVector (int magnitude, int angle ) {
        super((int) (magnitude * Math.cos(Math.toRadians(angle))),
        (int) (magnitude * Math.sin(Math.toRadians(angle))));
    }
}
