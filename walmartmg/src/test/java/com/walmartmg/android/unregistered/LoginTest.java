package com.walmartmg.android.unregistered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.walmartmg.business.android.LoginBusinessTest;
import com.walmartmg.constants.AppMessages;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature("Login Module - No session")
public class LoginTest {

	@Rule
	public TestName name = new TestName();
	private static final Logger logger = Logger.getLogger( LoginTest.class );
	private static LoginBusinessTest login = new LoginBusinessTest();
	
	@AfterClass
	public static void tearnDown() {
		login.driverDisconect();
	}

	@Before
	public void initApp() {
		logger.info("===> Iniciando caso de prueba: " + name.getMethodName());
	}
	
	@After
	public void resetApp() {
		login.resetApp();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("Validate login page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to login in the app")
	@Description("Validate that login page has all elements")
	public void CP018_validate_login_page() {
		login.selectProfileOption();
		login.selectMenuLogin();
		login.validateLoginPage();
	}
	
	@Test
	@DisplayName("Login without data")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to login in the app")
	@Description("Validate when user tries to login in the app without data")
	public void CP019_login_without_data() {
		login.selectProfileOption();
		login.selectMenuLogin();
		login.login("", "");
	}
	
	@Test
	@DisplayName("Login wrong data")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to login in the app")
	@Description("Validate when user tries to login in the app with wrong data")
	public void CP020_login_wrong_email() {
		login.selectProfileOption();
		login.selectMenuLogin();
		login.login("dj_fran@hotmail.es", "12345678");
		login.validatePopUpMessages( AppMessages.ACCOUNT_UNEXIST_EMAIL );
	}
	
	@Test
	@DisplayName("Login without password")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to login in the app")
	@Description("Validate when user tries to login in the app without password")
	public void CP021_login_without_pass() {
		login.selectProfileOption();
		login.selectMenuLogin();
		login.login("dj_fran_@hotmail.es", "");
	}
	
	@Test
	@DisplayName("Login without email")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to login in the app")
	@Description("Validate when user tries to login in the app without email")
    public void CP022_login_without_email() {
		login.selectProfileOption();
		login.selectMenuLogin();
		login.login("", "080714regina");
    }
	
	@Test
	@DisplayName("Login invalid password")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to login in the app")
	@Description("Validate when user tries to login in the app with invalid password")
	public void CP023_login_invalid_pass() {
		login.selectProfileOption();
		login.selectMenuLogin();
		login.login("dj_fran_@hotmail.es", "123");
		login.validatePopUpMessages( AppMessages.UNEXPECTED_ERROR );
	}
	
	@Test
	@DisplayName("Login success")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to login in the app")
	@Description("Validate when user login in the app successfully")
    public void CP026_login_success() {
		login.selectProfileOption();
		login.selectMenuLogin();
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.validateLogin();
    }
	
	@Test
	@DisplayName("Show password")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to login in the app")
	@Description("Validate when user pushes the eye button to see his password")
    public void CP000_showPassword() {
		login.selectProfileOption();
		login.selectMenuLogin();
		login.showPassword("080714regina");
    }
    
    @Test
    @DisplayName("Forgot password link")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to login in the app")
	@Description("Validate when user tries to recover his password")
    public void CP024_forgotPassword_success() {
    	login.selectProfileOption();
    	login.selectMenuLogin();
    	login.forgotPass("dj_fran@hotmail.es");
    }
    
    @Test
    @DisplayName("Forgor password without email")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to login in the app")
	@Description("Validate when user tries to recover his password without email")
    public void CP000_forgotPassword_without_email() {
    	login.selectProfileOption();
    	login.selectMenuLogin();
    	login.forgotPassWithoutEmail();
    }
    
    @Test
    @DisplayName("Create account")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to login in the app")
	@Description("Validate when user tries to create a new account from login page")
    public void CP025_createAccount() {
    	login.selectProfileOption();
    	login.selectMenuLogin();
    	login.createAccount();
    }
}
