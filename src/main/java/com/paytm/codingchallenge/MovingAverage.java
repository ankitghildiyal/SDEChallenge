package com.paytm.codingchallenge;

import java.util.List;

/**
 * The interface for calculating the moving average of given number of
 * last N elements. The value of N should be greater than 0.
 *
 */
public interface MovingAverage  {

    /**
     * Gets all the elements that were received from the stream.
     * The underlying data structure is a java.util.ArrayList
     *
     * @return List of all the elements
     */
    List<Double> getAllElements();

    /**
     * Method to add element to the calculator.
     *
     * @param streamElement
     */
    void addElement(double streamElement);

    /**
     * Gets average of last N elements added to the stream. The average
     * is rounded up (RoundingMode.HALF_UP) to 4 decimal places by
     * default. The number of decimal rounding is parametrized using
     * MovingAverageImpl(int averageSize, int decimalPointsInAverage).
     *
     * @return the average
     */
    double getAverage();
}
