package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RequestALoanPage {
	private WebDriver driver ;
	public RequestALoanPage(WebDriver driver) {
		this.driver = driver ;
	}
	
	public String anas = driver.findElement(By.xpath("//h1[contains(.,'طلب تمويل')]")).getText();
}
