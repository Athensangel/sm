package com.sm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sm.entity.Message;
import com.sm.service.MessageService;

@Controller
@RequestMapping("message")
public class MessageController {
	private static Logger logger = Logger.getLogger(MessageController.class);

	@Resource
	private MessageService messageService;
	/**
	 * 查询所有信息
	 * @param map
	 * @return
	 */
	@RequestMapping("messageList")
	public String findAllMessages(ModelMap map){
		List<Message> messageList=messageService.findAllMessage();
		map.put("messageList", messageList);
		logger.info("messageList="+messageList);
		return "views/message/messageList";
	}
	/**
	 * 跳转到产品新增页
	 * @return
	 */
	@RequestMapping("jumpSavaMessage")
	public String jumpSavaMessage(){
		return "views/message/messageSave";
	}
	
	@RequestMapping("saveMessage")
	
	public String saveMessage(Message message){
		messageService.saveMessage(message);
		return "redirect:messageList";
	}
	/**
	 * 跳转到信息修改页
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("jumpUpdateMessage")
	public String jumpUpdateMessage(Integer id,ModelMap map){
		Message message=messageService.queryMessageById(id);
		map.put("message", message);
		return "views/message/messageUpdate";
	}
	/**
	 * 修改产品
	 * @param message
	 * @return
	 */
	@RequestMapping("updateMessage")
	public String updateMessage(Message message){
		messageService.updateMessageById(message);
		return "redirect:messageList";
	}
	/**
	 * 删除产品
	 */
	@RequestMapping("deleteMessage")
	public String deleteMessage(Integer id){
		messageService.deletMessageById(id);
		return "redirect:messageList";
	  }
}
