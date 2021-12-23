package waits;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForJsAlert {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		 
		driver.findElement(By.name("proceed")).click();

	}
	
	public static Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static String getAlertText(int timeOut) {
		return waitForAlert(timeOut).getText();
		
	}
	
	public static void doAlertAccept(int timeOut) {
		 waitForAlert(timeOut).accept();
		
	}
	
	public static void doAlertDismiss(int timeOut) {
		 waitForAlert(timeOut).dismiss();
		
	}
	
	public static void enterAlertText(String text , int timeOut) {
		 waitForAlert(timeOut).sendKeys(text);
		
	}

}
