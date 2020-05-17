package com.github.AlGrom13.apps.dao;

import com.github.AlGrom13.apps.model.AuthUser;

public interface AdminDao {

    AuthUser getByLogin(String login);

    Long saveAdmin(AuthUser admin);

    void changePassword(String login, String password);

    void deleteByLogin(String login);
}
