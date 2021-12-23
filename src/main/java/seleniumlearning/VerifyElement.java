package seleniumlearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyElement {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By Formsfields = By.className("text");
		 int FormsfieldsCount = driver.findElements(Formsfields).size();
		 
		 if(FormsfieldsCount==0) {
			 System.out.println("formsfields are not available ");
			 
		 }
		 else {
			 System.out.println("formsfields are  available "); 
		 }

	
	
	//to verify single element -- for links what ever is visible on page , Selenium will interact with that only
	
	By contactSalesLinks = By.linkText("CONTACT SALES");
	boolean flag =driver.findElement(contactSalesLinks).isDisplayed();
	
	System.out.println(flag);
	
	if (driver.findElements(contactSalesLinks).size()>0) {
		System.out.println("contactSalesLinks is present on the page ");
	}
	
	else {
		System.out.println("contactSalesLinks is not present on the page ");
		
	}
	
	System.out.println(isElementExist(contactSalesLinks));

}
	
	public static boolean isElementExist(By locator) {
		
		int elementCount = driver.findElements(locator).size();
		System.out.println("total count is " +elementCount);
		
		if (elementCount>0) {
			System.out.println("element is present on the page " +locator);
			return true;
		}
		
		else {
			System.out.println("element is not present on the page "  +locator);
			return false;
			
		}
		
		
	}
}
