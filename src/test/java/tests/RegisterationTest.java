package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProfilePage;
import pages.RegisterationPage;

public class RegisterationTest extends TestBase{
	String fullName = "somia Hasab ELnabi";
	String email = "somia1446@gmail.com";
	String password = "123456789";
	
	HomePage homePageObject;
	RegisterationPage registerPageObject;
	ProfilePage profilePageObject;
	@Test
	//User Can Register With Valid Data
	public void userRegisterWithValidInput(){
		homePageObject = new HomePage(driver);
		registerPageObject = new RegisterationPage(driver);
		assertEquals(homePageObject.registerationBtn.getText(),"تسجيل حساب جديد");
		homePageObject.registerationBtn.click();
		registerPageObject.userRegistration(fullName,email,password,password);
		assertEquals(homePageObject.alertConfirmationMsg.getText(),
				"تم انشاء الحساب بنجاح .من فضلك افحص البريد الإلكتروني لتفعيل الحساب");
	}

}
