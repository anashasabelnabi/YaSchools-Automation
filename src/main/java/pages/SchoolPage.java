package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SchoolPage extends PageBase {

	public SchoolPage(WebDriver driver) {
		super(driver);
	}
	
 public By bookNowBtn = By.xpath("//*[@id=\"SchoolSingle\"]/section/div[3]/div/div[2]/div/div[2]/div/a[1]");
}
