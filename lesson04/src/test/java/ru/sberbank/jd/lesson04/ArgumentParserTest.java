package ru.sberbank.jd.lesson04;

import org.junit.*;

/**
 * Класс для тестирования ArgumentParser.
 */
public class ArgumentParserTest {

    ArgumentParser argumentParser;

    /**
     * Before.
     */
    @Before
    public void setUp() {
        argumentParser = new ArgumentParser();
    }

    /**
     * Проверка на получение экземпляра класса.
     */
    @Test
    public void parse() {
        String[] arguments = new String[1];
        arguments[0] = "--help";
        Assert.assertNotNull(argumentParser.parse(arguments));
        arguments = new String[1];
        arguments[0] = "--version";
        Assert.assertNotNull(argumentParser.parse(arguments));
        arguments = new String[2];
        arguments[0] = "-l -w";
        arguments[1] = "pom.xml";
        Assert.assertNotNull(argumentParser.parse(arguments));
    }
}