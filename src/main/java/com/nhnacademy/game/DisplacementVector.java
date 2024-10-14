package com.nhnacademy.game;

public class DisplacementVector extends Vector {

    public DisplacementVector(int magnitude, int angle) {
        super((int) (magnitude * Math.cos(Math.toRadians(angle))),
                (int) (magnitude * Math.sin(Math.toRadians(angle))));
    }
}


// DisplacementVector 용도
/* DisplacementVector (변위 벡터)
이동 분석: 물체가 한 지점에서 다른 지점으로 이동할 때, 이동의 크기와 방향을 표현할 수 있습니다.
물리학: 물체의 운동을 분석할 때, 변위는 중요한 개념으로, 초기와 최종 위치 간의 차이를 나타냅니다.
로봇 공학: 로봇이나 드론이 특정 경로를 따라 이동할 때, 변위 벡터를 통해 목표 위치로의 이동을 계획할 수 있습니다. */