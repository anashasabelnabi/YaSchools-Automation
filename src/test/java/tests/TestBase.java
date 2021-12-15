package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;

public class TestBase {
	public static WebDriver driver;

	@BeforeSuite
	//@Parameters("browser")
	public void startDriver() {
		driver = DriverFactory.getDriver();
		BrowserActions.navigateToURL(driver, "https://qc.yaschools.com/");
	}

	@AfterSuite
	public void stopDriver() {
		driver.quit();
	}

}
