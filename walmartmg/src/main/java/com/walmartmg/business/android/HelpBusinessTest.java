package com.walmartmg.business.android;

import java.util.List;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.AppMessages;
import com.walmartmg.constants.ConfigConstants;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.MenusEnum;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.enums.ProfileMenuEnum;

import io.appium.java_client.MobileElement;

public class HelpBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger( HelpBusinessTest.class );
	private GeneralBusinessTest general = new GeneralBusinessTest();
	public static LoginBusinessTest login = new LoginBusinessTest();
	private String email;
	
	public void selectProfileOption() {
		general.selectNavigationOption( NavigationBarEnum.PROFILE.getNavigation() );
	}
	
	public void selectMenuLogin() {
		general.selectProfileMenu(ProfileMenuEnum.LOGIN.getMenu());
	}
	
	//Help
	public void selectRequestMyProfile() {
		general.selectProfileMenu(ProfileMenuEnum.SUPPORT.getMenu() );
	}
	
	//Terms
	public void selectRequestMyProfileTerms() {
		general.selectProfileMenu(ProfileMenuEnum.TERMS.getMenu() );
	}
	
	//Legals
	public void selectRequestMyProfileLegal() {
		general.selectProfileMenu(ProfileMenuEnum.LEGALS.getMenu() );
	}
		
	//Logout
	public void selectRequestMyProfileLogut() {
		general.selectProfileMenu(ProfileMenuEnum.LOGOUT.getMenu() );
	}
	
	//Login
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
	
	//validate screen help
	public void validateScreenHelp() {
		logger.info("Validate screen");
		waitElementVisibility(NamesMobileElements.HELP_TITLE);
		waitElementVisibility(NamesMobileElements.HELP_ICON);
		waitElementVisibility(NamesMobileElements.HELP_CALL_BUTTON);
		waitElementVisibility(NamesMobileElements.HELP_EMAIL_BUTTON);
		waitElementVisibility(NamesMobileElements.HELP_PHONE);
	}
	
	public void validateCallButton() {
		logger.info("Validate acction call button");
		waitElementVisibility(NamesMobileElements.HELP_CALL_BUTTON);
		tapOnElement(NamesMobileElements.HELP_CALL_BUTTON);
		logger.info("Se visualiza pantalla de llamada");
	}
	
	public void validateEmailButton() {
		logger.info("Validate acction email button");
		waitElementVisibility(NamesMobileElements.HELP_EMAIL_BUTTON);
		tapOnElement(NamesMobileElements.HELP_EMAIL_BUTTON);
		logger.info("Se visualizan opciones de mensajeria");
	}
	
	//Validate Termns and conditions 
	public void validateTermsPage() {
		general.valitateDropDownMenu(MenusEnum.TERMS_RETURNS);
		general.valitateDropDownMenu(MenusEnum.TERMS_DELIVERY);
		general.valitateDropDownMenu(MenusEnum.TERMS_BILLING);
		general.valitateDropDownMenu(MenusEnum.TERMS_MARKETPLACE);
		general.valitateDropDownMenu(MenusEnum.TERMS_PAYMENTS);
		general.valitateDropDownMenu(MenusEnum.TERMS_PROMOTIONS);
		general.valitateDropDownMenu(MenusEnum.TERMS_FAQ);
		general.valitateDropDownMenu(MenusEnum.TERMS_SECURITY);
		general.valitateDropDownMenu(MenusEnum.TERMS_ACCOUNT);
		general.valitateDropDownMenu(MenusEnum.TERMS_ORDERS);
	}
	
	public void validateLegalsPage() {
		general.valitateDropDownMenu(MenusEnum.LEGALS_TERMS);
		general.valitateDropDownMenu(MenusEnum.LEGALS_PRIVACITY);
		List<MobileElement> terms = findElements(NamesMobileElements.LEGALS_ITEM);
		assertEquals(ConfigConstants.APP_VERSION.toLowerCase(), getElementText(terms.get(2)));
		logger.info("Página válida");
	}
	
	
}
