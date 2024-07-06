package ru.sberbank.jd.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.sberbank.jd.model.Student;
import ru.sberbank.jd.model.StudyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ClassRepository {
    private HashMap<String, StudyClass> classes;
    public void addClass(StudyClass c) {
        classes.put(c.getName(), c);
    }
    public List<StudyClass> getClasses() {
        return new ArrayList<>(classes.values());
    }

    public StudyClass getClass(String name) {
        return classes.get(name);
    }

    public void addStudentToClass(String name, Student student) {
        StudyClass sc = classes.get(name);
        sc.addStudent(student);
    }
}
