package ru.sberbank.jd.lesson04;

/**
 * Вывод данных.
 */
public class ResultPrinter {

    /**
     * Вывод результата на экран.
     */
    public void output(OutputResult result) {

        for (String outputString : result.outputStrings) {
            System.out.println(outputString);
        }
    }
}
