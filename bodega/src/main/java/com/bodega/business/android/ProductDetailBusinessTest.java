package com.bodega.business.android;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProductDetailBusinessTest {
	public static final Logger logger = Logger.getLogger(MyprofileBusinessTest.class);
	public static MyprofileBusinessTest productdetail = new MyprofileBusinessTest();

	@BeforeClass
	public static void init() {

	}

	@AfterClass
	public static void tearDown() {
		productdetail.driverDisconect();
	}

	@Before
	public void intapp() {
		productdetail.closeAndroidDialog();

	}

	@After
	public void reinicio() {
		productdetail.resetApp();

	}
	
	@Test
	public void CF037_ProductDetail() {
		logger.info("Iniciando caso de prueba: Product Detail");
		productdetail.login("emmanuel.dominguez@axity.com", "Edominguez#1234");
	//	productdetail.ProductDetail("00085369975649");
		productdetail.saveProfile();
	}
}
