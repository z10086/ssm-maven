package com.z.test.service.impl;

import com.z.test.dao.IUserdao;
import com.z.test.pojo.User;
import com.z.test.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("testService")
public class TestServiceImpl implements ITestService {

    @Autowired
    private IUserdao userDao;


    @Override
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    public void testTransaction() {
        User user = new User();
        user.setUsername("username");
        user.setPassword("pwd");
        userDao.addUser(user);
        userDao.throwExp();
    }
}
