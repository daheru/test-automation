package com.walmartmg.business.android;

import java.util.List;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.ConfigConstants;
import com.walmartmg.constants.GeneralConstants;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.MenusEnum;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.enums.ProfileMenuEnum;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;

public class MenuProfileBusinessTest extends BaseDriver {

	public static final Logger logger = Logger.getLogger(MenuProfileBusinessTest.class);
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();

	public void selectProfile() {
		generalBusinessTest.selectNavigationOption(NavigationBarEnum.PROFILE);
	}

	public void selectMenu(ProfileMenuEnum menuEnum) {
		generalBusinessTest.selectProfileMenu(menuEnum);
	}

	@Step("Validate help page")
	public void validateHelpPage() {
		waitElementVisibility(NamesMobileElements.HELP_TITLE);
		waitElementVisibility(NamesMobileElements.HELP_ICON);
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.HELP_EMAIL_BUTTON);
		waitElementVisibility(NamesMobileElements.HELP_PHONE);
		waitElementVisibility(NamesMobileElements.HELP_EMAIL_BUTTON);
		waitElementVisibility(NamesMobileElements.HELP_CALL_BUTTON);
	}

	@Step("Tap on call us")
	public void validateCallUs() {
		waitElementVisibility(NamesMobileElements.HELP_CALL_BUTTON);
		tapOnElement(NamesMobileElements.HELP_CALL_BUTTON);
	}
	
	@Step("Tap on write us")
	public void validateWriteUs() {
		waitElementVisibility(NamesMobileElements.HELP_EMAIL_BUTTON);
		tapOnElement(NamesMobileElements.HELP_EMAIL_BUTTON);
	}
	
	@Step("Validate profile menu")
	public void validateMenu(boolean isLogged) {
		if (isLogged) {

		} else {
			generalBusinessTest.selectProfileMenu(ProfileMenuEnum.LOGIN);
			generalBusinessTest.goBack();
			generalBusinessTest.selectProfileMenu(ProfileMenuEnum.CREATE_PROFILE);
			generalBusinessTest.goBack();
			generalBusinessTest.selectProfileMenu(ProfileMenuEnum.GET_BILL);
			closeAndroidDialog();
			generalBusinessTest.goBack();
			generalBusinessTest.selectProfileMenu(ProfileMenuEnum.SUPPORT);
			generalBusinessTest.goBack();
			generalBusinessTest.selectProfileMenu(ProfileMenuEnum.TERMS);
			generalBusinessTest.goBack();
			generalBusinessTest.selectProfileMenu(ProfileMenuEnum.LEGALS);
			generalBusinessTest.goBack();
		}
	}

	@Step("Validate terms page")
	public void validateTermsPage() {
		generalBusinessTest.valitateDropDownMenu(MenusEnum.TERMS_RETURNS);
		generalBusinessTest.valitateDropDownMenu(MenusEnum.TERMS_DELIVERY);
		generalBusinessTest.valitateDropDownMenu(MenusEnum.TERMS_BILLING);
		generalBusinessTest.valitateDropDownMenu(MenusEnum.TERMS_MARKETPLACE);
		generalBusinessTest.valitateDropDownMenu(MenusEnum.TERMS_PAYMENTS);
		generalBusinessTest.valitateDropDownMenu(MenusEnum.TERMS_PROMOTIONS);
		generalBusinessTest.valitateDropDownMenu(MenusEnum.TERMS_FAQ);
		generalBusinessTest.valitateDropDownMenu(MenusEnum.TERMS_SECURITY);
		generalBusinessTest.valitateDropDownMenu(MenusEnum.TERMS_ACCOUNT);
		generalBusinessTest.valitateDropDownMenu(MenusEnum.TERMS_ORDERS);
	}
	
	@Step("Validate legals page")
	public void validateLegalsPage() {
		generalBusinessTest.valitateDropDownMenu(MenusEnum.LEGALS_TERMS);
		generalBusinessTest.valitateDropDownMenu(MenusEnum.LEGALS_PRIVACITY);
		List<MobileElement> terms = findElements(NamesMobileElements.LEGALS_ITEM);
		assertEquals(ConfigConstants.APP_VERSION.toLowerCase(), getElementText(terms.get(2)));
		logger.info("Página válida");
	}
}
