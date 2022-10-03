package com.zcyi.rorschachdao.Dao;

import com.zcyi.rorschachinfrastructure.Entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Mapper
@Repository
public interface UserDao {
    /**
     * 查询所有用户
     *
     * @return 用户列表
     */
    @Select("select * from t_user")
    @Results({
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userNickname", column = "user_nickname"),
            @Result(property = "userCreateTime", column = "user_create_time"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userSex", column = "user_sex"),
            @Result(property = "userEmail", column = "user_email"),
            @Result(property = "userPhone", column = "user_phone"),

    })
    ArrayList<User> selectAllUser();

    /**
     * 添加用户
     *
     * @return int 1成功 0失败
     */
    @Insert("insert into t_user (user_name,user_password,user_email,user_phone,user_create_time) " +
            "value (#{userName},#{userPassword},#{userEmail},#{userPhone},#{userCreateTime}) ")
    int addUser(User user);

    /**
     * 登陆
     *
     * @return 用户信息
     */
    @Select("select * from t_user where user_name = #{username} and user_password = #{userPassword}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userPhone", column = "user_phone"),
            @Result(property = "userAvatar", column = "user_avatar"),
            @Result(property = "userSlogan", column = "user_slogan"),
            @Result(property = "userEmail", column = "user_email"),
            @Result(property = "userToken", column = "user_token"),
    })
    User selectByUserName(String username, String userPassword);

    @Update("update t_user set user_token=#{userToken} where user_id= #{userId}")
    int updateByUserId(Long userId, String userToken);
}
