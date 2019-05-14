package com.bodega.business.android;

import java.util.List;

import org.apache.log4j.Logger;

import com.bodega.base.BaseDriver;
import com.bodega.constants.ConfigConstants;
import com.bodega.constants.GeneralConstants;
import com.bodega.constants.NamesMobileElements;
import com.bodega.enums.NavigationBarEnum;
import com.bodega.enums.ProfileMenuEnum;
import com.bodega.vo.AddressVO;

import io.appium.java_client.MobileElement;

public class CheckoutBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(CheckoutBusinessTest.class);
	private GeneralBusinessTest general = new GeneralBusinessTest();
	private LoginBusinessTest login = new LoginBusinessTest();
	private SearchBusinessTest search = new SearchBusinessTest();
	private ProductBusinessTest product = new ProductBusinessTest();
	private CarBusinessTest car = new CarBusinessTest();
	private MenuBusinessTest menu = new MenuBusinessTest();

	private static String storeName = "";
	private static String storeAddress = "";
	private static String storeSchedule = "";
	private static String paymentMethod = "";

	public void selectProfile() {
		general.selectProfile();
	}

	public void selectNavigationOption(NavigationBarEnum navigationBarEnum) {
		general.selectNavigationOption(navigationBarEnum);
	}

	public void selectMenu(ProfileMenuEnum profileMenuEnum) {
		general.selectMenuOption(profileMenuEnum);
	}

	public void login(String email, String password) {
		login.login(email, password);
	}

	public void searchProduct(String product) {
		search.searchProduct(product);
	}

	public void tapOnProduct() {
		product.selectProduct();
	}

	public void addProduct() {
		product.addProduct();
	}

	public void goBack() {
		general.goBack();
	}

	public void tapOnCar() {
		car.selectCar();
	}

	public void validateCar() {
		car.validateCar();
	}

	public void tapOnBuy() {
		car.selectContinueBuying();
	}

	public void deleteProducts() {
		car.deleteProducts();
	}
	
	public void tapOnShippingAddress() {
		logger.info("Seleccionando direccion de entrega");
		waitElementVisibility(NamesMobileElements.CHECKOUT_ADDRESS_LIST);
		waitElementVisibility(NamesMobileElements.CHECKOUT_ADDRESS_TITLE);
		List<MobileElement> addressList = findSubElements(NamesMobileElements.CHECKOUT_ADDRESS_LIST,
				NamesMobileElements.CHECKOUT_ADDRESS_NAME);
		assertTrue("No hay direcciones", addressList.size() > 0);
		tapOnElement(addressList.get(general.randomNumber(0, addressList.size() - 1)));
	}

	public void validateOrderChangePage() {
		logger.info("Validando cambio de orden");
		waitElementVisibility(NamesMobileElements.CHECKOUT_OUT_STOCK_CONT);
		waitElementVisibility(NamesMobileElements.CHECKOUT_OUT_STOCK_IN_CAR_CONT);
		if (elementExist(NamesMobileElements.CHECKOUT_OUT_STOCK_IN_CAR_LIST)) {
			List<MobileElement> inProducts = findSubElements(NamesMobileElements.CHECKOUT_OUT_STOCK_IN_CAR_LIST,
					NamesMobileElements.CHECKOUT_SUMMARY_ITEM);
			assertTrue("No hay elementos en la lista", inProducts.size() > 0);
			assertTrue("El elemento no existe",
					findSubElement(inProducts.get(0), NamesMobileElements.CHECKOUT_SUMMARY_ITEM_IMAGE) != null);
			assertTrue("El elemento no existe",
					findSubElement(inProducts.get(0), NamesMobileElements.CHECKOUT_SUMMARY_ITEM_DESC) != null);
			assertTrue("El elemento no existe",
					findSubElement(inProducts.get(0), NamesMobileElements.CHECKOUT_SUMMARY_ITEM_PRICE) != null);
			assertTrue("El elemento no existe",
					findSubElement(inProducts.get(0), NamesMobileElements.CHECKOUT_SUMMARY_ITEM_QUAN) != null);
		}
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_OUT_STOCK_OUT_CAR_CONT);
		List<MobileElement> outProducts = findSubElements(NamesMobileElements.CHECKOUT_OUT_STOCK_OUT_CAR_LIST,
				NamesMobileElements.CHECKOUT_SUMMARY_ITEM);
		assertTrue("El elemento no existe",
				findSubElement(outProducts.get(0), NamesMobileElements.CHECKOUT_SUMMARY_ITEM_IMAGE) != null);
		assertTrue("El elemento no existe",
				findSubElement(outProducts.get(0), NamesMobileElements.CHECKOUT_SUMMARY_ITEM_DESC) != null);
		assertEquals(GeneralConstants.OUTSTOCK,
				getElementText(findSubElement(outProducts.get(0), NamesMobileElements.CHECKOUT_SUMMARY_ITEM_OUTSTOCK)));

		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_OUT_STOCK_GOHOME_BUTTON);
		validateSummatyPrice(NamesMobileElements.CHECKOUT_OUT_STOCK_SUMMARY_CONT);
	}

	public void tapOnSelectStore() {
		logger.info("Tap en recoger en tienda");
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_PICKUPSTORE_BUTTON);
		tapOnElement(NamesMobileElements.CHECKOUT_PICKUPSTORE_BUTTON);
	}

	public void searchStore(String store) {
		logger.info("Buscando tienda");
		waitElementVisibility(NamesMobileElements.CHECKOUT_STORE_CONT);
		waitElementVisibility(NamesMobileElements.CHECKOUT_STORE_TITLE);
		waitElementVisibility(NamesMobileElements.CHECKOUT_STORE_SEARCH_CONT);
		waitElementVisibility(NamesMobileElements.CHECKOUT_STORE_SEARCH);
		tapOnElement(NamesMobileElements.CHECKOUT_STORE_SEARCH);
		fillElement(NamesMobileElements.CHECKOUT_STORE_SEARCH, store);
		hideKeyboard();
	}

	public void tapOnAddress() {
		logger.info("Seleccionando tienda");
		waitElementVisibility(NamesMobileElements.CHECKOUT_STORE_LIST);
		List<MobileElement> addressList = findSubElements(NamesMobileElements.CHECKOUT_STORE_LIST,
				NamesMobileElements.CHECKOUT_STORE_ITEM_CONT);
		assertTrue("No se encontraron direcciones", addressList.size() > 0);
		storeName = getElementText(findSubElement(addressList.get(0), NamesMobileElements.CHECKOUT_STORE_ITEM_NAME));
		storeAddress = getElementText(
				findSubElement(addressList.get(0), NamesMobileElements.CHECKOUT_STORE_ITEM_ADDRESS));
		storeSchedule = getElementText(
				findSubElement(addressList.get(0), NamesMobileElements.CHECKOUT_STORE_ITEM_TIME));
		tapOnElement(addressList.get(0));
	}

	public void validateShippingStore() {
		logger.info("Validando tienda de recoleccion");
		waitElementVisibility(NamesMobileElements.CHECKOUT_ADDRESS_PICKUP_NAME);
		waitElementVisibility(NamesMobileElements.CHECKOUT_ADDRESS_PICKUP_CONT);
		String pickupStoreName = getElementText(findElement(NamesMobileElements.CHECKOUT_STORE_ITEM_NAME));
		String pickupStoreAddress = getElementText(findElement(NamesMobileElements.CHECKOUT_STORE_ITEM_ADDRESS));
		String pickupStoreTime = getElementText(findElement(NamesMobileElements.CHECKOUT_STORE_ITEM_TIME));
		assertEquals(pickupStoreName, storeName);
		assertEquals(pickupStoreAddress, storeAddress);
		assertEquals(pickupStoreTime, storeSchedule);
	}

	public void fillWhoReceive(String name, String lastName, String phone) {
		logger.info("Ingresando datos de quien recibe");
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_ADDRESS_PICKUP_PHONE_CONT);
		fillElement(NamesMobileElements.CHECKOUT_ADDRESS_BUYER_NAME, name);
		fillElement(NamesMobileElements.CHECKOUT_ADDRESS_BUYER_LASTNAME, lastName);
		fillElement(NamesMobileElements.CHECKOUT_ADDRESS_PICKUP_PHONE_CONT, phone);
	}

	public void tapOnPaymentMethod() {
		logger.info("Tap en metodo de pago");
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_ADDRESS_PICKUP_SAVE);
		tapOnElement(NamesMobileElements.CHECKOUT_ADDRESS_PICKUP_SAVE);
	}

	public void selectRandomPaymentMethod() {
		logger.info("Seleccionando metodo de pago random");
		int paymentMethod = general.randomNumber(1, 3);
		switch (paymentMethod) {
		case 1:
			storePayment();
			break;
		case 2:
			selectCreditCardPayment();
			break;
		case 3:
			newCreditCardPayment();
			addCreditCard("5555555555554444", "Benito Juarez", "0130", "123");
			isSameAddress(true, true);
			tapOnGoToPreOrder();
			break;
		}
	}

	public void storePayment() {
		logger.info("Tap en pago en tienda");
		waitEvent();
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_CARD_PAYMENT_STORE);
		tapOnElement(NamesMobileElements.CHECKOUT_CARD_PAYMENT_STORE);
		paymentMethod = "Pago en tienda";
	}

	public void newCreditCardPayment() {
		logger.info("Tap en registrar nueve tarjeta");
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_CARD_PAYMENT_ADD_CARD);
		tapOnElement(NamesMobileElements.CHECKOUT_CARD_PAYMENT_ADD_CARD);
		paymentMethod = "Registrar una tarjeta nueva";
	}

	public void selectCreditCardPayment() {
		logger.info("Tap en tarjeta de credito");
		if (elementExist(NamesMobileElements.CHECKOUT_CARD_PAYMENT_CARDS_CONT)) {
			waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_PAYMENT_CARDS_CONT);
			waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_PAYMENT_CARDS_ITEM);
			waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_PAYMENT_CARDS_ITEM_NAME);
			waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_PAYMENT_CARDS_ITEM_DELETE);
			// waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_PAYMENT_CARDS_ITEM_MAIN);
			waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_PAYMENT_CARDS_ITEM_OWNER);
			waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_PAYMENT_CARDS_ITEM_DATE);
			List<MobileElement> cards = findSubElements(NamesMobileElements.CHECKOUT_CARD_PAYMENT_CARDS_CONT,
					NamesMobileElements.CHECKOUT_CARD_PAYMENT_CARDS_ITEM);
			paymentMethod = getElementText(NamesMobileElements.CHECKOUT_CARD_PAYMENT_CARDS_ITEM_NAME)
					+ getElementText(NamesMobileElements.CHECKOUT_CARD_PAYMENT_CARDS_ITEM_OWNER);
			tapOnElement(cards.get(general.randomNumber(0, cards.size() - 1)));
		} else {
			newCreditCardPayment();
			addCreditCard("5555555555554444", "Benito Juarez", "0130", "123");
			isSameAddress(true, true);
			tapOnGoToOrder();
		}
	}

	public void validatePreOrderPage() {
		logger.info("Validando pagina de Pre-Orden");
		float productsTotal = 0;
		waitElementVisibility(NamesMobileElements.CHECKOUT_SUMMARY_CONT);
		waitElementVisibility(NamesMobileElements.CHECKOUT_SUMMARY_TITLE);
		waitElementVisibility(NamesMobileElements.CHECKOUT_SUMMARY_ITEM_LIST);
		List<MobileElement> products = findSubElements(NamesMobileElements.CHECKOUT_SUMMARY_ITEM_LIST,
				NamesMobileElements.CHECKOUT_SUMMARY_ITEM);
		for (MobileElement product : products) {
			assertTrue("El elemento no existe",
					findSubElement(product, NamesMobileElements.CHECKOUT_SUMMARY_ITEM_IMAGE) != null);
			assertTrue("El elemento no existe",
					findSubElement(product, NamesMobileElements.CHECKOUT_SUMMARY_ITEM_DESC) != null);
			assertTrue("El elemento no existe",
					findSubElement(product, NamesMobileElements.CHECKOUT_SUMMARY_ITEM_PRICE) != null);
			assertTrue("El elemento no existe",
					findSubElement(product, NamesMobileElements.CHECKOUT_SUMMARY_ITEM_QUAN) != null);
			int quantity = Integer
					.valueOf(getElementText(findSubElement(product, NamesMobileElements.CHECKOUT_SUMMARY_ITEM_QUAN))
							.replaceAll("[^\\d]", ""));
			float price = Float
					.valueOf(getElementText(findSubElement(product, NamesMobileElements.CHECKOUT_SUMMARY_ITEM_PRICE))
							.replaceAll("[^\\d]", ""));
			productsTotal = +(quantity * price);
		}
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_SUMMARY_PRICE_CONT);
		waitElementVisibility(NamesMobileElements.CHECKOUT_SUMMARY_CUPPON_CONT);
		waitElementVisibility(NamesMobileElements.CHECKOUT_SUMMARY_CUPPON_BUTTON);
		waitElementVisibility(NamesMobileElements.CHECKOUT_SUMMARY_CUPPON_CUP_CONT);
		waitElementVisibility(NamesMobileElements.CHECKOUT_SUMMARY_CUPPON_TITLE);

		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_SUMMARY_PRICE_IVA);
		validateSummatyPrice(NamesMobileElements.CHECKOUT_SUMMARY_PRICE_CONT);

		float subTotal = Float.valueOf(getElementText(findSubElement(NamesMobileElements.CHECKOUT_SUMMARY_PRICE_CONT,
				NamesMobileElements.CHECKOUT_SUMMARY_PRICE_SUBTOTAL_VAL)).replaceAll("[^\\d]", ""));
		float discount = Float.valueOf(getElementText(findSubElement(NamesMobileElements.CHECKOUT_SUMMARY_PRICE_CONT,
				NamesMobileElements.CHECKOUT_SUMMARY_PRICE_DISC_VAL)).replaceAll("[^\\d]", ""));
		float shipping = Float.valueOf(getElementText(findSubElement(NamesMobileElements.CHECKOUT_SUMMARY_PRICE_CONT,
				NamesMobileElements.CHECKOUT_SUMMARY_PRICE_SHIP_VAL)).replaceAll("[^\\d]", ""));
		float discountShipping = Float
				.valueOf(getElementText(findSubElement(NamesMobileElements.CHECKOUT_SUMMARY_PRICE_CONT,
						NamesMobileElements.CHECKOUT_SUMMARY_PRICE_DISCSHIP_VAL)).replaceAll("[^\\d]", ""));
		float summaryTotal = Float
				.valueOf(getElementText(findSubElement(NamesMobileElements.CHECKOUT_SUMMARY_PRICE_CONT,
						NamesMobileElements.CHECKOUT_SUMMARY_PRICE_TOTAL_VAL)).replaceAll("[^\\d]", ""));
		assertTrue("El subtotal no coincide con el total en de los productos", productsTotal == subTotal);
		assertTrue("El detalle de precions no coincide",
				summaryTotal == (subTotal - discount + shipping - discountShipping));

		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_SUMMARY_DELIVERY_CHECK_TIMES);
		validateSummaryShipping();

		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_SUMMARY_OPENPAY);
		// assertTrue("El elemento no existe",
		// findSubElement(NamesMobileElements.CHECKOUT_SUMMARY_PAYMENT_CONT,
		// NamesMobileElements.CHECKOUT_SUMMARY_INFO) != null);
		validateSummaryPayment();
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_PICKUPSTORE_CONT);
		waitElementVisibility(NamesMobileElements.CHECKOUT_SUMMARY_TOTAL);
		waitElementVisibility(NamesMobileElements.CHECKOUT_SUMMARY_TOTAL_VAL);
		float total = Float.valueOf(
				getElementText(findElement(NamesMobileElements.CHECKOUT_SUMMARY_TOTAL_VAL)).replaceAll("[^\\d]", ""));
		assertTrue("El precio total es incorrecto", total == summaryTotal);
	}

	public void validateOrderPage() {
		logger.info("Validar pagina de Orden");
		waitElementVisibility(NamesMobileElements.CHECKOUT_ORDER_CONT);
		waitElementVisibility(NamesMobileElements.CHECKOUT_ORDER_USER_CONT);
		waitElementVisibility(NamesMobileElements.CHECKOUT_ORDER_USER_REVIEW);
		waitElementVisibility(NamesMobileElements.CHECKOUT_ORDER_USER_CONFIRM);
		waitElementVisibility(NamesMobileElements.CHECKOUT_ORDER_USER_EMAIL);
		waitElementVisibility(NamesMobileElements.CHECKOUT_ORDER_NUM_CONT);
		waitElementVisibility(NamesMobileElements.CHECKOUT_ORDER_NUM_TEXT);
		waitElementVisibility(NamesMobileElements.CHECKOUT_ORDER_NUM_VAL);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_ORDER_BARCODE_SAVE);
		waitElementVisibility(NamesMobileElements.CHECKOUT_ORDER_BARCODE_CONT);
		waitElementVisibility(NamesMobileElements.CHECKOUT_ORDER_BARCODE_INS);
		waitElementVisibility(NamesMobileElements.CHECKOUT_ORDER_BARCODE_DATE);
		waitElementVisibility(NamesMobileElements.CHECKOUT_ORDER_BARCODE_TOTAL);
		waitElementVisibility(NamesMobileElements.CHECKOUT_ORDER_BARCODE_CODE);
		waitElementVisibility(NamesMobileElements.CHECKOUT_ORDER_BARCODE_SAVE);
		waitElementVisibility(NamesMobileElements.CHECKOUT_ORDER_BARCODE_SHARE);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_ORDER_SUMMARY_TITLE);
		waitElementVisibility(NamesMobileElements.CHECKOUT_ORDER_INVOICE_CONT);
		waitElementVisibility(NamesMobileElements.CHECKOUT_ORDER_INVOICE_TITLE);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_SUMMARY_PRICE_IVA);
		validateSummatyPrice(NamesMobileElements.CHECKOUT_ORDER_SUMMARY_PRICE_CONT);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_SUMMARY_DELIVERY_TIME);
		validateSummaryShipping();
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_ORDER_TIP);
		validateSummaryPayment();
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_ORDER_CONTINUE_BUTTON);
		waitElementVisibility(NamesMobileElements.CHECKOUT_ORDER_TIP);
	}

	public void validateCreditCardPage() {
		logger.info("Validando pagina de tarjeta de credito");
		waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_CONT);
		waitElementVisibility(NamesMobileElements.CHECKOUT_CARD);
		waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_FRONT);
		waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_FRONT_NUMBER);
		waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_FRONT_NAME);
		waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_FRONT_EXP);
		waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_NUMBER_CONT);
		waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_NAME_CONT);
		tapOnElement(NamesMobileElements.CHECKOUT_CARD_FRONT);
		waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_BACK);
		waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_LINE);
		waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_CVV);
		tapOnElement(NamesMobileElements.CHECKOUT_CARD_BACK);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_CARD_QUESTION);
		waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_PRIV_CONT);
		waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_PRIV_EXP_CONT);
		waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_PRIV_SEC_CONT);
		waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_PRIV_ICON);
		waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_QUESTION);
		waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_ANSWER_CONT);
		waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_ANSWER_YES);
		waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_ANSWER_NO);
	}

	public void addCreditCard(String number, String name, String date, String cvv) {
		logger.info("Agregar tarjeta de credito");
		fillElement(NamesMobileElements.CHECKOUT_CARD_NUMBER, number);
		fillElement(NamesMobileElements.CHECKOUT_CARD_NAME, name);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_CARD_PRIV_CONT);
		tapOnElement(NamesMobileElements.CHECKOUT_CARD_PRIV_EXP);
		fillElement(NamesMobileElements.CHECKOUT_CARD_PRIV_EXP, date);
		hideKeyboard();
		fillElement(NamesMobileElements.CHECKOUT_CARD_PRIV_SEC, cvv);
		scrollUntilShowElement(GeneralConstants.SCROLL_DOWN, NamesMobileElements.CHECKOUT_CARD_BACK);
		tapOnElement(NamesMobileElements.CHECKOUT_CARD_BACK);
		assertEquals(number, getElementText(NamesMobileElements.CHECKOUT_CARD_NUMBER).trim());
		assertEquals(name, getElementText(NamesMobileElements.CHECKOUT_CARD_NAME));
	}

	public void deleteCreditCard() {
		logger.info("Eliminar tarjeta de credito");
		List<MobileElement> cards = findSubElements(NamesMobileElements.CHECKOUT_CARD_PAYMENT_CARDS_CONT,
				NamesMobileElements.CHECKOUT_CARD_PAYMENT_CARDS_ITEM);
		int numberCards = cards.size();
		tapOnElement(findSubElement(cards.get(0), NamesMobileElements.CHECKOUT_CARD_PAYMENT_CARDS_ITEM_DELETE));
		waitEvent();
		cards = findSubElements(NamesMobileElements.CHECKOUT_CARD_PAYMENT_CARDS_CONT,
				NamesMobileElements.CHECKOUT_CARD_PAYMENT_CARDS_ITEM);
		assertTrue("No se eliminaron las tarjetas", numberCards > cards.size());
	}

	public void isSameAddress(boolean isSameAddress, boolean isValidData) {
		logger.info("Validando si es misma direccion");
		if (!isSameAddress && isValidData) {
			tapOnElement(NamesMobileElements.CHECKOUT_CARD_ANSWER_NO);
			scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_ADDRESS_NEIGHBORHOOD);
			waitElementVisibility(NamesMobileElements.CHECKOUT_CARD_QUESTION);
			waitElementVisibility(NamesMobileElements.CHECKOUT_ADDRESS_STREET_CONT);
			waitElementVisibility(NamesMobileElements.CHECKOUT_ADDRESS_OUT_NUMBER_CONT);
			waitElementVisibility(NamesMobileElements.CHECKOUT_ADDRESS_IN_NUMBER_CONT);
			waitElementVisibility(NamesMobileElements.CHECKOUT_ADDRESS_ZIPCODE_CONT);
			waitElementVisibility(NamesMobileElements.CHECKOUT_ADDRESS_NEIGHBORHOOD);
			AddressVO address = menu.initAddressVO();
			fillElement(NamesMobileElements.CHECKOUT_ADDRESS_STREET, address.getAddressStreet());
			fillElement(NamesMobileElements.CHECKOUT_ADDRESS_OUT_NUMBER, address.getAddressOutNumber());
			fillElement(NamesMobileElements.CHECKOUT_ADDRESS_IN_NUMBER, address.getAddressInnerNumber());
			fillElement(NamesMobileElements.CHECKOUT_ADDRESS_ZIPCODE, address.getAddressZipcode());
			tapOnElement(NamesMobileElements.CHECKOUT_ADDRESS_NEIGHBORHOOD);
			List<MobileElement> neighbornhoods = findElements(NamesMobileElements.COMBO_OPTIONS);
			for (MobileElement neighbornhood : neighbornhoods) {
				if (getAttribute(neighbornhood, ConfigConstants.ATTRIBUTE_TEXT).toLowerCase()
						.contains(address.getAddressNeighbornhood().toLowerCase())) {
					neighbornhood.click();
					break;
				}
			}
		}
	}

	public void tapOnGoToPreOrder() {
		logger.info("Tap en ir a pre-orden");
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_CARD_NEXT_BUTTON);
		tapOnElement(NamesMobileElements.CHECKOUT_CARD_NEXT_BUTTON);
	}

	public void tapOnGoToOrder() {
		logger.info("Tap en ir a orden");
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_SUMMARY_APPLY_BUTTON);
		tapOnElement(NamesMobileElements.CHECKOUT_SUMMARY_APPLY_BUTTON);
	}

	public void tapOnFinishOrder() {
		logger.info("Tap en finalizar orden");
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.CHECKOUT_ORDER_CONTINUE_BUTTON);
		tapOnElement(NamesMobileElements.CHECKOUT_ORDER_CONTINUE_BUTTON);
	}

	private void validateSummatyPrice(String parent) {
		logger.info("Validando resumen de precios");
		assertTrue("El elemento no existe",
				findSubElement(parent, NamesMobileElements.CHECKOUT_SUMMARY_PRICE_SUBTOTAL) != null);
		assertTrue("El elemento no existe",
				findSubElement(parent, NamesMobileElements.CHECKOUT_SUMMARY_PRICE_SUBTOTAL_VAL) != null);
		assertTrue("El elemento no existe",
				findSubElement(parent, NamesMobileElements.CHECKOUT_SUMMARY_PRICE_DISC) != null);
		assertTrue("El elemento no existe",
				findSubElement(parent, NamesMobileElements.CHECKOUT_SUMMARY_PRICE_DISC_VAL) != null);
		assertTrue("El elemento no existe",
				findSubElement(parent, NamesMobileElements.CHECKOUT_SUMMARY_PRICE_SHIP) != null);
		assertTrue("El elemento no existe",
				findSubElement(parent, NamesMobileElements.CHECKOUT_SUMMARY_PRICE_SHIP_VAL) != null);
		assertTrue("El elemento no existe",
				findSubElement(parent, NamesMobileElements.CHECKOUT_SUMMARY_PRICE_DISCSHIP) != null);
		assertTrue("El elemento no existe",
				findSubElement(parent, NamesMobileElements.CHECKOUT_SUMMARY_PRICE_DISCSHIP_VAL) != null);
		assertTrue("El elemento no existe",
				findSubElement(parent, NamesMobileElements.CHECKOUT_SUMMARY_PRICE_TOTAL) != null);
		assertTrue("El elemento no existe",
				findSubElement(parent, NamesMobileElements.CHECKOUT_SUMMARY_PRICE_TOTAL_VAL) != null);
		assertTrue("El elemento no existe",
				findSubElement(parent, NamesMobileElements.CHECKOUT_SUMMARY_PRICE_IVA) != null);
	}

	private void validateSummaryShipping() {
		logger.info("Validando resumen de entrega");
		assertTrue("El elemento no existe", findSubElement(NamesMobileElements.CHECKOUT_SUMMARY_DELIVERY_CONT,
				NamesMobileElements.CHECKOUT_SUMMARY_DELIVERY_TITLE) != null);
		assertTrue("El elemento no existe", findSubElement(NamesMobileElements.CHECKOUT_SUMMARY_DELIVERY_CONT,
				NamesMobileElements.CHECKOUT_SUMMARY_DELIVERY_NAME) != null);
		assertTrue("El elemento no existe", findSubElement(NamesMobileElements.CHECKOUT_SUMMARY_DELIVERY_CONT,
				NamesMobileElements.CHECKOUT_SUMMARY_DELIVERY_ADDRESS) != null);
		assertTrue("El elemento no existe", findSubElement(NamesMobileElements.CHECKOUT_SUMMARY_DELIVERY_CONT,
				NamesMobileElements.CHECKOUT_SUMMARY_DELIVERY_TIME) != null);
	}

	private void validateSummaryPayment() {
		logger.info("Validando metodo de pago");
		assertTrue("El elemento no existe", findSubElement(NamesMobileElements.CHECKOUT_SUMMARY_PAYMENT_CONT,
				NamesMobileElements.CHECKOUT_SUMMARY_PAYMENT_METHOD) != null);
		assertTrue("El elemento no existe", findSubElement(NamesMobileElements.CHECKOUT_SUMMARY_PAYMENT_CONT,
				NamesMobileElements.CHECKOUT_SUMMARY_PAYMENT_TYPE) != null);
		assertEquals(paymentMethod, getElementText(NamesMobileElements.CHECKOUT_SUMMARY_PAYMENT_TYPE));
	}
}
