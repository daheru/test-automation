package com.walmartmg.iOS.registered;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.iOS.HelpBusinessTest;
import com.walmartmg.business.iOS.LoginBusinessTest;
import com.walmartmg.business.iOS.registered.ProfileOnBusinessTest;
import com.walmartmg.iOS.LoginTest;

public class ProfileOnTest {

	private LoginBusinessTest login = new LoginBusinessTest();

	private static final Logger logger = Logger.getLogger(LoginTest.class);
	public static ProfileOnBusinessTest profile_on = new ProfileOnBusinessTest();

	@AfterClass
	public static void tearDown() {
		profile_on.driverDisconect();

	}

	@Before
	public void init() {
		profile_on.closeIOSDialog();
	}

	@Test
	public void CP082_Validate_screen() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.validateLoginIn();
		logger.info("Se da click en el icono de Perfil ");
		login.selectProfile();
		profile_on.Validate_Screen_profile();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP083_Date_personal() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.validateLoginIn();
		logger.info("Se da click en el icono de TU Perfil ");
		login.selectProfile();
		profile_on.Validate_DAte_Personal();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP084_Personal_data_Edit_with_invalid_data() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.selectProfile();
		profile_on.Edit_with_invalid_data("kj8474895", "uuiuf942", "");
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP085_Personal_data_Edit_with_valid_data() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.selectProfile();
		profile_on.Validate_Data_Personal("Miranda", "Cruz");
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP086_Validates_Screen_Logon_data() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.selectProfile();
		profile_on.Logon_date();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP087_Validate_error_messages() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.selectProfile();
		profile_on.Logon_date();
		profile_on.Error_Messages();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP088_Validate_error_messages_when_entering_incorrect_data() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.selectProfile();
		profile_on.When_Entering_Incorrect_Data("674839jfif", "ii40odn3434");
		profile_on.Incorrect_data();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test // when entering correct data
	public void CP089_Success_Messages() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.selectProfile();
		profile_on.When_Entering_Incorrect_Data("emilze080714", "regina080714");
		profile_on.Correct_data();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP090_Telephone_information_screen() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "emilze080714");
		login.selectProfile();
		profile_on.Validate_Telephone_information_screen();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP091_Validate_success_message() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "emilze080714");
		login.selectProfile();
		profile_on.When_Editing_Telephone_Information("5542054501", "5544203573");
		profile_on.validate_mensage();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP092_CP0093_Screen_Validate_Your_addresses() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "emilze080714");
		login.selectProfile();
		profile_on.Screen_validate();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP094_Validate_error_messages_with_empty_form() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "emilze080714");
		login.selectProfile();
		profile_on.Messages_with_empty_form();
		profile_on.Validate_error_mensage();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP095_Valida_date_formulari() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "emilze080714");
		login.selectProfile();
		// profile_on.Validate_date_capturing_correct("abu","omar","juarez","capuchinas");
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP99_Validate_the_screen_of_your_orders() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("javier_miranda@hotmail.com", "12345678");
		login.selectProfile();
		profile_on.With_a_new_account();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP100_Validate_list_orders() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("javier_miranda@hotmail.com", "12345678");
		login.selectProfile();
		profile_on.List_orders();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP101_102_103_Validate_Help() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("javier_miranda@hotmail.com", "12345678");
		login.selectProfile();
		profile_on.Validate_HELP();
		profile_on.Call_Us();
		profile_on.Mail_button();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP104_Legal() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("javier_miranda@hotmail.com", "12345678");
		login.selectProfile();
		profile_on.Validate_legal();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP105_al_115_TERMS_CONDI() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("javier_miranda@hotmail.com", "12345678");
		login.selectProfile();
		profile_on.click_terms();
		profile_on.VALIDATE_TERMS_COND();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}
	@Test
	public void CP116_closed() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("javier_miranda@hotmail.com", "12345678");
		login.selectProfile();
		profile_on.closed_sesion();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	
	}
	
}
