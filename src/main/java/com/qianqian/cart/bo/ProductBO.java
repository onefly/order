package com.qianqian.cart.bo;

import com.qianqian.product.model.Product;
import com.qianqian.product.model.ProductActivity;
import com.qianqian.product.model.ProductPicture;
import com.qianqian.product.model.ProductStandard;

/**
 * 产品与活动的业务封装对象
 * @Project 	: order.maxtp
 * @Program Name: com.qianqian.cart.bo.ProductBO.java
 * @ClassName	: ProductBO 
 * @Author 		: caozhifei 
 * @CreateDate  : 2014年6月18日 下午1:28:15
 */
public class ProductBO {
	/**
	 * 产品信息
	 */
	private Product product;
	/**
	 * 产品活动信息
	 */
	private ProductActivity activity;
	/**
	 * 产品的图片信息
	 */
	private ProductPicture picture;
	/**
	 * 产品的规格信息
	 */
	private ProductStandard standard;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public ProductActivity getActivity() {
		return activity;
	}
	public void setActivity(ProductActivity activity) {
		this.activity = activity;
	}
	public ProductPicture getPicture() {
		return picture;
	}
	public void setPicture(ProductPicture picture) {
		this.picture = picture;
	}
	public ProductStandard getStandard() {
		return standard;
	}
	public void setStandard(ProductStandard standard) {
		this.standard = standard;
	}
	
}
