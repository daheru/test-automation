package com.walmartmg.business.android;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.enums.ProfileMenuEnum;

public class HelpBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(HelpBusinessTest.class);
	private GeneralBusinessTest general = new GeneralBusinessTest();
	private static LoginBusinessTest login = new LoginBusinessTest();

	public void selectProfileOption() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE);
	}

	public void selectMenuLogin() {
		general.selectMenuOption(ProfileMenuEnum.LOGIN);
	}

	public void selectRequestMyProfile() {
		general.selectMenuOption(ProfileMenuEnum.SUPPORT);
	}

	public void login(String email, String password) {
		login.login(email, password);
	}

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
}
