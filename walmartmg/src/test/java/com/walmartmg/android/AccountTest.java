package com.walmartmg.android;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.android.AccountBusinessTest;

public class AccountTest {

	public static AccountBusinessTest account = new AccountBusinessTest();
	
	@AfterClass
	public static void tearDown(){
		account.desconectarDriver();
	}	
	
	@Before
	public void resetApp() {
		account.closeApp();
		account.lauchApp();
	}
	
	@Test
	public void create_account_validate_page() {
		account.selectProfileOption();
		account.selectCreateAccount();
		account.validateElements();
	}
	
	@Test
	public void create_Account_Without_Data() {
		account.selectProfileOption();
		account.selectCreateAccount();
		account.createAccount("","","","");
		account.validateErrorMessages("", "", "", "");
	}
	
	@Test
	public void create_Account_With_Wrong_Data() {
		account.selectProfileOption();
		account.selectCreateAccount();
		account.createAccount("123Juan","Bautista","correo@correo.com","12345678");
		account.validateErrorMessages("123Juan","Bautista","correo@correo.com","12345678");
	}
	
	@Test
	public void show_password() {
		account.selectProfileOption();
		account.selectCreateAccount();
		account.showPassword("hola123");
	}
	
	@Test
	public void term_link() {
		account.selectProfileOption();
		account.selectCreateAccount();
		account.tapTermsLink();
		account.validateTerms(5);
	}
	
	@Test
	public void login_button() {
		account.selectProfileOption();
		account.selectCreateAccount();
		account.tapLoginLink();
		account.validateLogin();
	}
	
	
}
