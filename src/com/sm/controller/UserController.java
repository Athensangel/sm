package com.sm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sm.entity.User;
import com.sm.service.UserService;

/**
 * 员工信息管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("checkLogin")
	public String checkLogin(User user){
		User currentUser = userService.checkUserLogin(user);//校验账号密码
		if(currentUser == null){
			return "login"; //账号密码错误，返回登录页
		}else{
			return "index";//账号密码正确，跳转到index页
		}
		
	}

}
