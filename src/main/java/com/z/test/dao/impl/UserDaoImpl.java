package com.z.test.dao.impl;

import com.z.test.dao.IUserdao;
import com.z.test.dao.mapper.UserMapper;
import com.z.test.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


@Repository("userDao")
public class UserDaoImpl implements IUserdao {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(Long id) {
        return  userMapper.getUserById(id);
    }

    @Override
    public User getUserByName(String userName) {
        return  userMapper.getUserByName(userName);
    }

    @Override
    public Integer addUser(User user) {
        return  userMapper.addUser(user);
    }

    @Override
    public void throwExp() {
        throw new RuntimeException("抛出异常测试回滚");
    }

}
