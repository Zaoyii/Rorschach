package com.zcyi.rorschachapi.Controller;

import com.zcyi.rorschachinfrastructure.Base.ApiResult;
import com.zcyi.rorschachinfrastructure.Entity.User;
import com.zcyi.rorschachinfrastructure.JWT.JwtUtils;
import com.zcyi.rorschachservice.Service.ServiceImpl.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@RestController
@ResponseBody
@RequestMapping("/User")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping("/Login")
    @ResponseBody
    public ApiResult<User> UserLogin(String userName, String userPassword) {
        System.out.println(userName + "---=--=-=-=" + userPassword);
        if (!userName.isEmpty() || !userPassword.isEmpty()) {
            User user = userService.Login(userName, userPassword);
            if (user != null) {
                if (user.getUserToken() == null || JwtUtils.verify(user.getUserToken()).getExpiresAt().before(Calendar.getInstance().getTime())) {
                    Map<String, String> tokenInfo = new HashMap<>();
                    tokenInfo.put("userName", user.getUserName());
                    tokenInfo.put("userId", user.getUserId() + "");
                    String token = JwtUtils.getToken(tokenInfo);

                    user.setUserToken(token);
                    userService.updateByUserId(user.getUserId(), token);
                    System.out.println("======token存储++++++++");
                }
                return ApiResult.Success(user);
            }
            return ApiResult.Failed("用户名或密码错误");
        } else {
            return ApiResult.Failed("用户名或密码为空");
        }

    }

    @RequestMapping("/AllUser")
    @ResponseBody
    public ApiResult<ArrayList<User>> AllUser() {
        ArrayList<User> users = userService.selectAllUser();
        for (User user : users) {
            System.out.println(user + "-=-=-==-=");
        }
        return ApiResult.Success(users);
    }

    @RequestMapping("/AddUser")
    @ResponseBody
    public ApiResult<String> AddUser(User user) {
        int i = userService.addUser(user);
        if (i != 0) {
            return ApiResult.Success();
        } else {
            return ApiResult.Failed();
        }

    }

}
