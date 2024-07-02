package ru.sberbank.jd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.sberbank.jd.security.model.Role;

@AllArgsConstructor
@Getter
@Setter
public class Logins {
    private String login;
    private String password;
    private Role role;
}
