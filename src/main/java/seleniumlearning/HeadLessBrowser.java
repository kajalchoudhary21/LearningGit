package seleniumlearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * Browser will be visible.Browser will be hidden
		 * Testing is happening behind the scene
		 * It will faster as compared to the normal mode.
		 */

		WebDriverManager.chromedriver().setup();
		//ChromeOptions co = new ChromeOptions();
		//co.addArguments("--headless");
		//co.addArguments("--incognito");
		WebDriver driver = new ChromeDriver();
		
		//WebDriverManager.firefoxdriver().setup();
		//FirefoxOptions fo = new FirefoxOptions();
		//fo.addArguments("--headless");
		//WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		driver.quit();
		
		
		
	}

}
