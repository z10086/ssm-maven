package com.z.test.dao.impl;

import com.z.test.dao.IUserdao;
import com.z.test.dao.mapper.UserMapper;
import com.z.test.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("userDao")
public class UserDaoImpl implements IUserdao {

    @Autowired
    UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    public User getUserById(int id) {
        User user = new User();
        user.setUsername("test");
        user.setPassword("password");
        userMapper.addUser(user);
        return  userMapper.getUserById(id);
    }
}
