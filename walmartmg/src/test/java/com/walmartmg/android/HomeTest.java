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
}
