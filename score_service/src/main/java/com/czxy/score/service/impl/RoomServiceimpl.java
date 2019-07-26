package com.czxy.score.service.impl;

import com.czxy.score.dao.RoomDao;
import com.czxy.score.domain.Room;
import com.czxy.score.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

/**
 * @author 550894211@qq.com
 * @version v 1.0
 * @date 2019/7/25
 */
@Service
@Transactional
public class RoomServiceimpl implements RoomService {

    @Autowired
    private RoomDao roomDao;

    @Override
    public List<Room> findAllRoom() {
        return roomDao.selectAll();
    }
}
