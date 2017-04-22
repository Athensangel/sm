package com.sm.service;

import java.util.List;
import com.sm.entity.Product;


public interface ProductService {
	
	public List<Product> findAllProduct();//遍历查询orders表中的字段

	public void saveProduct(Product product);//新增订单

	public void deletProductById(Integer toid);//通过toId查找订单信息并做删除处理

	public Product queryProductById(Integer toid);//通过toId查找订单信息并做删除处理

	public void updateProductById(Product product);//查找订单，并修改订单信息


}
