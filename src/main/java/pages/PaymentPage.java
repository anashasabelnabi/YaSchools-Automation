package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.element.ElementActions;

public class PaymentPage {
	private WebDriver driver ;
	public PaymentPage (WebDriver driver) {
		this.driver = driver ;
	}
		
	//Payment Using SADAD Option
	public By openPaymentUsingSadadButton = By.xpath("//button[contains(.,'سداد') or contains(.,'SADAD')]");
	public By makeBillUsingSadadButton = By.id("btn-confirm-sadad");
	public By confirmBillButonUsinSadad = By.xpath("(//a[contains(.,'تأكيد') or contains(.,'Confirm')])[1]");
	
	
	public void paymentUsingSadad() {
		if (ElementActions.isElementDisplayed(driver, makeBillUsingSadadButton)) {
			ElementActions.click(driver, makeBillUsingSadadButton);		
			if(ElementActions.isElementDisplayed(driver, confirmBillButonUsinSadad)) {
				ElementActions.click(driver, confirmBillButonUsinSadad);
			}
		}
	}
	
	//Payment Using Installment Option
	public By openPaymentUsingInstallmentButton = By.xpath("//button[contains(.,'التقسيط') or contains(.,'Installments')]");
	public By makeBillUsingInstallmentButton = By.xpath("//a[contains(.,'قسّط الآن') or contains(.,'Install now')]");
	public By confirmBillButonUsinInstallments = By.xpath("(//a[contains(.,'تأكيد') or contains(.,'Confirm')])[2]");
	
	public void paymentUsingInstallments() {
		ElementActions.click(driver, openPaymentUsingInstallmentButton);
		if(ElementActions.isElementDisplayed(driver, makeBillUsingInstallmentButton)) {
			ElementActions.click(driver, makeBillUsingInstallmentButton);
			if(ElementActions.isElementDisplayed(driver, confirmBillButonUsinInstallments)) {
					ElementActions.click(driver, confirmBillButonUsinInstallments);
			}
		}
	}
	//Payment Using Request A loan With National Finance
	public By openPaymentUsingLoanButton = By.xpath("//button[contains(.,'الشركة الوطنية') or contains(.,'National Finance')]");
	public By makeBillUsingRequestLoan = By.xpath("//a[contains(.,'اطلب الآن') or contains(.,'Request')]");
	
	public void paymentUsingRequestLoanWithNationalFinance() {
		ElementActions.click(driver, openPaymentUsingLoanButton);
		if(ElementActions.isElementDisplayed(driver, makeBillUsingRequestLoan)) {
			ElementActions.click(driver, makeBillUsingRequestLoan);
		}		
	}

}
