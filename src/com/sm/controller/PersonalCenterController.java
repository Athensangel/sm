package com.sm.controller;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sm.entity.User;
import com.sm.service.UserService;

/**
 * 个人中心
 * @author Administrator
 *
 */
@Controller
public class PersonalCenterController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("personalIndex")
	public String personalIndex(HttpServletRequest request){
		String toidStr = (String)request.getSession().getAttribute("toid");//获取session作用域里的toid
		Integer toid = Integer.parseInt(toidStr);//强转
		User personalUser = userService.queryUserById(toid);//通过toid查询当前登录人信息
		request.setAttribute("personalUser", personalUser);
		return "views/personal/personalCenter";
	}
	

}
