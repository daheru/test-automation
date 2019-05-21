package com.automation.web;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.automation.base.BaseWeb;
import com.automation.business.web.ExampleBusinessTest;

public class ExampleTest extends BaseWeb {

	private static ExampleBusinessTest example = new ExampleBusinessTest();
	
	@AfterClass
	public static void shutDown() {
		example.driverDisconect();
	}

	@Before
	public void initApp() {
		
	}

	@After
	public void relauchApp() {
		
	}
	
	@Test
	public void login() {
		example.login("correo@correo.com", "123456789");
	}
}
