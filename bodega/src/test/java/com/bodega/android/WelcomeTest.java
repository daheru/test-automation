package com.bodega.android;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.bodega.business.android.WelcomeBusinessTest;
import com.bodega.commons.MobileNamesConstants;

public class WelcomeTest {
	
	public static WelcomeBusinessTest welcome = new WelcomeBusinessTest();
	
	@AfterClass
	public static void tearDown() {
		welcome.driverDisconect();
	}
	
	@Before
	public void resetApp() {
		welcome.closeApp();
		welcome.lauchApp();
		if( welcome.elementExist( MobileNamesConstants.DIALOG_CONTENT ) ) {
			welcome.findElement( MobileNamesConstants.DIALOG_ALLOW ).click();
			//welcome.findElement( MobileNamesConstants.DIALOG_ALLOW ).click();
		}
	}
	
	@Test()
	public void init_as_guess() {
		welcome.initGuess();
		welcome.validateHome();
	}
	
	@Test
	public void test_nav_bar() {
		welcome.initGuess();
		welcome.selectMenus();
	}
	
	@Test
	public void test_menus() {
		welcome.initGuess();
		welcome.selectProfile();
		welcome.validateMenu();
	}
	
}
