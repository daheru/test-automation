package com.walmartmg.business.android;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.constants.AppMessages;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.enums.ProfileMenuEnum;

public class OrdersBusinessTest extends BaseDriver {

	private static final Logger logger = Logger.getLogger(InvoiceBusinessTest.class);
	private GeneralBusinessTest general = new GeneralBusinessTest();
	private static LoginBusinessTest login = new LoginBusinessTest();

	public void selectProfileOption() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE);
	}

	public void selectMenuLogin() {
		general.selectMenuOption(ProfileMenuEnum.LOGIN);
	}

	public void selectRequestMyProfile() {
		general.selectMenuOption(ProfileMenuEnum.ORDERS);
	}

	public void login(String email, String password) {
		login.login(email, password);
	}

	public void validateScreenYouOrders() {
		logger.info("Validate screen");
		waitElementVisibility(NamesMobileElements.ORDERS_CONT);
		waitElementVisibility(NamesMobileElements.ORDERS_EMPTY_IMG);
		general.validatePopUpMessages(AppMessages.ORDERS_EMPTY_MSG);
		waitElementVisibility(NamesMobileElements.ORDERS_BTN_STARTSHOPPING);
	}

	public void validateBtnStartYouOrders() {
		logger.info("Validate screen");
		waitElementVisibility(NamesMobileElements.ORDERS_CONT);
		waitElementVisibility(NamesMobileElements.ORDERS_BTN_STARTSHOPPING);
		tapOnElement(NamesMobileElements.ORDERS_BTN_STARTSHOPPING);
		waitElementVisibility(NamesMobileElements.MENU_PROFILE_CONT);
	}

	public void validateListYouOrders() {
		logger.info("validate list orders");
		waitElementVisibility(NamesMobileElements.ORDERS_LIST_CONT);
		waitElementVisibility(NamesMobileElements.ORDERS_LIST_HEADER);
		waitElementVisibility(NamesMobileElements.ORDERS_LIST_DATE);
		waitElementVisibility(NamesMobileElements.ORDERS_LIST_DETAIL);
		waitElementVisibility(NamesMobileElements.ORDERS_LIST_ORDERID);
		waitElementVisibility(NamesMobileElements.ORDERS_LIST_STATUS);
		waitElementVisibility(NamesMobileElements.ORDERS_LIST_QUANTITY);
		waitElementVisibility(NamesMobileElements.ORDERS_LIST_PRODUCT);
	}
}
