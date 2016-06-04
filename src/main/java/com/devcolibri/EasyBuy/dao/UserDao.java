package com.devcolibri.EasyBuy.dao;

import com.devcolibri.EasyBuy.entity.User;

/**
 * Created by misha on 04.06.2016.
 */
public interface UserDao {
    User getUser(String login);
    User getUser(int id);
    void saveUser(User user);

}
