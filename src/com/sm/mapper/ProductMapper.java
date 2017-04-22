package com.sm.mapper;

import java.util.List;

import com.sm.entity.Product;


public interface ProductMapper {

	public List<Product> findAllProduct();

	public void insertProduct(Product product);

	public void delProductById(Integer toid);

	public Product findProductById(Integer toid);

	public void updateProductById(Product product);

}
