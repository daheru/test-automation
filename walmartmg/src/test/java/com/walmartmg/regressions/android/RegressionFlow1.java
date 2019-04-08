package com.walmartmg.regressions.android;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.android.CarBusinessTest;
import com.walmartmg.business.android.DepartmentsBusinessTest;
import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.business.android.LoginBusinessTest;
import com.walmartmg.business.android.ProductBusinessTest;
import com.walmartmg.business.android.SearchBusinessTest;

public class RegressionFlow1 {

	private SearchBusinessTest search = new SearchBusinessTest();
	private LoginBusinessTest login = new LoginBusinessTest();
	private ProductBusinessTest product = new ProductBusinessTest();
	private CarBusinessTest car = new CarBusinessTest();
	private DepartmentsBusinessTest departments = new DepartmentsBusinessTest();
	private static GeneralBusinessTest general = new GeneralBusinessTest();
	
	@AfterClass
	public static void tearDown(){
		general.driverDisconect();
	}	
	
	@Before
	public void resetApp() {
		general.closeApp();
		general.lauchApp();
	}
	
	@Test
	public void regression_flow_001() {
		search.searchProduct("Celulares");
		search.validateSearch();
		product.selectProduct();
		product.addProduct();
		product.addProduct();
		product.removeProduct();
		general.goBack();
		general.goBack();
		product.selectHomeProduct();
		product.addProduct();
		general.goBack();
		departments.selectDepartmentOption();
		departments.selectDepartment();
		departments.selectFamily();
		product.selectProduct();
		product.addProduct();
		general.goBack();
		car.validateCar();
		car.deleteProduct();
		general.goBack();
		car.selectCar();
		car.validateContinue();
		login.login("dj_fran_@hotmail.es", "080714");
		login.login("dj_fran_@hotmail.es", "080714regina");
	}	
}
