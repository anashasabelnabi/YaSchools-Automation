package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.shaft.gui.element.ElementActions;

public class AllSchoolsPage{

	public JavascriptExecutor jse ;
	WebDriver driver ;
	public AllSchoolsPage(WebDriver driver) {
		this.driver = driver;
		jse = (JavascriptExecutor)driver;
		}
	@FindBy(id="schoolName")
	public WebElement searchInput;
	
	@FindBy(xpath="//button[contains(.,'ابحث')]")
	public WebElement searchBtn;
	
	public By ajyalMostqblPageBtn = By.xpath("//a[contains(.,'Ajyal Mostakbal')]");
	public void openSchoolPage() {
		ElementActions.click(driver, ajyalMostqblPageBtn);
	}
	
//	public void openTestingSchool() {
//		setText(searchInput,"ajyal");
//		jse.executeScript("arguments[0].value='ajyal'", searchInput);  
//		scriptToClickBtn(searchBtn);
//		scriptToClickBtn(ajyalMostqblPageBtn);
//	}
	public void scriptToClickBtn(WebElement button) {
		jse.executeScript("arguments[0].click();",button);
	}

}
