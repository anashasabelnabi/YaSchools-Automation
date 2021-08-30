package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shaft.gui.element.ElementActions;

public class HomePage{

	WebDriver driver ;
	public HomePage(WebDriver driver) {
		this.driver = driver ;
	}

	@FindBy(linkText="تسجيل حساب جديد")
	public WebElement registerationBtn;

	public By loginBtn = By.linkText("سجل الدخول");
	
	public void clickLogin() {
		closeAnnouncment();
		ElementActions.click(driver, loginBtn);
	}

	@FindBy(css="div.alert.alert-success.alert-dismissible.fade.show")
	public WebElement alertConfirmationMsg;
	public By closeAnnouncementForm = By.xpath("//i[contains(@class,'fas fa-times pe-2')]");

	public void closeAnnouncment() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(closeAnnouncementForm));
		if(ElementActions.isElementDisplayed(driver, closeAnnouncementForm)) {
			wait.until(ExpectedConditions.elementToBeClickable(closeAnnouncementForm));
			ElementActions.click(driver, closeAnnouncementForm);
		}else {
			System.out.println("Announcment alreadey closed");
		}
	}

	public By searchInput = By.id("schoolNameSearch");
	public By searchButton = By.xpath("//button[@class='btn custom-success-button homeBoxSearch']");
	public void searchForSchool() {
		closeAnnouncment();
		ElementActions.type(driver, searchInput, "ajyal");
		ElementActions.click(driver, searchButton);
	}
}
