public class Ball {
`   int x;
    int y;
    int radius;

    /**
     * @param x
     * @param y
     * @param radius
     */
    public Ball(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    /**
     * 
     * @return ball의 x축 상의 위치
     */
    public int getX() {
        //
    }

    /**
     * 
     * @return ball의 y축 상의 위치
     */
    public int getY() {
        //
    }

    /**
     * @return ball의 반지름을 반환한다.
     */
    public int getRadius() {
        //
    }


    /**
     * @return ball의 영역 중 최소 x좌표 값
     */
    public int getMinX(){
//
    }


    /**
     * 
     * @return ball의 영역 중 최대 x좌표 값
     */
    public int getMaxX(){
        //
    }

    /**
     * 
     * @return ball의 영역 중 최소 y좌표 값
     */
    public int getMinY(){
        //코드 추가
    }

    /**
     * 
     * @return ball의 영역 중 최대 y좌표 값
     */
    public int getMaxY(){
        // 코드 추가
    }


    /**
     * 
     * @return ball의 영역 넓이(x축의 길이)
     */
    public int getWidth(){
        //코드 추가
    }


    /**
     * 
     * @return ball의 영역 높이(y축의 길이)
     */
    public int getHeight(){
        //코드 추가
    }


    /**
     * @return ball의 정보를 문자열로 변환해 반환한다.
     */

    @Override
    public String toString() {
        return String.format("[(%d, %d),%d]", x, y, radius);
    }

}