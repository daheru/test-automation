package com.walmartmg.business.android;

import java.util.List;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.AppMessages;
import com.walmartmg.constants.GeneralConstants;
import com.walmartmg.constants.NamesMobileElements;

import io.appium.java_client.MobileElement;

public class ProductBusinessTest extends BaseDriver {

	private GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	private CarBusinessTest car = new CarBusinessTest();
	
	private static final Logger logger = Logger.getLogger(ProductBusinessTest.class);
	
	public void selectHomeProduct() {
		logger.info("Seleccionando producto");
		waitElementVisibility(NamesMobileElements.HOME_PRODUCT_LIST);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.HOME_PRODUCT_LIST);
		List<MobileElement> products = findElements(NamesMobileElements.HOME_PRODUCT_CONTAINER);
		tapOnElement(products.get(0));
	}
	
	public void selectProduct() {
		logger.info("Seleccionando producto");
		waitElementVisibility(NamesMobileElements.SEARCH_RESULT_LIST);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.SEARCH_RESULT_LIST);
		List<MobileElement> products = findElements(NamesMobileElements.SEARCH_RESULT_ELEMENT);
		tapOnElement(products.get(0));
	}
	
	public void validateProduct() {
		logger.info("Validando producto");
		waitElementVisibility(NamesMobileElements.PRODUCT_CONTAINER);
		waitElementVisibility(NamesMobileElements.PRODUCT_TITLE);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_IMAGE);
		waitElementVisibility(NamesMobileElements.PRODUCT_IMAGE);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_DESC);
		waitElementVisibility(NamesMobileElements.PRODUCT_PRICE);
		waitElementVisibility(NamesMobileElements.PRODUCT_SELL_BY);
		waitElementVisibility(NamesMobileElements.PRODUCT_UPC);
		waitElementVisibility(NamesMobileElements.PRODUCT_ADD);
		waitElementVisibility(NamesMobileElements.PRODUCT_PROMO);
		waitElementVisibility(NamesMobileElements.PRODUCT_DESC);
	}
	
	public void addProduct() {
		logger.info("Agregando producto");
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_ADD);
		waitElementVisibility(NamesMobileElements.PRODUCT_UPC);
		if (elementExist(NamesMobileElements.PRODUCT_PLUS_BUTTON)) {
			tapOnElement(NamesMobileElements.PRODUCT_PLUS_BUTTON);
			generalBusinessTest.validatePopUpMessages(AppMessages.UPDATE_PRODUCT);
		} else {
			tapOnElement(NamesMobileElements.PRODUCT_ADD);
			generalBusinessTest.validatePopUpMessages(AppMessages.ADD_PRODUCT);
		}
		String mobileUpc = getElementText(NamesMobileElements.PRODUCT_UPC);
		increaseProduct(mobileUpc);
	}
	
	public void removeProduct() {
		logger.info("Eliminando producto");
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_ADD);
		waitElementVisibility(NamesMobileElements.PRODUCT_UPC);
		if (elementExist(NamesMobileElements.PRODUCT_MINUS_BUTTON)) {
			String quantity = getElementText(findElement(NamesMobileElements.PRODUCT_QUANTITY)).replaceAll("[^\\d]", "");
			String errorMessage;
			if( GeneralConstants.UNO.equals(quantity) ) {
				errorMessage = AppMessages.DELETE_PRODUCT;
			} else {
				errorMessage = AppMessages.UPDATE_PRODUCT;
			}
			tapOnElement(NamesMobileElements.PRODUCT_MINUS_BUTTON);
			generalBusinessTest.validatePopUpMessages(errorMessage);
			car.getUpcs().remove(getElementText(NamesMobileElements.PRODUCT_UPC));
		}
	}
	
	private void increaseProduct(String mobileUpc) {
		if (car.getUpcs().get(mobileUpc) == null) {
			car.getUpcs().put(mobileUpc, 1);
		} else {
			car.getUpcs().put(mobileUpc, car.getUpcs().get(mobileUpc) + 1);
		}
	}
	
}
