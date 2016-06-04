package com.devcolibri.EasyBuy.service;

import com.devcolibri.EasyBuy.dao.UserDao;
import com.devcolibri.EasyBuy.entity.User;
import com.devcolibri.EasyBuy.entity.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String login) {


        return userDao.getUser(login);
    }

    @Override
    public void saveUser(User user) {
        user.setUserRole(UserRole.USER);
        userDao.saveUser(user);
    }

}
