package ru.sberbank.jd.lesson10;

import java.util.ArrayList;
import java.util.List;
import ru.sberbank.jd.lesson10.input.Catalog;
import ru.sberbank.jd.lesson10.output.Registry;

/**
 * Класс Main.
 * Основной класс для запуска и тестирования программы.
 */
public class Main {

    /**
     * Метод main.
     */
    public static void main(String[] args) {
        Catalog catalog = FileToCatalog.read();
        Registry registry = CatalogToRegistry.convert(catalog);

        List<WriteToFile> recording = new ArrayList<>();
        recording.add(new XmlWriter());
        recording.add(new JsonWriter());
        recording.add(new BinaryWriter());

        recording.forEach(writer -> writer.write(registry));
    }
}
