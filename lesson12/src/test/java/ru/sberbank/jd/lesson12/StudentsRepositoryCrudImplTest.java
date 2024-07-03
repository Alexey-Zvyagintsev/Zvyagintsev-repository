package ru.sberbank.jd.lesson12;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import ru.sberbank.jd.lesson12.model.Student;

public class StudentsRepositoryCrudImplTest {

    @Test
    public void test(){

        List<UUID> uuids = new ArrayList<>();
        String createTable = "CREATE TABLE IF NOT EXISTS Students (id VARCHAR(36), firstName VARCHAR(32),"
                + "lastName VARCHAR(32), birthDate DATE, isGraduated BOOLEAN)";

        String jdbcUrl = "jdbc:sqlite:C:\\Java\\sample.db";
        try (Connection connection = DriverManager.getConnection(jdbcUrl)) {
            try (Statement statement = connection.createStatement()) {
                // Создаем таблицу Students
                statement.execute(createTable);

                Student student1 = new Student("Вася", "Иванов", new Date(102, 12, 05),
                        false);
                Student student2 = new Student("Петя", "Петров", new Date(103, 02, 03),
                        false);
                // Создаем объект класса для считывания в него данных из БД
                StudentsRepositoryCrudImpl studentsRepositoryCrud = new StudentsRepositoryCrudImpl(connection);

                // Добавляем двух студентов
                assertNotNull(studentsRepositoryCrud.create(student1));
                assertNotNull(studentsRepositoryCrud.create(student2));

                //Получаем список всех студентов
                List<Student> students = studentsRepositoryCrud.selectAll();
                for (Student student : students) {
                    uuids.add(student.getId());
                }

                // Проверим, что в таблице 2 записи
                assertEquals(2,students.size());

                // Проверим имя первого студента из таблицы
                assertEquals("Вася",students.get(0).getFirstName());

                // Проверим, что UUID у второго студента не null
                assertNotNull(students.get(1).getId());

                // Создаем еще одну запись о студенте
                Student student3 = new Student("Иван", "Сидоров", new Date(103, 02, 03),
                        false);
                assertNotNull(studentsRepositoryCrud.create(student3));
                students = studentsRepositoryCrud.selectAll();
                uuids.add(students.get(2).getId());

                // Проверка метода update, меняем isGraduated
                student3 = new Student( uuids.get(2), "Иван", "Сидоров",
                        new Date(103, 02, 03), true);
                assertNotNull(studentsRepositoryCrud.create(student3));

                students = studentsRepositoryCrud.selectAll();

                // Проверим, что isGraduated у студента поменялся на true
                assertTrue(students.get(2).isGraduated());
                // Проверим, что в таблице стало 3 записи
                assertEquals(3,students.size());

                // Проверим, что после выборки по id получаем непустой объект Student
                assertNotNull(studentsRepositoryCrud.selectById(uuids.get(0)));

                // Проверим, что количество удаленных записей 3
                assertEquals(3,studentsRepositoryCrud.remove(uuids));
                students = studentsRepositoryCrud.selectAll();
                // Проверим, что таблица пустая
                assertTrue(students.isEmpty());

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}