package ru.sberbank.jd.lesson04;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Парсинг полученных аргументов.
 */
public class ArgumentParser {
    /**
     * Метод parse.
     */
    public Arguments parse(String[] args) {
        boolean l = false;
        boolean w = false;
        String option = "";
        ArrayList<String> files = new ArrayList<>();
        String usersInput = "";
        for (String argument : args) {
            if (argument.equals("--help") || argument.equals("--version")) {
                return new Arguments.ArgumentBuilder()
                        .setOption(argument)
                        .build();
            } else if (argument.equals("-l")) {
                l = true;
            } else if (argument.equals("-w")) {
                w = true;
            } else if (argument.equals("-wl") || argument.equals("-lw")) {
                l = true;
                w = true;
            } else {
                File f = new File(argument);
                if (f.isFile() || f.isDirectory()) {
                    files.add(String.valueOf(f));
                } else {
                    return new Arguments.ArgumentBuilder()
                            .setUserError(true)
                            .setOption(argument)
                            .build();
                }
            }
        }
        if (l == true && w != true) {
            option = "-l";
        } else if (w == true && l != true) {
            option = "-w";
        } else {
            option = "-lw";
        }
        if (files.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            Scanner s = new Scanner(System.in);
            while (s.hasNext()) {
                stringBuilder.append(s.nextLine() + "\n");
            }
            usersInput = stringBuilder.toString();
        }
        return new Arguments.ArgumentBuilder()
                .setOption(option)
                .setFiles(files)
                .setUserInput(usersInput)
                .build();
    }
}
