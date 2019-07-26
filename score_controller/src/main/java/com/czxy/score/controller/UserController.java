package com.czxy.score.controller;

import com.czxy.score.domain.User;
import com.czxy.score.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 27727
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 根据部门查询user对象集合
     * @param deptId
     * @return
     */
    @GetMapping("findUserByDeptId/{deptId}")
    public ResponseEntity<List<User>> findUserByDeptId(@PathVariable String deptId){
        return ResponseEntity.ok(userService.findUserByDeptId(deptId));
    }

    /**
     * 获取session中的user
     * @return
     */
    @GetMapping("getLoginUserId")
    public ResponseEntity<User> getLoginUserId(HttpSession session){
        User user = (User) session.getAttribute("user");
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user, HttpServletRequest request){
        User u = userService.login(user);
        if (u != null) {
            request.getSession().setAttribute("user",u);
            return new ResponseEntity<>("ok",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("不ok",HttpStatus.OK);
        }

    }
	
	/**
		展示登录用户名
	*/
	@GetMapping("/searchName")
    public ResponseEntity<String> searchName(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if(user != null){
            return new ResponseEntity<>(user.getUsername(),HttpStatus.OK);
        }
        return new ResponseEntity<>("null",HttpStatus.NO_CONTENT);
    }
    
}
