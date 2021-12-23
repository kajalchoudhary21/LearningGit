package seleniumlearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownWithSelectTag {
	
	// drown with html tag as select 
	//using Select class in Selenium
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		//WebElement country = driver.findElement(By.id("Form_submitForm_Country"));
		
		//Select sc = new Select(country);
		//sc.selectByIndex(5);
		//sc.selectByVisibleText("India");
		//sc.selectByValue("Cuba");
		
		By Country = By.id("Form_submitForm_Country");
		doDropdownSelectByIndex(Country , 10);
		

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doDropdownSelectByIndex(By locator , int index) {
		//WebElement element=getElement(locator);
		Select sc = new Select(getElement(locator));
		sc.selectByIndex(index);
}
	
	public static void doDropdownSelectByValue(By locator , String value) {
		//WebElement element=getElement(locator);
		Select sc = new Select(getElement(locator));
		sc.selectByValue(value);
}
	
	public static void doDropdownSelectByVisibleText(By locator , String visibleText) {
		//WebElement element=getElement(locator);
		Select sc = new Select(getElement(locator));
		sc.selectByVisibleText(visibleText);
}
}
