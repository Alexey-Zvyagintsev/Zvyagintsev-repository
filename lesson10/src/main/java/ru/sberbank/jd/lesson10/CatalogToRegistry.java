package ru.sberbank.jd.lesson10;

import java.util.List;
import java.util.stream.Collectors;
import ru.sberbank.jd.lesson10.input.Catalog;
import ru.sberbank.jd.lesson10.input.Cd;
import ru.sberbank.jd.lesson10.output.Album;
import ru.sberbank.jd.lesson10.output.Artist;
import ru.sberbank.jd.lesson10.output.Country;
import ru.sberbank.jd.lesson10.output.Registry;

/**
 * Класс для конвертации Catalog в Registry.
 */
public class CatalogToRegistry {

    /**
     * Метод для конвертации Catalog в Registry.
     * Получаем catalog и формируем реестр сгруппированный сначала по стране,
     * потом по артисту.
     */
    public static Registry convert(Catalog catalog) {

        Registry registry = new Registry();

        List<Country> countries = catalog.getCds().stream()
                .collect(Collectors.groupingBy(Cd::getCountry,
                        Collectors.groupingBy(Cd::getArtist,
                                Collectors.mapping(obj -> new Album(obj.getTitle(), obj.getYear()),
                                        Collectors.toList()))))
                .entrySet().stream().map(obj -> new Country(obj.getKey(), obj.getValue().entrySet().stream()
                        .map(art -> new Artist(art.getKey(), art.getValue()))
                        .collect(Collectors.toList())))
                .collect(Collectors.toList());

        registry.setCountries(countries);
        registry.setCountryCount(countries.size());
        return registry;
    }
}