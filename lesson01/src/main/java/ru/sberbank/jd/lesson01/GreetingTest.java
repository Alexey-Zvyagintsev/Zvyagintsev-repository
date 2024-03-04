package ru.sberbank.jd.lesson01;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * класс GreetingTest.
 */
public class GreetingTest {

    GreetingImpl greeting;

    @Before
    public void init() {
        System.out.println("Before test");
        greeting = new GreetingImpl();
    }

    @Test
    public void yearTest() {
        // Assert.assertEquals(1984, greeting.getBirthYear());
        Assert.assertNotEquals(0, greeting.getBirthYear());
    }


    @Test
    public void firstNameTest() {
        Assert.assertNotNull(greeting.getFirstName());
    }

    @Test
    public void lastNameTest() {
        Assert.assertNotNull(greeting.getLastName());
    }

    @Test
    public void hobbiesTest() {
        Assert.assertFalse(greeting.getHobbies().isEmpty());
    }

    @Test
    public void expectationsTest() {
        Assert.assertFalse(greeting.getCourseExpectations().isEmpty());
    }

    @Test
    public void repoUrlTest() {
        Assert.assertNotNull(greeting.getRepoUrl());
    }

    @Test
    public void phoneTest() {
        Assert.assertNotNull(greeting.getPhone());
    }

}
