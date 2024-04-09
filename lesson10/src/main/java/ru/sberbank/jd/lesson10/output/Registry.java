package ru.sberbank.jd.lesson10.output;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для хранения данных по странам.
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JacksonXmlRootElement(localName = "ArtistRegistry")
public class Registry implements Serializable {

    @JacksonXmlProperty(isAttribute = true)
    private int countryCount;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Country")
    private List<Country> countries = new ArrayList<>();

    /**
     * getCountries method.
     */
    public List<Country> getCountries() {
        return countries;
    }

    /**
     * setCountryCount.
     */
    public void setCountryCount(int countryCount) {
        this.countryCount = countryCount;
    }

    /**
     * setCountries.
     */
    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}