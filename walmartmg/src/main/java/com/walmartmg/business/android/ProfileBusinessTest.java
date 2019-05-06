package com.walmartmg.business.android;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.AppMessages;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.enums.ProfileMenuEnum;

public class ProfileBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(InvoiceBusinessTest.class);
	private GeneralBusinessTest general = new GeneralBusinessTest();
	private static LoginBusinessTest login = new LoginBusinessTest();

	public void selectProfileOption() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE);
	}

	public void selectMenuLogin() {
		general.selectMenuOption(ProfileMenuEnum.LOGIN);
	}

	public void selectRequestMyProfile() {
		general.selectMenuOption(ProfileMenuEnum.PROFILE);
	}

	public void login(String email, String password) {
		login.login(email, password);
	}

	public void validateScreenMyPorfile() {
		logger.info("Validar pantalla");
		waitElementVisibility(NamesMobileElements.MYPROFILE_PERSONAL_DETAILS_CONT);
		waitElementVisibility(NamesMobileElements.MYPROFILE_PERSONAL_DETAILS_LINKEDIT);
		waitElementVisibility(NamesMobileElements.MYPROFILE_LOGIN_DATA_CONT);
		waitElementVisibility(NamesMobileElements.MYPROFILE_LOGIN_DATA_LINKEDIT);
		waitElementVisibility(NamesMobileElements.MYPROFILE_PHONE_INFO_CONT);
		waitElementVisibility(NamesMobileElements.MYPROFILE_PHONE_INFO_LINKEDIT);

	}

	public void validateScreenPersonalDetails() {
		tapOnElement(NamesMobileElements.MYPROFILE_PERSONAL_DETAILS_LINKEDIT);
		waitElementVisibility(NamesMobileElements.PERSONAL_DETAILS_NAMELABEL);
		waitElementVisibility(NamesMobileElements.PERSONAL_DETAILS_NAMEFIELD);
		waitElementVisibility(NamesMobileElements.PERSONAL_DETAILS_LASTNAMELABEL);
		waitElementVisibility(NamesMobileElements.PERSONAL_DETAILS_LASTNAMEFIELD);
		waitElementVisibility(NamesMobileElements.PERSONAL_DETAILS_BIRTHDATELABEL);
		waitElementVisibility(NamesMobileElements.PERSONAL_DETAILS_BIRTHDATEFIELD);
		waitElementVisibility(NamesMobileElements.PERSONAL_DETAILS_BTNUPDATE);

	}

	public void enterDataPersonalDetails(String name, String lastname, String bornDate) {
		tapOnElement(NamesMobileElements.MYPROFILE_PERSONAL_DETAILS_LINKEDIT);
		fillElement(NamesMobileElements.PERSONAL_DETAILS_NAMEFIELD, name);
		fillElement(NamesMobileElements.PERSONAL_DETAILS_LASTNAMEFIELD, lastname);
		fillElement(NamesMobileElements.PERSONAL_DETAILS_BIRTHDATEFIELD, bornDate);
		tapOnElement(NamesMobileElements.PERSONAL_DETAILS_BTNUPDATE);
	}

	public void validateMessageAlert() {
		logger.info("Valida alerta");
		general.validatePopUpMessages(AppMessages.INVALID_AGE);
	}

	public void validateMessageUpdate() {
		logger.info("Valida alerta");
		general.validatePopUpMessages(AppMessages.UPDATE_PERSONAL_DETAIL);
	}

	public void validateScreenLogonData() {
		tapOnElement(NamesMobileElements.MYPROFILE_LOGIN_DATA_LINKEDIT);
		waitElementVisibility(NamesMobileElements.LOGON_DATA_CONT);
		waitElementVisibility(NamesMobileElements.LOGON_DATA_EMAIL);
		waitElementVisibility(NamesMobileElements.LOGON_DATA_CURRENT_PASSWORD);
		waitElementVisibility(NamesMobileElements.LOGON_DATA_NEW_PASSSWORD);
		waitElementVisibility(NamesMobileElements.LOGON_DATA_BTNUPDATE);
	}

	public void emptyFieldLogonData() {
		tapOnElement(NamesMobileElements.MYPROFILE_LOGIN_DATA_LINKEDIT);
		logger.info("Push botton update");
		tapOnElement(NamesMobileElements.LOGON_DATA_BTNUPDATE);
	}

	public void validateMessagePassword(String currentPass, String newPass) {
		logger.info("Verificando mensajes de validacion");
		if (currentPass.isEmpty()) {
			general.validateFieldErrorMessage(AppMessages.NO_PASS, NamesMobileElements.LOGON_DATA_CURRENT_PASSWORD);
		} else if (newPass.isEmpty()) {
			general.validateFieldErrorMessage(AppMessages.NO_PASS, NamesMobileElements.LOGON_DATA_NEW_PASSSWORD);
		}
	}

	public void enterDataLogonData(String currentPass, String newPass) {
		tapOnElement(NamesMobileElements.MYPROFILE_LOGIN_DATA_LINKEDIT);
		logger.info("ingresar datos invalidos");
		fillElement(NamesMobileElements.LOGON_DATA_CURRENT_PASSWORD, currentPass);
		fillElement(NamesMobileElements.LOGON_DATA_NEW_PASSSWORD, newPass);
		tapOnElement(NamesMobileElements.LOGON_DATA_BTNUPDATE);
	}

	public void validateMessageInvalidLogon() {
		logger.info("Valida alerta");
		general.validatePopUpMessages(AppMessages.INVALID_DATA_PASSWORD);
	}

	public void validateScreenPhoneInf() {
		tapOnElement(NamesMobileElements.MYPROFILE_PHONE_INFO_LINKEDIT);
		waitElementVisibility(NamesMobileElements.PHONE_INFO_CONT);
		waitElementVisibility(NamesMobileElements.PHONE_INFO_SPINNER_PRIMARY);
		waitElementVisibility(NamesMobileElements.PHONE_INFO_PRIMARY_FIELD);
		logger.info("valida movil");
		tapOnElement(NamesMobileElements.PHONE_INFO_SPINNER_PRIMARY);
		tapOnElement(findElements(NamesMobileElements.PHONE_INFO_COMBO).get(1));
		waitElementVisibility(NamesMobileElements.PHONE_INFO_PRIMARY_FIELD);
		waitElementVisibility(NamesMobileElements.PHONE_INFO_PRIMARY_EXT);
		logger.info("valida fijo");
		waitElementVisibility(NamesMobileElements.PHONE_INFO_ADD_LINK);
		tapOnElement(NamesMobileElements.PHONE_INFO_ADD_LINK);
		waitElementVisibility(NamesMobileElements.PHONE_INFO_SPINNER_SECONDARY);
		tapOnElement(NamesMobileElements.PHONE_INFO_SPINNER_SECONDARY);
		tapOnElement(findElements(NamesMobileElements.PHONE_INFO_COMBO).get(0));
		waitElementVisibility(NamesMobileElements.PHONE_INFO_SECONDARY_FIELD);
		tapOnElement(NamesMobileElements.PHONE_INFO_SPINNER_SECONDARY);
		tapOnElement(findElements(NamesMobileElements.PHONE_INFO_COMBO).get(1));
		waitElementVisibility(NamesMobileElements.PHONE_INFO_SECONDARY_FIELD);
		waitElementVisibility(NamesMobileElements.PHONE_INFO_SECONDARY_EXT);
		waitElementVisibility(NamesMobileElements.PHONE_INFO_BTNUPDATE);
	}

	public void enterPhoneValid(String movil, String fijo, String ext) {
		tapOnElement(NamesMobileElements.MYPROFILE_PHONE_INFO_LINKEDIT);
		fillElement(NamesMobileElements.PHONE_INFO_PRIMARY_FIELD, movil);
		tapOnElement(NamesMobileElements.PHONE_INFO_ADD_LINK);
		tapOnElement(NamesMobileElements.PHONE_INFO_SPINNER_SECONDARY);
		tapOnElement(findElements(NamesMobileElements.PHONE_INFO_COMBO).get(1));
		fillElement(NamesMobileElements.PHONE_INFO_SECONDARY_FIELD, fijo);
		fillElement(NamesMobileElements.PHONE_INFO_SECONDARY_EXT, ext);
		tapOnElement(NamesMobileElements.PHONE_INFO_BTNUPDATE);
		general.validatePopUpMessages(AppMessages.UPDATE_PERSONAL_DETAIL);
	}

	public void selectProfile() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE);
	}
}
