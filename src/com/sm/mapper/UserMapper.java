package com.sm.mapper;

import java.util.List;

import com.sm.entity.User;


/**
 * 员工Dao数
 * 
 * @author Administrator
 *
 */
public interface UserMapper {

	public User checkLogin(User user);// 对用户登录方法与数据查询

	public List<User> findAllUsers(); // 对User字段进行查找

	public void insertUser(User user); // 为User添加一条数据

	public void delUserById(Integer toid); // 通过toId删除一条记录

	public User findUserById(Integer toid);//查找

	public void updateUserById(User user);//修改员工表字段

	//public void updateUserInfo(User user);

}
