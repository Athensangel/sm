package com.sm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sm.entity.Message;
import com.sm.mapper.MessageMapper;
import com.sm.service.MessageService;

@Transactional
@Service
public class MessageServiceImpl implements MessageService {
	@Resource
	private MessageMapper messageMapper;

	@Override
	public List<Message> findAllMessage() {
		return messageMapper.findAllMessage();
	}

	@Override
	public void saveMessage(Message message) {
		messageMapper.insertMessage(message);
	}

	@Override
	public void deletMessageById(Integer id) {
		messageMapper.delMessageById(id);
	}

	@Override
	public Message queryMessageById(Integer id) {
		return messageMapper.findMessageById(id);
	}

	@Override
	public void updateMessageById(Message message) {
		messageMapper.updateMessageById(message);
	}

}
