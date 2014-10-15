package com.lenovo.leoss.service;

import com.lenovo.leoss.dao.inter.UserDAO;
import com.lenovo.leoss.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> getAll(){
        return userDAO.getAll();
    }

    public void save(User user){
        userDAO.save(user);
    }

}
