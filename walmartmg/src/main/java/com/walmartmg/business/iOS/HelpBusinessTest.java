package com.walmartmg.business.iOS;

import org.junit.Assert;

import com.walmartmg.base.BaseDriver;
import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.constants.NamesMobileElements;
import com.walmartmg.enums.ProfileMenuEnum;
import com.walmartmg.enums.NavigationBarEnum;


public class HelpBusinessTest  extends BaseDriver{
	public GeneralBusinessTest general = new GeneralBusinessTest();
	
	public void selectProfile() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE.getNavigation());
		
	}
	public void selectMenu() {
		general.selectProfileMenu(ProfileMenuEnum.SUPPORT.getMenu());
		
	}
	
	
	public void helpPage(){
		
	
	   String massageOK = getElementText(NamesMobileElements.PROFILE_HELP);
		Assert.assertEquals("¿Necesitas ayuda?".toLowerCase(), massageOK.toLowerCase());
	  
		String massageOK1 = getElementText(NamesMobileElements.PROFILE_HELP_TEL);	
		Assert.assertEquals("Llama al 01 800 925 6278".toLowerCase(), massageOK1.toLowerCase());
		
		String massageOK2 = getElementText(NamesMobileElements.PROFILE_HELP_TEXT_LLAMANOS);	
		Assert.assertEquals("Llámanos".toLowerCase(), massageOK2.toLowerCase());
		
		String massageOK3 = getElementText(NamesMobileElements.PROFILE_HELP_TEXT_MAIL);
		Assert.assertEquals("Escríbenos".toLowerCase(), massageOK3.toLowerCase());
	}
}
	
	
		
	 
       
       
		
		
	