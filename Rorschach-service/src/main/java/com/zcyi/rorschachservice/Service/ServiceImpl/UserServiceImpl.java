package com.zcyi.rorschachservice.Service.ServiceImpl;

import com.zcyi.rorschachdao.Dao.UserDao;
import com.zcyi.rorschachinfrastructure.Entity.User;
import com.zcyi.rorschachservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public ArrayList<User> selectAllUser() {
        return userDao.selectAllUser();
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User Login(String username, String userPassword) {
        return userDao.selectByUserName(username, userPassword);
    }

    @Override
    public int updateByUserId(Long userId, String userToken) {
        return userDao.updateByUserId(userId, userToken);
    }

}
