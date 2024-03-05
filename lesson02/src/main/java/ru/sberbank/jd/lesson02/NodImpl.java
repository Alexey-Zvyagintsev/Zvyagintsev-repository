package ru.sberbank.jd.lesson02;

/**
 * Реализация класса c интерфейсом Nod.
 */
public class NodImpl implements Nod {

    /**
     * Вычисляет наибольший общий делитель двух целых чисел.
     *
     * @param first  первое число
     * @param second второе число
     * @return наибольший общий делитель
     */
    @Override
    public int calculate(int first, int second) {
        //return 0;
        int a = Math.abs(first);
        int b = Math.abs(second);
        int nod;
        if (a == 0 && b == 0) {
            return -1;
        } else if (a == 0) {
            return b;
        } else if (b == 0) {
            return a;
        } else {
            nod = Math.min(a, b);
            for (int i = nod; i > 0; i--) {
                if ((a % i == 0) && (b % i == 0)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
