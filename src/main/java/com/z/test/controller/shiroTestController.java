package com.z.test.controller;

/**
 * Created by Administrator on 2015/11/22.
 */


import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/shiro")
public class ShiroTestController {
    static private Logger logger = LoggerFactory.getLogger(ShiroTestController.class);



    @RequiresPermissions("user:create")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        System.out.println("success");
        return "0";
    }


}
