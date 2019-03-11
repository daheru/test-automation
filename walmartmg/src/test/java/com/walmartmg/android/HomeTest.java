package com.walmartmg.android;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.android.HomeBusinessTest;

public class HomeTest {
	
	public static HomeBusinessTest home = new HomeBusinessTest();
	
	@AfterClass
	public static void tearDown(){
		home.desconectarDriver();
	}	
	
	@Before
	public void resetApp() {
		home.closeApp();
		home.lauchApp();
	}
	
	@Test
	public void home_validate_page() {
		home.selectHomeOption();
		home.validateElements();
	}
	
	@Test
	public void search_valid_product() {
		home.searchProduct("Celulares");
		home.validateSearch();
	}
	
	@Test
	public void search_invalid_product() {
		home.searchProduct("Pan");
		home.validateInvalidSearch();
	}
	
	@Test
	public void home_scan_validate_page() {
		home.scanProduct();
		home.validateScanPage();
	}
	
	@Test
	public void home_empty_car() {
		home.selectCar();
		home.validateEmptyCar();
	}
	
	@Test
	public void home_validate_starting_buy() {
		home.selectCar();
		home.validateStartingBuy();
	}
	
	@Test
	public void add_product() {
		home.selectProduct();
		home.validateProduct();
		home.addProduct();
	}
	
	@Test
	public void add_product_by_search() {
		home.searchProduct("Celulares");
		home.validateSearch();
		home.selectProduct();
		home.validateProduct();
		home.addProduct();
	}
	
	@Test
	public void add_product_by_two_ways() {
		home.selectProduct();
		home.validateProduct();
		home.addProduct();
		home.goBack();
		home.searchProduct("Celulares");
		home.validateSearch();
		home.selectProduct();
		home.validateProduct();
		home.addProduct();
		home.goBack();
		home.selectCar();
		home.validateCar( 2 );
	}
	
	@Test
	public void validate_car() {
		home.searchProduct("Celulares");
		home.validateSearch();
		home.selectProduct();
		home.validateProduct();
		home.addProduct();
		home.goBack();
		home.selectCar();
		home.validateCar( 1 );
	}
	
	@Test
	public void eliminate_product() {
		home.selectProduct();
		home.validateProduct();
		home.addProduct();
		home.goBack();
		home.selectCar();
		home.deleteProduct();
	}
	
	@Test
	public void validate_buy() {
		home.selectProduct();
		home.validateProduct();
		home.addProduct();
		home.selectCar();
		home.validateBuy();
	}
}
