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
	public List<User> findAllUser() {
		return userMapper.findAllUsers();
	}

	@Override
	public void saveUser(User user) {
		userMapper.insertUser(user);
	}

	@Override
	public void deletUserById(Integer toid) {
		userMapper.delUserById(toid);
	}

	@Override
	public User queryUserById(Integer toid) {
		return userMapper.findUserById(toid);
	}

	@Override
	public void updateUserById(User user) {
		userMapper.updateUserById(user);		
	}

}
