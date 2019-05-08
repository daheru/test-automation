package com.walmartmg.android.unregistered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.walmartmg.business.android.HomeBusinessTest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature("Home Module - No session")
public class HomeTest {

	@Rule
	public TestName name = new TestName();
	private static final Logger logger = Logger.getLogger(HomeTest.class);
	private static HomeBusinessTest home = new HomeBusinessTest();

	@AfterClass
	public static void tearDown() {
		home.driverDisconect();
	}

	@Before
	public void initApp() {
		logger.info("===> Iniciando caso de prueba: " + name.getMethodName());
	}
	
	@After
	public void resetApp() {
		home.resetApp();
		logger.info("Caso de prueba finalizado");
	}

	@Test
	@DisplayName("Validate home page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to see my home page")
	@Description("Validate that home page has all elements")
	public void CP001_home_validate_page() {
		home.selectHomeOption();
		home.validateElements();
	}

	@Test
	@DisplayName("Search valid product")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to search a product")
	@Description("Search a product using search bar")
	public void CP002_search_valid_product() {
		home.searchProduct("Celulares");
		home.validateSearch();
	}

	@Test
	@DisplayName("Search unexist product")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to search a product")
	@Description("Search an unexist product using search bar")
	public void CP003_search_unexist_product() {
		home.searchProduct("Pan");
		home.validateEmptySearch();
	}

	@Test
	@DisplayName("Validate scan page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to search a product")
	@Description("Validate that scan page has all elements")
	public void CP004_home_scan_validate_page() {
		home.scanProduct();
		home.validateScanPage();
	}

	@Test
	@DisplayName("Validate empty car")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to see my product's car")
	@Description("Validate car page when there are not products")
	public void CP007_home_empty_car() {
		home.selectCar();
		home.validateCar();
	}

	@Test
	@DisplayName("Validate starting buy page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to see my product's car")
	@Description("Validate car page when there are not products")
	public void CP008_home_validate_starting_buy() {
		home.selectCar();
		home.validateStartingBuy();
	}

	@Test
	@DisplayName("Add product")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to buy a product")
	@Description("Add a new product to car")
	public void CP009_add_product() {
		home.selectProduct();
		home.validateProduct();
		home.addProduct();
		home.selectCar();
		home.validateCar();
	}

	@Test
	@DisplayName("Add product by search")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to buy a product")
	@Description("Add a new product to car by search usign the search bar")
	public void CP010_add_product_by_search() {
		home.searchProduct("Celulares");
		home.validateSearch();
		home.selectProduct();
		home.addProduct();
		home.selectCar();
		home.validateCar();
	}
	
	@Test
	@DisplayName("Delete product")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to buy a product")
	@Description("Delete a product from car")
	public void CP011_remove_product_from_detail() {
		home.searchProduct("Celulares");
		home.validateSearch();
		home.selectProduct();
		home.addProduct();
		home.removeProduct();
		home.selectCar();
		home.validateCar();
	}

	@Test
	@DisplayName("Add product using plus")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to buy a product")
	@Description("Increase product quantity using plus button")
	public void CP012_add_product_using_plus() {
		home.searchProduct("Celulares");
		home.validateSearch();
		home.selectProduct();
		home.addProduct();
		home.addProduct();
		home.selectCar();
		home.validateCar();
	}

	@Test
	@DisplayName("Validate car")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to see my product's car")
	@Description("Validate product is added in the car")
	public void CP013_validate_car() {
		home.searchProduct("Celulares");
		home.validateSearch();
		home.selectProduct();
		home.addProduct();
		home.selectCar();
		home.validateCar();
	}

	@Test
	@DisplayName("Delete product")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to buy a product")
	@Description("Delete a product from car")
	public void CP014_eliminate_product() {
		home.selectProduct();
		home.addProduct();
		home.selectCar();
		home.deleteProduct();
		home.validateCar();
	}
	
	@Test
	@DisplayName("Cancel delete product")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to buy a product")
	@Description("Cancel delete product from car")
	public void CP015_cancel_eliminate_product() {
		home.selectProduct();
		home.addProduct();
		home.goBack();
		home.selectCar();
		home.cancelDeleteProduct();
		home.validateCar();
	}

	@Test
	@DisplayName("Validate buy")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to buy a product")
	@Description("Validate button Continuar con la compra")
	public void CP016_validate_buy() {
		home.selectProduct();
		home.addProduct();
		home.selectCar();
		home.validateCar();
		home.validateBuy();
	}
}