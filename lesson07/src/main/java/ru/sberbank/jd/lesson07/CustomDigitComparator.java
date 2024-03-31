package ru.sberbank.jd.lesson07;

import java.util.Comparator;

/**
 * Класс, определяющий порядок четных и нечетных чисел.
 */
public class CustomDigitComparator implements Comparator<Integer> {

    /**
     * Метод compare.
     * Определяется следующий порядок.
     * Сначала четные числа, затем нечетные
     * На вход подаются числа, отличные от null.
     *
     * @param i1 the first object to be compared.
     * @param i2 the second object to be compared.
     * @return возвращает результат сравнения двух чисел.
     */
    @Override
    public int compare(Integer i1, Integer i2) {
        if (i1 == null || i2 == null) {
            throw new NullPointerException("На вход должны подаваться числа, отличные от null");
        }
        //Оба числа четные или нечетные.
        if (i1 % 2 == 0 && i2 % 2 == 0 || i1 % 2 != 0 && i2 % 2 != 0) {
            return 0;
        //Первое четное, второе нечетное.
        } else if (i1 % 2 == 0 && i2 % 2 != 0) {
            return -1;
        //Первое нечетное, второе четное.
        } else {
            return 1;
        }
    }
}
