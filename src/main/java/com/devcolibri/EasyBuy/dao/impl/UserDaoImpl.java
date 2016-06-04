package com.devcolibri.EasyBuy.dao.impl;

import com.devcolibri.EasyBuy.dao.UserDao;
import com.devcolibri.EasyBuy.entity.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by misha on 04.06.2016.
 */

@Repository
@Transactional
public class UserDaoImpl extends AbstractDao implements UserDao {
    @Override
    @Transactional
    public User getUser(String login) {
        return (User) getSession().createCriteria(User.class).
                add(Restrictions.eq("login", login));
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return (User) getSession().get(User.class, id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void saveUser(User user) {
        getSession().save(user);
    }
}
