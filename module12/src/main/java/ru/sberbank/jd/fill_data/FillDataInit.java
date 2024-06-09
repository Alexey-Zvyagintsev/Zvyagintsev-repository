package ru.sberbank.jd.fill_data;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.sberbank.jd.entity.Department;
import ru.sberbank.jd.entity.Employee;
import ru.sberbank.jd.entity.Project;
import ru.sberbank.jd.entity.ProjectEmployeeRole;
import ru.sberbank.jd.entity.Role;
import ru.sberbank.jd.repository.DepartmentRepository;
import ru.sberbank.jd.repository.EmployeeRepository;
import ru.sberbank.jd.repository.ProjectEmployeeRoleRepository;
import ru.sberbank.jd.repository.ProjectRepository;
import ru.sberbank.jd.repository.RoleRepository;

@Component
@AllArgsConstructor
@Slf4j
public class FillDataInit {

    private DepartmentRepository departmentRepository;
    private EmployeeRepository employeeRepository;
    private ProjectRepository projectRepository;
    private RoleRepository roleRepository;
    private ProjectEmployeeRoleRepository perRepository;

    @PostConstruct
    public void initData() {
        Department department1 = new Department();
        Department department2 = new Department();
        Department department3 = new Department();
        department1.setDepartmentName("IT");
        department2.setDepartmentName("HR");
        department3.setDepartmentName("Бухгалтерия");
        departmentRepository.save(department1);
        departmentRepository.save(department2);
        departmentRepository.save(department3);
        departmentRepository.flush();

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Employee employee3 = new Employee();
        Employee employee4 = new Employee();
        Employee employee5 = new Employee();
        Employee employee6 = new Employee();
        employee1.setFirstName("Василий");
        employee1.setLastName("Иванов");
        employee1.setBossDepartment('X');
        employee1.setDepartment(department1);
        employee2.setFirstName("Иван");
        employee2.setLastName("Сидоров");
        employee2.setDepartment(department1);
        employee3.setFirstName("Петр");
        employee3.setLastName("Петров");
        employee3.setBossDepartment('X');
        employee3.setDepartment(department2);
        employee4.setFirstName("Лариса");
        employee4.setLastName("Васильева");
        employee4.setDepartment(department2);
        employee5.setFirstName("Юлия");
        employee5.setLastName("Сидорова");
        employee5.setBossDepartment('X');
        employee5.setDepartment(department3);
        employee6.setFirstName("Ксения");
        employee6.setLastName("Лазарева");
        employee6.setDepartment(department3);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
        employeeRepository.save(employee4);
        employeeRepository.save(employee5);
        employeeRepository.save(employee6);
        employeeRepository.flush();

        Project project1 = new Project();
        Project project2 = new Project();
        project1.setProjectName("Проект миграции");
        project2.setProjectName("Отчетность");
        projectRepository.save(project1);
        projectRepository.save(project2);
        projectRepository.flush();

        Role role1 = new Role();
        Role role2 = new Role();
        Role role3 = new Role();
        Role role4 = new Role();
        role1.setRoleName("Разработчик");
        role2.setRoleName("Консультант");
        role3.setRoleName("Аналитик");
        role4.setRoleName("Руководитель проекта");

        roleRepository.save(role1);
        roleRepository.save(role2);
        roleRepository.save(role3);
        roleRepository.save(role4);
        roleRepository.flush();

        ProjectEmployeeRole per1 = new ProjectEmployeeRole();
        ProjectEmployeeRole per2 = new ProjectEmployeeRole();
        ProjectEmployeeRole per3 = new ProjectEmployeeRole();
        ProjectEmployeeRole per4 = new ProjectEmployeeRole();
        ProjectEmployeeRole per5 = new ProjectEmployeeRole();
        per1.setProject(project1);
        per1.setEmployee(employee2);
        per1.setRole(role1);
        per2.setProject(project1);
        per2.setEmployee(employee4);
        per2.setRole(role2);
        per3.setProject(project2);
        per3.setEmployee(employee5);
        per3.setRole(role4);
        per4.setProject(project2);
        per4.setEmployee(employee2);
        per4.setRole(role1);
        per5.setProject(project2);
        per5.setEmployee(employee3);
        per5.setRole(role3);

        perRepository.save(per1);
        perRepository.save(per2);
        perRepository.save(per3);
        perRepository.save(per4);
        perRepository.save(per5);
        perRepository.flush();

    }

}
