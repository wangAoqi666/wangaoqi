package com.czxy.score.dao;


import com.czxy.score.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {

    @Select("select * from tab_user where username=#{username} and password=#{password}")
    public User login(User user);

    @Select("SELECT tu.`user_id`, tu.`username`, tu.`password`, tu.`phone`, tu.`email`,\n" +
            "       tu.`dept_id`\n" +
            "FROM `tab_user` AS tu,`tab_user_metting` AS tum\n" +
            "WHERE tum.`user_id` = tu.`user_id` AND tum.`metting_id` = #{mettingId}")
    List<User> findUserByMettingId(@Param("mettingId") Integer mettingId);
}
