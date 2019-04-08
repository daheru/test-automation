package com.walmartmg.business.iOS;

import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.MenuOptionsEnum;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.util.BaseDriver;

public class TermsBusinessTest extends BaseDriver {

	public GeneralBusinessTest general = new GeneralBusinessTest();

	public void selectProfile() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE.getNavigation());

	}

	public void selectMenu() {
		general.selectMenuOption(MenuOptionsEnum.LEGALS.getMenu());

	}

	public void Validate() {
		general.validateElement(NamesMobileElements.PROFILE_LEGAL);
		general.validateElement(NamesMobileElements.PROFILE_VERSION);
		tapOnElement(NamesMobileElements.PROFILE_PRICAVY_NOTICE1);
	
		general.validateElement(NamesMobileElements.PROFILE_PRIVACY_NOTICE2);
		// general.validateElement(NamesMobileElements.Privacy_notice2);

	}

}
