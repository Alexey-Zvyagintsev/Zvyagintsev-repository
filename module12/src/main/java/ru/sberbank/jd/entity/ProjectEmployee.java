package ru.sberbank.jd.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class ProjectEmployee implements Serializable {

    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "project_id")
    private String projectId;

}
