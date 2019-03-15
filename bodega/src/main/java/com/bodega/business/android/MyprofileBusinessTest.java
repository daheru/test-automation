package com.bodega.business.android;


import org.apache.log4j.Logger;
import com.bodega.commons.MenuOptionsEnum;
import com.bodega.util.BaseDriver;

public class MyprofileBusinessTest extends BaseDriver  {
	
	public static final Logger logger = Logger.getLogger(MainBusinessTest.class);
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	public LoginBusinessTest myprofile = new LoginBusinessTest();
	
	
	public void myprofile( String email, String pass) {
		myprofile.goToLogin();
		myprofile.login( email, pass);
	}

	public void selectProfile() {
		logger.info("Tap en perfil");
		generalBusinessTest.selectProfile();
	}

	public void selectMenuDirections() {
		logger.info("Tap en el menu de Mi Perfil");
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.PROFILE.getMenu() );
		
	
	}

}

