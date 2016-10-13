package com.z.test.service;

import java.util.Set;

/**
 * @author zcq
 * @ClassName:
 * @Description: TODO()
 * @date 2016/7/22 14:14
 */
public interface IRoleService {
    /**
     * 根据用户id得到角色标识符列表
     * @param userName
     * @return
     */
    Set<String> findRoles(String userName);

    /**
     * 根据用户id得到权限字符串列表
     * @param userName
     * @return
     */
    Set<String> findPermissions(String userName);
}
