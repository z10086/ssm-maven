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

    @Override
    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    public User findByUsername(String username) {
        return userDao.getUserById(3);
    }

    /**
     * 根据用户名查找其角色
     *
     * @param username
     * @return
     */
    public Set<String> findRoles(String username) {
        User user = findByUsername(username);
        if (user == null) {
            return Collections.EMPTY_SET;
        }
        Set<String> roles = new HashSet<String>();
        roles.add("rolesa");
        return roles;
        //return roleService.findRoles(user.getRoleIds().toArray(new Long[0]));
    }

    /**
     * 根据用户名查找其权限
     *
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username) {
        User user = findByUsername(username);
        if (user == null) {
            return Collections.EMPTY_SET;
        }
        Set<String> permissions = new HashSet<String>();
        permissions.add("Permissionsb");
        return permissions;
        //return roleService.findPermissions(user.getRoleIds().toArray(new Long[0]));
    }


    @Override
    public int login(User user) {
        User user1 = userDao.getUserById(user.getId());
        return 0;
    }


}
