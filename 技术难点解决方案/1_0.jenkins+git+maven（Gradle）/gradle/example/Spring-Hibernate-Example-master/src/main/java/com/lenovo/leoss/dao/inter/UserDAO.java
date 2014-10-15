package com.lenovo.leoss.dao.inter;

import com.lenovo.leoss.model.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAll();
    public Long save(User user);

}
