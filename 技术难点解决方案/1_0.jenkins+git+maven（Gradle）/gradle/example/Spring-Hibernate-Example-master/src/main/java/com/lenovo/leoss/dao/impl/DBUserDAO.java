package com.lenovo.leoss.dao.impl;

import com.lenovo.leoss.dao.inter.UserDAO;
import com.lenovo.leoss.model.User;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class DBUserDAO extends HibernateDaoSupport implements UserDAO {

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        return (List<User>)(getHibernateTemplate().loadAll(User.class));
    }

    @Override
    public Long save(User user) {
        getHibernateTemplate().saveOrUpdate(user);
        return null;
    }
}
