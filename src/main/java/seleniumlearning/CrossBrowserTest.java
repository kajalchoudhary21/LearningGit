package seleniumlearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowserTest {
	
	static String browser = "chrome";
	static WebDriver driver;
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABCD\\Desktop\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ABCD\\Desktop\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else 
		{
			System.out.println("Invalid Browser");
		}
		
		driver.get("https:\\www.google.com");
		String title= driver.getTitle();
		System.out.println(title);
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		driver.quit();
		
	}

}
