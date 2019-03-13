package com.bodega.business.android;

import java.util.List;

import org.junit.Assert;

import com.bodega.commons.GeneralConstants;
import com.bodega.commons.MenuOptionsEnum;
import com.bodega.commons.MobileNamesConstants;
import com.bodega.commons.PropertiesConstants;
import com.bodega.util.BaseDriver;
import com.bodega.vo.AddressVO;

import io.appium.java_client.MobileElement;

public class MainBusinessTest extends BaseDriver {

	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	public LoginBusinessTest login = new LoginBusinessTest();
	
	
	public void login( String email, String pass) {
		login.goToLogin();
		login.login( email, pass);
	}
	
	public void selectProfile() {
		generalBusinessTest.selectProfile();
	}
	
	public void selectMenuDirections() {	
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.ADDRESS.getMenu() );
	}
	
	public void addNewDirection( AddressVO addressVO ) {
		waitVisibility( MobileNamesConstants.ADDRESS_LIST );
		tapOnElement( MobileNamesConstants.ADDRESS_ADD_BUTTON );
		fillElement( MobileNamesConstants.ADDRESS_NAME_TEXT , addressVO.getAddressName());
		fillElement( MobileNamesConstants.ADDRESS_USER_NAME , addressVO.getAddressUserName());
		fillElement( MobileNamesConstants.ADDRESS_USER_LAST_NAME , addressVO.getAddressUserLastName());
		fillElement( MobileNamesConstants.ADDRESS_STREET_TEXT , addressVO.getAddressStreet());
		fillElement( MobileNamesConstants.ADDRESS_OUT_NUMBER , addressVO.getAddressOutNumber());
		fillElement( MobileNamesConstants.ADDRESS_INNER_NUMBER , addressVO.getAddressInnerNumber());
		tapOnElement( MobileNamesConstants.ADDRESS_ZIP_CODE );
		fillElement( MobileNamesConstants.ADDRESS_ZIP_CODE , addressVO.getAddressZipcode());
		hideKeyboard();
		waitVisibility( MobileNamesConstants.ADDRESS_NEIGHBORNHOOD );
		tapOnElement( MobileNamesConstants.ADDRESS_NEIGHBORNHOOD );
		List<MobileElement> neighbornhoods = findElements( MobileNamesConstants.ADDRESS_COMBO_OPTIONS );
		for( MobileElement neighbornhood : neighbornhoods ) {
			if( neighbornhood.getAttribute( PropertiesConstants.ATTRIBUTE_TEXT ).toLowerCase().contains( addressVO.getAddressNeighbornhood().toLowerCase() ) ) {
				neighbornhood.click();
				break;
			}
		}
		generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_UP , MobileNamesConstants.ADDRESS_REFERENCES_ONE );
		fillElement( MobileNamesConstants.ADDRESS_REFERENCES_ONE , addressVO.getAddressReferenceOne());
		generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_UP , MobileNamesConstants.ADDRESS_SAVE_BUTTON );
		fillElement( MobileNamesConstants.ADDRESS_REFERENCES_TWO , addressVO.getAddressReferenceTwo());
		tapOnElement( MobileNamesConstants.ADDRESS_PHONE_TYPE );
		List<MobileElement> phoneTypes = findElements( MobileNamesConstants.ADDRESS_COMBO_OPTIONS );
		for( MobileElement phoneType : phoneTypes ) {
			if( phoneType.getAttribute( PropertiesConstants.ATTRIBUTE_TEXT ).toLowerCase().contains( addressVO.getAddressPhoneOption().toLowerCase() ) ) {
				phoneType.click();
				break;
			}
		}
		fillElement( MobileNamesConstants.ADDRESS_PHONE_TEXT , addressVO.getAddressPhone());
	}
	
	public void selectAsMainAddress(boolean check) {
		MobileElement checkMainAddress = findElement( MobileNamesConstants.ADDRESS_MAIN_ADDRESS_CHECK );
		boolean checkMainAddressBool =  Boolean.parseBoolean( checkMainAddress.getAttribute( GeneralConstants.CHECKED ) );
		if( check && !checkMainAddressBool) {
			tapOnElement( MobileNamesConstants.ADDRESS_MAIN_ADDRESS_CHECK );
		}
	}
	
	public void saveDirection() {	
		tapOnElement( MobileNamesConstants.ADDRESS_SAVE_BUTTON );
	}
	
	public void validateAddressAsFavorite(boolean favorite, String name) {
		waitVisibility( MobileNamesConstants.ADDRESS_LIST );
		List<MobileElement> address = findSubElements( findElement( MobileNamesConstants.ADDRESS_LIST ),  MobileNamesConstants.ADDRESS_DETAIL_NAME );
		if( favorite ) {
			Assert.assertEquals(name.toLowerCase(), getText(address.get(0)) );
		} else {
			Assert.assertEquals(name.toLowerCase(), getText(address.get( address.size() - 1 )) );
		}
	}
	
	public void validateMessage() {
		generalBusinessTest.validateMessage();
	}
	
	public void editAddress( AddressVO addressVO ) {
		if( elementExist(MobileNamesConstants.ADDRESS_DETAIL_EDIT) ) {
			tapOnElement( MobileNamesConstants.ADDRESS_DETAIL_EDIT );
			fillElement( MobileNamesConstants.ADDRESS_NAME_TEXT , addressVO.getAddressName());
			generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_UP , MobileNamesConstants.ADDRESS_SAVE_BUTTON );
			fillElement( MobileNamesConstants.ADDRESS_PHONE_TEXT , addressVO.getAddressPhone());
		} 
	}
}
