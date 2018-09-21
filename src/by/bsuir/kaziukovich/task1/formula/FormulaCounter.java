package by.bsuir.kaziukovich.task1.formula;

/**
 * Class for counting formula value from first task
 */
public class FormulaCounter {
    /**
     * Counts formula value
     * @param x First parameter of formula
     * @param y Second parameter of formula
     * @return Formula value
     * @throws ArithmeticException Throws in case of not a number or infinite result
     */
    public static double count(double x, double y) {
        double numerator = 1 + Math.pow(Math.sin(x + y), 2);
        double denominator = 2 + Math.abs(x - 2 * x / (1 + Math.pow(x, 2) * Math.pow(y, 2)));
        double result = numerator / denominator + x;

        if (Double.isFinite(result)) {
            return result;
        } else {
            throw new ArithmeticException("Result is not a finite number");
        }
    }

    /**
     * Constructor to avoid object creation
     */
    private FormulaCounter() {}
}
