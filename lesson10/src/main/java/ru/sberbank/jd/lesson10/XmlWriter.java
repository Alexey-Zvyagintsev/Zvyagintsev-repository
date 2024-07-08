package ru.sberbank.jd.lesson10;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;
import ru.sberbank.jd.lesson10.output.Registry;

/**
 * Класс для записи в XML файл.
 */
public class XmlWriter implements WriteToFile {

    /**
     * Метод для записи в XML файл.
     */
    @Override
    public void write(Registry registry) {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            xmlMapper.writeValue(new File("lesson10/src/main/resources/output/artist_by_country.xml"), registry);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}