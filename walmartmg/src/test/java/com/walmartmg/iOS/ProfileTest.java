package com.walmartmg.iOS;

import org.junit.AfterClass;
import org.junit.Test;

public class ProfileTest {

	public static ProfileBusinessTest profile = new ProfileBusinessTest();

	@AfterClass
	public static void tearDown() {
		profile.driverDisconect();
	}

	@Test // crear usuario nuevo
	public void Creat() {
		profile.selectProfile();
		profile.selectMenu();
		profile.Accounts();
		profile.vUser();
	}

	@Test // Mensaje de error "Ya existe un usuario registrado con este corre//
	public void Creat2() {
		profile.selectProfile();
		profile.selectMenu();
		profile.menssage();

	}

	@Test // mensaje de error cuenta ya existente
	public void Creat3() {
		profile.selectProfile();
		profile.selectMenu();
		profile.exit();
		profile.Va();

	}
}
