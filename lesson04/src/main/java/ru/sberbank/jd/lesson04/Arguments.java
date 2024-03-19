package ru.sberbank.jd.lesson04;

import java.util.ArrayList;

/**
 * Аргументы.
 */
public class Arguments {

    private String option;
    private String userInput;
    private boolean userError = false;
    private ArrayList<String> files;

    private Arguments(ArgumentBuilder argumentBuilder) {
        option = argumentBuilder.option;
        userInput = argumentBuilder.userInput;
        files = argumentBuilder.files;
        userError = argumentBuilder.userError;
    }

    public String getOptions() {
        return option;
    }

    public String getUserInput() {
        return userInput;
    }

    public ArrayList<String> getFiles() {
        return files;
    }

    public boolean getUserError() {
        return userError;
    }

    /**
     * Класс билдер для сбора аргументов.
     */
    public static class ArgumentBuilder {

        private String option;
        private String userInput;
        private ArrayList<String> files;
        private boolean userError;

        public Arguments.ArgumentBuilder setOption(String option) {
            this.option = option;
            return this;
        }

        public Arguments.ArgumentBuilder setUserInput(String userInput) {
            this.userInput = userInput;
            return this;
        }

        public Arguments.ArgumentBuilder setFiles(ArrayList<String> files) {
            this.files = files;
            return this;
        }

        public Arguments.ArgumentBuilder setUserError(Boolean userError) {
            this.userError = userError;
            return this;
        }

        //Собираем
        public Arguments build() {
            return new Arguments(this);
        }
    }
}
