package com.walmartmg.business.android;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.AppMessages;
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
		logger.info("Validando elementos");
		waitElementVisibility(NamesMobileElements.CAR_BUY_BUTTON);
	}

	public void selectContinueBuying() {
		logger.info("Continuar la compra");
		tapOnElement(NamesMobileElements.CAR_BUY_BUTTON);
	}

	public void validateCar() {
		logger.info("Validando carrito");
		if (upcs.isEmpty()) {
			validateEmptyCar();
		} else {
			boolean validCar = true;
			waitElementVisibility(NamesMobileElements.CAR_CONTAINER);
			MobileElement productContainer = findElement(NamesMobileElements.CAR_CONTAINER);
			List<MobileElement> products = findSubElements(productContainer, NamesMobileElements.CAR_ITEM);
			Iterator<MobileElement> iteratorProducts = products.iterator();
			while (iteratorProducts.hasNext()) {
				MobileElement productName = findSubElement(iteratorProducts.next(),
						NamesMobileElements.CAR_PRODUCT_NAME);
				if (!upcs.containsKey(getElementText(productName))) {
					validCar = false;
					break;
				}
			}
			assertTrue("Los productos no estan en el carrito", validCar);
		}
		cleanCar();
	}

	public Map<String, Integer> getUpcs() {
		return upcs;
	}

	public void deleteProduct() {
		logger.info("Eliminando producto");
		MobileElement productContainer = findElement(NamesMobileElements.CAR_CONTAINER);
		List<MobileElement> products = findSubElements(productContainer, NamesMobileElements.CAR_DELETE_ITEM);
		List<MobileElement> productName = findSubElements(productContainer, NamesMobileElements.CAR_PRODUCT_NAME);
		assertTrue("El producto no existe", products.size() > 0);
		assertTrue("El producto no existe", products.size() > 0);
		tapOnElement(products.get(0));
		waitElementVisibility(NamesMobileElements.CAR_DELETE_DIALOG);
		tapOnElement(NamesMobileElements.CAR_DELETE_DIALOG);
		generalBusinessTest.validatePopUpMessages(AppMessages.DELETE_PRODUCT);
		upcs.remove(getElementText(productName.get(0)));
	}

	public void cancelDeleteProduct() {
		logger.info("Cancelando eliminación");
		MobileElement productContainer = findElement(NamesMobileElements.CAR_CONTAINER);
		assertTrue("El elemento no existe", productContainer != null);
		List<MobileElement> products = findSubElements(productContainer, NamesMobileElements.CAR_DELETE_ITEM);
		tapOnElement(products.get(0));
		waitElementVisibility(NamesMobileElements.CAR_DELETE_DIALOG);
		tapOnElement(NamesMobileElements.CAR_CANCEL_BUTTON);
	}
	
	public void deleteProducts() {
		logger.info("Eliminando productos");
		while (!elementExist(NamesMobileElements.CAR_EMPTY_CAR)
				&& elementExist(NamesMobileElements.CAR_DELETE_ITEM)) {
			tapOnElement(NamesMobileElements.CAR_DELETE_ITEM);
			waitElementVisibility(NamesMobileElements.CAR_DELETE_DIALOG);
			tapOnElement(NamesMobileElements.CAR_DELETE_DIALOG);
		}
		cleanCar();
		generalBusinessTest.goBack();
	}
	
	private void cleanCar() {
		upcs.clear();
	}
}
