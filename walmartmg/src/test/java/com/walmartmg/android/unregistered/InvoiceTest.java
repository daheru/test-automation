package com.walmartmg.android.unregistered;

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

@Feature("Invoice Module - No session")
public class InvoiceTest {
	
	@Rule
	public TestName name = new TestName();
	private static final Logger logger = Logger.getLogger( InvoiceTest.class );
	private static InvoiceBusinessTest invoice = new InvoiceBusinessTest();

	@AfterClass
	public static void tearDown(){
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
	@DisplayName("Validate request invoice page")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to request an invoice")
	@Description("Validate that request invoice page has all elements")
	public void CP034_validate_request_invoice() {
		logger.info("Start CP034");
		invoice.selectProfileOption();
		invoice.selectRequestInvoice();
		invoice.validateElements();
	}
	
	@Test
	@DisplayName("Empty invoice code")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to request an invoice")
	@Description("Validate error messages when user inserts an empty invoice code")
	public void CP037_empty_code_invoice(){
		logger.info("Start CP037 Validate Empty field");
		invoice.selectProfileOption();
		invoice.selectRequestInvoice();
		invoice.validateCodeInvoice("");
		invoice.validateMessageEmpty();	
	}
	
	@Test 
	@DisplayName("Correct invoice code")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to request an invoice")
	@Description("Validate invoice page when user inserts a invoice code")
	public void CP037_code_correct_invoice() {
		logger.info("Start CP037 Validate correct code");
		invoice.selectProfileOption();
		invoice.selectRequestInvoice();
		invoice.validateCodeInvoice("55830475286542537193");
	}
	
	@Test
	@DisplayName("Wrong invoice code")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As a user I want to request an invoice")
	@Description("Validate invoice page when user inserts a wrong invoice code")
	public void CP038_code_wrong_invoice() {
		logger.info("Start CP037 Validate wrong code");
		invoice.selectProfileOption();
		invoice.selectRequestInvoice();
		invoice.validateCodeInvoice("55830475286542537199");
		invoice.validateMessageError();
	}	
}
