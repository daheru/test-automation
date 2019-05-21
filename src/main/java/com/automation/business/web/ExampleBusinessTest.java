package com.automation.business.web;

import org.apache.log4j.Logger;

import com.automation.base.BaseWeb;
import com.automation.constants.NamesWebElements;

public class ExampleBusinessTest extends BaseWeb {

	private static final Logger logger = Logger.getLogger(ExampleBusinessTest.class);
	
	public void login(String email, String pass) {
		logger.info("Search something");
		fillElement(NamesWebElements.LOGIN_EMAIL, email);
		fillElement(NamesWebElements.LOGIN_PASSWORD, pass);
		clickOnElement(NamesWebElements.LOGIN_LOGIN_BUTTON);
	}
}
