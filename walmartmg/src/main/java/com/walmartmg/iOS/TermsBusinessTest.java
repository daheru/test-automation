package com.walmartmg.iOS;



import org.junit.Assert;

import com.walmartmg.business.android.GeneralBusinessTest;
import com.walmartmg.commons.MenuOptionsEnum;
import com.walmartmg.commons.MobileNamesConstants;
import com.walmartmg.commons.NavigationBarEnum;
import com.walmartmg.util.BaseDriver;

public class TermsBusinessTest  extends BaseDriver{ 

	public GeneralBusinessTest general = new GeneralBusinessTest();
	
	public void selectProfile() {
		general.selectNavigationOption(NavigationBarEnum.PROFILE.getNavigation());
		
	}
	public void selectMenu() {
		general.selectMenuOption(MenuOptionsEnum.LEGALS.getMenu());
		
	}
	  public void Validate() {
			 general.validateElement(MobileNamesConstants.LEGAL);
			 general.validateElement(MobileNamesConstants.Version);
			 tapOnElement(MobileNamesConstants.Privacy_notice1);
			 general.validateElement(MobileNamesConstants.Privacy_notice2);
			// general.validateElement(MobileNamesConstants.Privacy_notice2);
			
		  
		  
		  
		  
	  }
	
	
}
