package by.bsuir.kaziukovich.task9.basketanalysis;

import by.bsuir.kaziukovich.task9.basketball.Ball;
import by.bsuir.kaziukovich.task9.basketball.Basket;
import java.util.ArrayList;

/**
 * Class to analyse basket of balls
 */
public final class BasketAnalyzer {
    /**
     * Gets weight of all balls in basket
     * @param basket Basket to get balls from
     * @return Total weight of all balls
     */
    public static double getBallsWeight(Basket basket) {
        double weight = 0;

        if (basket == null) {
            throw new IllegalArgumentException("Basket shouldn't be null");
        }

        for (Ball ball : basket.getBalls()) {
            weight += ball.getWeight();
        }
        return weight;
    }

    /**
     * Gets list of ball by color
     * @param basket Basket to get balls from
     * @param color Color of balls
     * @return List of balls by color
     */
    public static ArrayList<Ball> getBallsByColor(Basket basket, String color) {
        ArrayList<Ball> coloredBalls = new ArrayList<>();

        if (basket == null) {
            throw new IllegalArgumentException("Basket shouldn't be null");
        }
        if ((color == null) || color.isEmpty()) {
            throw new IllegalArgumentException("You should set color to search for");
        }

        for (Ball ball : basket.getBalls()) {
            if (ball.getColor().toLowerCase().equals(color.toLowerCase())) {
                coloredBalls.add(ball);
            }
        }
        return coloredBalls;
    }

    /**
     * Private constructor to prevent object creation
     */
    private BasketAnalyzer() {}
}
