package seleniumlearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AttributeConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		
		By hrefVal = By.linkText("Amazon Devices");
		getAttributeValue(hrefVal, "href");
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
		
	}
	
	public static String getAttributeValue(By locator, String attributeName) {
		 String attrVal= getElement(locator).getAttribute(attributeName);
		 System.out.println(attrVal);
		 return attrVal;	
	}

}
