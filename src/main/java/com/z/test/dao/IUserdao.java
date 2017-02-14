package com.z.test.dao;

import com.z.test.pojo.User;

import java.util.Set;

/**
 * @author zcq
 * @ClassName:
 * @Description: TODO()
 * @date 2016/6/16 16:58
 */
public interface IUserdao {
     User getUserById(Long userId);

     User getUserByName(String userName);

     Integer addUser(User user);

     void throwExp();

}
