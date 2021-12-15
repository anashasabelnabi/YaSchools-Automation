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
import pages.OnlineBookingPage;
import pages.ProfilePage;
import pages.SchoolPage;

public class OnlineBookingTest extends TestBase {

	SchoolPage schoolPageObject ;
	OnlineBookingPage onlineBookingPageObject ;
	ProfilePage profilePageObject;

	@Test(description = "Online Booking Feature")
	@Description("Veirify That Parent Can Use Online Booking When He is Logged In")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Online Booking")
	@TmsLink("Test_case")
	@Issue("Software_bug")
	public void parentCanUseOnlineBooking() throws InterruptedException {
		schoolPageObject = new SchoolPage(driver);
		onlineBookingPageObject = new OnlineBookingPage(driver);
		profilePageObject = new ProfilePage(driver);
		//Open School Page
		profilePageObject.clickShowSchoolPage();
		//Click Book Now
		schoolPageObject.clickBookNow();
		//Online Booking 
		onlineBookingPageObject.parentBooking();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.urlContains("pay"));
		assertTrue(driver.getCurrentUrl().contains("pay"));
	}

}
