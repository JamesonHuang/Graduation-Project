package com.lenovo.leoss.controller.user;

import com.lenovo.leoss.model.User;
import com.lenovo.leoss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/user")
public class ListController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String showUsersAll(ModelMap model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "users";
    }

}
