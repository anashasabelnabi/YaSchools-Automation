package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText="تسجيل حساب جديد")
	public WebElement registerationBtn;
	
	@FindBy(linkText="سجل الدخول")
	public WebElement loginBtn;
	
	@FindBy(css="div.alert.alert-success.alert-dismissible.fade.show")
	public WebElement alertConfirmationMsg;
}
