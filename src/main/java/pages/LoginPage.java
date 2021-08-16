package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public JavascriptExecutor jse ;
	public LoginPage(WebDriver driver) {
		super(driver);
		jse= (JavascriptExecutor) driver;
	}

	@FindBy(css="a.mx-0.flat-custom-btn")
	public WebElement backToHomeBtn;
	
	@FindBy(linkText="تسجيل دخول معلم")
	public WebElement teacherLoginBtn;
	
	@FindBy(id="loginform-identity")
	public WebElement emailInput;
	
	@FindBy(xpath="//*[@id=\"login-form\"]/div/div[1]/div[2]/div[1]/div/p")
	public WebElement emailValidation;
	
	@FindBy(id="loginform-password")
	public WebElement passwordInput;
	
	@FindBy(xpath="//*[@id=\"login-form\"]/div/div[1]/div[2]/div[2]/div/p")
	public WebElement passwordValidation;
	
	@FindBy(css="button.btn.btn-lg.btn-block.w-100.custom-primary-button")
	public WebElement SubmitBtn;
	
	@FindBy(css="div.error")
	public WebElement confirmationEmailValidation ;
	
	
	public void userLogin(String email , String password){
		setText(emailInput, email);
		setText(passwordInput, password);
		//clickButton(SubmitBtn);
		scriptToClickBtn(SubmitBtn);
	}
	
	public void scriptToClickBtn(WebElement button) {
		jse.executeScript("arguments[0].click();",button);
	}
}
