package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.shaft.gui.element.ElementActions;

import pages.HomePage;
import pages.ProfilePage;
import pages.RegisterationPage;

public class RegisterationTest extends TestBase{
	String fullName = "somia Hasab ELnabi";
	String email = "somia997@gmail.com";
	String password = "123456789";
	
	HomePage homePageObject;
	RegisterationPage registerPageObject;
	ProfilePage profilePageObject;
	@Test
	//User Can Register With Valid Data
	public void userRegisterWithValidInput(){
		homePageObject = new HomePage(driver);
		registerPageObject = new RegisterationPage(driver);
		assertEquals(ElementActions.getText(driver,homePageObject.registerationBtn),"تسجيل حساب جديد");
		ElementActions.click(driver, homePageObject.registerationBtn);
		registerPageObject.userRegistration(fullName,email,password,password);
		assertEquals(ElementActions.getText(driver, homePageObject.alertConfirmationMsg),
				"تم انشاء الحساب بنجاح .من فضلك افحص البريد الإلكتروني لتفعيل الحساب");
	}

}
