package ru.sberbank.jd.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.repository.ClassRepository;
import ru.sberbank.jd.repository.StudentRepository;

@Service
@Getter
@Setter
public class SchoolService {
    private ClassRepository classRepository;
    private StudentRepository studentRepository;

    public SchoolService() {
        this.classRepository = new ClassRepository();
        this.studentRepository = new StudentRepository();
    }
}
