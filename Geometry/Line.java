import static java.lang.Math.*;

import java.awt.geom.Point2D;

public class Line {
    //General eq of line ax+by=c
    private double a, b, c;

    //line construction
    public Line(Point2D p1, Point2D p2) {
        this(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    public Line(double x1, double y1, double x2, double y2) {
        a = y1 - y2;
        b = x2 - x1;
        c = x2 * y1 - x1 * y2;
        
    }


    public static void main(String[] args) {
        
    }   
}
