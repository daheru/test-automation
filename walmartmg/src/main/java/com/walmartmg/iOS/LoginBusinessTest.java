

package com.walmartmg.iOS;

import org.junit.Assert;

import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.commons.MenuOptionsEnum;
import com.walmartmg.commons.MobileNamesConstants;
import com.walmartmg.commons.NavigationBarEnum;
import com.walmartmg.util.BaseDriver;


public class LoginBusinessTest extends BaseDriver{
  
	public GeneralBusinessTest general = new GeneralBusinessTest();
	
	
	public void selectProfile() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE.getNavigation());
		
	}
	public void selectMenu() {
		general.selectMenuOption(MenuOptionsEnum.LOGIN.getMenu());
		
	}
	
	
//contraseña_correcta 	
    public void login(String email, String pass) {
		fillElement(MobileNamesConstants.LOGIN_EMAIL, email);
	    fillElement(MobileNamesConstants.LOGIN_PASS, pass);
	    waitVisibility(MobileNamesConstants.SHOW_PASS);
	    tapOnElement(MobileNamesConstants.SHOW_PASS);
		tapOnElement(MobileNamesConstants.LOGIN_BUTTON);
	}
//validacion mensaje_de_contraseña_correcta
	public void  validateLoginSuccessful() {
		waitVisibility(MobileNamesConstants.MENSSAGE_OK);
		general.validateElement(MobileNamesConstants.MENSSAGE_OK);
	
	}

	//// validacion Contraseña_incorrecta_mensaje_de_contraseña.
	public void validateLoginfail() {
		String massageFail = getText(MobileNamesConstants.MENSSAGE_FAIL);	
		Assert.assertEquals("El correo o la contraseña no son correctos.".toLowerCase(), massageFail.toLowerCase());
		tapOnElement(MobileNamesConstants.BUTTON_FAIL);
	}
	

	
	
//  password incorrecto menor a 8 caracteres  
	public void loginminor() {
		fillElement(MobileNamesConstants.LOGIN_EMAIL, "dj_fran_@hotmail.es");
		fillElement(MobileNamesConstants.LOGIN_PASS, "Regina");
		waitVisibility(MobileNamesConstants.SHOW_PASS);
		tapOnElement(MobileNamesConstants.SHOW_PASS);
		
		tapOnElement(MobileNamesConstants.LOGIN_BUTTON);
	}
//validacion 	
	  
	public void	 validateMinor() {
		String massageFail = getText(MobileNamesConstants.MENSSAGE_MINOR);	
		Assert.assertEquals("Ocurrio un error, favor de intentar nuevamente".toLowerCase(), massageFail.toLowerCase());
		tapOnElement(MobileNamesConstants.BUTTON_FAIL);
	}

	
	
//mail incorrecto 
	public void mailfail() {
		fillElement(MobileNamesConstants.LOGIN_EMAIL, "dj_fran_@hotmail.com");
		fillElement(MobileNamesConstants.LOGIN_PASS, "080714regina");
		tapOnElement(MobileNamesConstants.SHOW_PASS);
		tapOnElement(MobileNamesConstants.LOGIN_BUTTON);
		Vmail();
	}
//validacion del mail 
		public void Vmail() {
			 general.validateElement(MobileNamesConstants.MENSSAGE_FAIL);
			 //tapOnElement(MobileNamesConstants.BUTTON_FAIL);
			 general.validateElement(MobileNamesConstants.BUTTON_FAIL);
		  
		    
		    
	}
		
		
		
	   public void RegNotuser() {
		   String massageFail = getText(MobileNamesConstants.MENSSAGE_USERNOTEXIST);	
			Assert.assertEquals("Este usuario no está registrado. Regístrate ahora.".toLowerCase(), massageFail.toLowerCase());	
		tapOnElement(MobileNamesConstants.BUTTON_FAIL);
		   
		   
		   
	   }
		
		
	}
	
	

	
	

