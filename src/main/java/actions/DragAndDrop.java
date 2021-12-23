
package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
        WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		//driver.get("https://jqueryui.com/droppable/");
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		//driver.findElement(By.xpath("//a[text()='Droppable']")).click();
		Thread.sleep(5000);
		
	    WebElement sourceEle = driver.findElement(By.id("draggable"));
	    WebElement destinationEle = driver.findElement(By.id("droppable"));
		Actions act = new Actions(driver);
		act.clickAndHold(sourceEle).moveToElement(destinationEle).release()
		.build().perform();
		
		

	}

}
