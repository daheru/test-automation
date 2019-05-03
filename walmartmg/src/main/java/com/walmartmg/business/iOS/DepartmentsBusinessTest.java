package com.walmartmg.business.iOS;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.NavigationBarEnum;
import com.walmartmg.enums.ProfileMenuEnum;

import io.appium.java_client.MobileElement;

public class DepartmentsBusinessTest extends BaseDriver {
	

	private static final Logger logger = Logger.getLogger(LoginBusinessTest.class);

	public GeneralBusinessTest general = new GeneralBusinessTest();
	
	
	
	public void selectProfile() {
		general.selectNavigationOption(NavigationBarEnum.DEPARTMENTS);

	}

	


	
}


