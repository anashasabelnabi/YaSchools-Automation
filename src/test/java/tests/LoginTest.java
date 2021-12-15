package tests;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;

public class LoginTest extends TestBase{

	String email = "anas123@gmail.com";
	String password = "123456";
	HomePage homePageObject ;
	LoginPage loginPageObject;
	ProfilePage profilePageObject;
	
	@Test(description = "Login Functionality")
	@Description("Veirify That Parent Can Login When Enter Valid Cardentaials")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Login")
	@TmsLink("Test_case")
	@Issue("Software_bug")
	//User Can Login With Valid Username and Valid Password
	public void userCanLoginWithValidData() {
		homePageObject = new HomePage(driver);
		homePageObject.clickLogin();
		loginPageObject = new LoginPage(driver);
		loginPageObject.userLogin(email, password);
		profilePageObject = new ProfilePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.urlContains("profile"));
		assertTrue(driver.getCurrentUrl().contains("profile"));
	}
}
