package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForNonWebElements {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://automationpractice.com/index.php");
		
		driver.findElement(By.linkText("Contact us")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("controller=contact"));
		
		if(waitForURLToBeContains("controller=contact" , 5)){
			System.out.println("Url is correct");
			
		}

	}
	
	public static String doGetTitleWithFraction(String titleFraction , int timeOut) {
		if(waitForTitleContain(titleFraction , timeOut)) {
			return driver.getTitle();		
			}
		return null;
		
	}
	
	public static String doGetTitle(String title , int timeOut) {
		if(waitForTitleContain(title , timeOut)) {
			return driver.getTitle();		
			}
		return null;
		
	}
	
	public static Boolean waitForTitleContain(String titleFraction , int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleContains(titleFraction));
		
	}
	
	public static Boolean waitForTitleToBe(String title , int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleIs(title));
		
	}
	
	public static Boolean waitForURLToBeContains(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.urlContains(urlFraction));
		
	}
	
	public static Boolean waitForURLToBe(String url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.urlContains(url));
		
	}

}
