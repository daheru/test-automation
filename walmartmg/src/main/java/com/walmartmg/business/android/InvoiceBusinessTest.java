package com.walmartmg.business.android;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.AppMessages;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.ProfileMenuEnum;
import com.walmartmg.enums.NavigationBarEnum;

public class InvoiceBusinessTest extends BaseDriver {
	
	public static final Logger logger = Logger.getLogger( InvoiceBusinessTest.class );
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	
	
	public void selectProfileOption() {
		generalBusinessTest.selectNavigationOption( NavigationBarEnum.PROFILE.getNavigation() );
	}
	
	public void selectRequestInvoice() {
		generalBusinessTest.selectProfileMenu(ProfileMenuEnum.GET_BILL.getMenu() );
	}
	
	
	public void validateElements() {
		closeAndroidDialog();
		waitElementVisibility(NamesMobileElements.INVOICE_TITLE);
		waitElementVisibility(NamesMobileElements.INVOICE_TEXT);
		waitElementVisibility(NamesMobileElements.INVOICE_SCAN);
		waitElementVisibility(NamesMobileElements.INVOICE_LINK);
		logger.info("Termina validación");
	}
	
	
	public void validateCodeInvoice(String code) {
		closeAndroidDialog();
		tapOnElement(NamesMobileElements.INVOICE_LINK);
		waitElementVisibility(NamesMobileElements.INV_MANUAL_NUM_INVOICE);
		fillElement(NamesMobileElements.INV_MANUAL_NUM_INVOICE, code);
		tapOnElement(NamesMobileElements.INV_MANUAL_BUTTON);
	}
	
	public void validateMessageEmpty(){
		logger.info("Valida campo vacio");
		generalBusinessTest.validateFieldErrorMessage(AppMessages.EMPTY_FIELD, NamesMobileElements.INV_MANUAL_NUM_INVOICE_CONT);
	}
	
	public void validateMessageError() {
		logger.info("Valida alerta");
		generalBusinessTest.validatePopUpMessages(AppMessages.INVOICE_INVALID_CODE);
	}
	
	
}
