package com.walmartmg.android.registered;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.walmartmg.business.android.InvoiceBusinessTest;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Feature("Profile Module - Whit session")
public class InvoiceTest {
	
	@Rule
	public TestName name = new TestName();
	public static final Logger logger = Logger.getLogger( InvoiceTest.class );
	public static InvoiceBusinessTest invoice = new InvoiceBusinessTest();

	@AfterClass
	public static void tearDown() {
		invoice.driverDisconect();
	}

	@Before
	public void initApp() {
		logger.info("===> Iniciando caso de prueba: " + name.getMethodName());
	}
	
	@After
	public void resetApp() {
		invoice.resetApp();
		logger.info("Caso de prueba finalizado");
	}

	
	//Validate screen
	@Test
	@DisplayName("Validate invoice")
	@Severity(SeverityLevel.MINOR)
	@Story("Validate screen invoice")
	@Description("Validate screen of the menu option request invoice")
	public void CP110_validate_screen_invoice() {
		logger.info("Start CP110 validate screen invoice");
		invoice.selectProfileOption();
		invoice.selectMenuLogin();
		invoice.login("alejandra.jra11@gmail.com", "12345678");
		invoice.selectRequestInvoice();
		invoice.validateElements();
	}
	
	
	@Test
	@DisplayName("Validate invoice")
	@Severity(SeverityLevel.NORMAL)
	@Story("Validate empty code invoice")
	@Description("Validate screen of the menu option request invoice")
	public void CP113_empty_code_invoice(){
		logger.info("Start CP113 Validate Empty field");
		invoice.selectProfileOption();
		invoice.selectMenuLogin();
		invoice.login("alejandra.jra11@gmail.com", "12345678");
		invoice.selectRequestInvoice();
		invoice.validateCodeInvoice("");
		invoice.validateMessageEmpty();	
	}
	
	@Test
	@DisplayName("Validate invoice")
	@Severity(SeverityLevel.NORMAL)
	@Story("Validate correct code")
	@Description("Validate screen of the menu option request invoice")
	public void CP113_code_correct_invoice() {
		logger.info("Start CP113 Validate correct code");
		invoice.selectProfileOption();
		invoice.selectMenuLogin();
		invoice.login("alejandra.jra11@gmail.com", "12345678");
		invoice.selectRequestInvoice();
		invoice.validateCodeInvoice("55830475286542537193");
	}
	
	@Test
	@DisplayName("Validate invoice")
	@Severity(SeverityLevel.NORMAL)
	@Story("Validate code wrong invoice")
	@Description("Validate screen of the menu option request invoice")
	public void CP114_code_wrong_invoice() {
		logger.info("Start CP114 Validate wrong code");
		invoice.selectProfileOption();
		invoice.selectMenuLogin();
		invoice.login("alejandra.jra11@gmail.com", "12345678");
		invoice.selectRequestInvoice();
		invoice.validateCodeInvoice("55830475286542537199");
		invoice.validateMessageError();
	}

}
