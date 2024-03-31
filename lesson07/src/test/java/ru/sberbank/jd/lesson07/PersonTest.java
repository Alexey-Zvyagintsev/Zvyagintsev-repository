package ru.sberbank.jd.lesson07;

import org.junit.Assert;
import org.junit.Test;

/**
 * Тестирование класса Person
 */
public class PersonTest {

    /**
     * test equals().
     */
    @Test
    public void testEquals() {
        Person p1 = new Person("Вася", "Москва", 25);
        Person p2 = new Person("Петя", "Самара", 25);
        Assert.assertFalse(p1.equals(p2));
        Assert.assertNotEquals(p1.hashCode(), p2.hashCode());
        Person p3 = new Person("Вова", "сочи", 26);
        Person p4 = new Person("вОва", "Сочи", 26);
        Assert.assertTrue(p3.equals(p4));
        Assert.assertEquals(p3.hashCode(), p3.hashCode());
    }

    /**
     * test compareTo().
     */
    @Test
    public void compareTo() {
        Person p1 = new Person("Вася", "Воронеж", 25);
        Person p2 = new Person("Петя", "Самара", 25);
        Assert.assertEquals(-15, p1.compareTo(p2));
        Person p3 = new Person("Вова", "сочи", 26);
        Person p4 = new Person("вОва", "Сочи", 26);
        Assert.assertEquals(32, p3.compareTo(p4));
    }
}