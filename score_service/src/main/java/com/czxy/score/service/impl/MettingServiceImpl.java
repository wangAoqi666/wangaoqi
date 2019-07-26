package com.czxy.score.service.impl;

import com.czxy.score.dao.MettingDao;
import com.czxy.score.dao.RoomDao;
import com.czxy.score.dao.UserMapper;
import com.czxy.score.dao.UserMettingDao;
import com.czxy.score.domain.Metting;
import com.czxy.score.domain.MettingVo;
import com.czxy.score.domain.User;
import com.czxy.score.domain.UserMetting;
import com.czxy.score.service.MettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 550894211@qq.com
 * @version v 1.0
 * @date 2019/7/25
 */
@Service
@Transactional
public class MettingServiceImpl implements MettingService {

    @Autowired
    private MettingDao mettingDao;

    @Autowired
    private RoomDao roomDao;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserMettingDao userMettingDao;

    @Override
    public List<Metting> findAll(String userId) {
        List<Metting> allMettingByUserId = mettingDao.findAllMettingByUserId(userId);
        for (Metting metting : allMettingByUserId) {
            metting.setRoom(roomDao.selectByPrimaryKey(metting.getRoomId()));
        }
        return allMettingByUserId;
    }

    @Override
    public MettingVo findMettingBymettingId(Integer mettingId) {
        Metting metting = mettingDao.selectByPrimaryKey(mettingId);
        //1.转换日期
        //创建一个日期转换对象
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        MettingVo mettingVo = new MettingVo();

        mettingVo.setStartTime(df.format(metting.getMettingStarttime()));
        mettingVo.setEndTime(df.format(metting.getMettingEndtime()));
        mettingVo.setCreateTime(df.format(metting.getMettingOrdertime()));
        //2.给用户集合赋值
        List<User> userList = userMapper.findUserByMettingId(mettingId);
        metting.setUserList(userList);
        mettingVo.setMetting(metting);
        return mettingVo;
    }

    @Override
    public List<MettingVo> findAllMetting(Integer userId) {
        List<Metting> mettingList = mettingDao.findAllMettingByUserId(userId + "");
        //创建一个日期转换对象
        for (Metting metting : mettingList) {
            metting.setRoom(roomDao.selectByPrimaryKey(metting.getRoomId()));
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //封装到POJO类中
        List<MettingVo> mettingVoList = new ArrayList<>();
        for (Metting metting : mettingList) {
            MettingVo mettingVo = new MettingVo();
            mettingVo.setMetting(metting);
            mettingVo.setStartTime(df.format(metting.getMettingStarttime()));
            mettingVo.setEndTime(df.format(metting.getMettingEndtime()));
            mettingVo.setCreateTime(df.format(metting.getMettingOrdertime()));
            mettingVoList.add(mettingVo);
        }

        return mettingVoList;
    }

    @Override
    public void insertMetting(Metting metting, String[] userIds,String username) {
        metting.setMettingOrdertime(new Date());
        metting.setStatus("未开始");
        metting.setUsername(username);
        mettingDao.insertSelective(metting);

        List<Metting> select = mettingDao.select(metting);
        for (String userId : userIds) {
            UserMetting userMetting = new UserMetting();
            userMetting.setUserId(Integer.parseInt(userId));
            userMetting.setMettingId(select.get(0).getMettingId());
            userMettingDao.insertSelective(userMetting);
        }

    }

}
