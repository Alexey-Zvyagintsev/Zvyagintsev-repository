package ru.sberbank.jd.lesson01;

import java.util.ArrayList;
import java.util.Collection;

/**
 * класс GreetingImpl.
 */
public class GreetingImpl implements Greeting {

    /**
     * Получение имени.
     */
    @Override
    public String getFirstName() {
        return "Алексей";
    }

    /**
     * Получение фамилии.
     */
    @Override
    public String getLastName() {
        return "Звягинцев";
    }

    /**
     * Получение года рождения.
     */
    @Override
    public int getBirthYear() {
        return 1984;
    }

    /**
     * Получение набора хобби.
     */
    @Override
    public Collection<String> getHobbies() {
        Collection<String> myHobbies = new ArrayList<>();
        myHobbies.add("Скейт");
        myHobbies.add("Сноуборд");
        return myHobbies;
    }

    /**
     * Получение имени репозитория.
     */
    @Override
    public String getRepoUrl() {
        return "https://github.com/Alexey-Zvyagintsev/Zvyagintsev-repository";
    }

    /**
     * Получение телефона.
     */
    @Override
    public String getPhone() {
        return "89032333228";
    }

    /**
     * Получение набора ожиданий от курса.
     */
    @Override
    public Collection<String> getCourseExpectations() {
        Collection<String> myExpectstions = new ArrayList<>();
        myExpectstions.add("Знание Java");
        myExpectstions.add("Ознакомление с инструментами разработки");
        return myExpectstions;
    }
}
