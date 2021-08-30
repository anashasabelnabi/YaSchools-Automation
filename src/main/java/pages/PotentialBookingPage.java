package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shaft.gui.element.ElementActions;

public class PotentialBookingPage {

	WebDriver driver ;

	public PotentialBookingPage (WebDriver driver) {
		this.driver = driver ;
	}
	public By firstNameInput = By.id("childsuperior-full_name");
	public By  mobileInput = By.id("childsuperior-mobile");
	public By emailInput = By.id("childsuperior-email");
	public By childNameDropdown =
			By.xpath("//span[contains(@class,'select2 select2-container select2-container--krajee')][contains(@data-select2-id, '1')]");
	
	public By childNameInput = By.id("childsuperior-childs-0-full_name");
	public By childName = By.xpath("//li[contains(@id,'3200')]");
	public By childGradeDropdown = By.id("childsuperior-childs-0-stage_id");
	public By DayDropdown = By.id("childsuperior-childs-0-birthdate-day");
	public By monthDropdown = By.id("childsuperior-childs-0-birthdate-month");
	public By yearDropdown = By.id("childsuperior-childs-0-birthdate-year");
	public By identityInput = By.id("childsuperior-childs-0-identity");
	public By genderDropdown = By.id("childsuperior-childs-0-gender");
	public By termsCheckBox = By.id("childsuperior-terms");
	public By submitButton =  By.xpath("//button[contains(@class,'btn custom-primary-button subBtn mb-5')]");
	public By confirmationMessage = By.xpath("//h3[contains(.,'تم إرسال طلب الحجز بنجاح')]");
	public By closeAnnouncementForm = By.xpath("//i[contains(@class,'fas fa-times pe-2')]");
	
	public void closeAnnouncment() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(closeAnnouncementForm));
		if(ElementActions.isElementDisplayed(driver, closeAnnouncementForm)) {
			wait.until(ExpectedConditions.elementToBeClickable(closeAnnouncementForm));
			ElementActions.click(driver, closeAnnouncementForm);
		}
	}
	
	public String getConfirmationMessageText() {
		return ElementActions.getText(driver, confirmationMessage);
		
	}
	
	public void potentialBookingParentLoggedIn() {
		WebDriverWait wait = new WebDriverWait(driver,50);
		if(ElementActions.isElementDisplayed(driver,childNameDropdown)){
			if(ElementActions.isElementClickable(driver,childNameDropdown)) {
				wait.until(ExpectedConditions.elementToBeClickable(childNameDropdown));
				ElementActions.click(driver, childNameDropdown);
				wait.until(ExpectedConditions.visibilityOfElementLocated(childName));
			}
		}
		if(ElementActions.isElementDisplayed(driver, childName)) {
			if(ElementActions.isElementClickable(driver, childName)) {
				wait.until(ExpectedConditions.elementToBeClickable(childName));
				ElementActions.click(driver,childName);
			}
		}
		ElementActions.click(driver, termsCheckBox);
		ElementActions.click(driver, submitButton);		
	}
	
	public void ptentialBookingWithoutLogin(String parentName ,String Phone,String email,String childName,String Identity) {
		ElementActions.type(driver,firstNameInput,parentName);
		ElementActions.type(driver,mobileInput,Phone);
		ElementActions.type(driver,emailInput,email);
		if(ElementActions.isElementDisplayed(driver, childNameInput)) {
			ElementActions.type(driver, childNameInput, childName);
		}
		ElementActions.select(driver, childGradeDropdown, "روضة 1 (KG 1)");
		ElementActions.select(driver, DayDropdown, "1");
		ElementActions.select(driver, monthDropdown, "12");
		ElementActions.select(driver, yearDropdown, "2011");
		ElementActions.type(driver, identityInput, Identity);
		ElementActions.select(driver, genderDropdown, "أنثى");
		ElementActions.click(driver, termsCheckBox);
		ElementActions.click(driver, submitButton);
	}


}
