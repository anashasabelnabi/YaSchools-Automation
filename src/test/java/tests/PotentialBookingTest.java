package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.PotentialBookingPage;
import pages.ProfilePage;
import pages.SchoolPage;

public class PotentialBookingTest extends TestBase {

	PotentialBookingPage potentialBookingPageObject ; 
	SchoolPage schoolPageObject ;
	ProfilePage profilePageObject;
	@Test
	public void parentCanMakePotentailBookingRequest () {
		//Click Book Now
		profilePageObject = new ProfilePage(driver);
		profilePageObject.clickShowSchoolPage();
		//Open School Page
		schoolPageObject = new SchoolPage(driver);
		schoolPageObject.clickBookNow();		
		//Potential Booking
		potentialBookingPageObject = new PotentialBookingPage(driver);
		potentialBookingPageObject.potentialBookingParentLoggedIn();
		assertEquals(potentialBookingPageObject.getConfirmationMessageText(),"تم إرسال طلب الحجز بنجاح");
	}

}
