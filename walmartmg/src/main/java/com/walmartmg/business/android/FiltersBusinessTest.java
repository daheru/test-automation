package com.walmartmg.business.android;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.NavigationBarEnum;

public class FiltersBusinessTest extends BaseDriver {
	
	private static final Logger logger = Logger.getLogger( InvoiceBusinessTest.class );
	private GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	private DepartmentsBusinessTest departments = new DepartmentsBusinessTest();
	
	
	public void selectDepartmentOption() {
		generalBusinessTest.selectNavigationOption(NavigationBarEnum.DEPARTMENTS.getNavigation());
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
	
	//Validate Screen Filter
	public void validateScreenFilter() {
		logger.info("Selecciona link Filtar");
		tapOnElement(NamesMobileElements.FILTERS_LINK);
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
	
	public void FilterOrderAZ() {
		logger.info("Selecciona link Filtar");
		tapOnElement(NamesMobileElements.FILTERS_LINK);
		logger.info("Selecciona ordenar por AZ");
		tapOnElement(NamesMobileElements.FILTERS_SORT_BY_AZ);
		logger.info("Presionar boton listo");
		tapOnElement(NamesMobileElements.FILTERS_BUTTON);
	}
	
	public void FilterOrderZA() {
		logger.info("Selecciona link Filtar");
		tapOnElement(NamesMobileElements.FILTERS_LINK);
		logger.info("Selecciona ordenar por ZA");
		tapOnElement(NamesMobileElements.FILTERS_SORT_BY_ZA);
		logger.info("Presionar boton listo");
		tapOnElement(NamesMobileElements.FILTERS_BUTTON);
	}
	
	public void FilterSmallestToLargest() {
		logger.info("Selecciona link Filtar");
		tapOnElement(NamesMobileElements.FILTERS_LINK);
		logger.info("Selecciona ordenar por $ - $$");
		tapOnElement(NamesMobileElements.FILTERS_SORT_BY_LESSTHAN);
		logger.info("Presionar boton listo");
		tapOnElement(NamesMobileElements.FILTERS_BUTTON);
	}
	
	public void FilterLargestToSmallest() {
		logger.info("Selecciona link Filtar");
		tapOnElement(NamesMobileElements.FILTERS_LINK);
		logger.info("Selecciona ordenar por $$ - $");
		tapOnElement(NamesMobileElements.FILTERS_SORT_BY_GREATERTHAN);
		logger.info("Presionar boton listo");
		tapOnElement(NamesMobileElements.FILTERS_BUTTON);
	}
	
	public void FilterPopularity() {
		logger.info("Selecciona link Filtar");
		tapOnElement(NamesMobileElements.FILTERS_LINK);
		logger.info("Selecciona ordenar por Popularidad");
		tapOnElement(NamesMobileElements.FILTERS_SORT_BY_POPULARITY);
		logger.info("Presionar boton listo");
		tapOnElement(NamesMobileElements.FILTERS_BUTTON);
	}
	
	public void FilterBy() {
		logger.info("Selecciona link Filtar");
		tapOnElement(NamesMobileElements.FILTERS_LINK);
		tapOnElement(NamesMobileElements.FILTERS_FILTER_BY);
		tapOnElement(NamesMobileElements.FILTERS_FILTER_BY_BRAND);
		tapOnElement(NamesMobileElements.FILTERS_FILTER_BY_CHECK);
		logger.info("Presionar boton listo");
		tapOnElement(NamesMobileElements.FILTERS_BUTTON);
	}
}
