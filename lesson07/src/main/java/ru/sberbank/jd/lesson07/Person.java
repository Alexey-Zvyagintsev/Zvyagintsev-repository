package ru.sberbank.jd.lesson07;

import java.util.Objects;

/**
 * Класс для хранения данных о человеке.
 */
public class Person implements Comparable<Person> {

    private String name;
    private String city;
    private int age;

    /**
     * Конструктор класса Person.
     *
     * @param name не может быть null
     * @param city не может быть null
     * @throws NullPointerException если city или name пустые выбрасываем ошибку.
     */
    public Person(String name, String city, int age) throws NullPointerException {
        if (name == null || city == null) {
            throw new NullPointerException("Поля `city` и `name` должны быть отличны от `null`");
        }
        this.name = name;
        this.city = city;
        this.age = age;
    }

    /**
     * equals.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        //Проверка на сравнение с null или с обьектом другого класса.
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        //Все значения в обьекте должны совпадать.
        return age == person.age && name.equalsIgnoreCase(person.name) && city.equalsIgnoreCase(person.city);
    }

    /**
     * hashCode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(), city.toLowerCase(), age);
    }

    /**
     * Метод compareTo.
     *
     * @param other the object to be compared.
     * @return возвращает результат сравнения.
     */
    @Override
    public int compareTo(Person other) {
        //Сортировка сначала по полю city, а затем по полю name.
        int cityCompare = city.compareTo(other.city);
        if (cityCompare == 0) {
            //Сортировка по name
            return name.compareTo(other.name);
        }
        return cityCompare;
    }

    /**
     * toString.
     */
    @Override
    public String toString() {
        return "{ " + name + ' ' + ", " + city + ' ' + ", " + age + " }";
    }
}