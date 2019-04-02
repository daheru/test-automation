package com.walmartmg.android;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.android.HomeBusinessTest;

public class HomeTest {
	
	public static HomeBusinessTest home = new HomeBusinessTest();
	
	@AfterClass
	public static void tearDown(){
		home.driverDisconect();
	}	
	
	@Before
	public void resetApp() {
		home.closeApp();
		home.lauchApp();
	}
	
	@Test
	public void CP001_home_validate_page() {
		home.selectHomeOption();
		home.validateElements();
	}
	
	@Test
	public void CP002_search_valid_product() {
		home.searchProduct("Celulares");
		home.validateSearch();
	}
	
	@Test
	public void CP003_search_invalid_product() {
		home.searchProduct("Pan");
		home.validateInvalidSearch();
	}
	
	@Test
	public void CP004_home_scan_validate_page() {
		home.scanProduct();
		home.validateScanPage();
	}
	
	@Test
	public void CP007_home_empty_car() {
		home.selectCar();
		home.validateEmptyCar();
	}
	
	@Test
	public void CP008_home_validate_starting_buy() {
		home.selectCar();
		home.validateStartingBuy();
	}
	
	@Test
	public void CP009_add_product() {
		home.selectProduct();
		home.validateProduct();
		home.addProduct();
		home.validateCar( 1 );
	}
	
	@Test
	public void CP010_add_product_by_search() {
		home.searchProduct("Celulares");
		home.validateSearch();
		home.selectProduct();
		home.addProduct();
		home.validateCar( 1 );
	}
	
	@Test
	public void CP011_add_product_by_two_ways() {
		home.selectProduct();
		home.addProduct();
		home.goBack();
		home.searchProduct("Celulares");
		home.selectProduct();
		home.addProduct();
		home.goBack();
		home.validateCar( 2 );
	}
	
	@Test
	public void CP012_validate_car() {
		home.searchProduct("Celulares");
		home.validateSearch();
		home.selectProduct();
		home.addProduct();
		home.goBack();
		home.validateCar( 1 );
	}
	
	@Test
	public void CP013_eliminate_product() {
		home.selectProduct();
		home.addProduct();
		home.goBack();
		home.selectCar();
		home.deleteProduct();
		home.validateEmptyCar();
	}
	
	@Test
	public void CP014_validate_buy() {
		home.selectProduct();
		home.addProduct();
		home.selectCar();
		home.validateBuy();
	}
}