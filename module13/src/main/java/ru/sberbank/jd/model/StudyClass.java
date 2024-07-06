package ru.sberbank.jd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class StudyClass {
    private String name;
    private List<Student> students;

    @Override
    public String toString() {
        return "StudyClass{" +
                "name='" + name + '\'' +
                ", students=" + students +
                '}';
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}
