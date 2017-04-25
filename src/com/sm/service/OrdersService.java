package com.sm.service;

import java.util.List;

import com.sm.entity.Orders;

/**
 * OrdersService实现方法
 * @author Administrator
 *
 */
public interface OrdersService {
	public List<Orders> findAllOrders();//遍历查询Orders表中的字段

	public void saveOrders(Orders orders);//新增订单

	public void deletOrdersById(Integer toid);//通过toId查找订单信息并做删除处理

	public Orders queryOrdersById(Integer toid);//通过toId查找订单信息并做删除处理

	public void updateOrdersById(Orders orders);//查找订单，并修改订单信息
}
