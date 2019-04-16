package com.bodega.android.unregistered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.bodega.business.android.AccountBusinessTest;
import com.bodega.constants.GeneralConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature("Account test module")
public class AccountTest {

	private static final Logger logger = Logger.getLogger(AccountTest.class);
	private static AccountBusinessTest account = new AccountBusinessTest();
	
	@AfterClass
	public static void tearDown(){
		account.driverDisconect();
	}	
	
	@Before
	public void initApp() {
		account.closeAndroidDialog();
		account.validateWelcomePage();
	}

	@After
	public void relauchApp() {
		account.resetApp();
	}
	
	@Test
	@DisplayName("Validate create account page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to create my account")
	@Description("Validate that create account page has all elements")
	public void create_account_validate_page() {
		logger.info("===> Iniciando caso de prueba: Validate account page");
		account.selectProfileOption();
		account.selectCreateAccount();
		account.validateElements();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("Create account without data")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to create my account")
	@Description("Try to create user's account without data")
	public void create_account_without_data() {
		logger.info("===> Iniciando caso de prueba: Create account withoout data");
		account.selectProfileOption();
		account.selectCreateAccount();
		account.createAccount("","","","");
		account.validateEmptyFields();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("Create account with invalid data")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to create my account")
	@Description("Try to create user's account with invalid data")
	public void create_account_with_invalid_data() {
		logger.info("===> Iniciando caso de prueba: Create account with invalid data");
		account.selectProfileOption();
		account.selectCreateAccount();
		account.createAccount("12345·$%","12344|@#","akakak.com@","123");
		account.validateInvalidData();
		logger.info("Caso de prueba finalizado");
	}
	
	@Test
	@DisplayName("Create account with exist email")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to create my account")
	@Description("Try to create user's account with exist email")
	public void create_account_exist_email() {
		logger.info("===> Iniciando caso de prueba: Create account exist email");
		account.selectProfileOption();
		account.selectCreateAccount();
		account.createAccount("Juan","Lopez",GeneralConstants.TEST_EMAIL,GeneralConstants.TEST_PASS);
		account.validateExistEmail();
		logger.info("Caso de prueba finalizado");
	}
	
	//@Test
	@DisplayName("Create account")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to create my account")
	@Description("Create user's account with valid data")
	public void create_account() {
		logger.info("===> Iniciando caso de prueba: Create account");
		account.selectProfileOption();
		account.selectCreateAccount();
		account.createAccount("Maria","Tester",GeneralConstants.TEST_EMPTY_EMAIL,GeneralConstants.TEST_EMPTY_PASS);
		account.validateCreateAccount();
		logger.info("Caso de prueba finalizado");
	}
}
