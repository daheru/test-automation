package com.bodega.business.android;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import com.bodega.constants.AppMessages;
import com.bodega.constants.ConfigConstants;
import com.bodega.constants.GeneralConstants;
import com.bodega.constants.NamesMobileElements;
import com.bodega.enums.MenuOptionsEnum;
import com.bodega.enums.MenusEnum;
import com.bodega.util.BaseDriver;
import com.bodega.vo.AddressVO;

import io.appium.java_client.MobileElement;

public class MenuBusinessTest extends BaseDriver {

	public static final Logger logger = Logger.getLogger(MenuBusinessTest.class);
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	public LoginBusinessTest login = new LoginBusinessTest();
	public static int numAddress = 0;

	public void login(String email, String pass) {
		login.login(email, pass);
	}

	public void selectProfile() {
		generalBusinessTest.selectProfile();
	}

	public void selectMenu(String menuOption) {
		generalBusinessTest.selectMenuOption(menuOption);
	}

	public void selectAddAddress() {
		waitElementVisibility(NamesMobileElements.ADDRESS_LIST);
		tapOnElement(NamesMobileElements.ADDRESS_ADD_BUTTON);
		logger.info("Tap en agrega direccion");
	}

	public void addNewDirection(AddressVO addressVO) {
		randomAddressName(addressVO);
		waitElementVisibility(NamesMobileElements.ADDRESS_NAME_TEXT);
		fillElement(NamesMobileElements.ADDRESS_NAME_TEXT, addressVO.getAddressName());
		fillElement(NamesMobileElements.ADDRESS_USER_NAME, addressVO.getAddressUserName());
		fillElement(NamesMobileElements.ADDRESS_USER_LAST_NAME, addressVO.getAddressUserLastName());
		fillElement(NamesMobileElements.ADDRESS_STREET_TEXT, addressVO.getAddressStreet());
		fillElement(NamesMobileElements.ADDRESS_OUT_NUMBER, addressVO.getAddressOutNumber());
		fillElement(NamesMobileElements.ADDRESS_INNER_NUMBER, addressVO.getAddressInnerNumber());
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.ADDRESS_ZIP_CODE);
		tapOnElement(NamesMobileElements.ADDRESS_ZIP_CODE);
		fillElement(NamesMobileElements.ADDRESS_ZIP_CODE, addressVO.getAddressZipcode());
		hideKeyboard();
		waitElementVisibility(NamesMobileElements.ADDRESS_NEIGHBORNHOOD);
		tapOnElement(NamesMobileElements.ADDRESS_NEIGHBORNHOOD);
		List<MobileElement> neighbornhoods = findElements(NamesMobileElements.COMBO_OPTIONS);
		for (MobileElement neighbornhood : neighbornhoods) {
			if (neighbornhood.getAttribute(ConfigConstants.ATTRIBUTE_TEXT).toLowerCase()
					.contains(addressVO.getAddressNeighbornhood().toLowerCase())) {
				neighbornhood.click();
				break;
			}
		}
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.ADDRESS_REFERENCES_TWO);
		fillElement(NamesMobileElements.ADDRESS_REFERENCES_ONE, addressVO.getAddressReferenceOne());
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.ADDRESS_SAVE_BUTTON);
		fillElement(NamesMobileElements.ADDRESS_REFERENCES_TWO, addressVO.getAddressReferenceTwo());
		tapOnElement(NamesMobileElements.ADDRESS_PHONE_TYPE);
		List<MobileElement> phoneTypes = findElements(NamesMobileElements.COMBO_OPTIONS);
		for (MobileElement phoneType : phoneTypes) {
			if (phoneType.getAttribute(ConfigConstants.ATTRIBUTE_TEXT).toLowerCase()
					.contains(addressVO.getAddressPhoneOption().toLowerCase())) {
				phoneType.click();
				break;
			}
		}
		fillElement(NamesMobileElements.ADDRESS_PHONE_TEXT, addressVO.getAddressPhone());
		selectAsMainAddress(addressVO.isMainAddress());
		logger.info("Escribiendo datos");
	}

	public void selectAsMainAddress(boolean check) {
		MobileElement checkMainAddress = findElement(NamesMobileElements.ADDRESS_MAIN_ADDRESS_CHECK);
		boolean checkMainAddressBool = Boolean.parseBoolean(checkMainAddress.getAttribute(GeneralConstants.CHECKED));
		if (check && !checkMainAddressBool) {
			tapOnElement(NamesMobileElements.ADDRESS_MAIN_ADDRESS_CHECK);
		}
		if (!check && checkMainAddressBool) {
			tapOnElement(NamesMobileElements.ADDRESS_MAIN_ADDRESS_CHECK);
		}
		logger.info("Tap en checkbox de direccion principal");
	}

	public void saveDirection() {
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.ADDRESS_SAVE_BUTTON);
		tapOnElement(NamesMobileElements.ADDRESS_SAVE_BUTTON);
		logger.info("Tap en guardar direccion");
	}

	public void validateAddress(AddressVO addressVO, String validationMessage) {
		generalBusinessTest.validatePopUpMessages(validationMessage);
		List<MobileElement> errors = findElements(NamesMobileElements.ERROR_TEXT_FIELD);
		assertEquals(0, errors.size());
		waitElementVisibility(NamesMobileElements.ADDRESS_LIST);
		MobileElement addressList = findElement(NamesMobileElements.ADDRESS_LIST);
		List<MobileElement> addressDetail = findSubElements(addressList, NamesMobileElements.ADDRESS_DETAIL_NAME);
		if (addressVO.isMainAddress()) {
			assertEquals(addressVO.getAddressName().toLowerCase(), getElementText(addressDetail.get(0)));
		} else {
			assertTrue("La direccion no debe ser principal",
					!addressVO.getAddressName().toLowerCase().equals(getElementText(addressDetail.get(0))));
		}
		logger.info("Guardado exitoso");
	}

	public void editAddress(AddressVO addressVO) {
		if (elementExist(NamesMobileElements.ADDRESS_DETAIL_EDIT)) {
			tapOnElement(NamesMobileElements.ADDRESS_DETAIL_EDIT);
			randomAddressName(addressVO);
			fillElement(NamesMobileElements.ADDRESS_NAME_TEXT, addressVO.getAddressName());
			scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.ADDRESS_SAVE_BUTTON);
			fillElement(NamesMobileElements.ADDRESS_PHONE_TEXT, addressVO.getAddressPhone());
		}
		logger.info("Editando direccion");
	}

	public void removeAddress(AddressVO addressVO) {
		if (elementExist(NamesMobileElements.ADDRESS_DETAIL_DELETE)) {
			List<MobileElement> deletes = findElements(NamesMobileElements.ADDRESS_DETAIL_DELETE);
			numAddress = deletes.size();
			tapOnElement(deletes.get(numAddress - 1));
			waitElementVisibility(NamesMobileElements.ADDRESS_DIALOG_DELETE);
			tapOnElement(NamesMobileElements.ADDRESS_DIALOG_DELETE);
			logger.info("Eliminando direccion");
		} else {
			randomAddressName(addressVO);
			selectAddAddress();
			addNewDirection(addressVO);
			selectAsMainAddress(false);
			saveDirection();
			validateAddress(addressVO, AppMessages.ADD_ADDRESS);
			removeAddress(addressVO);
		}
	}

	public void validateRemoveAddress() {
		generalBusinessTest.validatePopUpMessages(AppMessages.REMOVE_ADDRESS);
	}

	public void validateOrderPage() {
		if (elementExist(NamesMobileElements.ORDER_EMPTY_CONT)) {
			waitElementVisibility(NamesMobileElements.ORDER_EMPTY_ICON);
			waitElementVisibility(NamesMobileElements.ORDER_EMPTY_BUTTON);
		} else if (elementExist(NamesMobileElements.ORDER_ORDER_LIST)) {
			List<MobileElement> orders = findElements(NamesMobileElements.ORDER_ORDER_CONT);
			assertTrue("El elemento no existe", orders.size() > 0);
		}
		logger.info("Página válida");
	}

	public String[] orderDetail() {
		waitElementVisibility(NamesMobileElements.ORDER_ORDER_CONT);
		String orderNumber[] = { getElementText(NamesMobileElements.ORDER_ORDER_NUMBER),
				getElementText(NamesMobileElements.ORDER_ORDER_DATE) };
		tapOnElement(NamesMobileElements.ORDER_ORDER_DETAIL_LINK);
		return orderNumber;
	}

	public void validateOrderDetail(String[] orderNumber) {
		String orderDetailNumber = getElementText(NamesMobileElements.ORDER_DETAIL_ORDER_NUMBER);
		String orderDetailDate = getElementText(NamesMobileElements.ORDER_DETAIL_ORDER_DATE);
		assertTrue("", orderDetailNumber.equals(orderNumber[0]));
		assertTrue("", orderDetailDate.contains(orderNumber[1]));
		waitElementVisibility(NamesMobileElements.ORDER_DETAIL_ORDER_LIST);
		waitElementVisibility(NamesMobileElements.ORDER_DETAIL_ORDER_PRICE);
		logger.info("Página válida");
	}

	public void manualBill(String ticketCode) {
		waitElementVisibility(NamesMobileElements.GETBILL_SCAN_CONT);
		tapOnElement(NamesMobileElements.GETBILL_MANUAL_CODE);
		fillElement(NamesMobileElements.GETBILL_SCAN_MANUAL_TICKET_NUMBER, ticketCode);
		logger.info("Escribiendo codigo");
		tapOnElement(NamesMobileElements.GETBILL_SCAN_MANUAL_BUTTON);
		logger.info("Tap en obtener factura");
	}

	public void validateTerms(int elementNum) {
		MobileElement menuTerm = findElement(NamesMobileElements.LIST_TERMS);
		List<MobileElement> terms = findSubElements(menuTerm, NamesMobileElements.LIST_TERM_ELEMENT);
		assertEquals(elementNum, terms.size());
		for (MobileElement element : terms) {
			tapOnElement(element);
			tapOnElement(NamesMobileElements.BACK_BUTTON);
		}
		logger.info("Página válida");
	}

	public void validateSupportPage() {
		waitElementVisibility(NamesMobileElements.SUPPORT_CALL_ICON);
		waitElementVisibility(NamesMobileElements.SUPPORT_CALL_ICON);
		waitElementVisibility(NamesMobileElements.SUPPORT_EMAIL_ICON);
		logger.info("Página válida");
	}

	public void validateLogout() {
		selectProfile();
		selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		assertTrue("El elemento no existe", elementExist(NamesMobileElements.LOGIN_LOGIN_BUTTON));
		logger.info("Elemento válido");
	}

	public void validateLegalsPage() {
		generalBusinessTest.valitateMenuAndSubMenus(MenusEnum.LEGALS_TERMS);
		generalBusinessTest.valitateMenuAndSubMenus(MenusEnum.LEGALS_PRIVACITY);
		List<MobileElement> terms = findElements(NamesMobileElements.LEGALS_ITEM);
		assertEquals(ConfigConstants.APP_VERSION.toLowerCase(), getElementText(terms.get(2)));
		logger.info("Página válida");
	}

	private void randomAddressName(AddressVO addressVO) {
		Random generator = new Random();
		String newAddress = addressVO.getAddressName() + generator.nextInt(100);
		addressVO.setAddressName(newAddress);
	}

	public void validateErrorMessages(String message, String element) {
		generalBusinessTest.validateFieldErrorMessage(message, element);
		logger.info("Validando mensajes de error");
	}

	public void validateAddressErrorMessages() {
		scrollUntilShowElement(GeneralConstants.SCROLL_DOWN, NamesMobileElements.ADDRESS_NAME_TEXT_CONT);
		validateErrorMessages(AppMessages.EMPTY_FIELD, NamesMobileElements.ADDRESS_NAME_TEXT_CONT);
		validateErrorMessages(AppMessages.EMPTY_FIELD, NamesMobileElements.ADDRESS_STREET_TEXT_CONT);
		validateErrorMessages(AppMessages.EMPTY_FIELD, NamesMobileElements.ADDRESS_OUT_NUMBER_CONT);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.ADDRESS_SAVE_BUTTON);
		validateErrorMessages(AppMessages.EMPTY_FIELD, NamesMobileElements.ADDRESS_ZIP_CODE_CONT);
		validateErrorMessages(AppMessages.EMPTY_FIELD, NamesMobileElements.ADDRESS_PHONE_TEXT_CONT);
		logger.info("Mensajes de error válidos");
	}
}
