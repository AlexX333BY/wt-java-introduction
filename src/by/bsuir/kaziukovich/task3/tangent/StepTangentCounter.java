package by.bsuir.kaziukovich.task3.tangent;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class containing method to count multiple tangent values
 */
public class StepTangentCounter {
    /**
     * Method that counts tg(x) by interval with step and places results in Map
     * @param a Left bound of interval
     * @param b Right bound of interval
     * @param h Step
     * @return Results placed in Map
     */
    public static Map<Double, Double> count(double a, double b, double h) {
        Map<Double, Double> resultMap = new LinkedHashMap<>();

        if (!Double.isFinite(a) || !Double.isFinite(b) || !Double.isFinite(h)) {
            throw new IllegalArgumentException("Some of the arguments are not finite numbers");
        }
        if (b < a) {
            throw new IllegalArgumentException("Illegal interval");
        }
        if (h <= 0) {
            throw new IllegalArgumentException("Step should be positive number");
        }

        for (double x = a; x <= b; x += h) {
            resultMap.put(x, Math.tan(x));
        }
        return resultMap;
    }

    /**
     * Private constructor to prevent object creation
     */
    private StepTangentCounter() {}
}
