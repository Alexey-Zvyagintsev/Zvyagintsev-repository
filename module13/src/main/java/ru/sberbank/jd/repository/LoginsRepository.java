package ru.sberbank.jd.repository;

import java.util.HashMap;
import lombok.Getter;
import lombok.Setter;
import ru.sberbank.jd.model.Logins;
import ru.sberbank.jd.security.model.Role;

@Getter
@Setter
public class LoginsRepository {

    private HashMap<String, Logins> logins;

    public LoginsRepository() {
        this.logins = new HashMap<>();
        this.logins.put("admin", new Logins("admin", "password", Role.TEACHER));
        this.logins.put("teacher", new Logins("teacher", "tchr", Role.TEACHER));
        this.logins.put("student1", new Logins("student1", "password1", Role.STUDENT));
        this.logins.put("student2", new Logins("student2", "password2", Role.STUDENT));
        this.logins.put("student3", new Logins("student3", "password3", Role.STUDENT));
    }

    public Role getRole(String login, String password) {
        if ( logins.get(login).getPassword().equals(password) ) {
            return logins.get(login).getRole();
        }
        return null;
    }

    public void save(String login, String pass, Role role) {
        logins.put(login, new Logins(login, pass, role));
    }

}
