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
		waitElementVisibility(NamesMobileElements.PROFILE_LEGAL);
		waitElementVisibility(NamesMobileElements.PROFILE_VERSION);
		tapOnElement(NamesMobileElements.PROFILE_PRICAVY_NOTICE1);

		waitElementVisibility(NamesMobileElements.PROFILE_PRIVACY_NOTICE2);
		// waitElementVisibility(NamesMobileElements.Privacy_notice2);

	}

}
