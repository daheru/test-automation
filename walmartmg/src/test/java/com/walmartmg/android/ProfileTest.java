package com.walmartmg.android;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.android.ProfileBusinessTest;
import com.walmartmg.enums.MenuOptionsEnum;

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
	public void CPO15_validate_menu_without_login() {
		profile.selectProfileOption();
		profile.validateMenu(false);
	}
	
	@Test
	public void CP028_validate_help_page() {
		profile.selectProfileOption();
		profile.selectMenu(MenuOptionsEnum.SUPPORT.getMenu());
		profile.validateHelpPage();
	}
	
	@Test
	public void CP029_validate_help_callus() {
		profile.selectProfileOption();
		profile.selectMenu(MenuOptionsEnum.SUPPORT.getMenu());
		profile.validateCallUs();
	}
	
	@Test
	public void CP030_validate_help_writeus() {
		profile.selectProfileOption();
		profile.selectMenu(MenuOptionsEnum.SUPPORT.getMenu());
		profile.validateWriteUs();
	}
	
	@Test
	public void CP031_validate_terms_and_conds() {
		profile.selectProfileOption();
		profile.selectMenu(MenuOptionsEnum.TERMS.getMenu());
		profile.validateTermsPage();
	}
	
}
