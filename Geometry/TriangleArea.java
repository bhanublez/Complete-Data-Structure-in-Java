import static java.lang.Math.abs;

import java.awt.geom.*;
import static java.lang.Math.*;

public class TriangleArea {
    
    private static double triangleArea(Point2D a, Point2D b, Point2D c) {
        return triangleArea(a.getX(), a.getY(), b.getX(), b.getY(), c.getX(), c.getY());
    }

    private static double triangleArea(double x, double y, double x2, double y2, double x3, double y3) {
        double v1_x = x2 - x;
        double v1_y = y2 - y;
        double v2_x = x3 - x;
        double v2_y = y3 - y;
        double determinant = v1_x * v2_y - v1_y * v2_x;
        return abs(determinant) / 2;

    }

    //Hero's formula
    private static double triangleArea(double side1, double side2, double side3) {
        double s = (side1 + side2 + side3) / 2.0;
        return sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    
    //Traaditional formula
    private static double triangleArea(double base, double height) {
        return base * (height / 2.0);
    } 
    public static void main(String[] args) {
        Point2D a = new Point2D.Double(0, 1);
        Point2D b = new Point2D.Double(3, 6);
        Point2D c=new Point2D.Double(3,4);
        System.out.println(triangleArea(a, b, c));
        
        double side1 = a.distance(b);
        double side2 = a.distance(c);
        double side3 = b.distance(c);
        System.out.println(triangleArea(side1,side2, side3));

    }
}