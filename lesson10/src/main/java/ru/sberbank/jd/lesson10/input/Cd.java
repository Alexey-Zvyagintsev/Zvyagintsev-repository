package ru.sberbank.jd.lesson10.input;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Класс для хранения данных о диске.
 */

@JacksonXmlRootElement(localName = "CD")
public class Cd {

    @JacksonXmlProperty(localName = "TITLE")
    private String title;
    @JacksonXmlProperty(localName = "ARTIST")
    private String artist;
    @JacksonXmlProperty(localName = "COUNTRY")
    private String country;
    @JacksonXmlProperty(localName = "COMPANY")
    private String company;
    @JacksonXmlProperty(localName = "PRICE")
    private double price;
    @JacksonXmlProperty(localName = "YEAR")
    private int year;

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getCountry() {
        return country;
    }

    public String getCompany() {
        return company;
    }

    public double getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }


}
