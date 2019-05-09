package com.bodega.business.android;

import java.util.List;

import org.apache.log4j.Logger;

import com.bodega.base.BaseDriver;
import com.bodega.constants.AppMessages;
import com.bodega.constants.GeneralConstants;
import com.bodega.constants.NamesMobileElements;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class ProductBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(ProductBusinessTest.class);
	private GeneralBusinessTest general = new GeneralBusinessTest();
	private CarBusinessTest car = new CarBusinessTest();

	@Step("Tap on product")
	public void selectProduct() {
		logger.info("Seleccionando producto");
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.SEARCH_PRODUCT_LIST);
		waitElementVisibility(NamesMobileElements.SEARCH_PRODUCT_LIST);
		List<MobileElement> products = findElements(NamesMobileElements.SEARCH_PRODUCT_NAME);
		tapOnElement(products.get(general.randomNumber(0, products.size() - 1)));
	}

	@Step("Add product")
	public void addProduct() {
		logger.info("Agregando producto");
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_ADD_BUTTON);
		waitElementVisibility(NamesMobileElements.PRODUCT_DETAIL_UPC);
		if (elementExist(NamesMobileElements.PRODUCT_PLUS_BUTTON)) {
			tapOnElement(NamesMobileElements.PRODUCT_PLUS_BUTTON);
			general.validatePopUpMessages(AppMessages.CAR_UPDATE);
		} else {
			tapOnElement(NamesMobileElements.PRODUCT_ADD_BUTTON);
			general.validatePopUpMessages(AppMessages.ADD_PRODUCT);
		}
		scrollUntilShowElement(GeneralConstants.SCROLL_DOWN, NamesMobileElements.PRODUCT_DETAIL_NAME);
		MobileElement parentElement = findElement(NamesMobileElements.PRODUCT_DETAIL_CONT);
		String productName = getElementText(findSubElement(parentElement, NamesMobileElements.PRODUCT_DETAIL_NAME));
		increaseProduct(productName);
	}

	@Step("Delete product")
	public void removeProduct() {
		logger.info("Eliminando producto");
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_ADD_BUTTON);
		waitElementVisibility(NamesMobileElements.PRODUCT_DETAIL_UPC);
		if (elementExist(NamesMobileElements.PRODUCT_MINUS_BUTTON)) {
			String quantity = getElementText(findElement(NamesMobileElements.PRODUCT_QUANTITY)).replaceAll("[^\\d]", "");
			String errorMessage;
			if( GeneralConstants.UNO.equals(quantity) ) {
				errorMessage = AppMessages.DELETE_PRODUCT;
			} else {
				errorMessage = AppMessages.UPDATE_PRODUCT;
			}
			tapOnElement(NamesMobileElements.PRODUCT_MINUS_BUTTON);
			general.validatePopUpMessages(errorMessage);
			waitElementVisibility(NamesMobileElements.PRODUCT_DETAIL_CONT);
			MobileElement parentElement = findElement(NamesMobileElements.PRODUCT_DETAIL_CONT);
			String productName = getElementText(findSubElement(parentElement, NamesMobileElements.PRODUCT_DETAIL_NAME));
			if( car.getUpcs().get(productName) == 1 ) {
				car.getUpcs().remove(productName);
			} else {
				car.getUpcs().replace(productName, car.getUpcs().get(productName) - 1);
			}
		}
	}
	
	@Step("Validate special product")
	public void validateSpecialProduct() {
		logger.info("Validando mensaje");
		waitElementVisibility(NamesMobileElements.PRODUCT_DETAIL_CONT);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_ADD_BUTTON);
		tapOnElement(NamesMobileElements.PRODUCT_ADD_BUTTON);
		general.validatePopUpMessages(AppMessages.SPECIAL_PRODUCT_VALIDATION);
	}
	
	public void increaseProduct(String productName) {
		if (car.getUpcs().get(productName) == null) {
			car.getUpcs().put(productName, 1);
		} else {
			car.getUpcs().put(productName, car.getUpcs().get(productName) + 1);
		}
	}

}
