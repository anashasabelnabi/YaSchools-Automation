package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.PaymentPage;
import pages.RequestALoanPage;

public class PaymentWithRequestAlLoanTest extends TestBase{
	PaymentPage paymentPageObject ;
	RequestALoanPage requestLoanPageObject ; 
	@Test
	public void parentCanPayUsingRequestLoan() {
		paymentPageObject = new PaymentPage(driver);
		paymentPageObject.paymentUsingRequestLoan();
		requestLoanPageObject = new RequestALoanPage(driver);
		assertEquals(requestLoanPageObject.anas,"طلب تمويل مصروفات دراسية");
	}

}
