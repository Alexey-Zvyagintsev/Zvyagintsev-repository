package ru.sberbank.jd.lesson12;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import ru.sberbank.jd.lesson12.model.Student;

/**
 * Класс для работы с записями таблицы Students.
 */
public class StudentsRepositoryCrudImpl implements StudentsRepositoryCrud {

    private Connection connection;

    /**
     * Constructor.
     *
     * @param connection коннект к БД
     */
    public StudentsRepositoryCrudImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * Создание записи о студенте.
     *
     * @param student - заполненный объект
     * @return создаем студента и возвращаем его UUID
     */
    @Override
    public UUID create(Student student) {
        String statament = null;
        UUID studentId = student.getId();

        if (studentId != null) {
            //Если студент найден, то обновляем информацию о студенте
            update(student);
        } else {
            //Если студент не найден, то создаем запись в БД о новом студенте
            studentId = UUID.randomUUID(); //Генерируем новый id
            statament = "INSERT INTO Students (id, firstName, lastName, birthDate, isGraduated) VALUES (?, ?, ?, ?, ?)";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(statament);
                preparedStatement.setString(1, studentId.toString());
                preparedStatement.setString(2, student.getFirstName());
                preparedStatement.setString(3, student.getLastName());
                preparedStatement.setDate(4, (Date) student.getBirthDate());
                preparedStatement.setBoolean(5, student.isGraduated());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return studentId;
    }

    /**
     * Получение записи о студенте.
     *
     * @param id идентификатор записи
     * @return возвращаем запись о студенте по UUID
     */
    @Override
    public Student selectById(UUID id) {

        Student student = null;

        if (id == null) {
            return student;
        }
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM Students WHERE id = '" + id.toString() + "'");
            while (rs.next()) {
                student = new Student(UUID.fromString(rs.getString("id")),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getDate("birthDate"),
                        rs.getBoolean("isGraduated"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    /**
     * Получение всех записей о студентах.
     *
     * @return возвращаем список студентов
     */
    @Override
    public List<Student> selectAll() {
        List<Student> students = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM Students");
            while (rs.next()) {
                students.add(new Student(UUID.fromString(rs.getString("id")),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getDate("birthDate"),
                        rs.getBoolean("isGraduated")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    /**
     * Обновление записи о студенте.
     *
     * @param student измененная запись
     * @return запись об измененном студенте
     */
    @Override
    public int update(Student student) {
        int updatedStudents = 0;
        String sql = "UPDATE Students SET firstName = ?, lastName = ?, birthDate = ?, isGraduated = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setDate(3, (Date) student.getBirthDate());
            preparedStatement.setBoolean(4, student.isGraduated());
            preparedStatement.setString(5, student.getId().toString());
            updatedStudents = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return updatedStudents;
    }

    /**
     * Удаление всех записей из таблицы Students.
     *
     * @param idList список идентификаторов записей
     * @return количество удаленных записей
     */
    @Override
    public int remove(List<UUID> idList) {
        int removedRows = 0;
        String sql = "DELETE FROM Students WHERE id = ?";
        for (UUID id : idList) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, id.toString());
                removedRows = removedRows + preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return removedRows;
    }
}
