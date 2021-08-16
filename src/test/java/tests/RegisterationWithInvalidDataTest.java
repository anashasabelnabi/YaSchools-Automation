package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProfilePage;
import pages.RegisterationPage;

public class RegisterationWithInvalidDataTest extends TestBase{
	String fullName = "somia hasab Elnabi";
	String email = "somia146@gmail.com";
	String password = "123456789";

	HomePage homePageObject;
	RegisterationPage registerPageObject;
	ProfilePage profilePageObject;
	@Test(priority = 0)
	//User Cannot Register With Exist Email 
	public void userRegisterWithExistEmail() throws InterruptedException{
		homePageObject = new HomePage(driver);
		registerPageObject = new RegisterationPage(driver);
		assertEquals(homePageObject.registerationBtn.getText(),"تسجيل حساب جديد");
		homePageObject.registerationBtn.click();
		registerPageObject.userRegistration(fullName,email,password,password);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(registerPageObject.emailValidation));
		assertEquals(registerPageObject.emailValidation.getText(),"هذا البريد الإلكتروني مستخدم من قبل");
		registerPageObject.backToHomeBtn.click();
	}

	@Test(priority = 1)
	//User Cannot Register With Invalid Email 

	public void userRegisterWithInValidEmail() throws InterruptedException{
		homePageObject = new HomePage(driver);
		registerPageObject = new RegisterationPage(driver);
		assertEquals(homePageObject.registerationBtn.getText(),"تسجيل حساب جديد");
		homePageObject.registerationBtn.click();
		registerPageObject.userRegistration(fullName,"somiahasab",password,password);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(registerPageObject.emailValidation));
		assertEquals(registerPageObject.emailValidation.getText(),"البريد الإلكتروني ليس ببريد إلكتروني صحيح.");
		registerPageObject.backToHomeBtn.click();
	}

	@Test(priority = 2)
	//User Cannot Register With Invalid Name

	public void userRegisterWithInvalidName() throws InterruptedException{
		homePageObject = new HomePage(driver);
		registerPageObject = new RegisterationPage(driver);
		assertEquals(homePageObject.registerationBtn.getText(),"تسجيل حساب جديد");
		homePageObject.registerationBtn.click();
		registerPageObject.userRegistration("somia",email,password,password);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(registerPageObject.nameValidation));
		assertEquals(registerPageObject.nameValidation.getText(),"الاسم كاملاً يجب أن يحتوي على أكثر من ٨ حروف.");
		registerPageObject.backToHomeBtn.click();
	}

	@Test(priority = 4)
	//User Cannot Register With Empty Name 

	public void userRegisterWithEmptyName() throws InterruptedException{
		homePageObject = new HomePage(driver);
		registerPageObject = new RegisterationPage(driver);
		assertEquals(homePageObject.registerationBtn.getText(),"تسجيل حساب جديد");
		homePageObject.registerationBtn.click();
		registerPageObject.userRegistration("",email,password,password);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(registerPageObject.nameValidation));
		assertEquals(registerPageObject.nameValidation.getText(),"الاسم كاملاً لا يمكن تركه فارغًا.");
		registerPageObject.backToHomeBtn.click();
	}

	@Test(priority = 5)
	//User Cannot Register With Short Password and Not Match Confirm Password

	public void userRegisterWithShortPassword() throws InterruptedException{
		homePageObject = new HomePage(driver);
		registerPageObject = new RegisterationPage(driver);
		assertEquals(homePageObject.registerationBtn.getText(),"تسجيل حساب جديد");
		homePageObject.registerationBtn.click();
		registerPageObject.userRegistration(fullName,email,"1234",password);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(registerPageObject.passwordValidation));
		assertEquals(registerPageObject.passwordValidation.getText(),"كلمة المرور يجب أن يحتوي على أكثر من ٦ حروف.");
		assertEquals(registerPageObject.confirmPasswordValidation.getText()
				,"تأكيد كلمة المرور يجب أن يساوي \"كلمة المرور\".");
		registerPageObject.backToHomeBtn.click();
	}

	@Test(priority = 6)
	//User Cannot Register With Empty Password and Empty Confirm Password

	public void userRegisterWithEmptyPassword() throws InterruptedException{
		homePageObject = new HomePage(driver);
		registerPageObject = new RegisterationPage(driver);
		assertEquals(homePageObject.registerationBtn.getText(),"تسجيل حساب جديد");
		homePageObject.registerationBtn.click();
		registerPageObject.userRegistration(fullName,email,"","");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(registerPageObject.passwordValidation));
		assertEquals(registerPageObject.passwordValidation.getText(),"كلمة المرور لا يمكن تركه فارغًا.");
		assertEquals(registerPageObject.confirmPasswordValidation.getText(),"تأكيد كلمة المرور لا يمكن تركه فارغًا.");
		registerPageObject.backToHomeBtn.click();
	}	

}
