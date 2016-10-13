package com.z.test.service;


import com.z.test.pojo.User;

import java.util.Set;

public interface IUserService {

     User getUserById(Long userId);

     User findByUsername(String username);

     int login(User user);

}
