package ru.sberbank.jd.security.model;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public enum Role implements GrantedAuthority {

    TEACHER("ROLE_TEACHER"),
    STUDENT("ROLE_STUDENT");

    private final String value;

    @Override
    public String getAuthority() {
        return value;
    }
}