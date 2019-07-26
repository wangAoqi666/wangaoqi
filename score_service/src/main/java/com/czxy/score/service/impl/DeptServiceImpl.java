package com.czxy.score.service.impl;

import com.czxy.score.dao.DeptDao;
import com.czxy.score.dao.UserMapper;
import com.czxy.score.domain.Dept;
import com.czxy.score.domain.User;
import com.czxy.score.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 550894211@qq.com
 * @version v 1.0
 * @date 2019/7/25
 */
@Service
@Transactional
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Dept> findAllDept() {
        List<Dept> depts = deptDao.selectAll();
        for (Dept dept : depts) {
            Example example = new Example(User.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("deptId", dept.getDeptId());
            List<User> userList = userMapper.selectByExample(example);
            dept.setUserList(userList);
        }
        return depts;
    }
}
