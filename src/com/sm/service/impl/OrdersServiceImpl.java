package com.sm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sm.entity.Orders;
import com.sm.mapper.OrdersMapper;
import com.sm.service.OrdersService;
/**
 * OrdersMapper跟数据库打交道层
 * @author Administrator
 *
 */
@Transactional(readOnly=true)
@Service
public class OrdersServiceImpl implements OrdersService {
	
	@Resource
	private OrdersMapper ordersMapper;

	@Override
	public List<Orders> findAllOrders() {
		return ordersMapper.findAllOrders();
	}

	@Transactional(readOnly=false)
	@Override
	
	public void saveOrders(Orders orders){
		ordersMapper.insertOrders(orders);
	}

	@Transactional(readOnly=false)
	@Override
	public void deletOrdersById(Integer toid) {
		ordersMapper.delOrdersById(toid);
	}

	@Override
	public Orders queryOrdersById(Integer toid) {
		return ordersMapper.findOrdersById(toid);
	}

	@Transactional(readOnly=false)
	@Override
	public void updateOrdersById(Orders orders) {
		ordersMapper.updateOrdersById(orders);
	}


}
