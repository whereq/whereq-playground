/******************************************************************************
 *  A simple implementation of Newton's method to calculate the square root.
 *  
 *  TODO: Add test cases.
 *
 ******************************************************************************/

public class Newton {

    public static double sqrt(double c) {
        if (c < 0) {
            return Double.NaN;
        }
        double EPSILON = 1E-15;
        return sqrt(c, EPSILON);
    }

    public static double sqrt(double c, double epsilon) {
        if (c < 0) {
            return Double.NaN;
        }
        double t = c;
        while (Math.abs(t - c / t) > epsilon * t) {
           t = (c / t + t) / 2.0;
        }
        return t;
    }
}
