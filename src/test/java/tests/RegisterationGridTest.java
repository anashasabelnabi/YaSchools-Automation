package tests;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.shaft.driver.DriverFactory;
import com.shaft.driver.DriverFactory.DriverType;
import com.shaft.gui.element.ElementActions;

import pages.HomePage;
import pages.ProfilePage;
import pages.RegisterationPage;

public class RegisterationGridTest{
	public static String BaseUrl = "https://qc.yaschools.com/";
	public static String hubUrl = "http://localhost:4444/wd/hub";

	WebDriver driver = DriverFactory.getDriver(DriverType.DESKTOP_CHROME);

	HomePage homePageObject;
	RegisterationPage registerPageObject;
	ProfilePage profilePageObject;

	String fullName = "somia Hasab ELnabi";
	String email = "somia1100@gmail.com";
	String password = "123456789";

	@BeforeTest
	//@Parameters(value={"browserName"})
	public void setup(){

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
//		try {
//			driver = new RemoteWebDriver(new URL(hubUrl), caps);
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
		driver.navigate().to(BaseUrl);
	}
	@Test
	//User Can Register With Valid Data
	public void userRegisterWithValidInput(){
		homePageObject = new HomePage(driver);
		registerPageObject = new RegisterationPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(homePageObject.closeAnnouncementForm));
		ElementActions.click(driver, homePageObject.closeAnnouncementForm);
		ElementActions.click(driver,homePageObject.registerationBtn);
		registerPageObject.userRegistration(fullName,email,password,password);
		assertEquals(ElementActions.getText(driver, homePageObject.alertConfirmationMsg),
				"تم انشاء الحساب بنجاح .من فضلك افحص البريد الإلكتروني لتفعيل الحساب");
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
