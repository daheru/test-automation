package com.walmartmg.iOS;

import org.junit.Assert;

import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.commons.MenuOptionsEnum;
import com.walmartmg.commons.MobileNamesConstants;
import com.walmartmg.commons.NavigationBarEnum;
import com.walmartmg.util.BaseDriver;


public class HelpBusinessTest  extends BaseDriver{
	public GeneralBusinessTest general = new GeneralBusinessTest();
	
	public void selectProfile() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE.getNavigation());
		
	}
	public void selectMenu() {
		general.selectMenuOption(MenuOptionsEnum.SUPPORT.getMenu());
		
	}
	
	
	public void helpPage(){
		
	
	   String massageOK = getText(MobileNamesConstants.HELP);	
		Assert.assertEquals("¿Necesitas ayuda?".toLowerCase(), massageOK.toLowerCase());
	  
		String massageOK1 = getText(MobileNamesConstants.HELP_TEL);	
		Assert.assertEquals("Llama al 01 800 925 6278".toLowerCase(), massageOK1.toLowerCase());
		
		String massageOK2 = getText(MobileNamesConstants.HELP_TEXT_LLAMANOS);	
		Assert.assertEquals("Llámanos".toLowerCase(), massageOK2.toLowerCase());
		
		String massageOK3 = getText(MobileNamesConstants.HELP_TEXT_MAIL);	
		Assert.assertEquals("Escríbenos".toLowerCase(), massageOK3.toLowerCase());
	}
}
	
	
		
	 
       
       
		
		
	