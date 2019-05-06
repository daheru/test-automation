package com.walmartmg.business.android;

import java.util.List;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.NamesMobileElements;

import io.appium.java_client.MobileElement;

public class SearchBusinessTest extends BaseDriver {
	
	private static final Logger logger = Logger.getLogger(SearchBusinessTest.class);
	
	public void searchProduct(String product) {
		logger.info("Buscando producto");
		waitElementVisibility(NamesMobileElements.HOME_SEARCH_BUTTON);
		tapOnElement(NamesMobileElements.HOME_SEARCH_BUTTON);
		fillElement(NamesMobileElements.HOME_SEARCH_FIELD, product + "\\n");
	}

	public void validateSearch() {
		logger.info("Validando busqueda");
		waitElementVisibility(NamesMobileElements.SEARCH_RESULT_LIST);
		MobileElement productContainter = findElement(NamesMobileElements.SEARCH_RESULT_LIST);
		List<MobileElement> products = findSubElements(productContainter, NamesMobileElements.SEARCH_RESULT_ELEMENT);
		assertTrue("El elemento no existe", products.size() > 0);
	}
	
	public void validateEmptySearch() {
		logger.info("Validando busqueda vacía");
		waitElementVisibility(NamesMobileElements.SEARCH_WITHOUT_RESULT);
		waitElementVisibility(NamesMobileElements.SEARCH_WITHOUT_RESULT_HEADER);
		waitElementVisibility(NamesMobileElements.SEARCH_WITHOUT_RESULT_ICON);
		waitElementVisibility(NamesMobileElements.SEARCH_WITHOUT_RESULT_BOTTOM);
		waitElementVisibility(NamesMobileElements.SEARCH_WITHOUT_TAKE_ME);
	}

}
