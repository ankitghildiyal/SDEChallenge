package com.paytm.codingchallenge;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


public class MovingAverageImpl implements MovingAverage {

    private static int DEFAULT_DECIMAL_POINTS_FOR_AVERAGE = 4;
    private List<Double> elements;
    private double sum;
    private int averageSize;
    private int decimalPointsInAverage;

    /**
     * Instantiates a new Moving average. Throws java.lang.IllegalArgumentException if
     * averageSize is less that or equal to zero
     *
     * @param averageSize The average size we want to calculate
     */
    public MovingAverageImpl(int averageSize) {
        if(averageSize <= 0 ){
            throw new IllegalArgumentException("averageSize cannot be less than or equal to 0");
        }
        elements = new ArrayList();
        this.averageSize = averageSize;
        this.decimalPointsInAverage = DEFAULT_DECIMAL_POINTS_FOR_AVERAGE;
    }

    /**
     * Overloaded constructor to parametrize the number of decimal places
     * in average.
     *
     * @param averageSize            the average size
     * @param decimalPointsInAverage the number decimal points in average
     */
    public MovingAverageImpl(int averageSize, int decimalPointsInAverage) {
        this.decimalPointsInAverage = decimalPointsInAverage;
        elements = new ArrayList();
        this.averageSize = averageSize;
    }

    public List getAllElements() {
        return elements;
    }

    public void addElement(double streamElement) {
        if(elements.size() >= averageSize) {
            Double elementToRemove = elements.get(elements.size() - averageSize);
            sum -= elementToRemove;
        }
        sum += streamElement;
        elements.add(streamElement);
    }

    public double getAverage() {
        double avg = sum / averageSize;
        BigDecimal bd = new BigDecimal(avg).setScale(decimalPointsInAverage, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
