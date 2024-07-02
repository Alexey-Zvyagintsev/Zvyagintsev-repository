package ru.sberbank.jd.controller;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.sberbank.jd.model.Student;
import ru.sberbank.jd.model.StudyClass;
import ru.sberbank.jd.service.SchoolService;
import lombok.RequiredArgsConstructor;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SchoolController {

    private SchoolService schoolService;

    @PreAuthorize("hasRole('ROLE_TEACHER') or hasRole('ROLE_STUDENT')")
    @GetMapping("/students")
    public String getAllStudents() {
        return "GET :" + schoolService.getStudentRepository().getAllStudents().toString();
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @PostMapping("/students/add")
    public String addStudent(@RequestBody Student student) {
        schoolService.getStudentRepository().addStudent(student);
        return "STUDENT ADDED :" + student.toString()
        + " TOTAL: " +schoolService.getStudentRepository().getAllStudents().size();
    }

    @DeleteMapping("/students/{id}")
    @PreAuthorize("hasRole('ROLE_TEACHER')")
    public String removeStudent(@PathVariable("id") String name) {
        schoolService.getStudentRepository().removeStudent(name);
        return "REMOVED :" + name;
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @PostMapping("/classes/add")
    public String addClass(@RequestBody StudyClass studyClass) {
        schoolService.getClassRepository().addClass(studyClass);
        return "ADDED :" + schoolService.getClassRepository().getClass()
        + " TOTAL: " + schoolService.getClassRepository().getClasses().size();
    }

    @PreAuthorize("hasRole('ROLE_TEACHER')")
    @PostMapping("/classes/addstudent/{id}")
    public String addClassStudent(@RequestBody Student student, @PathVariable("id") String className) {
        schoolService.getClassRepository().getClass(className).addStudent(student);
        return "ADDED :" + schoolService.getClassRepository().getClass()
                + " TOTAL: " + schoolService.getClassRepository().getClasses().size();
    }

    @PostConstruct
    public void init() {
        schoolService = new SchoolService();
    }
}
