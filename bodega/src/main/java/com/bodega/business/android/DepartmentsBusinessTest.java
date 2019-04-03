package com.bodega.business.android;

import java.util.List;

import org.apache.log4j.Logger;

import com.bodega.constants.NamesMobileElements;
import com.bodega.util.BaseDriver;

import io.appium.java_client.MobileElement;

public class DepartmentsBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(DepartmentsBusinessTest.class);
	private GeneralBusinessTest general = new GeneralBusinessTest();
	private LoginBusinessTest login = new LoginBusinessTest();
	private SearchBusinessTest search = new SearchBusinessTest();
	
	public void validateWelcomePage() {
		general.validateWelcomePage();
	}

	public void selectProfile() {
		general.selectProfile();
	}

	public void selectMenu(String menu) {
		general.selectMenuOption(menu);
	}

	public void selectNavigation(int option) {
		general.selectNavigationOption(option);
	}

	public void login(String email, String password) {
		login.login(email, password);
	}
	
	public void validateProducts() {
		waitElementVisibility(NamesMobileElements.SEARCH_PRODUCT_LIST);
	}
	
	public void validateDepartments() {
		waitElementVisibility(NamesMobileElements.DEPARTMENT_DEPARTMENT_LIST);
	}
	
	public void selectShowAll() {
		waitElementVisibility( NamesMobileElements.HOME_SHOW_ALL );
		tapOnElement( NamesMobileElements.HOME_SHOW_ALL );
	}
	
	public void selectDepartment() {
		logger.info("Seleccionado Departamento");
		waitElementVisibility(NamesMobileElements.DEPARTMENT_DEPARTMENT_LIST);
		List<MobileElement> departments = findElements(NamesMobileElements.DEPARTMENT_ITEM_TEXT);
		tapOnElement(departments.get(0));
	}

	public void selectCategory() {
		logger.info("Seleccionado Categoria");
		waitElementVisibility(NamesMobileElements.DEPARTMENT_CAT_LIST);
		List<MobileElement> categoties = findElements(NamesMobileElements.DEPARTMENT_CAT_ITEM);
		tapOnElement(categoties.get(0));
	}
	
	public void tapOnFilter() {
		search.tapOnFilter();
	}
	
	public void selectFilter(String filters) {
		search.selectFilter(filters);
	}
	
	public void applyFilter() {
		search.applyFilter();
	}
	
	public void validateSearch() {
		search.validateSearch();
	}
}
