package com.walmartmg.android;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.android.InvoiceBusinessTest;

public class InvoiceTest {
	
	public static final Logger logger = Logger.getLogger( InvoiceTest.class );
	public static InvoiceBusinessTest invoice = new InvoiceBusinessTest();

	@AfterClass
	public static void tearDown(){
		invoice.driverDisconect();
	}	
	
	@Before
	public void resetApp() {
		invoice.closeApp();
		invoice.lauchApp();
	}
	
	//Validate screen
	@Test
	public void CP034_validate_request_invoice() {
		logger.info("Start CP034");
		invoice.selectProfileOption();
		invoice.selectRequestInvoice();
		invoice.validateElements();
	}
	
	
	@Test
	public void CP037_empty_code_invoice(){
		logger.info("Start CP037 Validate Empty field");
		invoice.selectProfileOption();
		invoice.selectRequestInvoice();
		invoice.validateCodeInvoice("");
		invoice.validateMessageEmpty();	
	}
	
	@Test 
	public void CP037_code_correct_invoice() {
		logger.info("Start CP037 Validate correct code");
		invoice.selectProfileOption();
		invoice.selectRequestInvoice();
		invoice.validateCodeInvoice("55830475286542537193");
	}
	
	@Test
	public void CP038_code_wrong_invoice() {
		logger.info("Start CP037 Validate wrong code");
		invoice.selectProfileOption();
		invoice.selectRequestInvoice();
		invoice.validateCodeInvoice("55830475286542537199");
		invoice.validateMessageError();
	}
	

	
	
}
