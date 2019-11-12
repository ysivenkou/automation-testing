package by.bsu.lab3;

public class TriangleInequality {
    private static final String ERROR_NOT_POSITIVE_LENGTH = "One or more triangle side is less or equal 0";
    private static final String ERROR_MAX_LENGTH = "One or more triangle side is double max value";

    public static boolean isInequalityHolds(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException(ERROR_NOT_POSITIVE_LENGTH);
        }
        if (a == Double.MAX_VALUE || b == Double.MAX_VALUE || c == Double.MAX_VALUE) {
            throw new IllegalArgumentException(ERROR_MAX_LENGTH);
        }
        return ((a + b) > c && (a + c) > b && (b + c) > a);
    }
}