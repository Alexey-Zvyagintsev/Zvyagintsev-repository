package ru.sberbank.jd.lesson10;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import ru.sberbank.jd.lesson10.output.Registry;

/**
 * Класс для записи в JSON файл.
 */
public class JsonWriter implements WriteToFile {

    /**
     * Метод для записи в JSON файл.
     */
    @Override
    public void write(Registry registry) {
        ObjectMapper objMapper = new ObjectMapper();
        objMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            objMapper.writeValue(new File("lesson10/src/main/resources/output/artist_by_country.json"), registry);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
