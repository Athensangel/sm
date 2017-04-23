package com.sm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sm.entity.User;
import com.sm.mapper.UserMapper;
import com.sm.service.UserService;

@Transactional(readOnly=true)
@Service
public class UserServiceimpl implements UserService {
	
	@Resource
	public UserMapper userMapper;
	
	@Override
	public User checkUserLogin(User user) {
		return userMapper.checkLogin(user);
	}

	@Override
	public List<User> findAllUsers() {
		return userMapper.findAllUsers();	//查找所有员工的信息
	}
	
	@Transactional(readOnly=false)
	/**
	 * 添加员工信息
	 */
	@Override
	public void saveUser(User user) {
		userMapper.insertUser(user);
	}
	
	@Transactional(readOnly=false)
	/**
	 * 删除员工信息
	 */
	@Override
	public void deletUserById(Integer toid) {
		userMapper.delUserById(toid);
	}
	
	/**
	 * 通过ID来查询员工信息
	 */
	@Override
	public User queryUserById(Integer toid) {
		return userMapper.findUserById(toid);
	}
	
	@Transactional(readOnly=false)
	/**
	 * 修改员工信息
	 */
	@Override
	public void updateUserByID(User user) {
		userMapper.updateUserById(user);
	}
	
	@Transactional(readOnly=false)
	/**
	 * 修改员工信息
	 */
	@Override
	public void updateUserInfo(User user) {
		userMapper.updateUserInfo(user);
	}
}
