package com.czxy.score.dao;

import com.czxy.score.domain.Dept;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author 550894211@qq.com
 * @version v 1.0
 * @date 2019/7/25
 */
@Repository
@org.apache.ibatis.annotations.Mapper
public interface DeptDao extends Mapper<Dept> {
}
