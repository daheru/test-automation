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

	private static final Logger logger = Logger.getLogger(MenuProfileBusinessTest.class);
	private GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	private LoginBusinessTest login = new LoginBusinessTest();

	public void selectProfile() {
		generalBusinessTest.selectNavigationOption(NavigationBarEnum.PROFILE);
	}

	public void selectMenu(ProfileMenuEnum menuEnum) {
		generalBusinessTest.selectMenuOption(menuEnum);
	}

	public void login(String email, String password) {
		login.login(email, password);
	}

	@Step("Validate home page")
	public void validateHomePage() {
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.HOME_PRODUCT_LIST);
		waitElementVisibility(NamesMobileElements.HOME_PRODUCT_LIST);
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
			generalBusinessTest.selectMenuOption(ProfileMenuEnum.PROFILE);
			generalBusinessTest.goBack();
			generalBusinessTest.selectMenuOption(ProfileMenuEnum.ADDRESS);
			generalBusinessTest.goBack();
			generalBusinessTest.selectMenuOption(ProfileMenuEnum.ORDERS);
			generalBusinessTest.goBack();
		} else {
			generalBusinessTest.selectMenuOption(ProfileMenuEnum.LOGIN);
			generalBusinessTest.goBack();
			generalBusinessTest.selectMenuOption(ProfileMenuEnum.CREATE_PROFILE);
			generalBusinessTest.goBack();
		}
		generalBusinessTest.selectMenuOption(ProfileMenuEnum.GET_BILL);
		closeAndroidDialog();
		generalBusinessTest.goBack();
		generalBusinessTest.selectMenuOption(ProfileMenuEnum.SUPPORT);
		generalBusinessTest.goBack();
		generalBusinessTest.selectMenuOption(ProfileMenuEnum.TERMS);
		generalBusinessTest.goBack();
		generalBusinessTest.selectMenuOption(ProfileMenuEnum.LEGALS);
		generalBusinessTest.goBack();
		if (isLogged) {
			generalBusinessTest.selectMenuOption(ProfileMenuEnum.LOGOUT);
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
	public void validateLegalsPage(int elementNum) {
		logger.info("Página válida");
		List<MobileElement> terms = findSubElements(NamesMobileElements.TERMS_LIST, NamesMobileElements.TERMS_ITEM);
		assertEquals(elementNum, terms.size());
		for (MobileElement element : terms) {
			if (!ConfigConstants.APP_VERSION.toLowerCase().equals(getElementText(element).toLowerCase())) {
				tapOnElement(element);
				tapOnElement(NamesMobileElements.BACK_BUTTON);
			}
		}
	}
}
