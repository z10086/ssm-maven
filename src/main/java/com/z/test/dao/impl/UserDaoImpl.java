package com.z.test.dao.impl;

import com.z.test.dao.IUserdao;
import com.z.test.dao.mapper.UserMapper;
import com.z.test.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements IUserdao {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(int id){
        return  userMapper.getUserById(id);
    }
}
