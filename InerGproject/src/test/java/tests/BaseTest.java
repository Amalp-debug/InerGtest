package tests;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	WebDriver driver;
	
@BeforeMethod

public void setup() {

WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();

driver.manage().window().maximize(); driver.get("https://inerg-test.web.app/");

}
	@AfterMethod

	public void TearDown() {

		driver.quit();

	}
}
