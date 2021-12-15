package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.shaft.gui.element.ElementActions;

public class RequestALoanPage {
	private WebDriver driver ;
	public RequestALoanPage(WebDriver driver) {
		this.driver = driver ;
	}
	
	//Enter Information Step 1
	public By MonthlySalaryInput = By.id("nationalfinance-monthly_salary");
	public By termsCheckBox = By.id("nationalfinance-terms");
	public By submitButton = By.xpath("//button[@type='submit']");
	
	public void payUsingNationalFinanceRequest(String MonthlySalary){
		(new ElementActions(driver))
				.type(MonthlySalaryInput, MonthlySalary)
				.click(termsCheckBox)
				.click(submitButton);	
	}
	
	//Upload Files Step 2
	public By financeRequestUploadWidget = By.id("w1");
	public By salaryStatementUploadWidget = By.id("w2");
	public By bankStatementfinanceRequestUploadWidget = By.id("w3");
	public By IdentityUploadWidget = By.id("w4");
	public By nationalAddressUploadWidget = By.id("w5");
	
	public void uploadAttachments(String filePath) {
		ElementActions.typeFileLocationForUpload(driver, financeRequestUploadWidget,filePath);
		(new ElementActions(driver))
		.typeFileLocationForUpload(financeRequestUploadWidget, filePath)
		.typeFileLocationForUpload(salaryStatementUploadWidget, filePath)
		.typeFileLocationForUpload(bankStatementfinanceRequestUploadWidget, filePath)
		.typeFileLocationForUpload(IdentityUploadWidget, filePath)
		.typeFileLocationForUpload(nationalAddressUploadWidget, filePath)
		.click(submitButton);
	}
	
	public By conirmationMessage = By.xpath("//h3[contains(.,'تم')]"); 
}
