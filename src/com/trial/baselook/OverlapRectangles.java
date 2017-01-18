package com.trial.baselook;

import java.util.function.Predicate;

/**
 *
 * Check if two rectangles overlap given diagonal cordinates
 *
 * Created by adityaprasann on 18/1/17.
 */
public class OverlapRectangles {

    public static void main(String... args){

        OverlapRectangles overlapRectangles = new OverlapRectangles();
        overlapRectangles.checkRectanglesOverlap();

    }

    private void checkRectanglesOverlap() {
        int r1x1 = 1;
        int r1y1 = 1;
        int r1x2 = 4;
        int r1y2 = 2;

        int r2x1 = 2;
        int r2y1 = 1;
        int r2x2 = 4;
        int r2y2 = 4;

        MyRectangle r1 = new MyRectangle(r1x1,r1y1,r1x2,r1y2);

        MyRectangle r2 = new MyRectangle(r2x1,r2y1,r2x2,r2y2);

        boolean isNonOverLap = MyRectangle.isRectangleNonOverLap(r2).test(r1);

        System.out.println(isNonOverLap);

    }



}

class MyRectangle{
    int x1;
    int y1;
    int x2;
    int y2;

    public MyRectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public static Predicate<MyRectangle> isRectangleNonOverLap(MyRectangle r2) {
        return r1 -> (r1.x1 >= r2.x2 || r1.x2 <= r2.x1 || r1.y1 >= r2.y2 || r1.y2 <= r2.y1);
    }
}
