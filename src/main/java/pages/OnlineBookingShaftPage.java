package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shaft.gui.element.ElementActions;

public class OnlineBookingShaftPage {

	WebDriver driver ;
	
	public OnlineBookingShaftPage(WebDriver driver){
		this.driver = driver;		
	}
	private By childNameDropdown = By.xpath("//option[contains(.,'yosraa')]");
	private By childNameText = By.xpath("//*[@id=\"select2-childsuperior-childs-0-full_name-container\"]/span");
	
	public void parentEnterChildInfo() {
		ElementActions.type(driver, childNameText, "yosraa");
		ElementActions.click(driver, childNameDropdown);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeSelected(childNameDropdown));
	}
}
