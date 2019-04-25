package com.walmartmg.business.android;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.AppMessages;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.enums.ProfileMenuEnum;

import io.qameta.allure.Step;

public class InvoiceBusinessTest extends BaseDriver {

	public static final Logger logger = Logger.getLogger(InvoiceBusinessTest.class);
	public GeneralBusinessTest general = new GeneralBusinessTest();
	public static LoginBusinessTest login = new LoginBusinessTest();
	private String email;

	public void selectProfileOption() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE);
	}

	public void selectMenuLogin() {
		general.selectProfileMenu(ProfileMenuEnum.LOGIN);
	}

	public void selectRequestInvoice() {
		general.selectProfileMenu(ProfileMenuEnum.GET_BILL);
	}

	public void selectRequestMyProfile() {
		general.selectProfileMenu(ProfileMenuEnum.GET_BILL);
	}

	// Login
	public void login(String email, String password) {
		this.email = email;
		fillElement(NamesMobileElements.LOGIN_EMAIL, email);
		fillElement(NamesMobileElements.LOGIN_PASS, password);
		tapOnElement(NamesMobileElements.LOGIN_BUTTON);
		validateLoginErrors(email, password);
	}

	private void validateLoginErrors(String email, String password) {
		logger.info("Verificando mensajes de validacion");
		if (email.isEmpty()) {
			general.validateFieldErrorMessage(AppMessages.NO_EMAIL, NamesMobileElements.LOGIN_EMAIL_CONT);
		} else if (password.isEmpty()) {
			general.validateFieldErrorMessage(AppMessages.NO_PASS, NamesMobileElements.LOGIN_PASS_CONT);
		}
	}

	@Step("Validate invoice page")
	public void validateElements() {
		closeAndroidDialog();
		waitElementVisibility(NamesMobileElements.INVOICE_TITLE);
		waitElementVisibility(NamesMobileElements.INVOICE_TEXT);
		waitElementVisibility(NamesMobileElements.INVOICE_SCAN);
		waitElementVisibility(NamesMobileElements.INVOICE_LINK);
		logger.info("Termina validación");
	}

	@Step("Validate invoice code")
	public void validateCodeInvoice(String code) {
		closeAndroidDialog();
		tapOnElement(NamesMobileElements.INVOICE_LINK);
		waitElementVisibility(NamesMobileElements.INV_MANUAL_NUM_INVOICE);
		fillElement(NamesMobileElements.INV_MANUAL_NUM_INVOICE, code);
		tapOnElement(NamesMobileElements.INV_MANUAL_BUTTON);
	}

	public void validateMessageEmpty() {
		logger.info("Valida campo vacio");
		general.validateFieldErrorMessage(AppMessages.EMPTY_FIELD, NamesMobileElements.INV_MANUAL_NUM_INVOICE_CONT);
	}

	public void validateMessageError() {
		logger.info("Valida alerta");
		general.validatePopUpMessages(AppMessages.INVOICE_INVALID_CODE);
	}
}