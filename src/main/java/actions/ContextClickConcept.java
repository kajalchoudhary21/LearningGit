package actions;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextClickConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		By xpath = By.xpath("//ul[@class='context-menu-list context-menu-root']/li[contains(@class,'context-menu-item context-menu-icon')]/span");
	
		alertText(xpath,"copy");
		alertText(xpath,"cut");
		alertText(xpath,"quit");
	}	  
		  public static void alertText(By locator , String function) {
			  
			  WebElement rightClickme= driver.findElement(By.xpath("//span[text()='right click me']"));
				
				Actions act = new Actions(driver);
				
				act.contextClick(rightClickme).build().perform();
			  
			  List<WebElement> opnList = driver.findElements(locator);
			  for(WebElement e: opnList) {
				  String text = e.getText();
				  
				  if(text.equalsIgnoreCase(function)) {
					  e.click();
					  Alert a = driver.switchTo().alert();
					  System.out.println(a.getText());
					  a.accept();
				  }
				  
				
			   }
			  
		  }
		

	

}

