package com.z.test.controller;

/**
 * Created by Administrator on 2015/11/22.
 */


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.z.test.pojo.User;
import com.z.test.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/user")
public class UserController {
    static private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping("/showUser")
    public User toIndex(String id) {
        User user;
        user = this.userService.getUserById(Long.parseLong(id));
        logger.error("[info message]");
        return user;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String Login(@RequestBody User user, HttpSession session) {
        /*就是代表当前的用户。*/
        Subject currentUser = SecurityUtils.getSubject();
        //获取基于用户名和密码的令牌
        //这里的token大家叫他令牌，也就相当于一张表格，你要去验证，你就得填个表，里面写好用户名密码，交给公安局的同志给你验证。
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());


//      但是，“已记住”和“已认证”是有区别的：
//      已记住的用户仅仅是非匿名用户，你可以通过subject.getPrincipals()获取用户信息。但是它并非是完全认证通过的用户，当你访问需要认证用户的功能时，你仍然需要重新提交认证信息。
//      这一区别可以参考亚马逊网站，网站会默认记住登录的用户，再次访问网站时，对于非敏感的页面功能，页面上会显示记住的用户信息，但是当你访问网站账户信息时仍然需要再次进行登录认证。
        token.setRememberMe(true);

        try {
            //这句是提交申请，验证能不能通过，也就是交给公安局同志了。这里会回调reaml里的一个方法
            // 回调doGetAuthenticationInfo，进行认证
            currentUser.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        //验证是否通过
        if (currentUser.isAuthenticated()) {
            return "ok.";
        } else {
            return "";
        }
    }

    @RequiresPermissions("user:create")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        System.out.println("success");
        return "0";
    }
}
