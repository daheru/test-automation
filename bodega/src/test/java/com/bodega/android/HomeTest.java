package com.bodega.android;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.bodega.business.android.HomeBusinessTest;

public class HomeTest {

	public static final Logger logger = Logger.getLogger( HomeBusinessTest.class );
	public static HomeBusinessTest home = new HomeBusinessTest();
	
	@AfterClass
	public static void tearDown() {
		home.driverDisconect();
	}
	
	@Before
	public void relauchApp() {
		home.closeApp();
		home.lauchApp();
		home.closeAndroidDialog();
	}
	
	@Test
	public void validate_home_page() {
		home.selectHomeOption();
		home.validateElements();
	}
	
}
