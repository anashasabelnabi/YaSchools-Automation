package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.AllSchoolsPage;
import pages.HomePage;
import pages.PotentialBookingPage;
import pages.ProfilePage;
import pages.SchoolPage;

public class PotentialBookingWithoutLoginTest extends TestBase{
	String parentName = "Anas Hasasb";
	String phoneNumber = "0512345678";
	String email = "anasTest@yahoo.com";
	String childName = "hamada";
	String identity = "2114512345";
	PotentialBookingPage potentialBookingPageObject ; 
	SchoolPage schoolPageObject ;
	ProfilePage profilePageObject;
	HomePage homePageObject ;
	AllSchoolsPage allSchoolPageObject ;
	@Test
	public void parentCanMakePotentailBookingRequestWithoutLogin () {
		//Search For School
		homePageObject = new HomePage(driver);
		homePageObject.searchForSchool();
		//Open School Page
		allSchoolPageObject = new AllSchoolsPage(driver);
		allSchoolPageObject.openSchoolPage();
		//Click Book Now
		schoolPageObject = new SchoolPage(driver);
		schoolPageObject.clickBookNow();		
		//Potential Booking
		potentialBookingPageObject = new PotentialBookingPage(driver);
		potentialBookingPageObject.ptentialBookingWithoutLogin(parentName,phoneNumber,email,childName,identity);
		assertEquals(potentialBookingPageObject.getConfirmationMessageText(),"تم إرسال طلب الحجز بنجاح");
	}

}
