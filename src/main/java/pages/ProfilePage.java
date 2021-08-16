package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageBase{
	
	public JavascriptExecutor jse ;
	public ProfilePage(WebDriver driver) {
		super(driver);
		jse= (JavascriptExecutor) driver;
	}
	
	@FindBy(xpath="//*[@id=\"userProfile\"]/div[1]/div/div[1]/div[1]/div[2]/h3")
	public WebElement fullNameHeader;
	
	@FindBy(id="ProfileDropdown")
	public WebElement profileDropDown;
	
	@FindBy(xpath="//*[@id=\"navbarSupportedContent\"]/ul/li[6]/ul/li[3]/a")
	public WebElement logoutBtn;
	
	@FindBy(linkText="المدارس")
	public WebElement schoolsBtn;
	
	@FindBy(xpath="//*[@id=\"newsList\"]/div[1]/div[1]/a")
	public WebElement showSchoolPageBtn;
	
	public void selectLogoutBtn() {
		clickButton(profileDropDown);
		clickButton(logoutBtn);
	}
	public void scriptToClickBtn(WebElement button) {
		jse.executeScript("arguments[0].click();",button);
	}
	

}
