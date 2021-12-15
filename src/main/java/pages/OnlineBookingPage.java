package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shaft.gui.element.ElementActions;

public class OnlineBookingPage{

	private WebDriver driver;
	public OnlineBookingPage(WebDriver driver) {
		this.driver = driver ;
	}
	@FindBy(xpath = "//*[@id=\"bookingCtrl\"]/div[1]/div/div/div/div/h1")
	public WebElement onlineBookingPageHeader ;

	@FindBy (id="childsuperior-first_name_ar")
	public WebElement firstNameInput ; 

	@FindBy (id="childsuperior-father_name_ar")
	public WebElement fatherNameInput ;

	@FindBy (id="childsuperior-grand_father_name_ar")
	public WebElement grandFatherNameInput ;

	@FindBy (id="childsuperior-last_name_ar")
	public WebElement lastNameInput ;

	@FindBy (id="childsuperior-email")
	public WebElement emailInput ;

	@FindBy (id="childsuperior-birthdate")
	public WebElement birthdateInput ;

	@FindBy (id="childsuperior-childs-0-stage_id")
	public WebElement childGradeDropdown ;
	
	//When Open The Page There is a span under Select With class defined in FirstClick Locator .

	public By firstClick = By.xpath("//span[contains(@class,'select2 select2-container select2-container--krajee')][contains(@data-select2-id, '1')]");
	
	//When I click on the dropdown The class of this Span Change to Locator defined in secondClick.

	public By secondClick = By.xpath("//span[@class='select2 select2-container select2-container--krajee select2-container--above select2-container--open select2-container--focus'][contains(@data-select2-id,'1')]");
	
	//When I choose option from dropdown The class of this Span Change to Locator defined in thirdClick.
	
	public By thirdClick = By.xpath("//span[@class='select2 select2-container select2-container--krajee select2-container--below select2-container--focus']");
									 
	//Choose child name
	public By childName = By.xpath("//li[contains(@id,'3200')]");
	
	//Close Announcement Form
	public By closeAnnouncementForm = By.xpath("//i[contains(@class,'fas fa-times pe-2')]");
	
	@FindBy (id="childsuperior-childs-0-birthdate")
	public WebElement childBirthdateInput ;

	@FindBy (id="childsuperior-childs-0-identity")
	public WebElement childIdInput ;

	@FindBy (id="childsuperior-childs-0-gender")
	public WebElement childGenderDropDown ;

	@FindBy (css="div.multiple-input-list__btn.js-input-plus.btn.btn-success")
	public WebElement addChildButton ;

	@FindBy (css="div.multiple-input-list__btn.js-input-remove.btn.btn-danger")
	public WebElement removeChildButton ;

	public By termsCheckBox = By.id("childsuperior-terms") ;

	public By contractTermsCheckBox = By.id("childsuperior-contract_items") ;

	@FindBy(css="button.btn.custom-primary-button.subBtn")
	
	public By payFeeButton = By.xpath("//button[@class='btn custom-primary-button subBtn d-none d-lg-block']") ;

	public void parentBooking(){
		WebDriverWait wait = new WebDriverWait(driver,50);
		if(ElementActions.isElementDisplayed(driver,firstClick)){
			if(ElementActions.isElementClickable(driver,firstClick)) {
				wait.until(ExpectedConditions.elementToBeClickable(firstClick));
				ElementActions.click(driver, firstClick);
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
		ElementActions.click(driver, contractTermsCheckBox);
		ElementActions.click(driver, payFeeButton);
	}
}
