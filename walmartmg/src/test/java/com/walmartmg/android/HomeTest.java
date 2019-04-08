package com.walmartmg.android;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.android.HomeBusinessTest;

public class HomeTest {

	private static HomeBusinessTest home = new HomeBusinessTest();
	private static final Logger logger = Logger.getLogger(HomeTest.class);

	@AfterClass
	public static void tearDown() {
		home.driverDisconect();
	}

	@Before
	public void resetApp() {
		home.closeApp();
		home.lauchApp();
	}

	@Test
	public void CP001_home_validate_page() {
		logger.info("===> Iniciando caso de prueba: Home Validation Page");
		home.selectHomeOption();
		home.validateElements();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CP002_search_valid_product() {
		logger.info("===> Iniciando caso de prueba: Search valid product");
		home.searchProduct("Celulares");
		home.validateSearch();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CP003_search_invalid_product() {
		logger.info("===> Iniciando caso de prueba: Search invalid product");
		home.searchProduct("Pan");
		home.validateEmptySearch();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CP004_home_scan_validate_page() {
		logger.info("===> Iniciando caso de prueba: Home scan validate page");
		home.scanProduct();
		home.validateScanPage();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CP007_home_empty_car() {
		logger.info("===> Iniciando caso de prueba: Empty car");
		home.selectCar();
		home.validateEmptyCar();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CP008_home_validate_starting_buy() {
		logger.info("===> Iniciando caso de prueba: Validate Starting buy");
		home.selectCar();
		home.validateStartingBuy();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CP009_add_product() {
		logger.info("===> Iniciando caso de prueba: Add product");
		home.selectProduct();
		home.validateProduct();
		home.addProduct();
		home.validateCar();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CP010_add_product_by_search() {
		logger.info("===> Iniciando caso de prueba: Add product by search");
		home.searchProduct("Celulares");
		home.validateSearch();
		home.selectProduct();
		home.validateProduct();
		home.addProduct();
		home.validateCar();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP011_remove_product_from_detail() {
		logger.info("===> Iniciando caso de prueba: Remove product from detail");
		home.searchProduct("Celulares");
		home.validateSearch();
		home.selectProduct();
		home.validateProduct();
		home.addProduct();
		home.removeProduct();
		home.validateCar();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP012_add_product_using_plus() {
		logger.info("===> Iniciando caso de prueba: Add product using plus");
		home.searchProduct("Celulares");
		home.validateSearch();
		home.selectProduct();
		home.validateProduct();
		home.addProduct();
		home.addProduct();
		home.validateCar();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CP013_validate_car() {
		logger.info("===> Iniciando caso de prueba: Validate car");
		home.searchProduct("Celulares");
		home.validateSearch();
		home.selectProduct();
		home.addProduct();
		home.goBack();
		home.validateCar();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CP014_eliminate_product() {
		logger.info("===> Iniciando caso de prueba: Eliminate product");
		home.selectProduct();
		home.addProduct();
		home.goBack();
		home.selectCar();
		home.deleteProduct();
		home.validateEmptyCar();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	public void CP015_cancel_eliminate_product() {
		logger.info("===> Iniciando caso de prueba: Eliminate product");
		home.selectProduct();
		home.addProduct();
		home.goBack();
		home.selectCar();
		home.deleteProduct();
		home.validateEmptyCar();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	public void CP016_validate_buy() {
		logger.info("===> Iniciando caso de prueba: Validate buy");
		home.selectProduct();
		home.addProduct();
		home.selectCar();
		home.validateBuy();
		logger.info("Caso de prueba finalizado");
	}
}