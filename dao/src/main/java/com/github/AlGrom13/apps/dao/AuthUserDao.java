package com.github.AlGrom13.apps.dao;

import com.github.AlGrom13.apps.model.AuthUser;

public interface AuthUserDao {

    AuthUser getByLogin(String login);

    Long saveAuthUser(AuthUser authUser);

    void updateAuthUser(AuthUser authUser);

    void deleteAuthUser(AuthUser authUser);
}
