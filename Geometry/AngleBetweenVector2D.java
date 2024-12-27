import static java.lang.Math.*;

public class AngleBetweenVector2D {
    public static double angleBetweenVectors(double v1x, double v1y, double v2x, double v2y) {
        double dotproduct = (v1x * v2x) + (v1y * v2y);
        double v1Length = sqrt((v1x * v1x) + (v1y * v1y));// determ

        double v2Length = sqrt((v2x * v2x) + (v2y * v2y));// determ
        double value = dotproduct / (v1Length * v2Length);
        if (value <= -1) {
            return PI;// 180 degree
        }
        if (value >= +1.0) {
            return 0;// 90 degree
        }
        return acos(value);
    }

    public static void main(String[] args) {
        System.out.println(angleBetweenVectors(1, 1, 2, 2));
    }

}
