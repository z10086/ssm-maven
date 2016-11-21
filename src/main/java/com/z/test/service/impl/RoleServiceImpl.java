package com.z.test.service.impl;

import com.z.test.dao.IRoledao;
import com.z.test.pojo.User;
import com.z.test.service.IRoleService;
import com.z.test.service.IUserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Set;


@Service("roleService")
public class RoleServiceImpl implements IRoleService {


    private final IRoledao roledao;

    private final IUserService userService;

    @Inject
    public RoleServiceImpl(IRoledao roledao, IUserService userService) {
        this.roledao = roledao;
        this.userService = userService;
    }



    /**
     * 根据用户名查找其角色
     *
     * @param username 用户名
     * @return 角色 roles
     */
    public Set<String> findRoles(String username) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return null;
        }
        Set<String> roles = roledao.findRoles(user.getId());
        roles.remove("");
        roles.remove(null);
        return roles;
    }

    /**
     * 根据用户名查找其权限
     *
     * @param username 用户名
     * @return permissions
     */
    public Set<String> findPermissions(String username) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return null;
        }
        Set<String> permissions = roledao.findPermissions(user.getId());
        permissions.remove("");
        permissions.remove(null);
        return permissions;
    }


}
