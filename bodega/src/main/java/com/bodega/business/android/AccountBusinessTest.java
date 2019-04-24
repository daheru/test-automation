package com.bodega.business.android;

import org.apache.log4j.Logger;

import com.bodega.base.BaseDriver;
import com.bodega.constants.AppMessages;
import com.bodega.constants.GeneralConstants;
import com.bodega.constants.NamesMobileElements;
import com.bodega.enums.ProfileMenuEnum;

public class AccountBusinessTest extends BaseDriver {

	public static final Logger logger = Logger.getLogger( AccountBusinessTest.class );
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	
	public void selectProfileOption() {
		generalBusinessTest.selectProfile();
	}
	
	public void selectCreateAccount() {
		generalBusinessTest.selectMenuOption( ProfileMenuEnum.CREATE_PROFILE );
	}
	
	public void validateWelcomePage() {
		generalBusinessTest.validateWelcomePage();
	}
	
	public void validateElements() {
		logger.info("Validando account page");
		waitElementVisibility( NamesMobileElements.ACCOUNT_NAME_CONT );
		waitElementVisibility( NamesMobileElements.ACCOUNT_LASTNAME_CONT );
		waitElementVisibility( NamesMobileElements.ACCOUNT_EMAIL_CONT );
		waitElementVisibility( NamesMobileElements.ACCOUNT_PASS_CONT );
		waitElementVisibility( NamesMobileElements.ACCOUNT_CREATE_BUTTON );
	}
	
	public void createAccount( String name, String lastname, String email, String pass ) {
		logger.info("Creando cuenta");
		fillElement( NamesMobileElements.ACCOUNT_NAME_TEXT, name);
		fillElement( NamesMobileElements.ACCOUNT_LASTNAME_TEXT, lastname);
		fillElement( NamesMobileElements.ACCOUNT_EMAIL_TEXT, email);
		generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_UP, NamesMobileElements.ACCOUNT_CREATE_BUTTON );
		fillElement( NamesMobileElements.ACCOUNT_PASS_TEXT, pass);
		tapOnElement( NamesMobileElements.ACCOUNT_CREATE_BUTTON );
		hideKeyboard();
	}
	
	public void validateEmptyFields() {
		logger.info("Validando mensajes de error");
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.ACCOUNT_NAME_CONT);
		generalBusinessTest.validateFieldErrorMessage( AppMessages.EMPTY_FIELD, NamesMobileElements.ACCOUNT_NAME_CONT);
		generalBusinessTest.validateFieldErrorMessage( AppMessages.EMPTY_FIELD, NamesMobileElements.ACCOUNT_LASTNAME_CONT);
		generalBusinessTest.validateFieldErrorMessage( AppMessages.EMPTY_FIELD, NamesMobileElements.ACCOUNT_EMAIL_CONT);
		generalBusinessTest.validateFieldErrorMessage( AppMessages.EMPTY_FIELD, NamesMobileElements.ACCOUNT_PASS_CONT);
	}
	
	public void validateInvalidData() {
		logger.info("Validando mensajes de error");
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.ACCOUNT_NAME_CONT);
		generalBusinessTest.validateFieldErrorMessage( AppMessages.INVALID_ACCOUNT_NAME, NamesMobileElements.ACCOUNT_NAME_CONT);
		generalBusinessTest.validateFieldErrorMessage( AppMessages.INVALID_ACCOUNT_LAST_NAME, NamesMobileElements.ACCOUNT_LASTNAME_CONT);
		generalBusinessTest.validateFieldErrorMessage( AppMessages.INVALID_ACCOUNT_EMAIL, NamesMobileElements.ACCOUNT_EMAIL_CONT);
		generalBusinessTest.validateFieldErrorMessage( AppMessages.INVALID_ACCOUNT_PASS, NamesMobileElements.ACCOUNT_PASS_CONT); 
	}
	
	public void validateExistEmail() {
		logger.info("Validando mensajes emergente");
		generalBusinessTest.validatePopUpMessages( AppMessages.ACCOUNT_EXIST_EMAIL ); 
	}
	
	public void validateCreateAccount() {
		logger.info("Validando cuenta creada");
		generalBusinessTest.validatePopUpMessages( AppMessages.CREATE_ACCOUNT_SUCCESS );
		selectProfileOption();
		generalBusinessTest.selectMenuOption( ProfileMenuEnum.PROFILE );
	}
}
