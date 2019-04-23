package com.bodega.business.android;

import org.apache.log4j.Logger;

import com.bodega.base.BaseDriver;
import com.bodega.constants.GeneralConstants;
import com.bodega.constants.NamesMobileElements;
import com.bodega.enums.NavigationBarEnum;

import io.qameta.allure.Step;

public class HomeBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(HomeBusinessTest.class);
	private GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();

	public void initAsGuess() {
		generalBusinessTest.initAsGuess();
	}

	public void selectHomeOption() {
		generalBusinessTest.selectNavigationOption(NavigationBarEnum.HOME);
	}

	@Step("Validate home page")
	public void validateHomePage() {
		waitElementVisibility(NamesMobileElements.HOME_SEARCH_BAR);
		waitElementVisibility(NamesMobileElements.HOME_ITEM_BANNER);
		waitElementVisibility(NamesMobileElements.HOME_CARROUSEL);
		waitElementVisibility(NamesMobileElements.NAV_BAR);
		waitElementVisibility(NamesMobileElements.NAV_BAR_HOME);
		waitElementVisibility(NamesMobileElements.NAV_BAR_DEPARTMENTS);
		waitElementVisibility(NamesMobileElements.NAV_BAR_PROMOTIONS);
		waitElementVisibility(NamesMobileElements.NAV_BAR_CAR);
		waitElementVisibility(NamesMobileElements.NAV_BAR_CAR_QUANTITY);
		waitElementVisibility(NamesMobileElements.HOME_ITEM_BANNER);
		waitElementVisibility(NamesMobileElements.HOME_CARROUSEL);
		logger.info("Validando Home Page");
	}

	@Step("Tap on banner")
	public void tapOnBanner() {
		waitElementVisibility(NamesMobileElements.HOME_ITEM_BANNER);
		tapOnElement(NamesMobileElements.HOME_ITEM_BANNER);
	}

	@Step("Tap on home product")
	public void tapOnHomeProduct() {
		scrollUntilShowElement(GeneralConstants.SCROLL_UP, NamesMobileElements.HOME_PRODUCT_ICON);
		tapOnElement(NamesMobileElements.HOME_PRODUCT_ICON);
	}
}
