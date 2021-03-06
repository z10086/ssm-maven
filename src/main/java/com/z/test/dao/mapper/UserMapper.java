package com.z.test.dao.mapper;

import com.z.test.pojo.User;
import org.springframework.stereotype.Component;

import javax.inject.Named;
import java.util.Set;

/**
 * @author zcq
 * @ClassName:
 * @Description: TODO
 * @date 2016/6/16 15:04
 */

@Named("userMapper")
public interface UserMapper {
        User getUserById(Long id);

        User getUserByName(String userName);

        Integer addUser(User user);
}
