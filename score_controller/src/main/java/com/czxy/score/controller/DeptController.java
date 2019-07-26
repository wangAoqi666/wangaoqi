package com.czxy.score.controller;

import com.czxy.score.domain.Dept;
import com.czxy.score.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 550894211@qq.com
 * @version v 1.0
 * @date 2019/7/25
 */
@RestController
@RequestMapping("dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询所有部门
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Dept>> findAllDept(){
        List<Dept> allDept = deptService.findAllDept();
        return ResponseEntity.ok(allDept);
    }
}
