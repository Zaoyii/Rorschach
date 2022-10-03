package com.zcyi.rorschachinfrastructure.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class User {

    private String userName;
    private long   userId;
    private String userPassword;
    private String userAvatar;
    private String userToken;
    private String userEmail;
    private String userPhone;
    private String userCreateTime;
    private String userSlogan;

    public User(String userName, String userPassword, String userEmail, String userPhone, String userCreateTime) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userCreateTime = userCreateTime;
    }

}
