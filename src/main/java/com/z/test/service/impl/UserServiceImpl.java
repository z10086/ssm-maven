package com.z.test.service.impl;

import com.z.test.dao.IUserdao;
import com.z.test.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.z.test.pojo.User;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserdao userDao;


    public User getUserById(Long userId) {
        return userDao.getUserById(userId);
    }

    public Integer addUser(User user) {
        return userDao.addUser(user);
    }

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    public User findByUsername(String username) {
        return userDao.getUserByName(username);
    }




    public int login(User user) {
        User user1 = userDao.getUserById(user.getId());
        return 0;
    }


}
