package com.walmartmg.regressions.ios;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.business.iOS.LoginBusinessTest;
import com.walmartmg.business.iOS.HelpBusinessTest;
import com.walmartmg.business.iOS.HomeBussinesTest;
import com.walmartmg.business.iOS.ProfileBusinessTest;
import com.walmartmg.business.iOS.TermsBusinessTest;
import com.walmartmg.business.iOS.TermsyConditionsBusinessTest;
import com.walmartmg.enums.NavigationBarEnum;

public class RegressionFlow {

	private static GeneralBusinessTest general = new GeneralBusinessTest();

	private LoginBusinessTest login = new LoginBusinessTest();
	private ProfileBusinessTest profile = new ProfileBusinessTest();
	private TermsyConditionsBusinessTest Condition = new TermsyConditionsBusinessTest();
	private TermsBusinessTest Terms = new TermsBusinessTest();
	private HelpBusinessTest Help = new HelpBusinessTest();
	private HomeBussinesTest home = new HomeBussinesTest();

	@AfterClass
	public static void tearDown() {
		general.driverDisconect();
	}

	@Before
	public void init() {
		general.closeIOSDialog();
	}

	@Test
	public void Regresion_ios() {
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.validateLoginIn();		
		home.Validate_secure_payment_screen();

	}

}
