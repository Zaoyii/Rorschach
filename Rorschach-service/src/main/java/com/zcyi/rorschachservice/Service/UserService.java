package com.zcyi.rorschachservice.Service;

import com.zcyi.rorschachinfrastructure.Entity.User;

import java.util.ArrayList;

public interface UserService {

    ArrayList<User> selectAllUser();

    int addUser(User user);

    User Login(String username, String userPassword);

    int updateByUserId(Long userId, String userToken);
}
