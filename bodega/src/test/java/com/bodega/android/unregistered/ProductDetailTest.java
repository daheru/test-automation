package com.bodega.android.unregistered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.bodega.business.android.ProductDetailBusinessTest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature("Product Detail - No session")

public class ProductDetailTest {

	@Rule
	public TestName name = new TestName();
	private static final Logger logger = Logger.getLogger(ProductDetailTest.class);
	private static ProductDetailBusinessTest detail = new ProductDetailBusinessTest();

	@AfterClass
	public static void shutDown() {
		detail.driverDisconect();
	}

	@Before
	public void initApp() {
		detail.closeAndroidDialog();
		detail.validateWelcomePage();
		logger.info("===> Iniciando caso de prueba: " + name.getMethodName());
	}

	@After
	public void relauchApp() {
		detail.resetApp();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("Validate product detail caracteristics")
	@Severity(SeverityLevel.MINOR)
	@Story("As a user I want to know about product")
	@Description("Validate caracteristics options when user selects a product")
	public void CF037_product_detail_caracteristics() {
		detail.searchProduct("Celular");
		detail.selectProduct();
		detail.validateCaracteristics();
	}
	
	@Test
	@DisplayName("Validate product promotions")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to know about product")
	@Description("Validate promotions when user selects a product")
	public void CF038_product_detail_msi() {
		detail.searchProduct("Celular");
		detail.selectProduct();
		detail.validateMSI();
	}
	
	@Test
	@DisplayName("Add product")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to know about product")
	@Description("Try to add a product to car")
	public void CF039_product_detail_add_product() {
		detail.searchProduct("Celular");
		detail.selectProduct();
		detail.addProduct();
		detail.selectCar();
		detail.validateCar();
	}
	
	@Test
	@DisplayName("Add special product")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to know about product")
	@Description("Validate different sellers information when user select a product")
	public void CF040_product_detail_validate_sellers() {
		detail.searchProduct("Celular");
		detail.selectProduct();
		detail.validateSellers();
	}
}