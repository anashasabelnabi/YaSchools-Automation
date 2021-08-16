package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	protected WebDriver driver ;
	public JavascriptExecutor jse ;
	//create constructor
	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	protected static void clickButton(WebElement button) {
		button.click();
	}
	protected static void clearInput(WebElement input) {
		input.click();
	}
	protected static void setText(WebElement txt,String value){
		txt.clear();
		txt.sendKeys(value);
	}
	protected static void selectValue(WebElement select,String value) {
		Select options = new Select(select);
		options.selectByValue(value);
	}
	protected static void selectIndex(WebElement select,int value) {
		Select options = new Select(select);
		options.selectByIndex(value);
	}
	protected static void selectText(WebElement select,String value) {
		Select options = new Select(select);
		options.selectByVisibleText(value);
	}
	
	public void scrollToBottom() {
		jse.executeScript("scrollBy(0,2500)");
	}

}
