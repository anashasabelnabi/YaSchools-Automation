package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.OnlineBookingPage;
import pages.ProfilePage;
import pages.SchoolPage;

public class OnlineBookingTest extends TestBase {
	
	SchoolPage schoolPageObject ;
	OnlineBookingPage onlineBookingPageObject ;
	ProfilePage profilePageObject;
	@Test
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
