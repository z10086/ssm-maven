package com.z.test.service;

import java.util.Set;

/**
 * @author zcq
 * @ClassName:
 * @Description: TODO()
 * @date 2016/7/22 14:14
 */
public interface IRoalsService {
    /**
     * 根据角色编号得到角色标识符列表
     * @param roleIds
     * @return
     */
    Set<String> findRoles(Long... roleIds);

    /**
     * 根据角色编号得到权限字符串列表
     * @param roleIds
     * @return
     */
    Set<String> findPermissions(Long[] roleIds);
}
