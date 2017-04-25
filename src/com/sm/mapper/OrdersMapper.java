package com.sm.mapper;

import java.util.List;

import com.sm.entity.Orders;
/**
 * OrdersMapper的接口，实现CRUD功能
 * @author Administrator
 *
 */
public interface OrdersMapper {

	public List<Orders> findAllOrders();

	public void insertOrders(Orders orders);

	public void delOrdersById(Integer toid);

	public void updateOrdersById(Orders orders);

	public Orders findOrdersById(Integer toid);

}
