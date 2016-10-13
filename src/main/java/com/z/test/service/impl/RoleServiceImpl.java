package com.z.test.service.impl;

import com.z.test.dao.IRoledao;
import com.z.test.dao.IUserdao;
import com.z.test.pojo.User;
import com.z.test.service.IRoleService;
import com.z.test.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service("roleService")
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoledao roledao;

    @Autowired
    private IUserService userService;


    /**
     * 根据用户名查找其角色
     *
     * @param username
     * @return
     */
    public Set<String> findRoles(String username) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return null;
        }
        Set<String> roles = roledao.findRoles(user.getId());
        return roles;
    }

    /**
     * 根据用户名查找其权限
     *
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return null;
        }
        Set<String> permissions = roledao.findPermissions(user.getId());
        return permissions;
    }


}
