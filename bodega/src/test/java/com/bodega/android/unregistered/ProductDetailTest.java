package com.bodega.android.unregistered;

import org.apache.log4j.Logger;

import com.bodega.business.android.GeneralBusinessTest;
import com.bodega.business.android.LoginBusinessTest;

public class ProductDetailTest {

	private static final Logger logger = Logger.getLogger(ProductDetailTest.class);
	private GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	private LoginBusinessTest login = new LoginBusinessTest();

	public void login(String email, String pass) {
		login.selectProfile();
		login.selectLoginOption();
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
