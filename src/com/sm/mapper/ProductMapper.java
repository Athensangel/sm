package com.sm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sm.entity.Product;

@Repository 
public interface ProductMapper {

	public List<Product> findAllProduct();

	public void insertProduct(Product product);

	public void delProductById(Integer toid);

	public Product findProductById(Integer toid);

	public void updateProductById(Product product);

}
