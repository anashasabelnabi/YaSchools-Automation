package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class LoginWithInvalidDataTest extends TestBase {

	String email = "anas_hasab_elnabi@yahoo.com";
	String password = "123456789";
	HomePage homeBageObject ;
	LoginPage loginPageObject;
	ProfilePage profilePageObject;
	@Test
	//User Cannot Login With invalid Email and valid password
	public void userCannotLoginWithInValidEmail() {
		homeBageObject = new HomePage(driver);
		homeBageObject.loginBtn.click();
		loginPageObject = new LoginPage(driver);
		loginPageObject.userLogin("anas1234",password);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(loginPageObject.emailValidation));
		assertEquals(loginPageObject.emailValidation.getText(),"البريد الإلكتروني ليس ببريد إلكتروني صحيح.");
		loginPageObject.backToHomeBtn.click();
	}

	@Test
	//User Cannot login with Wrong Email and Valid Password
	public void userCannotLoginWithWrongEmail() {
		homeBageObject = new HomePage(driver);
		homeBageObject.loginBtn.click();
		loginPageObject = new LoginPage(driver);
		loginPageObject.userLogin("anas1234@yahoo.com",password);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(loginPageObject.passwordValidation));
		assertEquals(loginPageObject.passwordValidation.getText(),"كلمة المرور أو البريد الإلكتروني غير صحيح");
		loginPageObject.backToHomeBtn.click();
	}

	@Test
	//User Cannot Login With Valid Email and invalid Password
	public void userCannotLoginWithInValidPassword() {
		homeBageObject = new HomePage(driver);
		homeBageObject.loginBtn.click();
		loginPageObject = new LoginPage(driver);
		loginPageObject.userLogin(email,"12345");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(loginPageObject.passwordValidation));
		assertEquals(loginPageObject.passwordValidation.getText(),"كلمة المرور أو البريد الإلكتروني غير صحيح");
		loginPageObject.backToHomeBtn.click();
	}	
	@Test
	//User Cannot Login With Invalid Email and invalid Password
	public void userCannotLoginWithInvaildEmailAndInValidPassword() {
		homeBageObject = new HomePage(driver);
		homeBageObject.loginBtn.click();
		loginPageObject = new LoginPage(driver);
		loginPageObject.userLogin("anas@yahoo.com","12345");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(loginPageObject.passwordValidation));
		assertEquals(loginPageObject.passwordValidation.getText(),"كلمة المرور أو البريد الإلكتروني غير صحيح");
		loginPageObject.backToHomeBtn.click();
	}

	@Test
	//User Cannot login Without Entering Email
	public void emailFieldIsRequired() {
		homeBageObject = new HomePage(driver);
		homeBageObject.loginBtn.click();
		loginPageObject = new LoginPage(driver);
		loginPageObject.userLogin("",password);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(loginPageObject.emailValidation));
		assertEquals(loginPageObject.emailValidation.getText(),"البريد الإلكتروني لا يمكن تركه فارغًا.");
		loginPageObject.backToHomeBtn.click();
	}
	 //User Cannot Login Without Entering Password
	@Test
	public void passwordFieldIsRequired() {
		homeBageObject = new HomePage(driver);
		homeBageObject.loginBtn.click();
		loginPageObject = new LoginPage(driver);
		loginPageObject.userLogin(email,"");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(loginPageObject.passwordValidation));
		assertEquals(loginPageObject.passwordValidation.getText(),"كلمة المرور لا يمكن تركه فارغًا.");
		loginPageObject.backToHomeBtn.click();
	}

}
