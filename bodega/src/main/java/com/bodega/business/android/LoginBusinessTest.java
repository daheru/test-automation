package com.bodega.business.android;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.bodega.commons.MenuOptionsEnum;
import com.bodega.commons.MobileNamesConstants;
import com.bodega.commons.PropertiesConstants;
import com.bodega.util.BaseDriver;

import io.appium.java_client.MobileElement;

public class LoginBusinessTest extends BaseDriver {
	
	private static final Logger logger = Logger.getLogger( LoginBusinessTest.class );
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	
	
	public void goToLogin() {
		logger.info("Ingresando a Login");
		generalBusinessTest.initAsGuess();
		waitVisibility( MobileNamesConstants.HOME_PROFILE );
		generalBusinessTest.selectProfile();
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.LOGIN.getMenu() );
	}
	
	public void login( String email, String pass ) {
		logger.info("Escribiendo email y password");
		fillElement( MobileNamesConstants.LOGIN_EMAIL_TEXT , email);
		fillElement( MobileNamesConstants.LOGIN_PASS_TEXT , pass);
		tapOnElement( MobileNamesConstants.LOGIN_LOGIN_BUTTON );
	}
	
	public void validateLogin(String email) {
		logger.info("Validando login");
		generalBusinessTest.selectProfile();
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.PROFILE.getMenu() );
		MobileElement profileEmail = findElement( MobileNamesConstants.PROFILE_EMAIL );
		Assert.assertEquals( profileEmail.getAttribute( PropertiesConstants.ATTRIBUTE_TEXT ) , email);
		
	}
	
	public void selectCreateAccount() {
		tapOnElement( MobileNamesConstants.LOGIN_CREATE_LINK );
	}
	
	public void createAccount( String name, String lastName, String email, String pass ) {
		fillElement( MobileNamesConstants.REG_NAME_TEXT , name);
		fillElement( MobileNamesConstants.REG_LAST_NAME_TEXT, lastName );
		fillElement( MobileNamesConstants.REG_EMAIL_TEXT, email );
		fillElement( MobileNamesConstants.REG_PASS_TEXT, pass );
		//tapOnElement( MobileNamesConstants.REG_CREATE_BUTTON );
	}
	
	public void selectPassRecovery(String email) {
		fillElement( MobileNamesConstants.LOGIN_EMAIL_TEXT, email );
		tapOnElement( MobileNamesConstants.LOGIN_FORGOT_PASS_LINK );
		generalBusinessTest.validateMessage();
	}
	
}
