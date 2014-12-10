
package com.qianqian.order.dto;

import java.io.Serializable;

import com.qianqian.product.model.Product;
import com.qianqian.product.model.ProductActivity;
import com.qianqian.product.model.ProductPicture;
import com.qianqian.product.model.ProductStandard;

/** 包含产品信息,活动信息,规格信息,图片信息,品牌id
 * 
 * @Project 	: order.maxtp
 * @Program Name: com.qianqian.order.dto.ProductDTO.java
 * @ClassName	: ProductDTO 
 * @Author 		: shenzhenxing 
 * @CreateDate  : 2014年7月2日 下午2:13:24  
 */
public class ProductDTO implements Serializable{
	/**
	 * @Fields serialVersionUID :   
	 * @since Ver 1.1
	 */
	private static final long serialVersionUID = 8382220772754586875L;
	private Product prodcut;
	private ProductActivity productActivity;
	private ProductStandard productStandard;
	private ProductPicture  productPicture;
	private long brandId;
	
	public long getBrandId() {
		return brandId;
	}
	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}
	public Product getProdcut() {
		return prodcut;
	}
	public void setProdcut(Product prodcut) {
		this.prodcut = prodcut;
	}
	public ProductActivity getProductActivity() {
		return productActivity;
	}
	public void setProductActivity(ProductActivity productActivity) {
		this.productActivity = productActivity;
	}
	public ProductStandard getProductStandard() {
		return productStandard;
	}
	public void setProductStandard(ProductStandard productStandard) {
		this.productStandard = productStandard;
	}
	public ProductPicture getProductPicture() {
		return productPicture;
	}
	public void setProductPicture(ProductPicture productPicture) {
		this.productPicture = productPicture;
	}
	
	
}
