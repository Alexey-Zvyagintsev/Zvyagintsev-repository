package ru.sberbank.jd.lesson07;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Класс для тестирования CustomDigitComparator.
 */
public class CustomDigitComparatorTest {

    CustomDigitComparator customDigitComparator;

    /**
     * Before.
     */
    @Before
    public void setUp() {
        customDigitComparator = new CustomDigitComparator();
    }

    /**
     * Тестовое покрытие.
     * Проверка на сравнение с null.
     * 1. Все четные.
     * 2. Все нечетные.
     * 3. Первое четное, второе нечетное.
     * 4. Первое нечетное, второе четное.
     */
    @Test
    public void compare() {
        Assert.assertThrows(NullPointerException.class, () -> {
            customDigitComparator.compare(1, null);
        });
        Assert.assertEquals(0, customDigitComparator.compare(14, 100));
        Assert.assertEquals(0, customDigitComparator.compare(1, 7));
        Assert.assertEquals(-1, customDigitComparator.compare(2, 9));
        Assert.assertEquals(1, customDigitComparator.compare(5, 2));
    }
}