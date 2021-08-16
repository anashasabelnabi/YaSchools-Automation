package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllSchoolsPage extends PageBase {

	public JavascriptExecutor jse ;
	public AllSchoolsPage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor)driver;
		}
	@FindBy(id="schoolName")
	public WebElement searchInput;
	
	@FindBy(xpath="//button[contains(.,'ابحث')]")
	public WebElement searchBtn;
	
	@FindBy(xpath = "//a[contains(.,'Ajyal Mostakbal School')]")
	public WebElement ajyalMostqblPageBtn;
	
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
