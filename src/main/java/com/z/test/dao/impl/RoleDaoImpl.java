package com.z.test.dao.impl;

import com.z.test.dao.IRoledao;
import com.z.test.dao.IUserdao;
import com.z.test.dao.mapper.RoleMapper;
import com.z.test.dao.mapper.UserMapper;
import com.z.test.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


@Repository("roleDao")
public class RoleDaoImpl implements IRoledao {

    @Autowired
    RoleMapper roleMapper;

    public Set<String> findRoles(Long userId){
        return  roleMapper.findRoles(userId);
    }

    public Set<String> findPermissions(Long userId){
        return  roleMapper.findPermissions(userId);
    }


}
