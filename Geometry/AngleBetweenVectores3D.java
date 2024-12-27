import static java.lang.Math.*;

public class AngleBetweenVectores3D {
    // We gone use dot(v1,v2) = len(v1)*len(v2)*cosθ
    // dot(a,b) is the dot product and len(c) is the length of c.
    public static double angleBetween3DVectors(double v1x, double v1y, double v1z, double v2x, double v2y, double v2z) {
        double dotproduct = (v1x * v2x) + (v1y * v2y) + (v1z * v2z);
        double v1Length = sqrt(v1x * v1x + v1y * v1y + v1z * v1z);
        double v2Length = sqrt(v2x * v2x + v2y * v2y + v2z * v2z);

        double value = dotproduct / (v1Length * v2Length);
        if (value <= -1.0)
            return PI;
        if (value >= +1.0)
            return 0;
        return acos(value);
    }
}
