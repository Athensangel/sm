package com.sm.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sm.entity.User;
import com.sm.service.UserService;

/**
 * 员工信息管理
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("user")

public class UserController {
	private static Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@RequestMapping("checkLogin")
	public ModelAndView checkLogin(User user) {
		User currentUser = userService.checkUserLogin(user);// 校验账号密码
		if (currentUser == null) {
			return new ModelAndView("login"); // 账号密码错误，返回登录页
		} else {
			return new ModelAndView("index");// 账号密码正确，跳转到index页
		}
	}
	/**
	 * 查询所有员工
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("userList")
	public String findAllUsers(ModelMap map) {
		List<User> userList = userService.findAllUser();
		map.put("userList", userList);
		logger.info("userList=" + userList);
		return "views/user/userList";
	}

	/**
	 * 跳转到员工新增页
	 * 
	 * @return
	 */
	@RequestMapping("jumpSaveUser")
	public String jumpSaveUser() {
		return "views/user/userSave";
	}

	/**
	 * 新增员工
	 * 
	 * @return
	 */
	@RequestMapping("saveUser")
	public String saveUser(User user) {
		userService.saveUser(user);
		return "redirect:userList";
	}

	/**
	 * 跳转到员工修改页
	 * 
	 * @return
	 */
	@RequestMapping("jumpUpdateUser")
	public String jumpUpdateUser(Integer toid, ModelMap map) {
		User user = userService.queryUserById(toid);
		map.put("user",user);
		return "views/user/userUpdate";
	}

	/**
	 * 修改员工
	 * 
	 * @return
	 */
	@RequestMapping("updateUser")
	public String updateUser(User user) {
		userService.updateUserById(user);
		return "redirect:userList";
	}

	/**
	 * 删除员工
	 * 
	 * @return
	 */
	@RequestMapping("deleteUser")
	public String deleteUser(Integer toid) {
		userService.deletUserById(toid);
		return "redirect:userList";
	}
}
