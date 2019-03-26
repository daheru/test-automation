package com.walmartmg.android;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.android.LoginBusinessTest;
import com.walmartmg.constants.AppMessages;
import com.walmartmg.enums.MenuOptionsEnum;

public class LoginTest {

	public static LoginBusinessTest login = new LoginBusinessTest();
	
	@AfterClass
	public static void tearnDown() {
		login.desconectarDriver();
	}

	@Before
	public void reloadApp() {
		login.closeApp();
		login.lauchApp();
	}
	
	@Test
	public void CP043_validate_login_page() {
		login.selectProfileOption();
		login.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		login.validateLoginPage();
	}
	
	@Test
	public void CP045_login_without_data() {
		login.selectProfileOption();
		login.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		login.login("", "");
	}
	
	@Test
	public void CP046_login_wrong_email() {
		login.selectProfileOption();
		login.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		login.login("dj_fran@hotmail.es", "12345678");
		login.validatePopUpMessages( AppMessages.ACCOUNT_UNEXIST_EMAIL );
	}
	
	@Test
	public void CP047_login_without_pass() {
		login.selectProfileOption();
		login.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		login.login("dj_fran_@hotmail.es", "");
	}
	
	@Test
    public void CP048_login_without_email() {
		login.selectProfileOption();
		login.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		login.login("", "080714regina");
    }
	
	@Test
	public void CP049_login_invalida_pass() {
		login.selectProfileOption();
		login.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		login.login("dj_fran_@hotmail.es", "123");
		login.validatePopUpMessages( AppMessages.UNEXPECTED_ERROR );
	}
	
	@Test
    public void CP050_login_success() {
		login.selectProfileOption();
		login.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.validateLogin("dj_fran_@hotmail.es");
    }
	
	@Test
    public void showPassword() {
		login.selectProfileOption();
		login.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
		login.showPassword("080714regina");
    }
    
    @Test
    public void forgotPassword_success() {
    	login.selectProfileOption();
    	login.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
    	login.forgotPass("dj_fran@hotmail.es");
    }
    
    @Test
    public void forgotPassword_without_email() {
    	login.selectProfileOption();
    	login.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
    	login.forgotPassWithoutEmail();
    }
    
    @Test
    public void createAccount() {
    	login.selectProfileOption();
    	login.selectMenu(MenuOptionsEnum.LOGIN.getMenu());
    	login.createAccount();
    }
}
