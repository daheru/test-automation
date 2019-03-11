package com.walmartmg.android;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.android.ProfileBusinessTest;

public class ProfileTest {
	
	public static ProfileBusinessTest profile = new ProfileBusinessTest();
	
	@AfterClass
	public static void tearnDown() {
		profile.desconectarDriver();
	}
	
	@Before
	public void reloadApp() {
		profile.closeApp();
		profile.lauchApp();
	}
	
	@Test
	public void validate_help_page() {
		profile.selectProfileOption();
		profile.selectHelpMenu();
		profile.validatePage();
	}
	
}
