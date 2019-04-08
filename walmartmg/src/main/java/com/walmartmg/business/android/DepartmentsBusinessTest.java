package com.walmartmg.business.android;

import java.util.List;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.MenusEnum;
import com.walmartmg.enums.NavigationBarEnum;

import io.appium.java_client.MobileElement;

public class DepartmentsBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(DepartmentsBusinessTest.class.getName());
	private GeneralBusinessTest general = new GeneralBusinessTest();
	private ProductBusinessTest product = new ProductBusinessTest();
	
	public void selectDepartmentOption() {
		logger.info("Seleccionando opción de departamento");
		general.selectNavigationOption(NavigationBarEnum.DEPARTMENTS.getNavigation());
	}

	public void validateDepartment(MenusEnum department) {
		logger.info("Validando departamento");
		tapUp();
		general.valitateDropDownMenu(department);
	}

	public void selectDepartment() {
		List<MobileElement> departments = findElements(NamesMobileElements.DEP_ICON);
		tapOnElement( departments.get(0) );
	}

	public void selectFamily() {
		List<MobileElement> departments = findElements(NamesMobileElements.DEP_ITEM_CHILD);
		tapOnElement( departments.get(0) );
		
	}
	
	public void selectProduct() {
		product.selectProduct();
	}
	
	public void addProduct() {
		product.addProduct();
	}

}
