package com.walmartmg.business.android;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.AppMessages;
import com.walmartmg.constants.ConfigConstants;
import com.walmartmg.constants.GeneralConstants;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.enums.ProfileMenuEnum;
import com.walmartmg.vo.AddressVO;

import io.appium.java_client.MobileElement;

public class AddressesBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(InvoiceBusinessTest.class);
	private GeneralBusinessTest general = new GeneralBusinessTest();
	private LoginBusinessTest login = new LoginBusinessTest();
	private static String addressName = "";

	public AddressVO initAddressVO() {
		return new AddressVO("Mi direccion ", "Juan", "Perez", "Av Rodolfo Gaona 46", "456", "", "11200",
				"Lomas de Sotelo", "Entre calle 1 y calle 2", "Plaza Toreo", "Movil", "5555555555", true);
	}

	public void login(String email, String pass) {
		login.login(email, pass);
	}

	public void selectProfileOption() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE);
	}

	public void selectMenuLogin() {
		general.selectMenuOption(ProfileMenuEnum.LOGIN);
	}

	public void selectRequestAddress() {
		general.selectMenuOption(ProfileMenuEnum.ADDRESS);
	}

	// botón cuenta nueva
	public void pressBtnAdd() {
		tapOnElement(NamesMobileElements.ADDRESS_BTNADD);
	}

	public void pressPlusAdd() {
		tapOnElement(NamesMobileElements.ADDRESS_PLUS_ADD);
	}

	public void pressBtnSave() {
		tapOnElement(NamesMobileElements.ADDRESS_BTN_SAVE);
	}

	public void addNewDirection(AddressVO addressVO) {
		logger.info("Escribiendo datos");
		randomAddressName(addressVO);
		waitElementVisibility(NamesMobileElements.ADDRESS_ADDRESS_NAME);
		fillElement(NamesMobileElements.ADDRESS_ADDRESS_NAME, addressVO.getAddressName());
		fillElement(NamesMobileElements.ADDRESS_NAME, addressVO.getAddressUserName());
		fillElement(NamesMobileElements.ADDRESS_LAST_NAME, addressVO.getAddressUserLastName());
		fillElement(NamesMobileElements.ADDRESS_STREET, addressVO.getAddressStreet());
		fillElement(NamesMobileElements.ADDRESS_OUTER_NUMBER, addressVO.getAddressOutNumber());
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
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.ADDRESS_REFERENCE_TWO);
		fillElement(NamesMobileElements.ADDRESS_REFERENCE_ONE, addressVO.getAddressReferenceOne());
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.ADDRESS_BTN_SAVE);
		fillElement(NamesMobileElements.ADDRESS_REFERENCE_TWO, addressVO.getAddressReferenceTwo());
		tapOnElement(NamesMobileElements.ADDRESS_PHONE);
		fillElement(NamesMobileElements.ADDRESS_PHONE, addressVO.getAddressPhone());
		selectAsMainAddress(addressVO.isMainAddress());
	}

	public void editAddress(AddressVO addressVO) {
		waitElementVisibility(NamesMobileElements.ADDRESS_LIST);
		if (elementExist(NamesMobileElements.ADDRESS_BTN_EDIT)) {
			tapOnElement(NamesMobileElements.ADDRESS_BTN_EDIT);
			addNewDirection(addressVO);
		} else {
			assertTrue("No hay direcciones que editar", Boolean.FALSE);
		}
		logger.info("Editando direccion");
	}

	private void randomAddressName(AddressVO addressVO) {
		Random generator = new Random();
		String newAddress = addressVO.getAddressName() + generator.nextInt(1000);
		addressVO.setAddressName(newAddress);
	}

	// @Step("Validate address")
	public void validateAddress(AddressVO addressVO, String validationMessage) {
		general.validatePopUpMessages(validationMessage);
		waitElementVisibility(NamesMobileElements.ADDRESS_LIST);
		MobileElement addressList = findElement(NamesMobileElements.ADDRESS_LIST);
		List<MobileElement> addressDetail = findSubElements(addressList, NamesMobileElements.ADDRESS_ADDRESS_NAME);
		if (addressVO.isMainAddress()) {
			assertEquals(addressVO.getAddressName().toLowerCase(), getElementText(addressDetail.get(0)));
		} else {
			assertTrue("La direccion no debe ser principal",
					!addressVO.getAddressName().toLowerCase().equals(getElementText(addressDetail.get(0))));
		}
		logger.info("Guardado exitoso");
	}

	// check address principal
	private void selectAsMainAddress(boolean check) {
		logger.info("Tap en checkbox de direccion principal");
		MobileElement checkMainAddress = findElement(NamesMobileElements.ADDRESS_CHECK);
		boolean checkMainAddressBool = checkMainAddress != null
				? Boolean.parseBoolean(checkMainAddress.getAttribute(GeneralConstants.CHECKED))
				: false;
		if (check && !checkMainAddressBool) {
			tapOnElement(NamesMobileElements.ADDRESS_CHECK);
		}
		if (!check && checkMainAddressBool) {
			tapOnElement(NamesMobileElements.ADDRESS_CHECK);
		}
	}

	// Validate screen your addresses with new account
	public void validateScreenYoursAddresses() {
		logger.info("Validate screen without addresses");
		waitElementVisibility(NamesMobileElements.ADDRESS_EMPTY_IMG);
		general.validatePopUpMessages(AppMessages.ADDRESS_EMPTY_MSG);
		waitElementVisibility(NamesMobileElements.ADDRESS_BTNADD);
	}

	// Validate Form
	public void validateFormAddAddress() {
		logger.info("Validate Form");
		waitElementVisibility(NamesMobileElements.ADDRESS_ADDRESS_NAME);
		waitElementVisibility(NamesMobileElements.ADDRESS_NAME);
		waitElementVisibility(NamesMobileElements.ADDRESS_LAST_NAME);
		waitElementVisibility(NamesMobileElements.ADDRESS_STREET);
		waitElementVisibility(NamesMobileElements.ADDRESS_OUTER_NUMBER);
		waitElementVisibility(NamesMobileElements.ADDRESS_INNER_NUMBER);
		waitElementVisibility(NamesMobileElements.ADDRESS_ZIP_CODE);
		waitElementVisibility(NamesMobileElements.ADDRESS_REFERENCE_ONE);
		waitElementVisibility(NamesMobileElements.ADDRESS_REFERENCE_TWO);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.ADDRESS_PHONE);
		waitElementVisibility(NamesMobileElements.ADDRESS_PHONE);
		waitElementVisibility(NamesMobileElements.ADDRESS_CHECK);
		waitElementVisibility(NamesMobileElements.ADDRESS_BTN_SAVE);
		logger.info("Complete the validation of the form");
	}

	// Validate error messages with fields empty
	public void validateFieldsEmpty() {
		logger.info("Validate error messages with fields empty");
		scrollUntilShowElement(GeneralConstants.SCROLL_DOWN, NamesMobileElements.ADDRESS_ADDRESS_NAME_CONT);
		general.validateFieldErrorMessage(AppMessages.EMPTY_FIELD, NamesMobileElements.ADDRESS_ADDRESS_NAME_CONT);
		general.validateFieldErrorMessage(AppMessages.EMPTY_FIELD, NamesMobileElements.ADDRESS_STREET_CONT);
		general.validateFieldErrorMessage(AppMessages.EMPTY_FIELD, NamesMobileElements.ADDRESS_OUTER_NUMBER_CONT);
		general.validateFieldErrorMessage(AppMessages.EMPTY_FIELD, NamesMobileElements.ADDRESS_ZIP_CODE_CONT);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.ADDRESS_PHONE_CONT);
		general.validateFieldErrorMessage(AppMessages.EMPTY_FIELD, NamesMobileElements.ADDRESS_PHONE_CONT);
		logger.info("Complete the validation of the form");
	}

	public void validateInvalidData() {
		logger.info("Validate invalid data form");
		scrollUntilShowElement(GeneralConstants.SCROLL_DOWN, NamesMobileElements.ADDRESS_ADDRESS_NAME_CONT);
		general.validateFieldErrorMessage(AppMessages.INVALID_FIELDS_ADDRESS,
				NamesMobileElements.ADDRESS_ADDRESS_NAME_CONT);
		general.validateFieldErrorMessage(AppMessages.INVALID_FIELDS_ADDRESS, NamesMobileElements.ADDRESS_NAME_CONT);
		general.validateFieldErrorMessage(AppMessages.INVALID_FIELDS_ADDRESS, NamesMobileElements.ADDRESS_STREET_CONT);
		general.validateFieldErrorMessage(AppMessages.INVALID_FIELDS_ADDRESS,
				NamesMobileElements.ADDRESS_OUTER_NUMBER_CONT);
		general.validateFieldErrorMessage(AppMessages.INVALID_NUM_ADDRESS,
				NamesMobileElements.ADDRESS_INNER_NUMBER_CONT);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.ADDRESS_PHONE_CONT);
		general.validateFieldErrorMessage(AppMessages.INVALID_PHONE_ADDRESS, NamesMobileElements.ADDRESS_PHONE_CONT);
		logger.info("Complete the validation of the form");
	}

	// Delete address
	public void removeAddress(AddressVO addressVO) {
		waitElementVisibility(NamesMobileElements.ADDRESS_LIST);
		if (elementExist(NamesMobileElements.ADDRESS_DESCRIPTION)) {
			List<MobileElement> deletes = findElements(NamesMobileElements.ADDRESS_BTN_DELETE);
			addressName = getElementText(findElements(NamesMobileElements.ADDRESS_BTN_DELETE).get(0));
			tapOnElement(deletes.get(0));
			waitElementVisibility(NamesMobileElements.ADDRESS_DIALOG_DELETE);
			tapOnElement(NamesMobileElements.ADDRESS_DIALOG_BTNDELETE);
			logger.info("Eliminando direccion");
		} else {
			randomAddressName(addressVO);
			pressPlusAdd();
			addNewDirection(addressVO);
			selectAsMainAddress(false);
			pressBtnSave();
			validateAddress(addressVO, AppMessages.ADD_ADDRESS);
			removeAddress(addressVO);
		}
	}

	public void validateRemoveAddress() {
		general.validatePopUpMessages(AppMessages.DELETE_ADDRESS);
		waitEvent();
		List<MobileElement> address = findElements(NamesMobileElements.ADDRESS_BTN_DELETE);
		String actualAddress = getElementText(address.get(0));
		assertTrue("No se eliminó la dirección", !addressName.equals(actualAddress));
	}

}
