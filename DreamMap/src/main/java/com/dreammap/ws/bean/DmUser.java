package com.dreammap.ws.bean;/**
 * Created by Lenovo on 2017/4/24.
 */

/**
 * Title: DmUser
 * Project: DreamMap
 * Package: com.dreammap.ws.bean
 * Description: Please fill description of the file here
 * Author: lianchenyu
 * Date: 2017/4/24
 */

public class DmUser {
    private Integer userId;
    private String phone;
    private String userName;
    private String password;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
