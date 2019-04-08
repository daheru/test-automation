package com.walmartmg.android;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.android.AccountBusinessTest;

public class AccountTest {

	public static AccountBusinessTest account = new AccountBusinessTest();
	
	@AfterClass
	public static void tearDown(){
		account.driverDisconect();
	}	
	
	@Before
	public void resetApp() {
		account.closeApp();
		account.lauchApp();
	}
	
	@Test
	public void CP027_create_account_validate_page() {
		account.selectProfileOption();
		account.selectCreateAccount();
		account.validateElements();
	}
	
	@Test
	public void CP028_create_account_without_data() {
		account.selectProfileOption();
		account.selectCreateAccount();
		account.createAccount("","","","");
		account.validateEmptyFields();
	}
	
	@Test
	public void CP029_create_account_with_invalid_data() {
		account.selectProfileOption();
		account.selectCreateAccount();
		account.createAccount("12345·$%","12344|@#","akakak.com@","123");
		account.validateInvalidData();
	}
	
	@Test
	public void CP030_create_account_exist_email() {
		account.selectProfileOption();
		account.selectCreateAccount();
		account.createAccount("Juan","Lopez","dj_fran_@hotmail.es","12345678");
		account.validateExistEmail();
	}
	
	@Test
	public void CP031_validate_terms() {
		account.selectProfileOption();
		account.selectCreateAccount();
		account.tapTermsLink();
		account.validateTerms(5);
	}
	
	@Test
	public void CP032_validate_login_link() {
		account.selectProfileOption();
		account.selectCreateAccount();
		account.tapLoginLink();
		account.validateLogin();
	}
	
	//@Test
	public void CP033_create_account() {
		account.selectProfileOption();
		account.selectCreateAccount();
		account.createAccount("Maria","Tester","test1@correo.com","Test#1234");
		account.validateCreateAccount();
	}
	
	@Test
	public void show_password() {
		account.selectProfileOption();
		account.selectCreateAccount();
		account.showPassword("NuevoPass12345");
	}	
}
