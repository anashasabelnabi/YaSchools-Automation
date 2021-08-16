package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class TeacherLoginWithInvalidData extends TestBase{

	String email = "anashasab26@gmail.com";
	String password = "123456789";
	HomePage homeBageObject ;
	LoginPage loginPageObject;
	ProfilePage profilePageObject;
	@Test
	//Teacher Cannot Login With invalid Email and valid password
	public void teacherCannotLoginWithInValidEmail() {
		homeBageObject = new HomePage(driver);
		homeBageObject.loginBtn.click();
		loginPageObject = new LoginPage(driver);
		assertEquals(loginPageObject.teacherLoginBtn.getText(),"تسجيل دخول معلم");
		loginPageObject.teacherLoginBtn.click();
		assertTrue(driver.getCurrentUrl().contains("teacher/login"));
		loginPageObject.userLogin("anas1234",password);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(loginPageObject.emailValidation));
		assertEquals(loginPageObject.emailValidation.getText(),"البريد الإلكتروني ليس ببريد إلكتروني صحيح.");
		loginPageObject.backToHomeBtn.click();
	}

	@Test
	//Teacher Cannot Login With Wrong Email and valid password
	public void teacherCannotLoginWithWrongEmail() {
		homeBageObject = new HomePage(driver);
		homeBageObject.loginBtn.click();
		loginPageObject = new LoginPage(driver);
		assertEquals(loginPageObject.teacherLoginBtn.getText(),"تسجيل دخول معلم");
		loginPageObject.teacherLoginBtn.click();
		assertTrue(driver.getCurrentUrl().contains("teacher/login"));
		loginPageObject.userLogin("anas1234@yahoo.com",password);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(loginPageObject.passwordValidation));
		assertEquals(loginPageObject.passwordValidation.getText(),"كلمة المرور أو البريد الإلكتروني غير صحيح");
		loginPageObject.backToHomeBtn.click();
	}

	@Test
	//Teacher Cannot Login With valid Email and invalid password
	public void teacherCannotLoginWithInValidPassword() {
		homeBageObject = new HomePage(driver);
		homeBageObject.loginBtn.click();
		loginPageObject = new LoginPage(driver);
		assertEquals(loginPageObject.teacherLoginBtn.getText(),"تسجيل دخول معلم");
		loginPageObject.teacherLoginBtn.click();
		assertTrue(driver.getCurrentUrl().contains("teacher/login"));
		loginPageObject.userLogin(email,"12345");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(loginPageObject.passwordValidation));
		assertEquals(loginPageObject.passwordValidation.getText(),"كلمة المرور أو البريد الإلكتروني غير صحيح");
		loginPageObject.backToHomeBtn.click();
	}	
	@Test
	//Teacher Cannot Login With invalid Email and invalid password
	public void teacherCannotLoginWithInvaildEmailAndInValidPassword() {
		homeBageObject = new HomePage(driver);
		homeBageObject.loginBtn.click();
		loginPageObject = new LoginPage(driver);
		assertEquals(loginPageObject.teacherLoginBtn.getText(),"تسجيل دخول معلم");
		loginPageObject.teacherLoginBtn.click();
		assertTrue(driver.getCurrentUrl().contains("teacher/login"));
		loginPageObject.userLogin("anas@yahoo.com","12345");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(loginPageObject.passwordValidation));
		assertEquals(loginPageObject.passwordValidation.getText(),"كلمة المرور أو البريد الإلكتروني غير صحيح");
		loginPageObject.backToHomeBtn.click();
	}

	@Test
	//Teacher Cannot login Without Entering Email
	public void emailFieldIsRequired() {
		homeBageObject = new HomePage(driver);
		homeBageObject.loginBtn.click();
		loginPageObject = new LoginPage(driver);
		assertEquals(loginPageObject.teacherLoginBtn.getText(),"تسجيل دخول معلم");
		loginPageObject.teacherLoginBtn.click();
		assertTrue(driver.getCurrentUrl().contains("teacher/login"));
		loginPageObject.userLogin("",password);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(loginPageObject.emailValidation));
		assertEquals(loginPageObject.emailValidation.getText(),"البريد الإلكتروني لا يمكن تركه فارغًا.");
		loginPageObject.backToHomeBtn.click();
	}
	
	@Test
	//Teacher Cannot login Without Entering Password
	public void passwordFieldIsRequired() {
		homeBageObject = new HomePage(driver);
		homeBageObject.loginBtn.click();
		loginPageObject = new LoginPage(driver);
		assertEquals(loginPageObject.teacherLoginBtn.getText(),"تسجيل دخول معلم");
		loginPageObject.teacherLoginBtn.click();
		assertTrue(driver.getCurrentUrl().contains("teacher/login"));
		loginPageObject.userLogin(email,"");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(loginPageObject.passwordValidation));
		assertEquals(loginPageObject.passwordValidation.getText(),"كلمة المرور لا يمكن تركه فارغًا.");
		loginPageObject.backToHomeBtn.click();
	}
}
