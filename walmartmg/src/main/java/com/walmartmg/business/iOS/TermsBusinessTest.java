package com.walmartmg.business.iOS;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.ProfileMenuEnum;
import com.walmartmg.enums.NavigationBarEnum;

public class TermsBusinessTest extends BaseDriver {

	public GeneralBusinessTest general = new GeneralBusinessTest();

	public void selectProfile() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE.getNavigation());

	}

	public void selectMenu() {
		general.selectProfileMenu(ProfileMenuEnum.LEGALS.getMenu());

	}

	public void Validate() {
		waitElementVisibility(NamesMobileElements.LEGAL);
		waitElementVisibility(NamesMobileElements.VERSION);
		tapOnElement(NamesMobileElements.PRICAVY_NOTICE1);
	
		waitElementVisibility(NamesMobileElements.PRIVACY_NOTICE2);
		// waitElementVisibility(NamesMobileElements.Privacy_notice2);

	}

}
