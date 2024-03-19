package ru.sberbank.jd.lesson04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Генерация данных для вывода.
 */
public class OutputGenerator {

    /**
     * Создаем строки для вывода исходя их полученных аргументов.
     */
    public OutputResult generate(Arguments arguments) {

        int[] count = new int[2];
        OutputResult outputResult = new OutputResult();
        String lines = "";
        String words = "";
        int fileLines = 0;
        int fileWords = 0;
        File file;
        StringBuilder stringBuilder;
        if (arguments.getUserError()) {
            addOutputResult(outputResult, "wc:", "invalid option", arguments.getOptions());
            outputResult.outputStrings.add(" Try 'wc --help' for more information.\n");
        } else if (arguments.getOptions().equals("--help")) {
            outputResult.outputStrings.add(" Информация о содержимом файла и вывода с консоли:\n"
                    + "     -l - количество строк\n"
                    + "     -w - количество слов\n"
                    + "     --help - печать справки по использованию программы\n"
                    + "     --version - информация о программе\n");
        } else if (arguments.getOptions().equals("--version")) {
            outputResult.outputStrings.add(" version01\n" + "Zvyagintsev AV\n");
        } else {
            if (!arguments.getUserInput().isEmpty()) {
                // Cтроки и слова
                count = counter(arguments.getUserInput());

                switch (arguments.getOptions()) {
                    case ("-l"):
                        lines = String.valueOf(count[0]);
                        break;
                    case ("-w"):
                        words = String.valueOf(count[1]);
                        break;
                    case ("-lw"):
                        lines = String.valueOf(count[0]);
                        words = String.valueOf(count[1]);
                        break;
                    default:
                        break;
                }

                addOutputResult(outputResult, lines, words, "");
            } else {
                // Чтение файлов
                int fileCounter = 0;
                for (String fileName : arguments.getFiles()) {
                    lines = "";
                    words = "";
                    file = new File(fileName);
                    if (file.isDirectory()) {
                        if (arguments.getOptions().equals("-lw")) {
                            addOutputResult(outputResult, "wc:", fileName, ": Это каталог");
                            lines = "0";
                            words = "0";
                        } else {
                            addOutputResult(outputResult, "wc:", fileName, ": Это каталог");
                            lines = "0";
                            words = "";
                        }
                        addOutputResult(outputResult, lines, words, fileName);
                    } else {
                        try {
                            fileCounter++;
                            Scanner scan = new Scanner(file);
                            stringBuilder = new StringBuilder();
                            while (scan.hasNextLine()) {
                                stringBuilder.append(scan.nextLine() + '\n');
                            }
                            scan.close();
                            if (!stringBuilder.toString().isEmpty()) {
                                // посчитаем строки и слова
                                count = counter(stringBuilder.toString());
                                if (arguments.getOptions().equals("-l")) {
                                    lines = String.valueOf(count[0]);
                                    fileLines += count[0];
                                } else if (arguments.getOptions().equals("-w")) {
                                    words = String.valueOf(count[1]);
                                    fileWords += count[1];
                                } else {
                                    lines = String.valueOf(count[0]);
                                    words = String.valueOf(count[1]);
                                    fileLines += count[0];
                                    fileWords += count[1];
                                }

                                addOutputResult(outputResult, lines, words, fileName);
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("Ошибка при чтении файла");
                        }
                    }
                }
                if (fileCounter > 0) {
                    if (arguments.getOptions().equals("-l")) {
                        addOutputResult(outputResult, String.valueOf(fileLines), "", "итого");
                    } else if (arguments.getOptions().equals("-w")) {
                        addOutputResult(outputResult, "", String.valueOf(fileWords), "итого");
                    } else {
                        addOutputResult(outputResult, String.valueOf(fileLines), String.valueOf(fileWords), "итого");
                    }
                }
            }
        }
        if (outputResult.outputStrings.isEmpty()) {
            outputResult.outputStrings.add("\n");
        }
        return outputResult;
    }

    /**
     * Считаем буквы и слова в строке.
     */
    private int[] counter(String input) {

        int[] count = new int[]{0, 0};
        int wordCount = 0;
        int lineCount = 0;
        boolean isWord = false;
        boolean charOrDigit = false;
        int endOfLine = input.length() - 1;
        char[] characters = input.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            charOrDigit = Character.isLetterOrDigit(characters[i]);
            if (Character.toString(characters[i]).equals("\n")) {
                lineCount++;
            }

            if (charOrDigit && i != endOfLine) {
                isWord = true;
            } else if (!charOrDigit && isWord) {
                wordCount++;
                isWord = false;
            } else if (charOrDigit) {
                wordCount++;
            }
        }
        count[0] = lineCount;
        count[1] = wordCount;
        return count;
    }

    /**
     * Формируем и добавляем строки для вывода.
     */
    private void addOutputResult(OutputResult outResult, String valueLines, String valueWords, String total) {
        if (valueLines.equals("") && !valueWords.isEmpty()) {
            String formatString = "%4s %4s %4s";
            outResult.outputStrings.add(String.format(formatString, valueWords, total, valueLines));
        } else if (valueWords.equals("") && !valueLines.isEmpty()) {
            String formatString = "%4s %4s %4s";
            outResult.outputStrings.add(String.format(formatString, valueLines, total, valueWords));
        } else if (!valueWords.isEmpty() && !valueLines.isEmpty()) {
            String formatString = "%4s %4s %4s";
            outResult.outputStrings.add(String.format(formatString, valueLines, valueWords, total));
        }
    }
}