package com.walmartmg.iOS;

import org.junit.AfterClass;
import org.junit.Test;

public class LoginTest {

	public static LoginBusinessTest login = new LoginBusinessTest();
    
	@AfterClass
	public static void tearDown(){
		login.desconectarDriver();
	}	
	
	@Test  //pass correcto Validar Crear cuenta  //Crear cuenta/Correo existente
	public void loginSuccessful() {
		
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.validateLoginSuccessful();	
		
	}
	@Test //pasword incorrecto   password incorrecto 
	public void PassFail() {
		
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "Regina080714");	
		login.validateLoginfail();
		
	}
	
    
    @Test  //  password incorrecto menor a 8 caracteres  
       public void loginminor(){
    	login.selectProfile();
    	login.selectMenu();
    	login.loginminor();
    	login.validateMinor();
    }
    
     @Test// mail incorrecto /validacion de correo
     public void Validatemail() {
    	 login.selectProfile();
    	 login.selectMenu();
    	 login.mailfail();
    	 login.Vmail();
    	 
     }
    	 
    	 
      @Test//  CORREO NO EXITENTE
      public void notRegs(){
    	  login.selectProfile();
    	  login.selectMenu();
    	  login.login("javier_miranda@hotmail.com", "12345678");    	  
    	  login.RegNotuser();
    	 
    		 
    		 
    	 }
    	 
     
    
}

	
	

