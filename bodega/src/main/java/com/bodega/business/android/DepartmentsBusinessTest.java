package com.bodega.business.android;

import java.util.List;

import org.apache.log4j.Logger;

import com.bodega.base.BaseDriver;
import com.bodega.constants.NamesMobileElements;
import com.bodega.enums.FiltersEnum;
import com.bodega.enums.NavigationBarEnum;
import com.bodega.enums.ProfileMenuEnum;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class DepartmentsBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(DepartmentsBusinessTest.class);
	private GeneralBusinessTest general = new GeneralBusinessTest();
	private LoginBusinessTest login = new LoginBusinessTest();
	private SearchBusinessTest search = new SearchBusinessTest();
	private HomeBusinessTest home = new HomeBusinessTest();
	private String departmentName = "";
	
	public void selectProfile() {
		general.selectProfile();
	}

	public void selectMenu(ProfileMenuEnum menu) {
		general.selectMenuOption(menu);
	}

	public void selectNavigation(NavigationBarEnum option) {
		general.selectNavigationOption(option);
	}

	public void goBack() {
		general.goBack();
	}
	
	public void login(String email, String password) {
		login.login(email, password);
	}
	
	public void validateHome() {
		home.validateHomePage();
	}
	
	@Step("Validate navigation bar")
	public void validateNavigationBar() {
		waitElementVisibility(NamesMobileElements.NAV_BAR);
	}
	
	@Step("Validate product list")
	public void validateProducts() {
		waitElementVisibility(NamesMobileElements.SEARCH_PRODUCT_LIST);
	}
	
	@Step("Validate department list")
	public void validateDepartments() {
		waitElementVisibility(NamesMobileElements.DEPARTMENT_DEPARTMENT_LIST);
	}
	
	@Step("Tap on show all")
	public void selectShowAll() {
		waitElementVisibility( NamesMobileElements.HOME_SHOW_ALL );
		tapOnElement( NamesMobileElements.HOME_SHOW_ALL );
	}
	
	@Step("Tap on department")
	public void selectDepartment() {
		logger.info("Seleccionado Departamento");
		waitElementVisibility(NamesMobileElements.DEPARTMENT_DEPARTMENT_LIST);
		List<MobileElement> departments = findSubElements(NamesMobileElements.DEPARTMENT_DEPARTMENT_LIST, NamesMobileElements.DEPARTMENT_ITEM_TEXT);
		departmentName = getElementText(departments.get(0));
		tapOnElement(departments.get(0));
	}

	@Step("Tap on category")
	public void selectCategory() {
		logger.info("Seleccionado Categoria");
		waitElementVisibility(NamesMobileElements.DEPARTMENT_CAT_LIST);
		List<MobileElement> categoties = findSubElements(NamesMobileElements.DEPARTMENT_CAT_LIST, NamesMobileElements.DEPARTMENT_CAT_ITEM);
		tapOnElement(categoties.get(0));
		waitElementVisibility(NamesMobileElements.DEPARTMENT_CAT_FILTER);
	}
	
	public void tapOnFilter() {
		search.tapOnFilter();
	}
	
	public void selectFilter(FiltersEnum filterEnum) {
		search.selectFilter(filterEnum);
	}
	
	public void applyFilter() {
		search.applyFilter();
	}
	
	public void validateSearch() {
		search.validateSearch();
	}
	
	public void validateTitleToolbar() {
		waitElementVisibility( NamesMobileElements.DEPARTMENT_TITLE_TOOLBAR );
		MobileElement titleToolbar = findElement( NamesMobileElements.DEPARTMENT_TITLE_TOOLBAR );
		assertEquals(getElementText(titleToolbar).toLowerCase(), departmentName);
	}
}
