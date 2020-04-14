package com.paytm.codingchallenge;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MovingAvgCalculatorTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void testGetAllElements(){
        //given
        MovingAverageImpl testClass = new MovingAverageImpl(3);
        testClass.addElement(1d);
        testClass.addElement(2d);
        testClass.addElement(3d);
        testClass.addElement(4d);
        List<Double> expected = Arrays.asList(1d,2d,3d,4d);
        //when
        List<Double> result = testClass.getAllElements();
        //then
        assertEquals(result,expected);
    }

    @Test
    public void testIllegalArgumentException(){
        //given
        expectedEx.expect(IllegalArgumentException.class);
        expectedEx.expectMessage("averageSize cannot be less than or equal to 0");
        //when
        MovingAverageImpl testClass = new MovingAverageImpl(0);

    }

    @Test
    public void testGetAverage_defaultRounding(){
        //given
        List<Double> stream = Arrays.asList(1d,2d,3d,4d,34d,56d);
        MovingAverageImpl testClass = new MovingAverageImpl(3);
        List<Double> expected = Arrays.asList(0.3333, 1.0, 2.0, 3.0, 13.6667, 31.3333);
        List<Double> actual = new ArrayList<Double>();
        //when
        for(Double d : stream){
            testClass.addElement(d);
            actual.add(testClass.getAverage());
        }

        //then
        assertEquals(actual,expected);
    }

    @Test
    public void testGetAverage_SpecifiedRounding(){
        //given
        List<Double> stream = Arrays.asList(1d,2d,3d,4d,34d,56d);
        MovingAverageImpl testClass = new MovingAverageImpl(3, 6);
        List<Double> expected = Arrays.asList(0.333333, 1.0, 2.0, 3.0, 13.666667, 31.333333);
        List<Double> actual = new ArrayList<Double>();
        //when
        for(Double d : stream){
            testClass.addElement(d);
            actual.add(testClass.getAverage());
        }

        //then
        assertEquals(actual,expected);
    }

}