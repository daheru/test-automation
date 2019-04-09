package com.bodega.business.android;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.bodega.base.BaseDriver;
import com.bodega.constants.AppMessages;
import com.bodega.constants.GeneralConstants;
import com.bodega.constants.NamesMobileElements;

import io.appium.java_client.MobileElement;

public class CarBusinessTest extends BaseDriver {
	
	private static final Logger logger = Logger.getLogger(CarBusinessTest.class);
	private GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	
	private static Map<String, Integer> upcs = new HashMap<String, Integer>();
	
	public void selectCar() {
		logger.info("Seleccionando carrito");
		waitElementVisibility(NamesMobileElements.CAR_BUTTON);
		tapOnElement(NamesMobileElements.CAR_BUTTON);
	}
	
	public void validateEmptyCar() {
		logger.info("Validando carrito vacío");
		waitElementVisibility(NamesMobileElements.CAR_EMPTY_CAR);
		waitElementVisibility(NamesMobileElements.CAR_EMPTY_ICON);
		waitElementVisibility(NamesMobileElements.CAR_EMPTY_BUTTON);
	}
	
	public void validateStartingBuy() {
		logger.info("Validando empezar a comprar");
		waitElementVisibility(NamesMobileElements.CAR_EMPTY_CAR);
		tapOnElement(NamesMobileElements.CAR_EMPTY_BUTTON);
		upcs = new HashMap<String, Integer>();
	}
	
	public void validateContinue() {
		logger.info("Continuar la compra");
		waitElementVisibility(NamesMobileElements.CAR_BUY_BUTTON);
	}
	
	public void selectContinueBuying() {
		logger.info("Continuar la compra");
		tapOnElement(NamesMobileElements.CAR_BUY_BUTTON);
	}
	
	public void validateCar() {
		selectCar();
		logger.info("Validando carrito");
		if (upcs.isEmpty()) {
			validateEmptyCar();
		} else {
			waitElementVisibility(NamesMobileElements.CAR_PRODUCT_LIST);
			MobileElement productContainer = findElement(NamesMobileElements.CAR_PRODUCT_LIST);
			List<MobileElement> products = findSubElements(productContainer, NamesMobileElements.CAR_PRODUCT_ITEM);
			Iterator<MobileElement> iteratorProducts = products.iterator();
			while (iteratorProducts.hasNext()) {
				tapOnElement(iteratorProducts.next());
				scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.PRODUCT_DETAIL_UPC);
				String productInCar = getElementText(NamesMobileElements.PRODUCT_DETAIL_UPC);
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
		MobileElement productContainer = findElement(NamesMobileElements.CAR_PRODUCT_LIST);
		List<MobileElement> products = findSubElements(productContainer, NamesMobileElements.CAR_PRODUCT_DELETE);
		products.get(0).click();
		waitElementVisibility(NamesMobileElements.CAR_DELETE_DIALOG);
		tapOnElement(NamesMobileElements.CAR_DIALOG_CONFIRM);
		generalBusinessTest.validatePopUpMessages(AppMessages.DELETE_PRODUCT);
		upcs.clear();
	}
	
	public void cancelDeleteProduct() {
		logger.info("Canelando eliminación");
		MobileElement productContainer = findElement(NamesMobileElements.CAR_PRODUCT_LIST);
		List<MobileElement> products = findSubElements(productContainer, NamesMobileElements.CAR_PRODUCT_DELETE);
		products.get(0).click();
		waitElementVisibility(NamesMobileElements.CAR_DELETE_DIALOG);
		tapOnElement(NamesMobileElements.CAR_DIALOG_CANCEL);
	}
}
