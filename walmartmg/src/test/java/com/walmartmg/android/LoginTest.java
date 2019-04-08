package com.walmartmg.android;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.android.LoginBusinessTest;
import com.walmartmg.constants.AppMessages;

public class LoginTest {

	public static LoginBusinessTest login = new LoginBusinessTest();
	
	@AfterClass
	public static void tearnDown() {
		login.driverDisconect();
	}

	@Before
	public void reloadApp() {
		login.closeApp();
		login.lauchApp();
	}
	
	@Test
	public void CP018_validate_login_page() {
		login.selectProfileOption();
		login.selectMenuLogin();
		login.validateLoginPage();
	}
	
	@Test
	public void CP019_login_without_data() {
		login.selectProfileOption();
		login.selectMenuLogin();
		login.login("", "");
	}
	
	@Test
	public void CP020_login_wrong_email() {
		login.selectProfileOption();
		login.selectMenuLogin();
		login.login("dj_fran@hotmail.es", "12345678");
		login.validatePopUpMessages( AppMessages.ACCOUNT_UNEXIST_EMAIL );
	}
	
	@Test
	public void CP021_login_without_pass() {
		login.selectProfileOption();
		login.selectMenuLogin();
		login.login("dj_fran_@hotmail.es", "");
	}
	
	@Test
    public void CP022_login_without_email() {
		login.selectProfileOption();
		login.selectMenuLogin();
		login.login("", "080714regina");
    }
	
	@Test
	public void CP023_login_invalid_pass() {
		login.selectProfileOption();
		login.selectMenuLogin();
		login.login("dj_fran_@hotmail.es", "123");
		login.validatePopUpMessages( AppMessages.UNEXPECTED_ERROR );
	}
	
	@Test
    public void CP026_login_success() {
		login.selectProfileOption();
		login.selectMenuLogin();
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.validateLogin("dj_fran_@hotmail.es");
    }
	
	@Test
    public void CP000_showPassword() {
		login.selectProfileOption();
		login.selectMenuLogin();
		login.showPassword("080714regina");
    }
    
    @Test
    public void CP024_forgotPassword_success() {
    	login.selectProfileOption();
    	login.selectMenuLogin();
    	login.forgotPass("dj_fran@hotmail.es");
    }
    
    @Test
    public void CP000_forgotPassword_without_email() {
    	login.selectProfileOption();
    	login.selectMenuLogin();
    	login.forgotPassWithoutEmail();
    }
    
    @Test
    public void CP025_createAccount() {
    	login.selectProfileOption();
    	login.selectMenuLogin();
    	login.createAccount();
    }
}
