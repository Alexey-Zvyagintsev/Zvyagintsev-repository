package ru.sberbank.jd.lesson10.input;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.List;

/**
 * Класс для хранения данных каталога.
 */

@JacksonXmlRootElement(localName = "CATALOG")
public class Catalog {

    @JacksonXmlProperty(localName = "CD")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Cd> cds;

    public List<Cd> getCds() {
        return cds;
    }


}
