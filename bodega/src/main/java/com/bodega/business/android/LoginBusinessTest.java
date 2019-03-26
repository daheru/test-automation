package com.bodega.business.android;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.bodega.constants.AppMessages;
import com.bodega.constants.NamesMobileElements;
import com.bodega.constants.ConfigConstants;
import com.bodega.enums.MenuOptionsEnum;
import com.bodega.util.BaseDriver;

import io.appium.java_client.MobileElement;

public class LoginBusinessTest extends BaseDriver {
	
	private static final Logger logger = Logger.getLogger( LoginBusinessTest.class );
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	public HomeBusinessTest homePage = new HomeBusinessTest();
	
	public void selectProfile() {
		generalBusinessTest.selectProfile();
	}
	
	public void selectMenuOption( String option ) {
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.LOGIN.getMenu() );
	}
	
	public void initAsGuess() {
		generalBusinessTest.initAsGuess();
	}
	
	public void goToLogin() {
		logger.info("Tap en Login");
		generalBusinessTest.initAsGuess();
		waitVisibility( NamesMobileElements.HOME_PROFILE );
		generalBusinessTest.selectProfile();
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.LOGIN.getMenu() );
	}
	
	public void login( String email, String pass ) {
		logger.info("Escribiendo email y password");
		fillElement( NamesMobileElements.LOGIN_EMAIL_TEXT , email);
		fillElement( NamesMobileElements.LOGIN_PASS_TEXT , pass);
		tapOnElement( NamesMobileElements.LOGIN_LOGIN_BUTTON );
	}
	
	public void validateLogin(String email) {
		logger.info("Validando login");
		generalBusinessTest.selectProfile();
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.PROFILE.getMenu() );
		MobileElement profileEmail = findElement( NamesMobileElements.PROFILE_EMAIL );
		Assert.assertEquals( profileEmail.getAttribute( ConfigConstants.ATTRIBUTE_TEXT ) , email);
		
	}
	
	public void selectCreateAccount() {
		logger.info("Tap en Registrarse");
		tapOnElement( NamesMobileElements.LOGIN_CREATE_LINK );
	}
	
	public void createAccount( String name, String lastName, String email, String pass ) {
		logger.info("Escribiendo nombre, apellido, correo y password");
		fillElement( NamesMobileElements.REG_NAME_TEXT , name);
		fillElement( NamesMobileElements.REG_LAST_NAME_TEXT, lastName );
		fillElement( NamesMobileElements.REG_EMAIL_TEXT, email );
		fillElement( NamesMobileElements.REG_PASS_TEXT, pass );
		//tapOnElement( MobileNamesConstants.REG_CREATE_BUTTON );
	}
	
	public void selectPassRecovery(String email) {
		logger.info("Escribiendo correo");
		fillElement( NamesMobileElements.LOGIN_EMAIL_TEXT, email );
		logger.info("Tap en Olvidaste tu contraseña");
		tapOnElement( NamesMobileElements.LOGIN_FORGOT_PASS_LINK );
		generalBusinessTest.validatePopUpMessages( AppMessages.PASSWORD_RECOVERY );
	}
	
	public void validateErrorMessage() {
		logger.info("Validando mensajes de error");
		generalBusinessTest.validateErrorMessages();
	}
	
	public void validateHomePage() {
		homePage.validateHomePage();
	}
	
}
