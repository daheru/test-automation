package com.walmartmg.iOS;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.walmartmg.business.iOS.LoginBusinessTest;
import com.walmartmg.business.iOS.ProfileBusinessTest;

public class ProfileTest {
	private LoginBusinessTest login = new LoginBusinessTest();

	private static final Logger logger = Logger.getLogger(LoginTest.class);

	public static ProfileBusinessTest profile = new ProfileBusinessTest();

	@AfterClass

	public static void tearDown() {
		profile.driverDisconect();

	}

	@Before
	public void init() {
		profile.closeIOSDialog();
	}

	@Test
	public void CP082_Validate_screen() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		profile.selectProfile();
		profile.selectMenu();
		profile.Create_account_menu();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP024_Create_account_Validate_empty_fields() {
		profile.selectProfile();
		profile.selectMenu();
		profile.Validate_empty_fields();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP025_Create_account_Incorrect_data() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		profile.selectProfile();
		profile.selectMenu();
		profile.Data("1234", "12234rnmv", "jaid@hotk", "9di");
		profile.validate_data();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP026_Creat_Password_length() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		profile.selectProfile();
		profile.selectMenu();
		profile.Data("javier", "miranda", "miranda@hotmail.com", "12344");
		profile.validate_data2();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test // mensaje de error cuenta ya existente
	public void CP027_Create_user_exists_registered_in_the_app() {
		profile.selectProfile();
		profile.selectMenu();
		profile.Data("maziel", "chopin", "dj_fran_@hotmail.es", "080714javier");
		profile.Validata_mail();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP029_Create_account_Validate_log_in() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		profile.selectProfile();
		profile.selectMenu();
		profile.Create_account_Login_in();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP030_Create_Validate_the_registration_of_a_new_user() {
		profile.selectProfile();
		profile.selectMenu();
		profile.Data("maziel", "chopin", "cruz88996443@hotmail.com", "080714javier");
		profile.vUser();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	/// ******/////logon

	@Test
	public void CP082_Validate_screen1() {
		;
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.validateLoginIn();
		logger.info("Se da click en el icono de Perfil ");
		login.selectProfile();
		profile.Validate_Screen_profile();
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
		profile.Validate_DAte_Personal();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP084_Personal_data_Edit_with_invalid_data() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.selectProfile();
		profile.Edit_with_invalid_data("kj8474895", "uuiuf942", "");
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP085_Personal_data_Edit_with_valid_data() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.selectProfile();
		profile.Validate_Data_Personal("Miranda", "Cruz");
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP086_Validates_Screen_Logon_data() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.selectProfile();
		profile.Logon_date();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP087_Validate_error_messages() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.selectProfile();
		profile.Logon_date();
		profile.Error_Messages();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP088_Validate_error_messages_when_entering_incorrect_data() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.selectProfile();
		profile.When_Entering_Incorrect_Data("674839jfif", "ii40odn3434");
		profile.Incorrect_data();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test // when entering correct data
	public void CP089_Success_Messages() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "080714regina");
		login.selectProfile();
		profile.When_Entering_Incorrect_Data("emilze080714", "regina080714");
		profile.Correct_data();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP090_Telephone_information_screen() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "emilze080714");
		login.selectProfile();
		profile.Validate_Telephone_information_screen();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP091_Validate_success_message() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "emilze080714");
		login.selectProfile();
		profile.When_Editing_Telephone_Information("5542054501", "5544203573");
		profile.validate_mensage();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP092_CP0093_Screen_Validate_Your_addresses() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "emilze080714");
		login.selectProfile();
		profile.Screen_validate();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP094_Validate_error_messages_with_empty_form() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "emilze080714");
		login.selectProfile();
		profile.Messages_with_empty_form();
		profile.Validate_error_mensage();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP095_Valida_date_formulari() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("dj_fran_@hotmail.es", "emilze080714");
		login.selectProfile();
		// profile.Validate_date_capturing_correct("abu","omar","juarez","capuchinas");
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP99_Validate_the_screen_of_your_orders() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("javier_miranda@hotmail.com", "12345678");
		login.selectProfile();
		profile.With_a_new_account();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP100_Validate_list_orders() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("javier_miranda@hotmail.com", "12345678");
		login.selectProfile();
		profile.List_orders();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP101_102_103_Validate_Help() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("javier_miranda@hotmail.com", "12345678");
		login.selectProfile();
		profile.Validate_HELP();
		profile.Call_Us();
		profile.Mail_button();
		logger.info("FINALIZANDO CASO DE PRUEBA ");

	}

	@Test
	public void CP104_Legal() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("javier_miranda@hotmail.com", "12345678");
		login.selectProfile();
		profile.Validate_legal();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP105_al_115_TERMS_CONDI() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("javier_miranda@hotmail.com", "12345678");
		login.selectProfile();
		profile.click_terms();
		profile.VALIDATE_TERMS_COND();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	}

	@Test
	public void CP116_closed() {
		logger.info("INICIANDO CASO DE PRUEBA ");
		login.selectProfile();
		login.selectMenu();
		login.login("javier_miranda@hotmail.com", "12345678");
		login.selectProfile();
		profile.closed_sesion();
		logger.info("FINALIZANDO CASO DE PRUEBA ");
	 }
	@Test
	public void CP11_closed() {
		
	}
	
	

}
