package com.walmartmg.android.registered;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.android.OrdersBusinessTest;

public class YourOrdersTest {
	
	public static final Logger logger = Logger.getLogger( MyProfileTest.class );
	private static OrdersBusinessTest orders = new OrdersBusinessTest();
	
	@AfterClass
	public static void tearDown(){
		orders.driverDisconect();
	}	
	
	@Before
	public void resetApp() {
		orders.resetApp();
	}
	
	@Test
	public void CP107_validate_screen_your_orders() {
		logger.info("Start CP107 Validate screen Your Orders");
		orders.selectProfileOption();
		orders.selectMenuLogin();
		orders.login("tioxx2@gmail.com", "12345678");
		logger.info("Menu logueado");
		orders.selectRequestMyProfile();
		orders.validateScreenYouOrders();
	}
	
	@Test
	public void CP108_validate_btnstart_your_orders() {
		logger.info("Start CP108 Validate btn start shopping Your Orders");
		orders.selectProfileOption();
		orders.selectMenuLogin();
		orders.login("tioxx2@gmail.com", "12345678");
		logger.info("Menu logueado");
		orders.selectRequestMyProfile();
		orders.validateBtnStartYouOrders();
	}
	
	
	@Test
	public void CP109_validate_screen_list_orders(){
		logger.info("Start CP109 Validate screen List Products Your Orders");
		orders.selectProfileOption();
		orders.selectMenuLogin();
		orders.login("correo_test@correo.com", "Juan#123");
		logger.info("Menu logueado");
		orders.selectRequestMyProfile();
		orders.validateListYouOrders();
	}

	
	
}
