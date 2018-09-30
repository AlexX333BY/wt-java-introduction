package by.bsuir.kaziukovich.task9.runner;

import by.bsuir.kaziukovich.common.ConsoleScanner;
import by.bsuir.kaziukovich.task9.basketanalysis.BasketAnalyzer;
import by.bsuir.kaziukovich.task9.basketball.Ball;
import by.bsuir.kaziukovich.task9.basketball.Basket;

/**
 * Runner for task 9 implementation
 */
public class Task9Runner {
    /**
     * Fills basket with user's balls
     * @param basket Basket to fill
     */
    private static void fillBasket(Basket basket) {
        int ballsCount;
        double ballWeight;
        String ballColor;

        System.out.print("Enter balls amount: ");
        ballsCount = ConsoleScanner.getNonNegativeInt();
        for (int ballNo = 0; ballNo < ballsCount; ballNo++) {
            System.out.println("Ball " + (ballNo + 1) + " of " + ballsCount);
            System.out.print("Enter ball's weight: ");
            ballWeight = ConsoleScanner.getPositiveDouble();
            System.out.print("Enter ball's color: ");
            ballColor = ConsoleScanner.getNonEmptyString();
            basket.addBall(new Ball(ballWeight, ballColor));
        }
    }

    /**
     * Entry point for program
     * @param args Command line arguments, not in use
     */
    public static void main(String[] args) {
        Basket basket = new Basket();
        String color;

        fillBasket(basket);
        System.out.println("Balls in basket total weight: " + BasketAnalyzer.getBallsWeight(basket));

        System.out.print("Enter color to search for: ");
        color = ConsoleScanner.getNonEmptyString();
        System.out.println("Balls of " + color + " color in basket:");
        for (Ball ball : BasketAnalyzer.getBallsByColor(basket, color)) {
            System.out.println("\t" + ball.toString());
        }
    }
}
