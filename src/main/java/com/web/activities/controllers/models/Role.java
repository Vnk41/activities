package com.web.activities.controllers.models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, USER, SUPERUSER;

    @Override
    public String getAuthority() {
        return name();
    }
}
