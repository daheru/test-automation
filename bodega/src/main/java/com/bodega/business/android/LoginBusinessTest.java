package com.bodega.business.android;

import org.apache.log4j.Logger;

import com.bodega.constants.AppMessages;
import com.bodega.constants.NamesMobileElements;
import com.bodega.enums.MenuOptionsEnum;
import com.bodega.util.BaseDriver;

import io.appium.java_client.MobileElement;

public class LoginBusinessTest extends BaseDriver {
	
	private static final Logger logger = Logger.getLogger( LoginBusinessTest.class );
	private GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	private HomeBusinessTest homePage = new HomeBusinessTest();
	private String email = "";
	private String password = "";
	
	public LoginBusinessTest() {
		cleanData();
	}
	
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
		generalBusinessTest.initAsGuess();
		waitElementVisibility( NamesMobileElements.HOME_PROFILE );
		generalBusinessTest.selectProfile();
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.LOGIN.getMenu() );
		logger.info("Tap en Login");
	}
	
	public void login( String email, String pass ) {
		this.email = email;
		this.password = pass;
		fillElement( NamesMobileElements.LOGIN_EMAIL_TEXT , email);
		fillElement( NamesMobileElements.LOGIN_PASS_TEXT , pass);
		tapOnElement( NamesMobileElements.LOGIN_LOGIN_BUTTON );
		logger.info("Escribiendo email y password");
	}
	
	public void fillPassword( String pass ) {
		this.password = pass;
		fillElement( NamesMobileElements.LOGIN_PASS_TEXT , pass);
		logger.info("Escribiendo password");
	}
	
	public void validateLogin( ) {
		generalBusinessTest.selectProfile();
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.PROFILE.getMenu() );
		MobileElement profileEmail = findElement( NamesMobileElements.PROFILE_EMAIL );
	    assertEquals( getElementText(profileEmail) , email);
	    cleanData();
	    logger.info("Login válido");
	}
	
	public void selectCreateAccount() {
		tapOnElement( NamesMobileElements.LOGIN_CREATE_LINK );
		logger.info("Tap en Registrarse");
	}
	
	public void createAccount( String name, String lastName, String email, String pass ) {
		fillElement( NamesMobileElements.REG_NAME_TEXT , name);
		fillElement( NamesMobileElements.REG_LAST_NAME_TEXT, lastName );
		fillElement( NamesMobileElements.REG_EMAIL_TEXT, email );
		fillElement( NamesMobileElements.REG_PASS_TEXT, pass );
		//tapOnElement( NamesMobileElements.REG_CREATE_BUTTON );
		logger.info("Escribiendo nombre, apellido, correo y password");
	}
	
	public void validateRegisterPage() {
		waitElementVisibility(NamesMobileElements.REG_NAME_TEXT);
		waitElementVisibility(NamesMobileElements.REG_LAST_NAME_TEXT);
		waitElementVisibility(NamesMobileElements.REG_EMAIL_TEXT);
		waitElementVisibility(NamesMobileElements.REG_PASS_TEXT);
		waitElementVisibility(NamesMobileElements.REG_PUBLICY_CHECK);
		waitElementVisibility(NamesMobileElements.REG_TERMS_LINK);
		waitElementVisibility(NamesMobileElements.REG_CREATE_BUTTON);
		logger.info("Página válida");
	}
	
	public void selectPassRecovery(String email) {
		fillElement( NamesMobileElements.LOGIN_EMAIL_TEXT, email );
		logger.info("Escribiendo correo");
		tapOnElement( NamesMobileElements.LOGIN_FORGOT_PASS_LINK );
		logger.info("Tap en Olvidaste tu contraseña");
		generalBusinessTest.validatePopUpMessages( AppMessages.PASSWORD_RECOVERY );
	}
	
	public void validateErrorMessages(String message, String element) {
		generalBusinessTest.validateFieldErrorMessage( message, element);
		logger.info("Mensajes de error válidos");
	}
	
	public void validatePopUpMessage( String message ) {
		generalBusinessTest.validatePopUpMessages( message );
	}
	
	public void validateHomePage() {
		homePage.validateHomePage();
		logger.info("Página válida");
	}
	
	public void selectShowPassword() {
		tapOnElement( NamesMobileElements.LOGIN_SHOW_PASS_BUTTON );
		logger.info("Tap en mostrar password");
	}
	
	public void validatePassword() {
		assertEquals(password, getElementText(NamesMobileElements.LOGIN_PASS_TEXT));
		logger.info("Password valido");
		cleanData();
	}
	
	private void cleanData() {
		email = "";
	    password = "";
	}
}
