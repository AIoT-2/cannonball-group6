package com.nhnacademy.game;

public class PositionVector extends Vector{

    /*
     *  좌표계상에서의 위치 기반으로 벡터를 생성한다.
     * 
     * @param dx X축 상으로의 변위량
     * @param dy Y축 상으로의 변위량
     */
    public PositionVector(int dx, int dy) {
        super(dx, dy);
    }
    
}
