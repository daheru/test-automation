package com.walmartmg.business.android;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.AppMessages;
import com.walmartmg.constants.GeneralConstants;
import com.walmartmg.constants.NamesMobileElements;

import io.appium.java_client.MobileElement;

public class CarBusinessTest extends BaseDriver {
	
	private static final Logger logger = Logger.getLogger(CarBusinessTest.class);
	private GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	
	private static Map<String, Integer> upcs = new HashMap<String, Integer>();
	
	public void selectCar() {
		logger.info("Seleccionando carrito");
		waitElementVisibility(NamesMobileElements.HOME_CAR);
		tapOnElement(NamesMobileElements.HOME_CAR);
	}
	
	public void validateEmptyCar() {
		logger.info("Validando carrito vacío");
		waitElementVisibility(NamesMobileElements.CAR_EMPTY_CAR);
		waitElementVisibility(NamesMobileElements.CAR_EMPTY_CAR_ICON);
		waitElementVisibility(NamesMobileElements.CAR_EMPTY_CAR_BUTTON);
	}
	
	public void validateStartingBuy() {
		logger.info("Validando empezar a comprar");
		waitElementVisibility(NamesMobileElements.CAR_EMPTY_CAR);
		tapOnElement(NamesMobileElements.CAR_EMPTY_CAR_BUTTON);
		upcs = new HashMap<String, Integer>();
	}
	
	public void validateContinue() {
		logger.info("Continuar la compra");
		waitElementVisibility(NamesMobileElements.CAR_BUY_BUTTON);
		tapOnElement(NamesMobileElements.CAR_BUY_BUTTON);
		waitElementVisibility(NamesMobileElements.LOGIN_BUTTON);
	}
	
	public void validateCar() {
		selectCar();
		logger.info("Validando carrito");
		if (upcs.isEmpty()) {
			validateEmptyCar();
		} else {
			waitElementVisibility(NamesMobileElements.CAR_CONTAINER);
			MobileElement productContainer = findElement(NamesMobileElements.CAR_CONTAINER);
			List<MobileElement> products = findSubElements(productContainer, NamesMobileElements.CAR_ITEM);
			Iterator<MobileElement> iteratorProducts = products.iterator();
			while (iteratorProducts.hasNext()) {
				tapOnElement(iteratorProducts.next());
				scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_UPC);
				String productInCar = getElementText(NamesMobileElements.PRODUCT_UPC);
				if (upcs.containsKey(productInCar)) {
					upcs.remove(productInCar);
				}
				generalBusinessTest.goBack();
			}
			assertTrue("Los productos no estan en el carrito", upcs.isEmpty());
		}
		upcs = new HashMap<String, Integer>();
	}
	
	public Map<String, Integer> getUpcs(){
		return upcs;
	}
	
	public void deleteProduct() {
		logger.info("Eliminando producto");
		MobileElement productContainer = findElement(NamesMobileElements.CAR_CONTAINER);
		List<MobileElement> products = findSubElements(productContainer, NamesMobileElements.CAR_DELETE_ITEM);
		products.get(0).click();
		waitElementVisibility(NamesMobileElements.CAR_DELETE_DIALOG);
		tapOnElement(NamesMobileElements.CAR_CONFIRM_BUTTON);
		generalBusinessTest.validatePopUpMessages(AppMessages.DELETE_PRODUCT);
		upcs.clear();
	}
	
	public void cancelDeleteProduct() {
		logger.info("Canelando eliminación");
		MobileElement productContainer = findElement(NamesMobileElements.CAR_CONTAINER);
		List<MobileElement> products = findSubElements(productContainer, NamesMobileElements.CAR_DELETE_ITEM);
		products.get(0).click();
		waitElementVisibility(NamesMobileElements.CAR_DELETE_DIALOG);
		tapOnElement(NamesMobileElements.CAR_CANCEL_BUTTON);
	}
}
