package ru.sberbank.jd.lesson12.model;


import java.util.Date;
import java.util.UUID;

/**
 * Класс, отражающий структуру хранимых в таблице полей.
 */
public class Student {

    /*
     * Первичный ключ.
     *
     * Рекомендуется генерировать его только внутри StudentsRepositoryCRUD.create(),
     * иными словами до момента пока объект не будет сохранен в БД, он не должен
     * иметь значение id.
     */
    private UUID id;

    private String firstName;

    private String lastName;

    private Date birthDate;

    private boolean isGraduated;

    /**
     * Constructor.
     *
     * @param id id
     * @param firstName firstName
     * @param lastName lastName
     * @param birthDate birthDate
     * @param isGraduated isGraduated
     */
    public Student(UUID id, String firstName, String lastName, Date birthDate, boolean isGraduated) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.isGraduated = isGraduated;
    }

    /**
     *  Constructor.
     *
     * @param firstName firstName
     * @param lastName lastName
     * @param birthDate birthDate
     * @param isGraduated isGraduated
     */
    public Student(String firstName, String lastName, Date birthDate, boolean isGraduated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.isGraduated = isGraduated;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public boolean isGraduated() {
        return isGraduated;
    }

    @Override
    public String toString() {
        return "Student{"
                + "id=" + id
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", birthDate=" + birthDate
                + ", isGraduated=" + isGraduated
                + '}';
    }
}
