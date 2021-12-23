package seleniumlearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {
	
	WebDriver driver;
	
	public WebDriver launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABCD\\Desktop\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("Firefox")) {
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\ABCD\\Desktop\\geckodriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
		}
		else 
		{
			System.out.println("Invalid Browser");
		}
		
		return driver;
	}
	
	public void enterUrl(String url) {
		
		if (url==null) {
			System.out.println("url is null");
			return;
			}
		if (url.indexOf("https")==-1) {
			System.out.println("https is missing");
			return;
		}
		driver.get(url);
		}
	
	public String getAppCurrentUrl() {
		return driver.getCurrentUrl();
		
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
}
