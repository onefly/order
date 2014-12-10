package com.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qianqian.cart.model.BrandCart;
import com.qianqian.cart.model.Commodity;
import com.qianqian.cart.model.UserCart;
import com.qianqian.cart.service.ICartService;

public class TestCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestCart t = new TestCart();
		//t.test2();
		boolean r = false;
		System.out.println(Thread.currentThread().getId());

	}
	/**
	 * 添加商品到购物车测试
	 *  @Method_Name    : test1 
	 *  @return         : void
	 *  @Creation Date  : 2014年6月17日 上午9:17:11
	 *  @version        : v1.00
	 *  @Author         : caozhifei 
	 *  @Update Date    : 
	 *  @Update Author  :
	 */
	@Test
	public void test1(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/spring/applicationContext.xml");
		ICartService cartService = (ICartService) ctx
				.getBean("cartService");
		Commodity commodity = new Commodity(29l, 17, "百度杀毒",
				"/group1/M00/00/28/wKgGblORX6SSBX_TAABs5QESNpM090.jpg", "43", BigDecimal.valueOf(416.36),BigDecimal.valueOf(186.36), 1);
		commodity.setBrandId(1l);
		commodity.setBrandName("百度");
		commodity.setBrandImgSmall("/group1/M00/00/28/wKgGblORX57cvNnmAAA-KveQaas469.jpg");
		commodity.setBrandImgBig("/group1/M00/00/28/wKgGblORX6SSBX_TAABs5QESNpM090.jpg");
		long result=cartService.addCommodityToCart(commodity);
		System.out.println("result="+result);
		UserCart cart = cartService.getUserCart();
		System.out.println("#################1111#####################");
		System.out.println(cart);
		System.out.println("##################11111####################");
	}
	@Test
	public void test2(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/spring/applicationContext.xml");
		ICartService cartService = (ICartService) ctx
				.getBean("cartService");
		Commodity commodity = new Commodity();
		commodity.setProductCode(4004l);
		boolean result = cartService.deleteCommodityFromCart(commodity);
		System.out.println("result="+result);
		UserCart cart = cartService.getUserCart();
		System.out.println("################2222######################");
		System.out.println(cart);
		System.out.println("#################2222#####################");
	}
	
	@Test
	public void test3(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/spring/applicationContext.xml");
		ICartService cartService = (ICartService) ctx
				.getBean("cartService");
		boolean result=cartService.removeCartByBrandId(1991l);
		System.out.println("result="+result);
		UserCart cart = cartService.getUserCart();
		System.out.println("################33333######################");
		System.out.println(cart);
		System.out.println("#################33333#####################");
	}
	
	@Test
	public void test4(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/spring/applicationContext.xml");
		ICartService cartService = (ICartService) ctx
				.getBean("cartService");
		//cartService.removeCartByBrandId(1991l);
		BrandCart cart = cartService.getBrandCartByBrandId(2014l);
		System.out.println("################44444######################");
		System.out.println(cart);
		System.out.println("#################44444#####################");
	}
	@Test
	public void test5(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/spring/applicationContext.xml");
		ICartService cartService = (ICartService) ctx
				.getBean("cartService");
		boolean result= cartService.removeAllCart();
		System.out.println("result="+result);
		UserCart cart = cartService.getUserCart();
		System.out.println("################55555######################");
		System.out.println(cart);
		System.out.println("#################55555#####################");
	}

}
