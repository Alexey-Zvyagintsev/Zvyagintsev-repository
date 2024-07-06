package ru.sberbank.jd.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.sberbank.jd.model.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class StudentRepository {

    private HashMap<String, Student> students;

    public StudentRepository() {
        students = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.put(student.getName(), student);
    }

    public void removeStudent(String studentName) {
        students.remove(studentName);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }
}
