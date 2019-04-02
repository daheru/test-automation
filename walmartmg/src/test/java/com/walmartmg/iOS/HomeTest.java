package com.walmartmg.iOS;

import org.junit.AfterClass;
import org.junit.Test;

import com.walmartmg.business.iOS.HomeBussinesTest;

public class HomeTest {

	public static HomeBussinesTest home = new HomeBussinesTest();

	@AfterClass
	public static void tearDown() {
		home.driverDisconect();

	}

	@Test
	public void CP001() {
		home.selectMenu(1);
		home.validate();

	}

	@Test
	public void CPOO2() {
		home.selectMenu(1);
		home.vaCp002();

	}

	@Test
	public void CPOO3() {
		home.selectMenu(1);
		home.cp003();

	}

	@Test
	public void CP007() {
		home.selectMenu(1);
		home.cp007();

	}

	@Test
	public void CP008() {
		home.selectMenu(1);
		home.Cp008();

	}

}
