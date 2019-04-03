package com.bodega.business.android;

import java.util.List;

import org.apache.log4j.Logger;

import com.bodega.constants.AppMessages;
import com.bodega.constants.GeneralConstants;
import com.bodega.constants.NamesMobileElements;
import com.bodega.util.BaseDriver;

import io.appium.java_client.MobileElement;

public class SpecialProductsBusiness extends BaseDriver {

	private static final Logger logger = Logger.getLogger(SpecialProductsBusiness.class);
	private GeneralBusinessTest general = new GeneralBusinessTest();
	private LoginBusinessTest login = new LoginBusinessTest();
	private SearchBusinessTest search = new SearchBusinessTest();
	private String upc = "";

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

	public void searchProduct(String product) {
		search.searchProduct(product);
	}

	public void validateSearch() {
		waitElementVisibility(NamesMobileElements.SEARCH_PRODUCT_LIST);
	}

	public void goBack() {
		general.goBack();
	}

	public void selectProduct() {
		logger.info("Seleccionando producto");
		waitElementVisibility(NamesMobileElements.SEARCH_PRODUCT_LIST);
		List<MobileElement> products = findElements(NamesMobileElements.SEARCH_PRODUCT_NAME);
		tapOnElement(products.get(0));
		upc = "";
	}

	public void addProduct() {
		logger.info("Agregando producto");
		waitElementVisibility(NamesMobileElements.PRODUCT_DETAIL_CONT);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_ADD_BUTTON);
		if (elementExist(NamesMobileElements.PRODUCT_PLUS_BUTTON)) {
			tapOnElement(NamesMobileElements.PRODUCT_PLUS_BUTTON);
			general.validatePopUpMessages(AppMessages.CAR_UPDATE);
		} else {
			tapOnElement(NamesMobileElements.PRODUCT_ADD_BUTTON);
			general.validatePopUpMessages(AppMessages.ADD_PRODUCT);
		}
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_DETAIL_UPC);
		upc = getElementText(findElement(NamesMobileElements.PRODUCT_DETAIL_UPC));
	}

	public void validateSpecialProduct() {
		logger.info("Validando mensaje");
		waitElementVisibility(NamesMobileElements.PRODUCT_DETAIL_CONT);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_ADD_BUTTON);
		tapOnElement(NamesMobileElements.PRODUCT_ADD_BUTTON);
		general.validatePopUpMessages(AppMessages.SPECIAL_PRODUCT_VALIDATION);
	}

	public void validateCar() {
		logger.info("Validando el carrito");
		tapOnElement(NamesMobileElements.CAR_BUTTON);
		waitElementVisibility(NamesMobileElements.CAR_PRODUCT_LIST);
		List<MobileElement> products = findElements(NamesMobileElements.CAR_PRODUCT_ITEM);
		boolean productExist = false;
		for (MobileElement product : products) {
			tapOnElement(product);
			waitElementVisibility(NamesMobileElements.PRODUCT_DETAIL_CONT);
			scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_DETAIL_UPC);
			if (getElementText(NamesMobileElements.PRODUCT_DETAIL_UPC).equals(upc)) {
				productExist = true;
				break;
			}
			goBack();
		}
		assertTrue("El producto no se agregó al carrito", productExist);
		goBack();
		goBack();
		goBack();
	}

	public void deleteProducts() {
		logger.info("Eliminando productos");
		while (!elementExist(NamesMobileElements.CAR_EMPTY_CAR) && elementExist(NamesMobileElements.CAR_PRODUCT_DELETE)) {
			tapOnElement(NamesMobileElements.CAR_PRODUCT_DELETE);
			waitElementVisibility(NamesMobileElements.CAR_DIALOG_DELETE);
			tapOnElement(NamesMobileElements.CAR_DIALOG_DELETE);
		}
		goBack();
	}

}
