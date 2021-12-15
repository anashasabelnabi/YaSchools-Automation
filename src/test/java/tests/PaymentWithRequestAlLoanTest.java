package tests;

import org.testng.annotations.Test;

import com.shaft.validation.Validations;

import io.qameta.allure.Description;
import pages.PaymentPage;
import pages.RequestALoanPage;

public class PaymentWithRequestAlLoanTest extends TestBase{
	PaymentPage paymentPageObject ;
	RequestALoanPage requestLoanPageObject ; 
	String MonthlySalary = "5000" ;
	String FilePath = System.getProperty("user.dir")+"/target/resources/images/testUplaod.png" ;
	@Description("Parent Can Pay Using Finance Request")
	@Test
	public void parentCanPayUsingRequestLoan() {
		paymentPageObject = new PaymentPage(driver);
		paymentPageObject.paymentUsingRequestLoanWithNationalFinance();
		requestLoanPageObject = new RequestALoanPage(driver);
		requestLoanPageObject.payUsingNationalFinanceRequest(MonthlySalary);
		requestLoanPageObject.uploadAttachments(FilePath);
		Validations.assertThat()
		.element(driver,requestLoanPageObject.conirmationMessage)
		.exists()
		.perform();
	}

}
