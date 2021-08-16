package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProfilePage;
import pages.RegisterationPage;

public class TeacherRegisterWithInvalidData extends TestBase{

	String fullName = "anas hasab elnabi";
	String email = "anashasabragab148@gmail.com";
	String password = "123456789";

	HomePage homePageObject;
	RegisterationPage registerPageObject;
	ProfilePage profilePageObject;
	@Test(priority = 0)
	//Teacher Cannot Register With Exist Email 
	public void teacherRegisterWithExistEmail() throws InterruptedException{
		homePageObject = new HomePage(driver);
		registerPageObject = new RegisterationPage(driver);
		assertEquals(homePageObject.registerationBtn.getText(),"تسجيل حساب جديد");
		homePageObject.registerationBtn.click();
		assertEquals(registerPageObject.teacherLoginBtn.getText(), "تسجيل دخول معلم");
		registerPageObject.teacherLoginBtn.click();
		assertEquals(registerPageObject.loginBtn.getText(),"تسجيل حساب معلم");
		registerPageObject.scriptToClickBtn(registerPageObject.loginBtn);
		assertTrue(driver.getCurrentUrl().contains("teacher/signup"));
		registerPageObject.userRegistration(fullName,"anashasab26@gmail.com",password,password);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(registerPageObject.emailValidation));
		assertEquals(registerPageObject.emailValidation.getText(),"هذا البريد الإلكتروني مستخدم من قبل");
		registerPageObject.backToHomeBtn.click();
	}

	@Test(priority = 1)
	//Teacher Cannot Register With Invalid Email
	public void teacherRegisterWithInValidEmail() throws InterruptedException{
		homePageObject = new HomePage(driver);
		registerPageObject = new RegisterationPage(driver);
		assertEquals(homePageObject.registerationBtn.getText(),"تسجيل حساب جديد");
		homePageObject.registerationBtn.click();
		assertEquals(registerPageObject.teacherLoginBtn.getText(), "تسجيل دخول معلم");
		registerPageObject.teacherLoginBtn.click();
		assertEquals(registerPageObject.loginBtn.getText(),"تسجيل حساب معلم");
		registerPageObject.scriptToClickBtn(registerPageObject.loginBtn);
		assertTrue(driver.getCurrentUrl().contains("teacher/signup"));
		registerPageObject.userRegistration(fullName,"somiahasab",password,password);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(registerPageObject.emailValidation));
		assertEquals(registerPageObject.emailValidation.getText(),"البريد الإلكتروني ليس ببريد إلكتروني صحيح.");
		registerPageObject.backToHomeBtn.click();
	}

	@Test(priority = 2)
	//Teacher Cannot Register With Invalid Name
	public void teacherRegisterWithInvalidName() throws InterruptedException{
		homePageObject = new HomePage(driver);
		registerPageObject = new RegisterationPage(driver);
		assertEquals(homePageObject.registerationBtn.getText(),"تسجيل حساب جديد");
		homePageObject.registerationBtn.click();
		assertEquals(registerPageObject.teacherLoginBtn.getText(), "تسجيل دخول معلم");
		registerPageObject.teacherLoginBtn.click();
		assertEquals(registerPageObject.loginBtn.getText(),"تسجيل حساب معلم");
		registerPageObject.scriptToClickBtn(registerPageObject.loginBtn);
		assertTrue(driver.getCurrentUrl().contains("teacher/signup"));
		registerPageObject.userRegistration("somia",email,password,password);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(registerPageObject.nameValidation));
		assertEquals(registerPageObject.nameValidation.getText(),"الاسم كاملاً يجب أن يحتوي على أكثر من ٨ حروف.");
		registerPageObject.backToHomeBtn.click();
	}

	@Test(priority = 4)
	//Teacher Cannot Register With Empty Name
	public void teacherRegisterWithEmptyName() throws InterruptedException{
		homePageObject = new HomePage(driver);
		registerPageObject = new RegisterationPage(driver);
		assertEquals(homePageObject.registerationBtn.getText(),"تسجيل حساب جديد");
		homePageObject.registerationBtn.click();
		assertEquals(registerPageObject.teacherLoginBtn.getText(), "تسجيل دخول معلم");
		registerPageObject.teacherLoginBtn.click();
		assertEquals(registerPageObject.loginBtn.getText(),"تسجيل حساب معلم");
		registerPageObject.scriptToClickBtn(registerPageObject.loginBtn);
		assertTrue(driver.getCurrentUrl().contains("teacher/signup"));
		registerPageObject.userRegistration("",email,password,password);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(registerPageObject.nameValidation));
		assertEquals(registerPageObject.nameValidation.getText(),"الاسم كاملاً لا يمكن تركه فارغًا.");
		registerPageObject.backToHomeBtn.click();
	}

	@Test(priority = 5)
	//Teacher Cannot Register With Short Password and Not Match confirm Password
	public void teacherRegisterWithShortPassword() throws InterruptedException{
		homePageObject = new HomePage(driver);
		registerPageObject = new RegisterationPage(driver);
		assertEquals(homePageObject.registerationBtn.getText(),"تسجيل حساب جديد");
		homePageObject.registerationBtn.click();
		assertEquals(registerPageObject.teacherLoginBtn.getText(), "تسجيل دخول معلم");
		registerPageObject.teacherLoginBtn.click();
		assertEquals(registerPageObject.loginBtn.getText(),"تسجيل حساب معلم");
		registerPageObject.scriptToClickBtn(registerPageObject.loginBtn);
		assertTrue(driver.getCurrentUrl().contains("teacher/signup"));
		registerPageObject.userRegistration(fullName,email,"1234",password);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(registerPageObject.passwordValidation));
		assertEquals(registerPageObject.passwordValidation.getText(),"كلمة المرور يجب أن يحتوي على أكثر من ٦ حروف.");
		assertEquals(registerPageObject.confirmPasswordValidation.getText()
				,"تأكيد كلمة المرور يجب أن يساوي \"كلمة المرور\".");
		registerPageObject.backToHomeBtn.click();
	}

	@Test(priority = 6)
	//Teacher Cannot Register With Empty password and empty Confirmation Password
	public void teacherRegisterWithEmptyPassword() throws InterruptedException{
		homePageObject = new HomePage(driver);
		registerPageObject = new RegisterationPage(driver);
		assertEquals(homePageObject.registerationBtn.getText(),"تسجيل حساب جديد");
		homePageObject.registerationBtn.click();
		assertEquals(registerPageObject.teacherLoginBtn.getText(), "تسجيل دخول معلم");
		registerPageObject.teacherLoginBtn.click();
		assertEquals(registerPageObject.loginBtn.getText(),"تسجيل حساب معلم");
		registerPageObject.scriptToClickBtn(registerPageObject.loginBtn);
		assertTrue(driver.getCurrentUrl().contains("teacher/signup"));
		registerPageObject.userRegistration(fullName,email,"","");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(registerPageObject.passwordValidation));
		assertEquals(registerPageObject.passwordValidation.getText(),"كلمة المرور لا يمكن تركه فارغًا.");
		assertEquals(registerPageObject.confirmPasswordValidation.getText(),"تأكيد كلمة المرور لا يمكن تركه فارغًا.");
		registerPageObject.backToHomeBtn.click();
	}	

}
