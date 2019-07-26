package com.czxy.score.service;

import com.czxy.score.domain.User;

import java.util.List;

public interface UserService {

    public User login(User user);

    /**
     * 根据部门id查询用户
     * @param deptId
     * @return
     */
    List<User> findUserByDeptId(String deptId);
}
