package com.sm.service;

import java.util.List;

import com.sm.entity.User;


public interface UserService {
	public User checkUserLogin(User user);//登陆验证
	
	public List<User> findAllUser();//遍历查询orders表中的字段

	public void saveUser(User user);//新增订单

	public void deletUserById(Integer toid);//通过toId查找订单信息并做删除处理

	public User queryUserById(Integer toid);//通过toId查找订单信息并做删除处理

	public void updateUserById(User user);//查找订单，并修改订单信息
}
