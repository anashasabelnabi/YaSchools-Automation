package tests;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.PaymentPage;
import pages.ProfilePage;

public class PaymentTest extends TestBase{

	PaymentPage paymentPageObject ;
	ProfilePage profilePageObject ;
	@Test
	public void parentCanPayUsingSadad() {
		paymentPageObject = new PaymentPage(driver);
		paymentPageObject.paymentUsingSadad();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		profilePageObject = new ProfilePage(driver);
		String alertText = driver.findElement(By.xpath("//div[contains(.,'تم إرسال الطلب بنجاح')]")).getText();				
		assertEquals(alertText, "تم إرسال الطلب بنجاح");
	}
}
