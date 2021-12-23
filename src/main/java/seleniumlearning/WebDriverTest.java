package seleniumlearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverTest {
	
	public static void main(String [] args) {
		
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("https:\\www.google.com");
	String title= driver.getTitle();
	System.out.println(title);
	
	String currentUrl = driver.getCurrentUrl();
	System.out.println(currentUrl);
	
	driver.quit(); // after quit method session id will be null and exception will NoSuchSessionException
	
	
	}

}
