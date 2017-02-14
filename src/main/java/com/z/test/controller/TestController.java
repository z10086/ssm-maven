package com.z.test.controller;

/**
 * Created by Administrator on 2015/11/22.
 */



import com.z.test.service.ITestService;
import com.z.test.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ITestService testService;

    static private Logger logger = LoggerFactory.getLogger(TestController.class);


    @RequestMapping(value = "/testServiceTransaction", method = RequestMethod.GET)
    public void test1() {
        testService.testTransaction();
    }


}
