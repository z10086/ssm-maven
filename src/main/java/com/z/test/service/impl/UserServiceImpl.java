package com.z.test.service.impl;

import com.z.test.dao.IUserdao;
import com.z.test.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.z.test.pojo.User;


@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserdao userDao;

    @Override
    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

}
