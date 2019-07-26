package com.czxy.score.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author 27727
 */
@Entity
@Table(name = "tab_user")
public class User {
    @Id
    private Integer userId;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String deptId;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", deptId='" + deptId + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public User() {
    }

    public User(Integer userId, String username, String password, String phone, String email, String deptId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.deptId = deptId;
    }
}
