package seleniumlearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoSuchElementConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		
		//No Such Element Exception will occur in case of find element 
		
		WebElement Firstname = driver.findElement(By.id("myTextIIIn"));
		Firstname.sendKeys("Kajal");
		
		// No Exception will be visible in case of find elements
		
		
	}

}
