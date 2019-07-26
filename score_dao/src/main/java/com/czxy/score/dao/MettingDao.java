package com.czxy.score.dao;

import com.czxy.score.domain.Metting;
import com.czxy.score.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 550894211@qq.com
 * @version v 1.0
 * @date 2019/7/25
 */
@Repository
@org.apache.ibatis.annotations.Mapper
public interface MettingDao extends Mapper<Metting> {
    /**
     * 根据userId查询所有的会议对象
     * @param userId
     * @return
     */
    @Select("SELECT tm.`metting_id`, tm.`metting_name`, tm.`metting_size`,\n" +
            "       tm.`metting_starttime`, tm.`metting_endtime`, tm.`metting_ordertime`,\n" +
            "       tm.`remark`, tm.`status`, tm.`username`, tm.`room_id`\n" +
            "FROM `tab_user_metting` AS tum,`tab_metting` AS tm\n" +
            "WHERE tm.`metting_id` = tum.`metting_id` AND tum.`user_id` = #{userId} ")
    List<Metting> findAllMettingByUserId(@Param("userId") String userId);

}
