Hibernate: create table department (department_name timestamp(6), department_id varchar(255) not null, primary key (department_id))
Hibernate: create table employee (boss_department char(1) not null, department_department_id varchar(255), employee_id varchar(255) not null, first_name varchar(255), last_name varchar(255), primary key (employee_id))
Hibernate: create table project (project_id varchar(255) not null, project_name varchar(255), primary key (project_id))
Hibernate: create table project_employee_role (employee_id varchar(255) not null, project_id varchar(255) not null, role_role_id varchar(255), primary key (employee_id, project_id))
Hibernate: create table role (role_id varchar(255) not null, role_name varchar(255), primary key (role_id))
Hibernate: alter table if exists employee add constraint FKiojsy23dwh2w9geqmvn955dqp foreign key (department_department_id) references department
Hibernate: alter table if exists project_employee_role add constraint FK85kadb2yyhbpi5a6y8nistfet foreign key (employee_id) references employee
Hibernate: alter table if exists project_employee_role add constraint FK369qfgon0y669v55b9w75ejdi foreign key (project_id) references project
Hibernate: alter table if exists project_employee_role add constraint FKlmh2p354w6mu70fwl2cbj7yx2 foreign key (role_role_id) references role