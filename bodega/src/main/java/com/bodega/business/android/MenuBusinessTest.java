package com.bodega.business.android;

import java.util.List;

import org.apache.log4j.Logger;

import com.bodega.base.BaseDriver;
import com.bodega.constants.AppMessages;
import com.bodega.constants.ConfigConstants;
import com.bodega.constants.GeneralConstants;
import com.bodega.constants.NamesMobileElements;
import com.bodega.enums.MenusEnum;
import com.bodega.enums.ProfileMenuEnum;
import com.bodega.enums.TermsEnum;
import com.bodega.vo.AddressVO;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class MenuBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(MenuBusinessTest.class);
	private GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	private LoginBusinessTest login = new LoginBusinessTest();
	private static String addressName = "";
	private static int addressCont = 0;

	public AddressVO initAddressVO() {
		return new AddressVO("Mi direccion ", "Juan", "Perez", "Av Rodolfo Gaona 46", "456", "", "11200",
				"Lomas de Sotelo", "Entre calle 1 y calle 2", "Plaza Toreo", "Movil", "5555555555", true);
	}

	public void login(String email, String pass) {
		login.login(email, pass);
	}

	public void selectProfile() {
		generalBusinessTest.selectProfile();
	}

	public void selectMenu(ProfileMenuEnum menuOption) {
		generalBusinessTest.selectMenuOption(menuOption);
	}

	@Step("Select add address")
	public void selectAddAddress() {
		logger.info("Tap en agrega direccion");
		addressCont = 0;
		if(elementExist(NamesMobileElements.ADDRESS_LIST)) {
			addressCont = findElements(NamesMobileElements.ADDRESS_LIST).size();
		} 
		tapOnElement(NamesMobileElements.ADDRESS_ADD_BUTTON);
	}

	@Step("Add new direction")
	public void addNewDirection(AddressVO addressVO) {
		logger.info("Escribiendo datos");
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
			if (getAttribute(neighbornhood, ConfigConstants.ATTRIBUTE_TEXT).toLowerCase()
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
			if (getElementText(phoneType).toLowerCase().contains(addressVO.getAddressPhoneOption().toLowerCase())) {
				phoneType.click();
				break;
			}
		}
		fillElement(NamesMobileElements.ADDRESS_PHONE_TEXT, addressVO.getAddressPhone());
		selectAsMainAddress(addressVO.isMainAddress());
	}

	@Step("Select as main address")
	private void selectAsMainAddress(boolean check) {
		logger.info("Tap en checkbox de direccion principal");
		MobileElement checkMainAddress = findElement(NamesMobileElements.ADDRESS_MAIN_ADDRESS_CHECK);
		boolean checkMainAddressBool = checkMainAddress != null
				? Boolean.parseBoolean(checkMainAddress.getAttribute(GeneralConstants.CHECKED))
				: false;
		if (check && !checkMainAddressBool) {
			tapOnElement(NamesMobileElements.ADDRESS_MAIN_ADDRESS_CHECK);
		}
		if (!check && checkMainAddressBool) {
			tapOnElement(NamesMobileElements.ADDRESS_MAIN_ADDRESS_CHECK);
		}
	}

	@Step("Select as main address")
	public void selectAsMainAddress() {
		logger.info("Tap en checkbox de direccion principal");
		waitElementVisibility(NamesMobileElements.ADDRESS_ICON_FAV);
		List<MobileElement> favIcon = findElements(NamesMobileElements.ADDRESS_ICON_FAV);
		waitElementVisibility(NamesMobileElements.ADDRESS_DETAIL_NAME);
		List<MobileElement> addressNames = findElements(NamesMobileElements.ADDRESS_DETAIL_NAME);
		addressName = addressNames.size() > 1 ? getElementText(addressNames.get(1)) : getElementText(addressNames.get(0));
		if (favIcon.size() > 1) {
			waitEvent();
			tapOnElement(favIcon.get(1));
		}
	}

	@Step("Save direction")
	public void saveDirection() {
		logger.info("Tap en guardar direccion");
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.ADDRESS_SAVE_BUTTON);
		tapOnElement(NamesMobileElements.ADDRESS_SAVE_BUTTON);
	}

	@Step("Validate address")
	public void validateAddress(AddressVO addressVO, String validationMessage) {
		generalBusinessTest.validatePopUpMessages(validationMessage);
		waitElementVisibility(NamesMobileElements.ADDRESS_LIST);
		MobileElement addressList = findElement(NamesMobileElements.ADDRESS_LIST);
		List<MobileElement> addressDetail = findSubElements(addressList, NamesMobileElements.ADDRESS_DETAIL_NAME);
		assertTrue("No se guardo la direccion", addressDetail.size() > addressCont );
		if (addressVO.isMainAddress()) {
			assertEquals(addressVO.getAddressName().toLowerCase(), getElementText(addressDetail.get(0)));
		} else {
			assertTrue("La direccion no debe ser principal",
					!addressVO.getAddressName().toLowerCase().equals(getElementText(addressDetail.get(0))));
		}
		addressCont = 0;
		logger.info("Guardado exitoso");
	}

	@Step("Edit address")
	public void editAddress(AddressVO addressVO) {
		waitElementVisibility(NamesMobileElements.ADDRESS_LIST);
		if (elementExist(NamesMobileElements.ADDRESS_DETAIL_EDIT)) {
			tapOnElement(NamesMobileElements.ADDRESS_DETAIL_EDIT);
			addNewDirection(addressVO);
		} else {
			assertTrue("No hay direcciones que editar", Boolean.FALSE);
		}
		logger.info("Editando direccion");
	}

	@Step("Remove address")
	public void removeAddress(AddressVO addressVO) {
		waitElementVisibility(NamesMobileElements.ADDRESS_LIST);
		if (elementExist(NamesMobileElements.ADDRESS_DETAIL_DELETE)) {
			List<MobileElement> deletes = findElements(NamesMobileElements.ADDRESS_DETAIL_DELETE);
			addressName = getElementText(findElements(NamesMobileElements.ADDRESS_DETAIL_NAME).get(0));
			tapOnElement(deletes.get(0));
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
		waitEvent();
		List<MobileElement> address = findElements(NamesMobileElements.ADDRESS_DETAIL_NAME);
		String actualAddress = getElementText(address.get(0));
		assertTrue("No se eliminó la dirección", !addressName.equals(actualAddress));
	}

	@Step("Validate order page")
	public void validateOrderPage() {
		List<MobileElement> orders = findElements(NamesMobileElements.ORDER_ORDER_CONT);
		assertTrue("El elemento no existe", orders.size() > 0);
		logger.info("Página válida");
	}

	@Step("Validate empty order page")
	public void validateEmptyOrderPage() {
		waitElementVisibility(NamesMobileElements.ORDER_EMPTY_ICON);
		waitElementVisibility(NamesMobileElements.ORDER_EMPTY_BUTTON);
		logger.info("Página válida");
	}

	@Step("Tap on order detail")
	public String[] orderDetail() {
		waitElementVisibility(NamesMobileElements.ORDER_ORDER_CONT);
		String orderNumber[] = { getElementText(NamesMobileElements.ORDER_ORDER_NUMBER),
				getElementText(NamesMobileElements.ORDER_ORDER_DATE) };
		tapOnElement(NamesMobileElements.ORDER_ORDER_DETAIL_LINK);
		return orderNumber;
	}

	@Step("Validate order detail page")
	public void validateOrderDetail(String[] orderNumber) {
		String orderDetailNumber = getElementText(NamesMobileElements.ORDER_DETAIL_ORDER_NUMBER);
		String orderDetailDate = getElementText(NamesMobileElements.ORDER_DETAIL_ORDER_DATE);
		assertTrue("Número de orden incorrecto", orderDetailNumber.equals(orderNumber[0]));
		assertTrue("Fecha de orden incorrecta", orderDetailDate.contains(orderNumber[1]));
		waitElementVisibility(NamesMobileElements.ORDER_DETAIL_ORDER_LIST);
		waitElementVisibility(NamesMobileElements.ORDER_DETAIL_ORDER_PRICE);
		logger.info("Página válida");
	}

	@Step("Manual bill")
	public void manualBill(String ticketCode) {
		waitElementVisibility(NamesMobileElements.GETBILL_SCAN_CONT);
		tapOnElement(NamesMobileElements.GETBILL_MANUAL_CODE);
		fillElement(NamesMobileElements.GETBILL_SCAN_MANUAL_TICKET_NUMBER, ticketCode);
		logger.info("Escribiendo codigo");
		tapOnElement(NamesMobileElements.GETBILL_SCAN_MANUAL_BUTTON);
		logger.info("Tap en obtener factura");
	}

	@Step("Validate terms page")
	public void validateTerms() {
		logger.info("Página válida");
		for (TermsEnum term : TermsEnum.values()  ) {
			generalBusinessTest.selectTerms(term.getTerm());
		}
	}

	@Step("Validate support page")
	public void validateSupportPage() {
		waitElementVisibility(NamesMobileElements.SUPPORT_CALL_ICON);
		waitElementVisibility(NamesMobileElements.SUPPORT_CALL_ICON);
		waitElementVisibility(NamesMobileElements.SUPPORT_EMAIL_ICON);
		logger.info("Página válida");
	}

	@Step("Validate logout")
	public void validateLogout() {
		selectProfile();
		selectMenu(ProfileMenuEnum.LOGIN);
		assertTrue("El elemento no existe", elementExist(NamesMobileElements.LOGIN_LOGIN_BUTTON));
		logger.info("Elemento válido");
	}

	@Step("Validate legals page")
	public void validateLegalsPage() {
		generalBusinessTest.valitateMenuAndSubMenus(MenusEnum.LEGALS_TERMS);
		generalBusinessTest.valitateMenuAndSubMenus(MenusEnum.LEGALS_PRIVACITY);
		List<MobileElement> terms = findElements(NamesMobileElements.LEGALS_ITEM);
		assertEquals(ConfigConstants.APP_VERSION.toLowerCase(), getElementText(terms.get(2)));
		logger.info("Página válida");
	}

	private void randomAddressName(AddressVO addressVO) {
		if(addressVO == null) {
			addressVO = initAddressVO();
		}
		String newAddress = addressVO.getAddressName() + generalBusinessTest.randomString(3, false, true);
		addressVO.setAddressName(newAddress);
	}

	@Step("Validate address empty data messages")
	public void validateAddressEmptyMessages() {
		scrollUntilShowElement(GeneralConstants.SCROLL_DOWN, NamesMobileElements.ADDRESS_NAME_TEXT_CONT);
		validateErrorMessages(AppMessages.EMPTY_FIELD, NamesMobileElements.ADDRESS_NAME_TEXT_CONT);
		validateErrorMessages(AppMessages.EMPTY_FIELD, NamesMobileElements.ADDRESS_STREET_TEXT_CONT);
		validateErrorMessages(AppMessages.EMPTY_FIELD, NamesMobileElements.ADDRESS_OUT_NUMBER_CONT);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.ADDRESS_SAVE_BUTTON);
		validateErrorMessages(AppMessages.EMPTY_FIELD, NamesMobileElements.ADDRESS_ZIP_CODE_CONT);
		validateErrorMessages(AppMessages.EMPTY_FIELD, NamesMobileElements.ADDRESS_PHONE_TEXT_CONT);
		logger.info("Mensajes de error válidos");
	}

	@Step("Validate address invalid data messages")
	public void validateAddressInvalidMessages() {
		scrollUntilShowElement(GeneralConstants.SCROLL_DOWN, NamesMobileElements.ADDRESS_NAME_TEXT_CONT);
		validateErrorMessages(AppMessages.INVALID_DATA_TEXT_FIELD, NamesMobileElements.ADDRESS_NAME_TEXT_CONT);
		validateErrorMessages(AppMessages.INVALID_DATA_TEXT_FIELD, NamesMobileElements.ADDRESS_USER_NAME_CONT);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.ADDRESS_STREET_TEXT_CONT);
		validateErrorMessages(AppMessages.INVALID_DATA_TEXT_FIELD, NamesMobileElements.ADDRESS_USER_LAST_NAME_CONT);
		validateErrorMessages(AppMessages.INVALID_DATA_TEXT_FIELD, NamesMobileElements.ADDRESS_STREET_TEXT_CONT);
		logger.info("Mensajes de error válidos");
	}

	@Step("Validate favorite address")
	public void validateFavoriteAddress() {
		generalBusinessTest.validatePopUpMessages(AppMessages.ADDRESS_FAV_ICON);
		generalBusinessTest.goBack();
		generalBusinessTest.selectMenuOption(ProfileMenuEnum.ADDRESS);
		waitElementVisibility(NamesMobileElements.ADDRESS_DETAIL_NAME);
		List<MobileElement> addressNames = findElements(NamesMobileElements.ADDRESS_DETAIL_NAME);
		assertEquals(addressName, getElementText(addressNames.get(0)));
	}

	@Step("Validate favorite address")
	public void validateEmptyAddressPage() {
		waitElementVisibility(NamesMobileElements.ADDRESS_EMPTY_PAGE);
		waitElementVisibility(NamesMobileElements.ADDRESS_EMPTY_ICON);
	}

	@Step("Validate profile menu")
	public void validateMenu(boolean isLogged) {
		if (isLogged) {
			generalBusinessTest.selectMenuOption(ProfileMenuEnum.PROFILE);
			generalBusinessTest.goBack();
			generalBusinessTest.selectMenuOption(ProfileMenuEnum.ADDRESS);
			generalBusinessTest.goBack();
			generalBusinessTest.selectMenuOption(ProfileMenuEnum.ORDERS);
			generalBusinessTest.goBack();
			generalBusinessTest.selectMenuOption(ProfileMenuEnum.NOTIFICATIONS);
		} else {
			generalBusinessTest.selectMenuOption(ProfileMenuEnum.LOGIN);
			generalBusinessTest.goBack();
			generalBusinessTest.selectMenuOption(ProfileMenuEnum.CREATE_PROFILE);
			generalBusinessTest.goBack();
		}
		generalBusinessTest.selectMenuOption(ProfileMenuEnum.GET_BILL);
		closeAndroidDialog();
		generalBusinessTest.goBack();
		generalBusinessTest.selectMenuOption(ProfileMenuEnum.SUPPORT);
		generalBusinessTest.goBack();
		generalBusinessTest.selectMenuOption(ProfileMenuEnum.TERMS);
		generalBusinessTest.goBack();
		generalBusinessTest.selectMenuOption(ProfileMenuEnum.LEGALS);
		generalBusinessTest.goBack();
		if (isLogged) {
			generalBusinessTest.selectMenuOption(ProfileMenuEnum.LOGOUT);
		}
	}

	@Step("Validate Zip Code")
	public void validateZipCode(String zipCode) {
		logger.info("Validando codigo postal");
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.ADDRESS_ZIP_CODE_CONT);
		fillElement(NamesMobileElements.ADDRESS_ZIP_CODE, zipCode);
		generalBusinessTest.validatePopUpMessages(AppMessages.UNEXIST_ZIPCODE);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.ADDRESS_REFERENCES_ONE);
		assertTrue("Error en la validacion de codigo postal", !elementExist(NamesMobileElements.ADDRESS_NEIGHBORNHOOD));
	}

	private void validateErrorMessages(String message, String element) {
		generalBusinessTest.validateFieldErrorMessage(message, element);
	}
}
