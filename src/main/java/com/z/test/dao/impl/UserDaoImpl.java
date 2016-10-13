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
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    public User getUserById(Long id) {
        return  userMapper.getUserById(id);
    }

}
