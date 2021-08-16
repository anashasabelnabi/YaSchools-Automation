package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterationPage extends PageBase {
	public JavascriptExecutor jse ;
	public RegisterationPage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
	}
	@FindBy(css="a.mx-0.flat-custom-btn")
	public WebElement backToHomeBtn;

	@FindBy(linkText="تسجيل دخول معلم")
	public WebElement teacherLoginBtn;

	@FindBy(id="signupform-fullname")
	public WebElement fullNameInput;

	@FindBy(xpath="//*[@id=\"signup-form\"]/div/div[1]/div[2]/div[1]/div/p")
	public WebElement nameValidation;

	@FindBy(id="signupform-email")
	public WebElement emailInput;

	@FindBy(xpath="//*[@id=\"signup-form\"]/div/div[1]/div[2]/div[2]/div/p")
	public WebElement emailValidation;

	@FindBy(id="signupform-password")
	public WebElement passwordInput;

	@FindBy(xpath="//*[@id=\"signup-form\"]/div/div[1]/div[2]/div[3]/div/p")
	public WebElement passwordValidation;

	@FindBy(id="signupform-password_confirm")
	public WebElement confirmPasswordInput;

	@FindBy(xpath="//*[@id=\"signup-form\"]/div/div[1]/div[2]/div[4]/div/p")
	public WebElement confirmPasswordValidation;

	@FindBy(name="signup-button")
	public WebElement SubmitBtn;

	@FindBy(css="a.btn.google")
	public WebElement googleBtn;

	@FindBy(css="a.btn.fb")
	public WebElement faceBookBtn;

	@FindBy(css="a.custom-dark-bordered-btn.mx-3")
	public WebElement loginBtn;

	public void userRegistration(String fullName , String email , String password , String confirmPassword) 
	{
		setText(fullNameInput, fullName);
		setText(emailInput, email);
		setText(passwordInput, password);
		setText(confirmPasswordInput, confirmPassword);
		//clickButton(SubmitBtn);
		scriptToClickBtn(SubmitBtn);
	}
	public void scriptToClickBtn(WebElement button) {
		jse.executeScript("arguments[0].click();",button);
	}

}
