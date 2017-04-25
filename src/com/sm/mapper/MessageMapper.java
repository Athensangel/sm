package com.sm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sm.entity.Message;

/*
 * MessageMapper实现接口
 */
@Repository 
public interface MessageMapper {

	public List<Message> findAllMessage();//查询Message中的数据

	public void insertMessage(Message message);//给Message表中插入一条数据

	public void delMessageById(Integer id);//删除Message表中的一条数据

	public Message findMessageById(Integer id);//通过toId查询Message中的数据

	public void updateMessageById(Message message);//修改Message中的数据

}
