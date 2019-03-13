package com.bodega.android;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.bodega.business.android.HomeBusinessTest;
import com.bodega.business.android.MyprofileBusinessTest;

public class Myprofile {
	
	public static final Logger logger = Logger.getLogger( MyprofileBusinessTest.class );
	public static MyprofileBusinessTest myprofile = new MyprofileBusinessTest();
	
	
	@AfterClass
	public static void tearDown() {
		myprofile.driverDisconect();
	}
	
	@Before
	public void relauchApp() {
		myprofile.closeApp();
		myprofile.lauchApp();
		myprofile.closeAndroidDialog();
	}
		
	/*	@Test
		public void login_as_guess_success() {
			logger.info("Iniciando caso de prueba: Login as guess success");
			myprofile.goToLogin();
			myprofile.login("emmanuel.dominguez@live.com.mx", "Edominguez#1234");
			myprofile.validateLogin("emmanuel1.dominguez@live.com.mx");
			
			logger.info("Finalizando caso de prueba"); 
		}*/
		
	}	



