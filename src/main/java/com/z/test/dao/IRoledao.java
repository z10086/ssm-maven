package com.z.test.dao;

import java.util.Set;

/**
 * @author zcq
 * @ClassName:
 * @Description: TODO()
 * @date 2016/6/16 16:58
 */
public interface IRoledao {
    //获取用户角色信息
    Set<String> findRoles(Long userId);

    Set<String> findPermissions(Long userId);

}
