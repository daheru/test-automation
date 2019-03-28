package com.bodega.business.android;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Assert;

import com.bodega.constants.AppMessages;
import com.bodega.constants.ConfigConstants;
import com.bodega.constants.GeneralConstants;
import com.bodega.constants.NamesMobileElements;
import com.bodega.enums.MenuOptionsEnum;
import com.bodega.enums.MenusEnum;
import com.bodega.util.BaseDriver;
import com.bodega.vo.AddressVO;

import io.appium.java_client.MobileElement;

public class MainBusinessTest extends BaseDriver {

	public static final Logger logger = Logger.getLogger(MainBusinessTest.class);
	public GeneralBusinessTest generalBusinessTest = new GeneralBusinessTest();
	public LoginBusinessTest login = new LoginBusinessTest();
	public static int numAddress = 0;
	
	public void login( String email, String pass) {
		login.login( email, pass);
	}
	
	public void selectProfile() {
		logger.info("Tap en perfil");
		generalBusinessTest.selectProfile();
	}
	
	public void selectMenu( String menuOption ) {
		generalBusinessTest.selectMenuOption( menuOption );
	}
	
	public void selectAddAddress() {
		logger.info("Tap en agrega direccion");
		waitVisibility( NamesMobileElements.ADDRESS_LIST );
		tapOnElement( NamesMobileElements.ADDRESS_ADD_BUTTON );
	}
	
	public void addNewDirection( AddressVO addressVO ) {
		logger.info("Ingresado datos");
		randomAddressName( addressVO );
		fillElement( NamesMobileElements.ADDRESS_NAME_TEXT , addressVO.getAddressName());
		fillElement( NamesMobileElements.ADDRESS_USER_NAME , addressVO.getAddressUserName());
		fillElement( NamesMobileElements.ADDRESS_USER_LAST_NAME , addressVO.getAddressUserLastName());
		fillElement( NamesMobileElements.ADDRESS_STREET_TEXT , addressVO.getAddressStreet());
		fillElement( NamesMobileElements.ADDRESS_OUT_NUMBER , addressVO.getAddressOutNumber());
		fillElement( NamesMobileElements.ADDRESS_INNER_NUMBER , addressVO.getAddressInnerNumber());
		generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_UP , NamesMobileElements.ADDRESS_ZIP_CODE );
		tapOnElement( NamesMobileElements.ADDRESS_ZIP_CODE );
		fillElement( NamesMobileElements.ADDRESS_ZIP_CODE , addressVO.getAddressZipcode());
		hideKeyboard();
		waitVisibility( NamesMobileElements.ADDRESS_NEIGHBORNHOOD );
		tapOnElement( NamesMobileElements.ADDRESS_NEIGHBORNHOOD );
		List<MobileElement> neighbornhoods = findElements( NamesMobileElements.COMBO_OPTIONS );
		for( MobileElement neighbornhood : neighbornhoods ) {
			if( neighbornhood.getAttribute( ConfigConstants.ATTRIBUTE_TEXT ).toLowerCase().contains( addressVO.getAddressNeighbornhood().toLowerCase() ) ) {
				neighbornhood.click();
				break;
			}
		}
		generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_UP , NamesMobileElements.ADDRESS_REFERENCES_TWO );
		fillElement( NamesMobileElements.ADDRESS_REFERENCES_ONE , addressVO.getAddressReferenceOne());
		generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_UP , NamesMobileElements.ADDRESS_SAVE_BUTTON );
		fillElement( NamesMobileElements.ADDRESS_REFERENCES_TWO , addressVO.getAddressReferenceTwo());
		tapOnElement( NamesMobileElements.ADDRESS_PHONE_TYPE );
		List<MobileElement> phoneTypes = findElements( NamesMobileElements.COMBO_OPTIONS );
		for( MobileElement phoneType : phoneTypes ) {
			if( phoneType.getAttribute( ConfigConstants.ATTRIBUTE_TEXT ).toLowerCase().contains( addressVO.getAddressPhoneOption().toLowerCase() ) ) {
				phoneType.click();
				break;
			}
		}
		fillElement( NamesMobileElements.ADDRESS_PHONE_TEXT , addressVO.getAddressPhone());
	}
	
	public void selectAsMainAddress(boolean check) {
		logger.info("Tap en checkbox de direccion principal");
		MobileElement checkMainAddress = findElement( NamesMobileElements.ADDRESS_MAIN_ADDRESS_CHECK );
		boolean checkMainAddressBool =  Boolean.parseBoolean( checkMainAddress.getAttribute( GeneralConstants.CHECKED ) );
		if( check && !checkMainAddressBool ) {
			tapOnElement( NamesMobileElements.ADDRESS_MAIN_ADDRESS_CHECK );
		} if( !check && checkMainAddressBool ) {
			tapOnElement( NamesMobileElements.ADDRESS_MAIN_ADDRESS_CHECK );
		}
	}
	
	public void saveDirection() {
		logger.info("Tap en guardar direccion");
		generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_UP , NamesMobileElements.ADDRESS_SAVE_BUTTON );
		tapOnElement( NamesMobileElements.ADDRESS_SAVE_BUTTON );
	}
	
	public void validateAddress( boolean isEdition, String validationMessage ) {
		generalBusinessTest.validatePopUpMessages(validationMessage);
	}
	
	public void editAddress( AddressVO addressVO ) {
		logger.info("Editando direccion");
		if( elementExist(NamesMobileElements.ADDRESS_DETAIL_EDIT) ) {
			tapOnElement( NamesMobileElements.ADDRESS_DETAIL_EDIT );
			randomAddressName( addressVO );
			fillElement( NamesMobileElements.ADDRESS_NAME_TEXT , addressVO.getAddressName() );
			generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_UP , NamesMobileElements.ADDRESS_SAVE_BUTTON );
			fillElement( NamesMobileElements.ADDRESS_PHONE_TEXT , addressVO.getAddressPhone());
		} 
	}
	
	public void removeAddress( AddressVO addressVO ) {
		logger.info("Eliminando direccion");
		if( elementExist( NamesMobileElements.ADDRESS_DETAIL_DELETE ) ) {
			List<MobileElement> deletes = findElements( NamesMobileElements.ADDRESS_DETAIL_DELETE );
			numAddress = deletes.size();
			tapOnElement( deletes.get( numAddress - 1 ) );
			waitVisibility( NamesMobileElements.ADDRESS_DIALOG_DELETE );
			tapOnElement( NamesMobileElements.ADDRESS_DIALOG_DELETE );
		} else {
			randomAddressName( addressVO );
			addNewDirection(addressVO);
			selectAsMainAddress(false);
			saveDirection();
			validateAddress(false, AppMessages.ADD_ADDRESS);
			removeAddress(addressVO);
		}
	}
	
	public void validateRemoveAddress() {
		generalBusinessTest.validatePopUpMessages( AppMessages.REMOVE_ADDRESS );
	}
	
	public void validateOrderPage() {
		if( elementExist( NamesMobileElements.ORDER_EMPTY_CONT ) ) {
			generalBusinessTest.validateElement( NamesMobileElements.ORDER_EMPTY_ICON );
			generalBusinessTest.validateElement( NamesMobileElements.ORDER_EMPTY_BUTTON );
		} else if( elementExist( NamesMobileElements.ORDER_ORDER_LIST ) ) {
			List<MobileElement> orders = findElements( NamesMobileElements.ORDER_ORDER_CONT);
			Assert.assertTrue( orders.size() > 0 );
		}
	}
	
	public String[] orderDetail() {
		waitVisibility( NamesMobileElements.ORDER_ORDER_CONT );
		String orderNumber[] = { getText( NamesMobileElements.ORDER_ORDER_NUMBER ), 
				getText( NamesMobileElements.ORDER_ORDER_DATE )};
		tapOnElement( NamesMobileElements.ORDER_ORDER_DETAIL_LINK );
		return orderNumber;
	}
	
	public void validateOrderDetail( String[] orderNumber ) {
		String orderDetailNumber = getText( NamesMobileElements.ORDER_DETAIL_ORDER_NUMBER );
		String orderDetailDate = getText( NamesMobileElements.ORDER_DETAIL_ORDER_DATE );
		Assert.assertTrue( orderDetailNumber.equals( orderNumber[0] ) );
		Assert.assertTrue( orderDetailDate.contains( orderNumber[1] ) );
		generalBusinessTest.validateElement( NamesMobileElements.ORDER_DETAIL_ORDER_LIST );
		generalBusinessTest.validateElement( NamesMobileElements.ORDER_DETAIL_ORDER_PRICE );
	}
	
	public void manualBill( String ticketCode ) {
		waitVisibility( NamesMobileElements.GETBILL_SCAN_CONT );
		tapOnElement( NamesMobileElements.GETBILL_MANUAL_CODE );
		fillElement( NamesMobileElements.GETBILL_SCAN_MANUAL_TICKET_NUMBER , ticketCode);
		tapOnElement( NamesMobileElements.GETBILL_SCAN_MANUAL_BUTTON );
	}
	
	public void validateTerms(int elementNum) {
		MobileElement menuTerm = findElement( NamesMobileElements.LIST_TERMS );
		List<MobileElement> terms = findSubElements( menuTerm, NamesMobileElements.LIST_TERM_ELEMENT );
		Assert.assertEquals(elementNum, terms.size());
		for( MobileElement element : terms) {
			tapOnElement(element);
			tapOnElement( NamesMobileElements.BACK_BUTTON );
		}
	}
	
	public void validateSupportPage() {
		waitVisibility( NamesMobileElements.SUPPORT_CALL_ICON );
		generalBusinessTest.validateElement( NamesMobileElements.SUPPORT_CALL_ICON );
		generalBusinessTest.validateElement( NamesMobileElements.SUPPORT_EMAIL_ICON );
	}
	
	public void validateLogout( ) {
		logger.info("Validando Login");
		selectProfile();
		selectMenu( MenuOptionsEnum.LOGIN.getMenu() );
		Assert.assertTrue( elementExist(NamesMobileElements.LOGIN_LOGIN_BUTTON) );
	}
	
	public void validateLegalsPage( ) {
		generalBusinessTest.valitateMenuAndSubMenus( MenusEnum.LEGALS_TERMS );
		generalBusinessTest.valitateMenuAndSubMenus( MenusEnum.LEGALS_PRIVACITY );
		List<MobileElement> terms = findElements( NamesMobileElements.LEGALS_ITEM );
		Assert.assertEquals( ConfigConstants.APP_VERSION.toLowerCase() , getText( terms.get(2) ));
	}
	
	private void randomAddressName( AddressVO addressVO ) {
		Random generator = new Random();
		String newAddress = addressVO.getAddressName() + " " + generator.nextInt(100);
		addressVO.setAddressName(newAddress);
	}
	
	public void validateErrorMessages(String message, String element) {
		logger.info("Validando mensajes de error");
		generalBusinessTest.validateFieldErrorMessage( message, element);
	}
	
	public void validateAddressErrorMessages() {
		generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_DOWN , NamesMobileElements.ADDRESS_NAME_TEXT_CONT);
		validateErrorMessages(AppMessages.EMPTY_FIELD, NamesMobileElements.ADDRESS_NAME_TEXT_CONT);
		validateErrorMessages(AppMessages.EMPTY_FIELD, NamesMobileElements.ADDRESS_STREET_TEXT_CONT);
		validateErrorMessages(AppMessages.EMPTY_FIELD, NamesMobileElements.ADDRESS_OUT_NUMBER_CONT);
		generalBusinessTest.scrollUntilShowElement( GeneralConstants.SCROLL_UP , NamesMobileElements.ADDRESS_SAVE_BUTTON);
		validateErrorMessages(AppMessages.EMPTY_FIELD, NamesMobileElements.ADDRESS_ZIP_CODE_CONT);
		validateErrorMessages(AppMessages.EMPTY_FIELD, NamesMobileElements.ADDRESS_PHONE_TEXT_CONT);
	}
}
