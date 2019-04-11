package com.walmartmg.iOS;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.iOS.TermsBusinessTest;
import com.walmartmg.business.iOS.TermsyConditionsBusinessTest;

public class TermsyConditionsTest {
	private static final Logger logger = Logger.getLogger(TermsyConditionsBusinessTest.class);

	
public static TermsyConditionsBusinessTest  Condition = new TermsyConditionsBusinessTest();
    
	@AfterClass
	public static void tearDown(){
		 Condition.driverDisconect();

}
	@Before
	public void init() {
		Condition.closeIOSDialog();
	}

	@Test
	public void CP035_AL_CP045_Validate_Termns_conditions_() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		Condition.selectProfile();
		Condition.selectMenu();
		Condition.cond();
		Condition.cond2();
	    Condition.cond3();
	    Condition.cond4();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

		
		
	}
		
}	
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

