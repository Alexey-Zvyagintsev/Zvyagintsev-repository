package ru.sberbank.jd.lesson02;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NodImplTest {

    NodImpl nodTest;
    @Before
    public void init() {
        System.out.println("Before test");
        nodTest = new NodImpl();
    }

    @Test
    public void calculate() {
        Assert.assertEquals(1, nodTest.calculate(0, 1));
        Assert.assertEquals(1, nodTest.calculate(5, 3));
        Assert.assertEquals(1, nodTest.calculate(1, 0));
        Assert.assertEquals(5, nodTest.calculate(15, 10));
        Assert.assertEquals(2, nodTest.calculate(-8, 6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateException() {
        nodTest.calculate(0, 0);
    }
}