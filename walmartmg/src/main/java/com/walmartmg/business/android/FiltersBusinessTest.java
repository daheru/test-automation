package com.walmartmg.business.android;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.enums.ProfileMenuEnum;

import io.qameta.allure.Step;

public class FiltersBusinessTest extends BaseDriver {
	
	private static final Logger logger = Logger.getLogger( InvoiceBusinessTest.class );
	private GeneralBusinessTest general = new GeneralBusinessTest();
	private DepartmentsBusinessTest departments = new DepartmentsBusinessTest();
	private LoginBusinessTest login = new LoginBusinessTest();
	
	
	public void selectDepartmentOption() {
		general.selectNavigationOption(NavigationBarEnum.DEPARTMENTS);
	}
	
	//Select department
	public void selectDepartment () {
		departments.selectDepartment();
		logger.info("Selecciona un departamento");
	}
	
	//Select family 
	public void selectFamily() {
		departments.selectFamily();
		logger.info("Selecciona una familia");
	}
	
	//Select filters
	public void pressLinkFilter() {
		tapOnElement(NamesMobileElements.FILTERS_LINK);
		logger.info("Seleccionar link filtro");
	}
	
	public void login(String email, String pass) {
		login.login(email, pass);
	}
	
	public void selectProfileOption() {
		general.selectNavigationOption( NavigationBarEnum.PROFILE );
	}
	
	public void selectMenuLogin() {
		general.selectProfileMenu(ProfileMenuEnum.LOGIN );
	}
	
	
	
	//Validate Screen Filter
	@Step("Validate filter page")
	public void validateScreenFilter() {
		logger.info("Selecciona link Filtar");
		waitElementVisibility(NamesMobileElements.FILTERS_CONT);
		waitElementVisibility(NamesMobileElements.FILTERS_FILTER_BY);
		waitElementVisibility(NamesMobileElements.FILTERS_SORT_BY_AZ);
		waitElementVisibility(NamesMobileElements.FILTERS_SORT_BY_ZA);
		waitElementVisibility(NamesMobileElements.FILTERS_SORT_BY_GREATERTHAN);
		waitElementVisibility(NamesMobileElements.FILTERS_SORT_BY_LESSTHAN);
		waitElementVisibility(NamesMobileElements.FILTERS_SORT_BY_POPULARITY);
		waitElementVisibility(NamesMobileElements.FILTERS_PRICE);
		waitElementVisibility(NamesMobileElements.FILTERS_FILTER_BY);
		waitElementVisibility(NamesMobileElements.FILTERS_BUTTON);
	}
	
	@Step("Tap on A-Z filter")
	public void filterOrderAZ() {
		logger.info("Selecciona ordenar por AZ");
		tapOnElement(NamesMobileElements.FILTERS_SORT_BY_AZ);
		logger.info("Presionar boton listo");
		tapOnElement(NamesMobileElements.FILTERS_BUTTON);
	}
	
	@Step("Tap on Z-A filter")
	public void filterOrderZA() {
		logger.info("Selecciona ordenar por ZA");
		tapOnElement(NamesMobileElements.FILTERS_SORT_BY_ZA);
		logger.info("Presionar boton listo");
		tapOnElement(NamesMobileElements.FILTERS_BUTTON);
	}
	
	@Step("Tap on minnor price filter")
	public void filterSmallestToLargest() {
		logger.info("Selecciona ordenar por $ - $$");
		tapOnElement(NamesMobileElements.FILTERS_SORT_BY_LESSTHAN);
		logger.info("Presionar boton listo");
		tapOnElement(NamesMobileElements.FILTERS_BUTTON);
	}
	
	@Step("Tap on higher price filter")
	public void filterLargestToSmallest() {
		logger.info("Selecciona ordenar por $$ - $");
		tapOnElement(NamesMobileElements.FILTERS_SORT_BY_GREATERTHAN);
		logger.info("Presionar boton listo");
		tapOnElement(NamesMobileElements.FILTERS_BUTTON);
	}
	
	@Step("Tap on popularity filter")
	public void filterPopularity() {
		logger.info("Selecciona ordenar por Popularidad");
		tapOnElement(NamesMobileElements.FILTERS_SORT_BY_POPULARITY);
		logger.info("Presionar boton listo");
		tapOnElement(NamesMobileElements.FILTERS_BUTTON);
	}
	
	@Step("Tap on sub category filter")
	public void filterBy() {
		tapOnElement(NamesMobileElements.FILTERS_FILTER_BY);
		tapOnElement(NamesMobileElements.FILTERS_FILTER_BY_BRAND);
		tapOnElement(NamesMobileElements.FILTERS_FILTER_BY_CHECK);
		logger.info("Presionar boton listo");
		tapOnElement(NamesMobileElements.FILTERS_BUTTON);
	}
}
