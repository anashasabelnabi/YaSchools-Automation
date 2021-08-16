package tests;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class LoginTest extends TestBase{

	String email = "anas123@gmail.com";
	String password = "123456";
	HomePage homePageObject ;
	LoginPage loginPageObject;
	ProfilePage profilePageObject;
	@Test
	//User Can Login With Valid Username and Valid Password
	public void userCanLoginWithValidData() {
		homePageObject = new HomePage(driver);
		homePageObject.loginBtn.click();
		loginPageObject = new LoginPage(driver);
		loginPageObject.userLogin(email, password);
		profilePageObject = new ProfilePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.urlContains("profile"));
		assertTrue(driver.getCurrentUrl().contains("profile"));
		//profilePageObject.selectLogoutBtn();
		//assertEquals(homePageObject.loginBtn.getText(),"سجل الدخول");
		//profilePageObject.scriptToClickBtn(profilePageObject.schoolsBtn);
	}
}
