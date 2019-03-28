package com.bodega.android;

import org.apache.log4j.Logger;

import java.util.List;

import com.bodega.business.android.GeneralBusinessTest;
import com.bodega.business.android.LoginBusinessTest;
import com.bodega.business.android.MainBusinessTest;
import com.bodega.constants.NamesMobileElements;

public class Product_Detail {


	public static final Logger logger = Logger.getLogger(MainBusinessTest.class);
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	public LoginBusinessTest login = new LoginBusinessTest();

	public void login(String email, String pass) {
		login.goToLogin();
		login.login(email, pass);
	}

	public void selectProfile() {
		logger.info("Tap en perfil");
		generalBusinessTest.selectProfile();
	}

	public void selectMenu(String menu) {
		generalBusinessTest.selectMenuOption(menu);
	}
	
	/*   	public void ProductDetail( String producto ) {
	    tapOnElement( NamesMobileElements.HOME_SEARCH_BAR );
		waitVisibility( NamesMobileElements.MYPROFILE_USER_NAME );
		fillElement( NamesMobileElements.HOME_SEARCH_BAR, producto);
		
  fillElement( NamesMobileElements.MYPROFILE_USER_LAST_NAME , last);
		tapOnElement( NamesMobileElements.MYPROFILE_USER_BIRTHDATE );
		fillElement( NamesMobileElements.MYPROFILE_USER_BIRTHDATE , bir);
		hideKeyboard();// esconde teclado
	}*/
}
