package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.shaft.gui.element.ElementActions;

public class LoginPage {

	private WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver ;
	}

	public By backToHomeBtn = By.xpath("//a/span[contains(.,'الرجوع للرئيسية')]");
	
	public By teacherLoginBtn = By.xpath("//a[contains(.,' تسجيل دخول معلم ')]");
	
	public By emailInput = By.id("loginform-identity");
	
	public By emailValidation = By.xpath("//p[@class='help-block help-block-error' and contains(.,'البريد')]");
	
	public By passwordInput = By.id("password");
	
	public By passwordValidation = By.xpath("//p[@class='help-block help-block-error' and contains(.,'كلمة المرور')]");
	
	public By SubmitBtn = By.xpath("//button[@class='btn btn-lg btn-block w-100 custom-primary-button']");
	
	@FindBy(css="div.error")
	public WebElement confirmationEmailValidation ;
	
	
	public void backToHome() {
		ElementActions.click(driver, backToHomeBtn);
	}
	public void teacherLogin() {
		ElementActions.click(driver, teacherLoginBtn);
	}	
	public void userLogin(String email , String password){
		new ElementActions(driver)
		.type(emailInput, email)
		.type(passwordInput, password)
		.click(SubmitBtn);
	}
}
