package com.z.test.controller;

/**
 * Created by Administrator on 2015/11/22.
 */


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.z.test.pojo.User;
import com.z.test.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/user")
public class UserController {
    static private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping("/showUser")
    @ResponseBody
    public User toIndex(String id) {
        User user = new User();
        user = this.userService.getUserById(Integer.parseInt(id));
        logger.error("[info message]");
        return user;
    }
}
