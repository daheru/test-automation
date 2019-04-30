package com.walmartmg.android.unregistered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.walmartmg.business.android.AccountBusinessTest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature("Account Module - No session")
public class AccountTest {

	@Rule
	public TestName name = new TestName();
	private static final Logger logger = Logger.getLogger(AccountTest.class);
	private static AccountBusinessTest account = new AccountBusinessTest();
	
	@AfterClass
	public static void tearDown(){
		account.driverDisconect();
	}	
	
	@Before
	public void initApp() {
		logger.info("===> Iniciando caso de prueba: " + name.getMethodName());
	}
	
	@After
	public void resetApp() {
		account.resetApp();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("Validate create account page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to create a new account")
	@Description("Validate that create account page has all elements")
	public void CP027_create_account_validate_page() {
		account.selectProfileOption();
		account.selectCreateAccount();
		account.validateElements();
	}
	
	@Test
	@DisplayName("Create account without data")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to create a new account")
	@Description("Try to create a new accoutn without data")
	public void CP028_create_account_without_data() {
		account.selectProfileOption();
		account.selectCreateAccount();
		account.createAccount("","","","");
		account.validateEmptyFields();
	}
	
	@Test
	@DisplayName("Create account invalid data")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to create a new account")
	@Description("Try to create a new account usign invalid data")
	public void CP029_create_account_with_invalid_data() {
		account.selectProfileOption();
		account.selectCreateAccount();
		account.createAccount("12345·$%","12344|@#","akakak.com@","123");
		account.validateInvalidData();
	}
	
	@Test
	@DisplayName("Create account exist email")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to create a new account")
	@Description("Try to create a new account using an exist email")
	public void CP030_create_account_exist_email() {
		account.selectProfileOption();
		account.selectCreateAccount();
		account.createAccount("Juan","Lopez","dj_fran_@hotmail.es","12345678");
		account.validateExistEmail();
	}
	
	@Test
	@DisplayName("Validate terms page")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to create a new account")
	@Description("Validate terms page has all elements")
	public void CP031_validate_terms() {
		account.selectProfileOption();
		account.selectCreateAccount();
		account.tapTermsLink();
		account.validateTerms(5);
	}
	
	@Test
	@DisplayName("Validate create account page")
	@Severity(SeverityLevel.CRITICAL)
	@Story("As a user I want to create a new account")
	@Description("Validate that login link works correctly")
	public void CP032_validate_login_link() {
		account.selectProfileOption();
		account.selectCreateAccount();
		account.tapLoginLink();
		account.validateLogin();
	}
	
	//@Test
	@DisplayName("Create new account")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to create a new account")
	@Description("Create a new account")
	public void CP033_create_account() {
		account.selectProfileOption();
		account.selectCreateAccount();
		account.createAccount("Maria","Tester","test3@correo.com","Test#1234");
		account.validateCreateAccount();
	}
	
	@Test
	@DisplayName("Show password")
	@Severity(SeverityLevel.NORMAL)
	@Story("As a user I want to create a new account")
	@Description("Validate that eye icon shows user's password")
	public void show_password() {
		account.selectProfileOption();
		account.selectCreateAccount();
		account.showPassword("NuevoPass12345");
	}	
}