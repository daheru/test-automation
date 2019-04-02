package com.walmartmg.iOS;

import org.junit.AfterClass;
import org.junit.Test;

import com.walmartmg.business.iOS.TermsyConditionsBusinessTest;

public class TermsyConditionsTest {
	
public static TermsyConditionsBusinessTest  Condition = new TermsyConditionsBusinessTest();
    
	@AfterClass
	public static void tearDown(){
		 Condition.driverDisconect();

}
	@Test
	public void valid() {
		Condition.selectProfile();
		Condition.selectMenu();
		Condition.cond();
		Condition.cond2();
	    Condition.cond3();
	    Condition.cond4();
		
		
	}
		
}	
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

