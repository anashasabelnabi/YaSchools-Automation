package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilites.Helpers;

public class TestBase{
	public static WebDriver driver;
	
	@BeforeSuite
	@Parameters("browser")
	public void startDriver(@Optional("chrome")String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/browsers/chromedriver.exe");
			driver = new ChromeDriver();		
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/browsers/geckodriver.exe");
			driver = new FirefoxDriver();		
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		driver.navigate().to("https://qc.yaschools.com/");
	}
	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed");
			System.out.println("Taking Screenshot...");
			Helpers.captureScreenShot(driver, result.getName());
		}
		
	}
	@AfterSuite
	public void stopDriver() {
		driver.quit();
	}

}
