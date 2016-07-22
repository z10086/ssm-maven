package com.z.test.service;


import com.z.test.pojo.User;

import java.util.Set;

public interface IUserService {
     User getUserById(int userId);

    public User findByUsername(String username);

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String username);

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username);

    /**
     * 登陆
     * @param user
     * @return
     */
     int login(User user);

}
