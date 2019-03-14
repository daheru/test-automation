package com.bodega.business.android;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.bodega.commons.GeneralConstants;
import com.bodega.commons.MenuOptionsEnum;
import com.bodega.commons.MobileNamesConstants;
import com.bodega.commons.PropertiesConstants;
import com.bodega.util.BaseDriver;
import com.bodega.vo.AddressVO;

import io.appium.java_client.MobileElement;

public class MainBusinessTest extends BaseDriver {

	public static final Logger logger = Logger.getLogger(MainBusinessTest.class);
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	public LoginBusinessTest login = new LoginBusinessTest();
	public static int numAddress = 0;
	
	public void login( String email, String pass) {
		login.goToLogin();
		login.login( email, pass);
	}
	
	public void selectProfile() {
		logger.info("Tap en perfil");
		generalBusinessTest.selectProfile();
	}
	
	public void selectMenuDirections() {
		logger.info("Tap en el menu de direcciones");
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.ADDRESS.getMenu() );
	}
	
	public void addNewDirection( AddressVO addressVO ) {
		waitVisibility( MobileNamesConstants.ADDRESS_LIST );
		logger.info("Tap en agrega direccion");
		tapOnElement( MobileNamesConstants.ADDRESS_ADD_BUTTON );
		logger.info("Ingresado datos");
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
		logger.info("Tap en checkbox de direccion principal");
		MobileElement checkMainAddress = findElement( MobileNamesConstants.ADDRESS_MAIN_ADDRESS_CHECK );
		boolean checkMainAddressBool =  Boolean.parseBoolean( checkMainAddress.getAttribute( GeneralConstants.CHECKED ) );
		if( check && !checkMainAddressBool) {
			tapOnElement( MobileNamesConstants.ADDRESS_MAIN_ADDRESS_CHECK );
		}
	}
	
	public void saveDirection() {
		logger.info("Tap en guardar direccion");
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
		logger.info("Editando direccion");
		if( elementExist(MobileNamesConstants.ADDRESS_DETAIL_EDIT) ) {
			tapOnElement( MobileNamesConstants.ADDRESS_DETAIL_EDIT );
			Random generator = new Random();
			String newAddress = addressVO.getAddressName() + " " + generator.nextInt(100);
			addressVO.setAddressName(newAddress);
			fillElement( MobileNamesConstants.ADDRESS_NAME_TEXT , addressVO.getAddressName() );
			generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_UP , MobileNamesConstants.ADDRESS_SAVE_BUTTON );
			fillElement( MobileNamesConstants.ADDRESS_PHONE_TEXT , addressVO.getAddressPhone());
		} 
	}
	
	public void removeAddress( AddressVO addressVO ) {
		logger.info("Eliminando direccion");
		if( elementExist( MobileNamesConstants.ADDRESS_DETAIL_DELETE ) ) {
			List<MobileElement> deletes = findElements( MobileNamesConstants.ADDRESS_DETAIL_DELETE );
			numAddress = deletes.size();
			tapOnElement( deletes.get( numAddress - 1 ) );
			waitVisibility( MobileNamesConstants.ADDRESS_DIALOG_DELETE );
			tapOnElement( MobileNamesConstants.ADDRESS_DIALOG_DELETE );
		} else {
			addNewDirection(addressVO);
			saveDirection();
			removeAddress(addressVO);
		}
	}
	
	public void validateRemoveAddress() {
		generalBusinessTest.validateMessage();
		List<MobileElement> deletes = findElements( MobileNamesConstants.ADDRESS_DETAIL_DELETE );
		Assert.assertTrue( deletes.size() < numAddress );
	}
	
	public void selectOrders() {
		logger.info("Tap en el menu pedidos");
		generalBusinessTest.selectMenuOption( MenuOptionsEnum.ORDERS.getMenu() );
	}
	
	public void validateOrderPage() {
		if( elementExist( MobileNamesConstants.ORDER_EMPTY_CONT ) ) {
			generalBusinessTest.validateElement( MobileNamesConstants.ORDER_EMPTY_ICON );
			generalBusinessTest.validateElement( MobileNamesConstants.ORDER_EMPTY_BUTTON );
		} else if( elementExist( MobileNamesConstants.ORDER_ORDER_LIST ) ) {
			List<MobileElement> orders = findElements( MobileNamesConstants.ORDER_ORDER_CONT);
			Assert.assertTrue( orders.size() > 0 );
		}
	}
	
	public void orderDetail() {
		waitVisibility( MobileNamesConstants.ORDER_ORDER_CONT );
		tapOnElement( MobileNamesConstants.ORDER_ORDER_DETAIL_LINK );
	}
	
	public void validateOrderDetail() {
		
	}
}
