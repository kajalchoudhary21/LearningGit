package waits;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * ExplictWait is high level wait 
		 * It can be applied for specific element not for all element by default
		 * It can be applied for non WebElement like alert , url,title etc
		 * It can be customized for specific element as per Use case --e1-5sec e2--noWait e3---10sec
		 * WebDriverWait(C)--extend--FluentWait(C)-->Wait(I)
		 * Until() --abstract method in Interface and Overriden in FluentWait
		 * 
		 * individual Method of FluentWait -PollingEvery() , Ignoring(),withTimeOut()
		 * 
		 * WebDriverWait and ExplictWait are exactly same ..containing same methods
		 */

		
        WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://classic.crmpro.com/index.html");
			
			//driver.findElement(By.name("username")).sendKeys("Kajal");
			
			By userName = By.name("username");
			
			//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			
			//WebElement user_ele = wait.until(ExpectedConditions.presenceOfElementLocated(userName));
			
			//user_ele.sendKeys("Kajal");
			
			//doSendKeys(userName , 10, "kajal");
			
			By footers = By.xpath("//footer//ul[@class='footer-nav']//a");
			
			waitForElementsToVisible(footers , 10 , 2);
	}
	
	public static void doSendKeys(By locator , int timeOut , String Value) {
		doPresenceOfElementLocated(locator , timeOut).sendKeys(Value);
		
		
	}
	
	public static WebElement doPresenceOfElementLocated(By locator , int timeOut) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
public static WebElement doPresenceOfElementLocated(By locator , int timeOut , long intervalTime) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut), Duration.ofMillis(intervalTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

public static WebElement waitForElementToVisible(By locator , int timeOut) {
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
	return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}

public static WebElement waitForElementToVisible(By locator , int timeOut , long intervalTime) {
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut), Duration.ofMillis(intervalTime));
	return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}

public static List<WebElement> waitForElementsToVisible(By locator , int timeOut) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
	return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	
	
}

public static List<WebElement> waitForElementsToVisible(By locator , int timeOut , long intervalTime) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut), Duration.ofMillis(intervalTime));
	return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	
	
}


}
