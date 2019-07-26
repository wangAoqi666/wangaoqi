package com.czxy.score.service;

import com.czxy.score.domain.Room;

import java.util.List;

/**
 * @author 550894211@qq.com
 * @version v 1.0
 * @date 2019/7/25
 */
public interface RoomService {
    /**
     * 查询所有的会议室信息
     * @return
     */
    List<Room> findAllRoom();
}
