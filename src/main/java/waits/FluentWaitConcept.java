package waits;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
       WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		 driver.get("https://demo.opencart.com/index.php?route=account/login");

	}
	
	public static WebElement waitForElementUsingFluentWait(By locator , int timeOut , int pollingTime) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class)
				.withMessage("Element not available");
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	
public static WebElement waitForElementUsingWebDriverWait(By locator , int timeOut , int pollingTime) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut),Duration.ofSeconds(pollingTime));
		wait.ignoring(NoSuchElementException.class)
			.withMessage("Element not available");
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}

}
