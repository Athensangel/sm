package com.sm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sm.entity.Product;
import com.sm.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {
	private static Logger logger = Logger.getLogger(ProductController.class);  
	
	//@Autowired
	@Resource
	private ProductService productService;
	
	
	/**
	 * 查询所有产品
	 * @param map
	 * @return
	 */
	@RequestMapping("productList")
	public String findAllProducts(ModelMap map){
		List<Product> productList = productService.findAllProduct();
		map.put("productList", productList);
		logger.info("productList="+productList);    
		return "views/product/productList";
	}
	
	/**
	 * 跳转到产品新增页
	 * @return
	 */
	@RequestMapping("jumpSaveProduct")
	public String jumpSaveProduct(){
		return "views/product/productSave";
	}
	
	/**
	 * 新增产品
	 * @return
	 */
	@RequestMapping("saveProduct")
	public String saveProduct(Product product){
		productService.saveProduct(product);
		return "redirect:productList";
	}
	
	/**
	 * 跳转到产品修改页
	 * @return
	 */
	@RequestMapping("jumpUpdateProduct")
	public String jumpUpdateProduct(Integer toid,ModelMap map){
		Product product = productService.queryProductById(toid);
		map.put("product", product);
		return "views/product/productUpdate";
	}
	
	/**
	 * 修改产品
	 * @return
	 */
	@RequestMapping("updateProduct")
	public String updateProduct(Product product){
		productService.updateProductById(product);
		return "redirect:productList";
	}
	
	/**
	 * 删除产品
	 * @return
	 */
	@RequestMapping("deleteProduct")
	public String deleteProduct(Integer toid){
		productService.deletProductById(toid);
		return "redirect:productList";
	}
}
