package com.bodega.business.android;

import java.util.List;

import org.apache.log4j.Logger;

import com.bodega.base.BaseDriver;
import com.bodega.constants.AppMessages;
import com.bodega.constants.GeneralConstants;
import com.bodega.constants.NamesMobileElements;
import com.bodega.enums.ProfileMenuEnum;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class ProfileBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(MenuBusinessTest.class);
	private GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	private LoginBusinessTest login = new LoginBusinessTest();

	public void login(String email, String pass) {
		login.login(email, pass);
	}

	public void selectProfile() {
		logger.info("Tap en perfil");
		generalBusinessTest.selectProfile();
	}

	public void selectMenu(ProfileMenuEnum menu) {
		generalBusinessTest.selectMenuOption(menu);
	}

	@Step("Validar profile")
	public void validatePersonalDataPage() {
		logger.info("Validando profile page");
		waitElementVisibility(NamesMobileElements.MYPROFILE_USER_NAME);
		waitElementVisibility(NamesMobileElements.MYPROFILE_USER_LAST_NAME);
		waitElementVisibility(NamesMobileElements.MYPROFILE_USER_BIRTHDATE);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.MYPROFILE_BUTTON_PROFILE_SAVE);
		waitElementVisibility(NamesMobileElements.MYPROFILE_BUTTON_WOMAN);
		waitElementVisibility(NamesMobileElements.MYPROFILE_BUTTON_MAN);
		waitElementVisibility(NamesMobileElements.MYPROFILE_CHECKBOX_PROFILE);
		waitElementVisibility(NamesMobileElements.MYPROFILE_BUTTON_WOMAN);
		waitElementVisibility(NamesMobileElements.MYPROFILE_BUTTON_PROFILE_SAVE);
	}

	@Step("Editar perfil: {name}, {lastName}, {birthday}, {sex}")
	public void editProfile(String name, String lastName, String birthday, String sex) {
		logger.info("Editando perfil");
		tapOnElement(NamesMobileElements.MYPROFILE_EDIT_PROFILE);
		waitElementVisibility(NamesMobileElements.MYPROFILE_USER_NAME);
		fillElement(NamesMobileElements.MYPROFILE_USER_NAME, name);
		fillElement(NamesMobileElements.MYPROFILE_USER_LAST_NAME, lastName);
		tapOnElement(NamesMobileElements.MYPROFILE_USER_BIRTHDATE);
		fillElement(NamesMobileElements.MYPROFILE_USER_BIRTHDATE, birthday);
		hideKeyboard();
		if (sex.equals("H")) {
			tapOnElement(NamesMobileElements.MYPROFILE_BUTTON_MAN);
		} else {
			tapOnElement(NamesMobileElements.MYPROFILE_BUTTON_WOMAN);
		}
		tapOnElement(NamesMobileElements.MYPROFILE_CHECKBOX_PROFILE);
	}

	@Step("Guardar perfil")
	public void saveProfile() {
		logger.info("Tap on actualizar");
		tapOnElement(NamesMobileElements.MYPROFILE_BUTTON_PROFILE_SAVE);
	}

	@Step("Editar password: {oldpass}, {newpass}")
	public void editPassword(String oldpass, String newpass) {
		logger.info("Editando password");
		tapOnElement(NamesMobileElements.MYPROFILE_EDIT_PASSWORD);
		waitElementVisibility(NamesMobileElements.MYPROFILE_BUTTON_PROFILE_SAVE);
		fillElement(NamesMobileElements.MYPROFILE_OLD_PASSWORD, oldpass);
		fillElement(NamesMobileElements.MYPROFILE_NEW_PASSWORD, newpass);
	}

	@Step("Guardar password")
	public void savePassword() {
		logger.info("Tap on Guardar");
		tapOnElement(NamesMobileElements.MYPROFILE_BUTTON_PROFILE_SAVE);
	}

	@Step("Editar telefono: {isPrimary}, {isValid}, {type}")
	public void editPhone(boolean isPrimary, boolean isValid, String type) {
		logger.info("Editando telefono");
		tapOnElement(NamesMobileElements.MYPROFILE_EDIT_PHONE);
		waitElementVisibility(NamesMobileElements.MYPROFILE_BUTTON_PHONE_SAVE);
		String extension = "";
		if (isPrimary) {
			fillElement(NamesMobileElements.MYPROFILE_PHONE_PRIMARY, isValid ? generalBusinessTest.randomString(10, false, true) : "123");
			tapOnElement(NamesMobileElements.MYPROFILE_SPINNER_PRIMARY_BUTTON);
			extension = NamesMobileElements.MYPROFILE_PHONE_PRIMARY_EXT;
		} else {
			fillElement(NamesMobileElements.MYPROFILE_PHONE_SECONDARY, isValid ? generalBusinessTest.randomString(10, false, true) : "123");
			tapOnElement(NamesMobileElements.MYPROFILE_SPINNER_SECUNDARY_BUTTON);
			extension = NamesMobileElements.MYPROFILE_PHONE_SECONDARY_EXT;
		}
		List<MobileElement> options = findElements(NamesMobileElements.COMBO_OPTIONS);
		for (MobileElement option : options) {
			if (type.equals(getElementText(option))) {
				tapOnElement(option);
				if (GeneralConstants.FIJO.equals(type)) {
					fillElement(extension, generalBusinessTest.randomString(5, false, true));
				}
				break;
			}
		}
	}

	@Step("Guardar telefono")
	public void savePhone() {
		logger.info("Tap on guardar");
		tapOnElement(NamesMobileElements.MYPROFILE_BUTTON_PHONE_SAVE);
	}

	@Step("Validar actualizacion perfil")
	public void validateProfileUpdate() {
		logger.info("Validando edicion de perfil");
		generalBusinessTest.validatePopUpMessages(AppMessages.UPDATE_PROFILE);
		waitElementVisibility(NamesMobileElements.MYPROFILE_EDIT_PROFILE);
	}

	@Step("Validar actualizacion telefonica")
	public void validatePhoneUpdate() {
		logger.info("Validando actualizacion telefonica");
		generalBusinessTest.validatePopUpMessages(AppMessages.UPDATE_PROFILE);
		waitElementVisibility(NamesMobileElements.MYPROFILE_EDIT_PROFILE);
	}

	@Step("Validar datos incorrectos")
	public void validateInvalidData() {
		logger.info("Validando informacion invalida");
		generalBusinessTest.validatePopUpMessages(AppMessages.MYPROFILE_INVALID_DATA);
		validatePersonalDataPage();
	}

	@Step("Validar datos incorrectos")
	public void validateAge() {
		logger.info("Validando informacion incorrecta");
		generalBusinessTest.validatePopUpMessages(AppMessages.INVALID_AGE);
		validatePersonalDataPage();
	}

	@Step("Validar actualizacion password")
	public void validatePasswordChange() {
		logger.info("Validando cambio de password");
		generalBusinessTest.validatePopUpMessages(AppMessages.UPDATE_PROFILE);
		waitElementVisibility(NamesMobileElements.MYPROFILE_EDIT_PROFILE);
	}

	@Step("Validar password incorrecto")
	public void validateInvalidPasswordChange() {
		logger.info("Validando password incorrecto");
		generalBusinessTest.validatePopUpMessages(AppMessages.MYPROFILE_INVALID_DATA);
		waitElementVisibility(NamesMobileElements.MYPROFILE_BUTTON_PROFILE_SAVE);
	}

	@Step("Validar mismo password")
	public void validateSamePasswordChange() {
		logger.info("Validando mismo password");
		generalBusinessTest.validatePopUpMessages(AppMessages.SAME_PASSWORD);
		waitElementVisibility(NamesMobileElements.MYPROFILE_BUTTON_PROFILE_SAVE);
	}

	@Step("Validar telefono vacio")
	public void validateEmptyPhone() {
		logger.info("Validando telefono vacio");
		generalBusinessTest.validatePopUpMessages(AppMessages.MYPROFILE_INVALID_DATA);
		waitElementVisibility(NamesMobileElements.MYPROFILE_BUTTON_PHONE_SAVE);
	}

	@Step("Validar telefono incorrecto")
	public void validateInvalidPhone() {
		logger.info("Validando telefono incorrecto");
		generalBusinessTest.validatePopUpMessages(AppMessages.MYPROFILE_INVALID_DATA);
		waitElementVisibility(NamesMobileElements.MYPROFILE_BUTTON_PHONE_SAVE);
	}

	public void editPhone() {
		tapOnElement(NamesMobileElements.MYPROFILE_EDIT_PHONE);
		fillElement(NamesMobileElements.MYPROFILE_PHONE_PRIMARY, "");
		fillElement(NamesMobileElements.MYPROFILE_PHONE_SECONDARY, "");
	}
}