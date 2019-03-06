package com.walmartmg.mobileTesting;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.LoginBusinessTest;

/**
 * Unit test for simple App.
 */
public class LoginTest 
{
	public static LoginBusinessTest login = new LoginBusinessTest();
	
	@AfterClass
	public static void tearDown(){
		login.desconectarDriver();
	}	
	
	@Before
	public void resetApp() {
		login.closeApp();
    	login.lauchApp();
	}
	
    @Test
    public void loginTest_Success() {
    	login.login("dj_fran_@hotmail.es", "080714regina");
    	login.validateLogin("dj_fran_@hotmail.es");
    }
    
    @Test
    public void loginTest_Fail() {
    	login.login("dj_fran@hotmail.es", "123456");
    	login.validateErrorMessages("dj_fran@hotmail.es", "123456");
    }
    
    @Test
    public void loginTest_Without_Data() {
    	login.login("", "");
    	login.validateErrorMessages("", "");
    }
}
