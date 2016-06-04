package com.devcolibri.EasyBuy.service;

import com.devcolibri.EasyBuy.entity.User;

public interface UserService {

    User getUser(String login);

    void saveUser(User user);
}
