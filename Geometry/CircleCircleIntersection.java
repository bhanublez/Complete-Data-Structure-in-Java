import static java.lang.Math.*;

import java.awt.geom.*;

public class CircleCircleIntersection {

    // We now range of cos is +1 to -1
    private static double arccosSafe(double x) {
        if (x >= +1.0)
            return 0;
        if (x <= -1.0)
            return PI;
        return acos(x);
    }

    public static double circleCircleIntersectionArea(Point2D c1, double r1, Point2D c2, double r2) {

        double r = r1, R = r2;
        Point2D c = c1, C = c2;

        if (r1 > r2) {
            r = r2;
            R = r1;
            c = c2;
            C = c1;
        }
        double dist = c1.distance(c2);
        Point2D[] inter = interSect(c1, r1, c2, r2);

    }

    public static Point2D[] interSect(Point2D c1, double r1, Point2D c2, double r2) {
        double r, R;
        Point2D c, C;
        if (r1 < r2) {
            r = r1;
            R = r2;
            c = c1;
            C = c2;
        } else {
            r = r2;
            R = r1;
            c = c2;
            C = c1;
        }
        // Many Solution possible
        double dist = c1.distance(c2);
        if (dist < EPS && abs(r - R) < EPS) {
            return null;
        }
        // No intersection (r inside R)
        if (r + dist < R)
            return null;

        // DisJoint
        if (r + R < dist)
            return new Point2D[] {};
        double cx = c.getX();
        double Cx = C.getX();
        double cy = c.getY();
        double Cy = C.getY();
        double vx = cx - Cx;
        double vy = cy - Cy;
        double x = (vx / dist) * R + Cx;
        double y = (vy / dist) * R + Cy;
        Point2D point = new Point2D.Double(x, y);
        //Unique one soln
        if (abs(r + R - dist) < EPS || abs(R - (r + dist)) < EPS)
            return new Point2D[] { point };
        double angle = arccosSafe((r * r - dist * dist - R * R) / (-2.0 * dist * R));
  
            Point2D pt1 = rotatePoint(C, point, angle);
        Point2D pt2 = rotatePoint(C, point, -angle);

    }

    private static final double EPS = 1e-6;

    public static void main(String[] args) {
        Point2D p1 = new Point2D.Double(2, 2);
        Point2D p2 = new Point2D.Double(4, 4);
        double r1 = 3;
        double r2 = 5;
        System.out.println(CircleCircleIntersectionArea(p1, r1, p2, r2));
    }
}
