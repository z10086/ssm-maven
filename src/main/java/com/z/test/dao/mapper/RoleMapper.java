package com.z.test.dao.mapper;


import javax.inject.Named;
import java.util.Set;

/**
 * 权限相关
 * @author zcq
 * @Description: TODO
 * @date 2016/6/16 15:04
 */

@Named("roleMapper")
public interface RoleMapper {

        Set<String> findRoles(Long userId);

        Set<String> findPermissions(Long userId);
}
