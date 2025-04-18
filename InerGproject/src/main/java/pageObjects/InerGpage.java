package pageObjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions; 
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui. ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InerGpage {

WebDriver driver;
WebDriverWait wait;
Actions actions;

By dropdown = By.xpath("//select");
By unfocusElement= By.xpath("//h1");
By graphSection = By.xpath("(//div[@class='graph-representation']) [2]");
By points =By.xpath("(//[local-name()='svg' and @class='main-svg']) [4]//[local-name()='g' and @class='points']//*[local-name()='path' and @class='point']");
By tooltip= By.xpath("//[local-name()='svg' and @class='main-svg'])[6]//[local-name()='g' and @class='hovertext']//*[local-name()='text' @class='nums']");

public InerGpage(WebDriver driver) {
this.driver= driver;
this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
this.actions = new Actions (driver);
PageFactory.initElements(driver, this);
}

public void selectDropdown (int index)
{
WebElement dropdownElement =driver.findElement(dropdown);
Select dropdown =new Select(dropdownElement);
dropdown.selectByIndex(index);
driver.findElement(unfocusElement).click();
}

public void waitForGraph() {
WebElement graph = wait.until (ExpectedConditions.visibilityOfElementLocated (graphSection));
((org.openqa.selenium. JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", graph);
}

public List<WebElement> getPoints() {
return driver.findElements(points);
}
public String getTooltipValue(WebElement point)
{
actions.moveToElement(point).perform();
try {
WebElement tooltipElement = driver.findElement(tooltip);
return tooltipElement.getAttribute("data-unformatted");

}

catch (Exception e)
{
	return "Tooltip not found or no data:" + e.getMessage();
}


}}