package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shaft.gui.element.ElementActions;

public class HomePage{

	WebDriver driver ;
	public HomePage(WebDriver driver) {
		this.driver = driver ;
	}

	public By registerationBtn = By.xpath("//li[@class='nav-item']/a[contains(.,'تسجيل حساب')]");
	public By loginBtn = By.linkText("سجل الدخول");

	public By searchInput = By.id("schoolNameSearch");
	public By searchButton = By.xpath("//button[@class='btn custom-success-button homeBoxSearch']");
	
	public By alertConfirmationMsg = By.xpath("//div[@class='alert alert-success alert-dismissible fade show']");
	public By closeAnnouncementForm = By.xpath("(//i[contains(@class,'fas fa-times pe-2')])[3]");
	
	public By cityDropDown = By.xpath("//span[@class='vs__selected']/span[contains(.,'كل المدن')]");
	public By curriculumCheckBoxes = By.id("curriculum_86'"); 
	
	
	public void clickLogin() {
		closeAnnouncment();
		ElementActions.click(driver, loginBtn);
	}
	public void clickRegister() {
		closeAnnouncment();
		ElementActions.click(driver,registerationBtn);
	}

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

	public void searchForSchool() {
		closeAnnouncment();
		ElementActions.type(driver, searchInput, "ajyal");
		ElementActions.click(driver, searchButton);
	}
}
