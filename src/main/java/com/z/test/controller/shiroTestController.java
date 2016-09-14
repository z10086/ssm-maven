package com.z.test.controller;

/**
 * Created by Administrator on 2015/11/22.
 */


import com.z.test.pojo.User;
import com.z.test.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/shiro")
public class shiroTestController {
    static private Logger logger = LoggerFactory.getLogger(shiroTestController.class);


    @RequiresPermissions("user:create")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        System.out.println("success");
        return "0";
    }


}
