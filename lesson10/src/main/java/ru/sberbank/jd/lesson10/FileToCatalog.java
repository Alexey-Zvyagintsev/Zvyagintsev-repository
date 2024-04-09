package ru.sberbank.jd.lesson10;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;
import ru.sberbank.jd.lesson10.input.Catalog;

/**
 * Класс чтения XML файла в объект класса Catalog.
 */
public class FileToCatalog {

    /**
     * Метод для чтения XML файла в объект класса Catalog.
     * Читает файл по указанному пути и десериализует в объект класса Catalog.
     */
    static Catalog read() {

        Catalog catalog = null;
        XmlMapper xmlMapper = new XmlMapper();
        File file = new File("lesson10/src/main/resources/input/cd_catalog.xml");
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            catalog = xmlMapper.readValue(file, Catalog.class);
        } catch (IOException e) {
            file = new File("src/main/resources/input/cd_catalog.xml");
            try {
                catalog = xmlMapper.readValue(file, Catalog.class);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        return catalog;
    }

}
