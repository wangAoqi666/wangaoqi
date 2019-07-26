package com.czxy.score.controller;

import com.czxy.score.domain.Metting;
import com.czxy.score.domain.MettingVo;
import com.czxy.score.domain.User;
import com.czxy.score.service.MettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author 550894211@qq.com
 * @version v 1.0
 * @date 2019/7/25
 */
@RestController
@RequestMapping("metting")
public class MettingController {

    @Autowired
    private MettingService mettingService;

    @PostMapping("addMetting")
    public ResponseEntity<Void> addMetting(Metting metting,String[] userIds,HttpSession session){
        User user = (User) session.getAttribute("user");
        mettingService.insertMetting(metting,userIds,user.getUsername());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * 查询所有的会议
     * @return
     */
    @GetMapping()
    public ResponseEntity<List<MettingVo>> findAllMetting(HttpSession session){
        User user = (User) session.getAttribute("user");
        List<MettingVo> mettingVoList = mettingService.findAllMetting(user.getUserId());
        return ResponseEntity.ok(mettingVoList);
    }

    /**
     * 根据主键查询会议详情
     * @param mettingId
     * @return
     */
    @GetMapping("/getMttingById/{mettingId}")
    public ResponseEntity<MettingVo> findMettingBymettingId(@PathVariable Integer mettingId){
        //1.调用方法 返回集合
        MettingVo mettingVo= mettingService.findMettingBymettingId(mettingId);
        //2.响应给浏览器
        return ResponseEntity.ok(mettingVo);
    }

    /**
     * 根据用户id查询会议信息
     * @param userId
     * @return
     */
    @GetMapping("findMettingByDate/{userId}")
    public ResponseEntity<List<MettingVo>> findMettingByDate(@PathVariable String userId){
        List<Metting> mettingList = mettingService.findAll(userId);
        List<Metting> newMettingList = new ArrayList<>();
        //将room封装进去
        for (Metting metting : mettingList) {
            if (metting.getMettingStarttime().getTime()>System.currentTimeMillis() && metting.getMettingStarttime().getTime()<System.currentTimeMillis()+(60*60*24*7*1000) && "未开始".equals(metting.getStatus())){
                newMettingList.add(metting);
            }
        }
        //创建一个日期转换对象
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //封装到POJO类中
        List<MettingVo> mettingVoList = new ArrayList<>();
        for (Metting metting : newMettingList) {
            MettingVo mettingVo = new MettingVo();
            mettingVo.setMetting(metting);
            mettingVo.setStartTime(df.format(metting.getMettingStarttime()));
            mettingVo.setEndTime(df.format(metting.getMettingEndtime()));
            mettingVo.setCreateTime(df.format(metting.getMettingOrdertime()));
            mettingVoList.add(mettingVo);
        }
        return ResponseEntity.ok(mettingVoList);
    }
}
