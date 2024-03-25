package ru.sberbank.jd.lesson04;

import org.junit.*;

/**
 * Класс для тесторования OutputGenerator.
 */
public class OutputGeneratorTest {

    OutputGenerator outputGenerator;
    ArgumentParser parser;

    /**
     * Before.
     */
    @Before
    public void setUp() throws Exception {
        outputGenerator = new OutputGenerator();
    }

    /**
     * Тест метода на возврат объекта класса OutputResult.
     */
    @Test
    public void generate() {
        parser = new ArgumentParser();
        String[] arguments = new String[1];
        arguments[0] = "--help";
        Arguments args = parser.parse(arguments);
        Assert.assertNotNull(outputGenerator.generate(args));

        arguments = new String[2];
        arguments[0] = "-l -w";
        arguments[1] = "pom.xml";
        args = parser.parse(arguments);
        Assert.assertNotNull(outputGenerator.generate(args));
    }
}