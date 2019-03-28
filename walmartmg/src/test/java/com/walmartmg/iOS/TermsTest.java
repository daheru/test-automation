package com.walmartmg.iOS;

import org.junit.AfterClass;
import org.junit.Test;

public class TermsTest {

	public static TermsBusinessTest Terms = new TermsBusinessTest();
    
	@AfterClass
	public static void tearDown(){
		 Terms.desconectarDriver();
		 
	}
	 	@Test // validacion de  LEGALES
	 public void Creat() {
	 	    Terms.selectProfile();
	 		Terms.selectMenu();
	        Terms. Validate();
	      
		
	}
	









}


	