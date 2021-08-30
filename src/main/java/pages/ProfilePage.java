package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shaft.gui.element.ElementActions;

public class ProfilePage{

	WebDriver driver ; 
	public JavascriptExecutor jse ;
	public ProfilePage(WebDriver driver) {
		this.driver = driver ;
	}

	@FindBy(xpath="//*[@id=\"userProfile\"]/div[1]/div/div[1]/div[1]/div[2]/h3")
	public WebElement fullNameHeader;

	@FindBy(id="ProfileDropdown")
	public WebElement profileDropDown;

	@FindBy(xpath="//*[@id=\"navbarSupportedContent\"]/ul/li[6]/ul/li[3]/a")
	public WebElement logoutBtn;

	@FindBy(linkText="المدارس")
	public WebElement schoolsBtn;

	//Close Announcement Form
	public By closeAnnouncementForm = By.xpath("//i[contains(@class,'fas fa-times pe-2')]");
	public void closeAnnouncment() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(closeAnnouncementForm));
		if(ElementActions.isElementDisplayed(driver, closeAnnouncementForm)) {
			wait.until(ExpectedConditions.elementToBeClickable(closeAnnouncementForm));
			ElementActions.click(driver, closeAnnouncementForm);
		}
	}

	//Open School Page
	public By showSchoolPageBtn = By.xpath("(//a[contains(.,'عرض')])[1]");
	public void clickShowSchoolPage() {
		ElementActions.click(driver, showSchoolPageBtn);
	}

//	public void selectLogoutBtn() {
//		clickButton(profileDropDown);
//		clickButton(logoutBtn);
//	}
	public void scriptToClickBtn(WebElement button) {
		jse.executeScript("arguments[0].click();",button);
	}


}
