package ru.sberbank.jd.lesson10.output;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для хранения данных о исполнителе.
 */

public class Artist implements Serializable {

    @JacksonXmlProperty(localName = "Name")
    private String name;


    @JacksonXmlElementWrapper(localName = "Albums")
    @JacksonXmlProperty(localName = "Album")
    private List<Album> albums = new ArrayList<>();

    public Artist(String name, List<Album> albums) {
        this.name = name;
        this.albums = albums;
    }

    public String getName() {
        return name;
    }

    public List<Album> getAlbums() {
        return albums;
    }
}