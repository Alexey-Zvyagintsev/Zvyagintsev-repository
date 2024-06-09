package ru.sberbank.jd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String roleId;

    private String roleName;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<ProjectEmployeeRole> projectEmployeeRoles;
}
