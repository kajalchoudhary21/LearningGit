package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickWhenReadyConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		 driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		 By register = By.linkText("Register");
		 
		 //WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
		 //wait.until(ExpectedConditions.elementToBeClickable(register));
		

	}
	
	public static void clickElementWhenReady(By locator , int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(timeOut));
		 wait.until(ExpectedConditions.elementToBeClickable(locator));
		
	}
	
	public static void clickElementWhenReady(By locator , int timeOut , long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(timeOut),Duration.ofMillis(intervalTime));
		 wait.until(ExpectedConditions.elementToBeClickable(locator));
		 
	}
	

}
