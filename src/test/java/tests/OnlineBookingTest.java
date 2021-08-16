package tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import com.shaft.gui.element.ElementActions;

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
		profilePageObject.showSchoolPageBtn.click();
		//Click Book Now
		ElementActions.click(driver,schoolPageObject.bookNowBtn);
		//Online Booking 
		onlineBookingPageObject.parentBooking();
		assertTrue(driver.getCurrentUrl().contains("pay"));
	}

}
