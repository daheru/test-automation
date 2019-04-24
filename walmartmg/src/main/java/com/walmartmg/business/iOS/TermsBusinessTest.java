package com.walmartmg.business.iOS;

import org.apache.log4j.Logger;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.ProfileMenuEnum;
import com.walmartmg.enums.NavigationBarEnum;

public class TermsBusinessTest extends BaseDriver {
	private static final Logger logger = Logger.getLogger(TermsBusinessTest.class);

	public GeneralBusinessTest general = new GeneralBusinessTest();

	public void selectProfile() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE);

	}

	public void selectMenu() {
		general.selectProfileMenu(ProfileMenuEnum.LEGALS);

	}

	public void Validate() {
		logger.info(" SE  VE AVISO DE PRIVACIDAD ");
		waitElementVisibility(NamesMobileElements.PROFILE_LEGAL);
		logger.info("CLICK EN AVISO");
		tapOnElement(NamesMobileElements.PROFILE_PRIVACY_NOTICE1);
		logger.info(" SE  VE AVISO DE PRIVACIDAD ");
		logger.info(" SE  VE  VERSION APP ");
		general.elementExist(NamesMobileElements.PROFILE_VERSION);

	}

}
