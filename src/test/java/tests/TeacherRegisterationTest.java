package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.RegisterationPage;

public class TeacherRegisterationTest extends TestBase{

	String fullName = "anas hasab elnabi";
	String email = "anashasabragab148@gmail.com";
	String password = "123456789";
	
	HomePage homePageObject;
	RegisterationPage registerPageObject;
	ProfilePage profilePageObject;
	LoginPage loginPageObject ;
	@Test(priority = 0)
	//Teacher Can Register With Valid Email and Valid Password
	public void teacherRegisterWithValidInput(){
		homePageObject = new HomePage(driver);
		registerPageObject = new RegisterationPage(driver);
		assertEquals(homePageObject.registerationBtn.getText(),"تسجيل حساب جديد");
		homePageObject.registerationBtn.click();
		assertEquals(registerPageObject.teacherLoginBtn.getText(), "تسجيل دخول معلم");
		registerPageObject.teacherLoginBtn.click();
		assertEquals(registerPageObject.loginBtn.getText(),"تسجيل حساب معلم");
		registerPageObject.scriptToClickBtn(registerPageObject.loginBtn);
		registerPageObject.userRegistration(fullName,email,password,password);
		assertEquals(homePageObject.alertConfirmationMsg.getText(),
				"تم انشاء الحساب بنجاح .من فضلك افحص البريد الإلكتروني لتفعيل الحساب");
	}
	
	@Test(priority = 1)
	//Teacher Can Login With Valid Email and Valid Password
	public void teacherLoginWithValidInput() {
		homePageObject = new HomePage(driver);
		homePageObject.loginBtn.click();
		loginPageObject = new LoginPage(driver);
		assertEquals(loginPageObject.teacherLoginBtn.getText(),"تسجيل دخول معلم");
		loginPageObject.teacherLoginBtn.click();
		assertTrue(driver.getCurrentUrl().contains("teacher/login"));
		loginPageObject.userLogin(email,password);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(loginPageObject.confirmationEmailValidation));
		assertEquals(loginPageObject.confirmationEmailValidation.getText(),"عليك تفعيل حسابك أولاً. من فضلك تفقد بريدك الالكتروني.");
		loginPageObject.backToHomeBtn.click();
	}
}
