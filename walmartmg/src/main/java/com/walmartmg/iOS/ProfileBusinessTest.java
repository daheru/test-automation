

package com.walmartmg.iOS;

import org.junit.Assert;

import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.commons.MenuOptionsEnum;
import com.walmartmg.commons.MobileNamesConstants;
import com.walmartmg.commons.NavigationBarEnum;
import com.walmartmg.util.BaseDriver;


public class ProfileBusinessTest extends BaseDriver{
  
	public GeneralBusinessTest general = new GeneralBusinessTest();
	
	
	public void selectProfile() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE.getNavigation());
		
	}
	public void selectMenu() {
		general.selectMenuOption(MenuOptionsEnum.CREATE_PROFILE.getMenu());
		
	}
	//7 crear  cuenta de usuario nuevo 
	public void Accounts() {
		fillElement(MobileNamesConstants.Profile_Name,"Maziel");
		fillElement(MobileNamesConstants.Profile_Last_Name,"Chopin");
		fillElement(MobileNamesConstants.Profile_Mail,"cruz88994443@hotmail.com");//cambiar los digitos
		fillElement(MobileNamesConstants.Profile_Password,"080714javier");
		waitVisibility(MobileNamesConstants.SHOW_PASS);
		tapOnElement(MobileNamesConstants.SHOW_PASS);
		tapOnElement(MobileNamesConstants.Profile_AcceptTerms);
		tapOnElement(MobileNamesConstants.Profile_Button);
	
	}
	// validacion de creacion de cuenta
	 public void vUser() { 
		 
		 general.validateElement(MobileNamesConstants.MENSSAGE_OK);
		 
		// String massageOK = getText(MobileNamesConstants.MENSSAGE_OK);	
			//Assert.assertTrue( massageOK.toLowerCase().contains("tu registro está completo".toLowerCase()));
			
		 
	 }
	 // mensaje de error 
	public void menssage () {
		fillElement(MobileNamesConstants.Profile_Name,"112341234");
		fillElement(MobileNamesConstants.Profile_Last_Name,"Chopin");
		fillElement(MobileNamesConstants.Profile_Mail,"hfiejier@.com");
		fillElement(MobileNamesConstants.Profile_Password,"080714_javier");
		waitVisibility(MobileNamesConstants.SHOW_PASS);
		tapOnElement(MobileNamesConstants.SHOW_PASS);
		tapOnElement(MobileNamesConstants.Profile_AcceptTerms);
		tapOnElement(MobileNamesConstants.Profile_Button);
		
		
	}
	
	// cuenta exietente
	public void exit() {  
	fillElement(MobileNamesConstants.Profile_Name,"Maziel");
		fillElement(MobileNamesConstants.Profile_Last_Name,"Chopin");
	fillElement(MobileNamesConstants.Profile_Mail,"cruz88994333@hotmail.com");
		fillElement(MobileNamesConstants.Profile_Password,"080714javier");
	waitVisibility(MobileNamesConstants.SHOW_PASS);
		tapOnElement(MobileNamesConstants.SHOW_PASS);
		tapOnElement(MobileNamesConstants.Profile_AcceptTerms);
		tapOnElement(MobileNamesConstants.Profile_Button);
	
	}
	
	// validacion de cuenta duplicada
	public void Va() { 
			// general.validateElement(MobileNamesConstants.Profile_menssage);
		String massageOKa = getText(MobileNamesConstants.Profile_menssage);	
		Assert.assertEquals("Ya existe un usuario registrado con este correo electrónico".toLowerCase(),massageOKa.toLowerCase());
		tapOnElement(MobileNamesConstants.BUTTON_MINOR);
	}
}
	
	
	
	

	
	

