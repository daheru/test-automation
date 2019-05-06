package com.walmartmg.business.android;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.AppMessages;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.enums.ProfileMenuEnum;

import io.qameta.allure.Step;

public class InvoiceBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(InvoiceBusinessTest.class);
	private GeneralBusinessTest general = new GeneralBusinessTest();
	private static LoginBusinessTest login = new LoginBusinessTest();

	public void selectProfileOption() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE);
	}

	public void selectMenuLogin() {
		general.selectMenuOption(ProfileMenuEnum.LOGIN);
	}

	public void selectRequestInvoice() {
		general.selectMenuOption(ProfileMenuEnum.GET_BILL);
	}

	public void login(String email, String password) {
		login.login(email, password);
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

	@Step("Validate invoice empty field")
	public void validateMessageEmpty() {
		logger.info("Valida campo vacio");
		general.validateFieldErrorMessage(AppMessages.EMPTY_FIELD, NamesMobileElements.INV_MANUAL_NUM_INVOICE_CONT);
	}

	@Step("Validate invoice invalid data")
	public void validateMessageError() {
		logger.info("Valida alerta");
		general.validatePopUpMessages(AppMessages.INVOICE_INVALID_CODE);
	}
}