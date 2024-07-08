package ru.sberbank.jd.lesson10;

import org.junit.Assert;
import org.junit.Test;
import ru.sberbank.jd.lesson10.input.Catalog;
import ru.sberbank.jd.lesson10.output.Country;
import ru.sberbank.jd.lesson10.output.Registry;
import java.util.List;

public class MainTest {

    @Test
    public void main() {

        Catalog catalog = FileToCatalog.read();
        //Проверяем, что файл был считан в объект catalog.
        Assert.assertFalse(catalog.getCds().isEmpty());

        Registry registry = CatalogToRegistry.convert(catalog);
        //Проверяем, что из каталога мы получили сгруппированный по странам реестр.
        Assert.assertNotNull(registry);

        List<Country> countries = registry.getCountries();

        //Проверяем, что мы получили список стран и название стран и артистов не пустые.
        Assert.assertFalse(countries.isEmpty());

        for (Country country: countries){
            Assert.assertNotNull(country.getName());
            Assert.assertFalse(country.getArtists().isEmpty());
        }
    }
}