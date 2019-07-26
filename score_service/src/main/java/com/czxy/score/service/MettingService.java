package com.czxy.score.service;

import com.czxy.score.domain.Metting;
import com.czxy.score.domain.MettingVo;
import com.czxy.score.domain.User;

import java.util.List;

/**
 * @author 550894211@qq.com
 * @version v 1.0
 * @date 2019/7/25
 */
public interface MettingService {

    /**
     * 查询所有会议的信息
     * @return
     */
    List<Metting> findAll(String userId);

    /**
     * 根据主键从数据库中查询会议
     * @param mettingId
     * @return
     */
    MettingVo findMettingBymettingId(Integer mettingId);

    /**
     * 从数据库中查询所有的会议信息
     * @param userId
     * @return
     */
    List<MettingVo> findAllMetting(Integer userId);

    void insertMetting(Metting metting, String[] userIds,String username);
}
