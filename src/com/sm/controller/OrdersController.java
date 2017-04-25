package com.sm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sm.entity.Orders;
import com.sm.service.OrdersService;

@Controller
@RequestMapping("orders")
public class OrdersController {
	private static Logger logger = Logger.getLogger(OrdersController.class);  
	
	//@Autowired
	@Resource
	private OrdersService ordersService;
	
	
	/**
	 * 查询所有产品
	 * @param map
	 * @return
	 */
	@RequestMapping("ordersList")
	public String findAllOrderss(ModelMap map){
		List<Orders> ordersList = ordersService.findAllOrders();
		map.put("ordersList", ordersList);
		logger.info("ordersList="+ordersList);    
		return "views/orders/ordersList";
	}
	
	/**
	 * 跳转到产品新增页
	 * @return
	 */
	@RequestMapping("jumpSaveOrders")
	public String jumpSaveOrders(){
		return "views/orders/ordersSave";
	}
	
	/**
	 * 新增产品
	 * @return
	 */
	@RequestMapping("saveOrders")
	public String saveOrders(Orders orders){
		ordersService.saveOrders(orders);
		return "redirect:ordersList";
	}
	
	/**
	 * 跳转到产品修改页
	 * @return
	 */
	@RequestMapping("jumpUpdateOrders")
	public String jumpUpdateOrders(Integer toid,ModelMap map){
		Orders orders = ordersService.queryOrdersById(toid);
		map.put("orders", orders);
		return "views/orders/ordersUpdate";
	}
	
	/**
	 * 修改产品
	 * @return
	 */
	@RequestMapping("updateOrders")
	public String updateOrders(Orders orders){
		ordersService.updateOrdersById(orders);
		return "redirect:ordersList";
	}
	
	/**
	 * 删除产品
	 * @return
	 */
	@RequestMapping("deleteOrders")
	public String deleteOrders(Integer toid){
		ordersService.deletOrdersById(toid);
		return "redirect:ordersList";
	}
}
