package ru.sberbank.jd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.jd.entity.ProjectEmployeeRole;

@Repository
public interface ProjectEmployeeRoleRepository extends JpaRepository<ProjectEmployeeRole, String> {

}
