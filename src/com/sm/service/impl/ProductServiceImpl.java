package com.sm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sm.entity.Product;
import com.sm.mapper.ProductMapper;
import com.sm.service.ProductService;

@Transactional
//@Service
@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService{
	
	
	@Resource
	private ProductMapper productMapper;

	@Override
	public List<Product> findAllProduct() {
		return productMapper.findAllProduct();
	}

	@Override
	public void saveProduct(Product product) {
		productMapper.insertProduct(product);
	}

	@Override
	public void deletProductById(Integer toid) {
		productMapper.delProductById(toid);		
	}

	@Override
	public Product queryProductById(Integer toid) {
		return productMapper.findProductById(toid);
	}

	@Override
	public void updateProductById(Product product) {
		productMapper.updateProductById(product);		
	}

}
