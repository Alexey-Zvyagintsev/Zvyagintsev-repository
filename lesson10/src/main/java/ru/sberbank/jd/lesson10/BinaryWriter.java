package ru.sberbank.jd.lesson10;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import ru.sberbank.jd.lesson10.output.Registry;

/**
 * Класс для записи в файл.
 */
public class BinaryWriter implements WriteToFile {

    /**
     * Метод для записи в файл.
     */
    @Override
    public void write(Registry registry) {

        try {
            OutputStream outputStream = Files.newOutputStream(Paths
                    .get("lesson10/src/main/resources/output/artist_by_country.serialized"));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(registry);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}