package com.walmartmg.iOS;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.iOS.LoginBusinessTest;
import com.walmartmg.business.iOS.DepartmentsBusinessTest;

public class DepartmentsTest {
	
	private LoginBusinessTest login = new LoginBusinessTest();
	private static final Logger logger = Logger.getLogger(LoginTest.class);
    public static DepartmentsBusinessTest departs = new DepartmentsBusinessTest();

	@AfterClass
	public static void tearDown() {
	departs.driverDisconect();

	}
	@Before
	public void init() {
	departs.closeIOSDialog();
	}
	
	@Test
	public void CP117_Validate_the_Departments_screen() {
		
		
	}

}
