package com.czxy.score.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tab_dept")
public class Dept {
    @Id
    private Integer deptId;
    private String deptName;

    private List<User> userList = new ArrayList<>();


    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", userList=" + userList +
                '}';
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Dept() {
    }

    public Dept(Integer deptId, String deptName, List<User> userList) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.userList = userList;
    }
}
