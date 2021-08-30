package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shaft.gui.element.ElementActions;

public class SchoolPage{

	WebDriver driver;
	public SchoolPage(WebDriver driver) {
		this.driver = driver ;
	}

	//Close Announcment Form
	public By closeAnnouncementForm = By.xpath("//i[contains(@class,'fas fa-times pe-2')]");
	public void closeAnnouncment() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(closeAnnouncementForm));
		if(ElementActions.isElementDisplayed(driver, closeAnnouncementForm)) {
			wait.until(ExpectedConditions.elementToBeClickable(closeAnnouncementForm));
			ElementActions.click(driver, closeAnnouncementForm);
		}
	}
	//Book Now Button
	public By bookNowBtn = By.xpath("(//a[contains(@class,'custom-success-button mx-1 position-relative book-now')])[1]");
	public void clickBookNow() {
		ElementActions.click(driver,bookNowBtn);
	}
}
