package tests;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations. Listeners;
import org.testng.annotations.Test;
import pageObjects.InerGpage;

@Test

public class InerGTest extends BaseTest {

public void inerGDropdown() throws InterruptedException {

InerGpage inerGPage = new InerGpage(driver);

inerGPage.selectDropdown(2); 
Thread.sleep(2000);

inerGPage.waitForGraph();
Thread.sleep(1000);

List<WebElement> points= inerGPage.getPoints(); 
System.out.println("Total points: "+ points.size());

for (WebElement point:points) {

System.out.println("Hovering...");

Thread.sleep(2000);

String value= inerGPage.getTooltipValue(point); 
System.out.println("Tooltip value: " + value);

}}}
