package com.bodega.business.android;
import org.apache.log4j.Logger;

import com.bodega.constants.NamesMobileElements;
import com.bodega.util.BaseDriver;

public class MyprofileBusinessTest extends BaseDriver {

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
	
	public void editProfile( String name, String lastName, String birthday, String sex ) {
		tapOnElement( NamesMobileElements.MYPROFILE_EDIT_PROFILE );
		waitVisibility( NamesMobileElements.MYPROFILE_USER_NAME );
		fillElement( NamesMobileElements.MYPROFILE_USER_NAME , name);
		fillElement( NamesMobileElements.MYPROFILE_USER_LAST_NAME , lastName);
		tapOnElement( NamesMobileElements.MYPROFILE_USER_BIRTHDATE );
		fillElement( NamesMobileElements.MYPROFILE_USER_BIRTHDATE , birthday);
		hideKeyboard();// esconde teclado
		if( sex.equals("H") ) {
			tapOnElement( NamesMobileElements.MYPROFILE_BUTTON_MAN );
		} else {
			tapOnElement( NamesMobileElements.MYPROFILE_BUTTON_WOMAN );
		}
		tapOnElement( NamesMobileElements.MYPROFILE_CHECKBOX_PROFILE );
	}
	
	public void saveProfile() {
		tapOnElement(NamesMobileElements.MYPROFILE_BUTTON_PROFILE_SAVE);
	}
	
	public void editPassword( String oldpass, String newpass ) {
		tapOnElement( NamesMobileElements.MYPROFILE_EDIT_PASSWORD );
		waitVisibility( NamesMobileElements.MYPROFILE_OLD_PASSWORD );
		tapOnElement( NamesMobileElements.MYPROFILE_OLD_CON_PASSWORD );
		fillElement( NamesMobileElements.MYPROFILE_OLD_PASSWORD , oldpass);
		tapOnElement( NamesMobileElements.MYPROFILE_NEW_CON_PASSWORD );
		fillElement( NamesMobileElements.MYPROFILE_NEW_PASSWORD , newpass);
		hideKeyboard();
	}
	  ////
	public void savePassword() {
		tapOnElement(NamesMobileElements.MYPROFILE_BUTTON_PROFILE_SAVE);
	}
	public void editPhone( String Phoneprimary, String Phonesecundary) {
		tapOnElement( NamesMobileElements.MYPROFILE_EDIT_PHONE );
		waitVisibility( NamesMobileElements.MYPROFILE_PHONE_PRIMARY );
		fillElement( NamesMobileElements.MYPROFILE_PHONE_PRIMARY , Phoneprimary);
		tapOnElement( NamesMobileElements.MYPROFILE_ADD_PHONE );
	//	tapOnElement( NamesMobileElements.MYPROFILE_BUTTON_PHONE_FIJO_LIS );
	//	tapOnElement( NamesMobileElements.MYPROFILE_BUTTON_PHONE_FIJO );
		
		fillElement( NamesMobileElements.MYPROFILE_PHONE_SECONDARY , Phonesecundary);
		//fillElement( NamesMobileElements.MYPROFILE_PHONE_SECONDARY_EXT , ext);
		hideKeyboard();
	}
	
	public void savePhone() {
		tapOnElement(NamesMobileElements.MYPROFILE_BUTTON_PHONE_SAVE);
	}
	
	public void editPhone_Secundary( String Phonesecundary) {
		tapOnElement( NamesMobileElements.MYPROFILE_EDIT_PHONE );
		waitVisibility( NamesMobileElements.MYPROFILE_PHONE_PRIMARY );
		tapOnElement( NamesMobileElements.MYPROFILE_ADD_PHONE );
		fillElement( NamesMobileElements.MYPROFILE_PHONE_SECONDARY , Phonesecundary);
		hideKeyboard();
	}
	
	public void savePhone_Secundary() {
		tapOnElement(NamesMobileElements.MYPROFILE_BUTTON_PHONE_SAVE);
	}
	
}
