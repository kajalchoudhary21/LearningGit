package waits;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitforFrame {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("main"));
		
		driver.switchTo().frame("main");

	}
	
	public static void waitForFrameByNameOrID(String nameOrID , int timeOut) {
    WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(timeOut));
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrID));
		
	}

	public static void waitForFrameByIndex(int frameindex , int timeOut) {
	    WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameindex));
			
		}
	public static void waitForFrameByLocator(String frameLocator , int timeOut) {
	    WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
			
		}
	
	public static void waitForFrameByElement(WebElement frameElement , int timeOut) {
	    WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
			
		}

}
