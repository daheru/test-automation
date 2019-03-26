package com.bodega.business.android;
import org.apache.log4j.Logger;
<<<<<<< refs/remotes/origin/bodega

import com.bodega.enums.MenuOptionsEnum;
=======
import com.bodega.commons.MenuOptionsEnum;
import com.bodega.commons.MobileNamesConstants;
>>>>>>> MyProfileTest methods
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
		tapOnElement( MobileNamesConstants.MYPROFILE_EDIT_PROFILE );
		waitVisibility( MobileNamesConstants.MYPROFILE_USER_NAME );
		fillElement( MobileNamesConstants.MYPROFILE_USER_NAME , name);
		fillElement( MobileNamesConstants.MYPROFILE_USER_LAST_NAME , lastName);
		tapOnElement( MobileNamesConstants.MYPROFILE_USER_BIRTHDATE );
		fillElement( MobileNamesConstants.MYPROFILE_USER_BIRTHDATE , birthday);
		hideKeyboard();// esconde teclado
		if( sex.equals("H") ) {
			tapOnElement( MobileNamesConstants.MYPROFILE_BUTTON_MAN );
		} else {
			tapOnElement( MobileNamesConstants.MYPROFILE_BUTTON_WOMAN );
		}
		tapOnElement( MobileNamesConstants.MYPROFILE_CHECKBOX_PROFILE );
	}
	
	public void saveProfile() {
		tapOnElement(MobileNamesConstants.MYPROFILE_BUTTON_PROFILE_SAVE);
	}
	
	public void editPassword( String oldpass, String newpass ) {
		tapOnElement( MobileNamesConstants.MYPROFILE_EDIT_PASSWORD );
		waitVisibility( MobileNamesConstants.MYPROFILE_OLD_PASSWORD );
		tapOnElement( MobileNamesConstants.MYPROFILE_OLD_CON_PASSWORD );
		fillElement( MobileNamesConstants.MYPROFILE_OLD_PASSWORD , oldpass);
		tapOnElement( MobileNamesConstants.MYPROFILE_NEW_CON_PASSWORD );
		fillElement( MobileNamesConstants.MYPROFILE_NEW_PASSWORD , newpass);
		hideKeyboard();
	}
	  ////
	public void savePassword() {
		tapOnElement(MobileNamesConstants.MYPROFILE_BUTTON_PROFILE_SAVE);
	}
	public void editPhone( String Phoneprimary, String Phonesecundary) {
		tapOnElement( MobileNamesConstants.MYPROFILE_EDIT_PHONE );
		waitVisibility( MobileNamesConstants.MYPROFILE_PHONE_PRIMARY );
		fillElement( MobileNamesConstants.MYPROFILE_PHONE_PRIMARY , Phoneprimary);
		tapOnElement( MobileNamesConstants.MYPROFILE_ADD_PHONE );
	//	tapOnElement( MobileNamesConstants.MYPROFILE_BUTTON_PHONE_FIJO_LIS );
	//	tapOnElement( MobileNamesConstants.MYPROFILE_BUTTON_PHONE_FIJO );
		
		fillElement( MobileNamesConstants.MYPROFILE_PHONE_SECONDARY , Phonesecundary);
		//fillElement( MobileNamesConstants.MYPROFILE_PHONE_SECONDARY_EXT , ext);
		hideKeyboard();
	}
	
	public void savePhone() {
		tapOnElement(MobileNamesConstants.MYPROFILE_BUTTON_PHONE_SAVE);
	}
	
	public void editPhone_Secundary( String Phonesecundary) {
		tapOnElement( MobileNamesConstants.MYPROFILE_EDIT_PHONE );
		waitVisibility( MobileNamesConstants.MYPROFILE_PHONE_PRIMARY );
		tapOnElement( MobileNamesConstants.MYPROFILE_ADD_PHONE );
		fillElement( MobileNamesConstants.MYPROFILE_PHONE_SECONDARY , Phonesecundary);
		hideKeyboard();
	}
	
	public void savePhone_Secundary() {
		tapOnElement(MobileNamesConstants.MYPROFILE_BUTTON_PHONE_SAVE);
	}
	
}
