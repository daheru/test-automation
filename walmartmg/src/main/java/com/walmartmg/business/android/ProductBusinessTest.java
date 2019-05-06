package com.walmartmg.business.android;

import java.util.List;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.AppMessages;
import com.walmartmg.constants.GeneralConstants;
import com.walmartmg.constants.NamesMobileElements;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class ProductBusinessTest extends BaseDriver {

	private GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	private CarBusinessTest car = new CarBusinessTest();

	private static final Logger logger = Logger.getLogger(ProductBusinessTest.class);

	@Step("Tap on product")
	public void selectHomeProduct() {
		logger.info("Seleccionando producto");
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.HOME_PRODUCT_LIST);
		waitElementVisibility(NamesMobileElements.HOME_PRODUCT_LIST);
		List<MobileElement> products = findElements(NamesMobileElements.HOME_PRODUCT_CONTAINER);
		tapOnElement(products.get(0));
	}

	@Step("Tap on product")
	public void selectProduct() {
		logger.info("Seleccionando producto");
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.SEARCH_RESULT_LIST);
		waitElementVisibility(NamesMobileElements.SEARCH_RESULT_LIST);
		List<MobileElement> products = findElements(NamesMobileElements.SEARCH_RESULT_ELEMENT);
		tapOnElement(products.get(0));
	}

	@Step("Validate product")
	public void validateProduct() {
		logger.info("Validando producto");
		waitElementVisibility(NamesMobileElements.PRODUCT_DETAIL_CONT);
		waitElementVisibility(NamesMobileElements.PRODUCT_DETAIL_NAME);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_DETAIL_ICON);
		waitElementVisibility(NamesMobileElements.PRODUCT_DETAIL_ICON);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_DETAIL_DESC);
		waitElementVisibility(NamesMobileElements.PRODUCT_DETAIL_PRICE);
		waitElementVisibility(NamesMobileElements.PRODUCT_DETAIL_SELLER);
		waitElementVisibility(NamesMobileElements.PRODUCT_DETAIL_UPC);
		waitElementVisibility(NamesMobileElements.PRODUCT_ADD_BUTTON);
		waitElementVisibility(NamesMobileElements.PRODUCT_DETAIL_MSI);
		waitElementVisibility(NamesMobileElements.PRODUCT_DETAIL_DESC);
	}
	
	@Step("Add product")
	public void addProduct() {
		logger.info("Agregando producto");
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_ADD_BUTTON);
		waitElementVisibility(NamesMobileElements.PRODUCT_DETAIL_UPC);
		if (elementExist(NamesMobileElements.PRODUCT_PLUS_BUTTON)) {
			tapOnElement(NamesMobileElements.PRODUCT_PLUS_BUTTON);
			generalBusinessTest.validatePopUpMessages(AppMessages.UPDATE_PRODUCT);
		} else {
			tapOnElement(NamesMobileElements.PRODUCT_ADD_BUTTON);
			generalBusinessTest.validatePopUpMessages(AppMessages.ADD_PRODUCT);
		}
		scrollUntilShowElement(GeneralConstants.SCROLL_DOWN, NamesMobileElements.PRODUCT_DETAIL_NAME_CONT);
		MobileElement parentElement = findElement(NamesMobileElements.PRODUCT_DETAIL_NAME_CONT);
		String productName = getElementText(findSubElement(parentElement, NamesMobileElements.PRODUCT_DETAIL_NAME));
		increaseProduct(productName);
	}

	@Step("Delete product")
	public void removeProduct() {
		logger.info("Eliminando producto");
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_ADD_BUTTON);
		waitElementVisibility(NamesMobileElements.PRODUCT_DETAIL_UPC);
		if (elementExist(NamesMobileElements.PRODUCT_MINUS_BUTTON)) {
			String quantity = getElementText(findElement(NamesMobileElements.PRODUCT_QUANTITY)).replaceAll("[^\\d]",
					"");
			String errorMessage;
			if (GeneralConstants.UNO.equals(quantity)) {
				errorMessage = AppMessages.DELETE_PRODUCT;
			} else {
				errorMessage = AppMessages.UPDATE_PRODUCT;
			}
			scrollUntilShowElement(GeneralConstants.SCROLL_DOWN, NamesMobileElements.PRODUCT_DETAIL_NAME_CONT);
			tapOnElement(NamesMobileElements.PRODUCT_MINUS_BUTTON);
			generalBusinessTest.validatePopUpMessages(errorMessage);
			MobileElement parentElement = findElement(NamesMobileElements.PRODUCT_DETAIL_NAME_CONT);
			String productName = getElementText(findSubElement(parentElement, NamesMobileElements.PRODUCT_DETAIL_NAME));
			if( car.getUpcs().get(productName) == 1 ) {
				car.getUpcs().remove(productName);
			} else {
				car.getUpcs().replace(productName, car.getUpcs().get(productName) - 1);
			}
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
