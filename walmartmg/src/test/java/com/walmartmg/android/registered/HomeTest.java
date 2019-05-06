package com.walmartmg.android.registered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.walmartmg.business.android.HomeBusinessTest;
import com.walmartmg.constants.GeneralConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature("Home Module - Whit session")
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
	@DisplayName("Search valid product")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to search a product")
	@Description("Search a product using search bar")
	public void CP166_search_valid_product() {
		home.selectProfileOption();
		home.selectMenuLogin();
		home.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		home.selectHomeOption();
		home.searchProduct("Celulares");
		home.validateSearch();
	}
	
	@Test
	@DisplayName("Validate product detail")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to search a product")
	@Description("Validate that product detail has all elements")
	public void CP000_validate_product() {
		home.selectProfileOption();
		home.selectMenuLogin();
		home.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		home.selectHomeOption();
		home.selectProduct();
		home.validateProduct();
	}

	@Test
	@DisplayName("Search unexist product")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to search a product")
	@Description("Search an unexist product using search bar")
	public void CP167_search_unexist_product() {
		home.selectProfileOption();
		home.selectMenuLogin();
		home.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		home.selectHomeOption();
		home.searchProduct("Pan");
		home.validateEmptySearch();
	}

	@Test
	@DisplayName("Validate scan page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to search a product")
	@Description("Validate that scan page has all elements")
	public void CP168_home_scan_validate_page() {
		home.selectProfileOption();
		home.selectMenuLogin();
		home.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		home.selectHomeOption();
		home.scanProduct();
		home.validateScanPage();
	}

	@Test
	@DisplayName("Validate empty car")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to see my product's car")
	@Description("Validate car page when there are not products")
	public void CP171_home_empty_car() {
		home.selectProfileOption();
		home.selectMenuLogin();
		home.login(GeneralConstants.TEST_EMPTY_EMAIL, GeneralConstants.TEST_EMPTY_PASS);
		home.selectHomeOption();
		home.selectCar();
		home.validateEmptyCar();
	}

	@Test
	@DisplayName("Validate starting buy page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to see my product's car")
	@Description("Validate car page when there are not products")
	public void CP172_home_validate_starting_buy() {
		home.selectProfileOption();
		home.selectMenuLogin();
		home.login(GeneralConstants.TEST_EMPTY_EMAIL, GeneralConstants.TEST_EMPTY_PASS);
		home.selectHomeOption();
		home.selectCar();
		home.validateStartingBuy();
	}

	@Test
	@DisplayName("Add product")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to buy a product")
	@Description("Add a new product to car")
	public void CP173_add_product() {
		home.selectProfileOption();
		home.selectMenuLogin();
		home.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		home.selectHomeOption();
		home.selectCar();
		home.deleteProducts();
		home.selectProduct();
		home.addProduct();
		home.selectCar();
		home.validateCar();
	}

	@Test
	@DisplayName("Add product by search")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to buy a product")
	@Description("Add a new product to car by search usign the search bar")
	public void CP174_add_product_by_search() {
		home.selectProfileOption();
		home.selectMenuLogin();
		home.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		home.selectHomeOption();
		home.selectCar();
		home.deleteProducts();
		home.searchProduct("Celulares");
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
	public void CP175_remove_product_from_detail() {
		home.selectProfileOption();
		home.selectMenuLogin();
		home.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		home.selectHomeOption();
		home.selectCar();
		home.deleteProducts();
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
	public void CP176_add_product_using_plus() {
		home.selectProfileOption();
		home.selectMenuLogin();
		home.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		home.selectHomeOption();
		home.selectCar();
		home.deleteProducts();
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
	public void CP177_validate_car() {
		home.selectProfileOption();
		home.selectMenuLogin();
		home.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		home.selectHomeOption();
		home.selectCar();
		home.deleteProducts();
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
	public void CP178_eliminate_product() {
		home.selectProfileOption();
		home.selectMenuLogin();
		home.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		home.selectHomeOption();
		home.selectCar();
		home.deleteProducts();
		home.selectProduct();
		home.addProduct();
		home.goBack();
		home.selectCar();
		home.deleteProduct();
		home.validateCar();
	}

	@Test
	@DisplayName("Cancel delete product")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to buy a product")
	@Description("Cancel delete product from car")
	public void CP179_cancel_eliminate_product() {
		home.selectProfileOption();
		home.selectMenuLogin();
		home.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		home.selectHomeOption();
		home.selectCar();
		home.deleteProducts();
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
	public void CP180_validate_buy() {
		home.selectProfileOption();
		home.selectMenuLogin();
		home.login(GeneralConstants.TEST_EMAIL, GeneralConstants.TEST_PASS);
		home.selectHomeOption();
		home.selectProduct();
		home.addProduct();
		home.selectCar();
		home.validateBuy();
	}

}
