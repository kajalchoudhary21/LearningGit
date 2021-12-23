package seleniumlearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OtherLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		
		// name locator
		
		By emailid = By.name("Username");
		By Password = By.name("Password");
		
		ElementUtil eleutil = new ElementUtil(driver);
		eleutil.doSendKeys(emailid, "naveen@gmail.com");
		

	}
	

}
