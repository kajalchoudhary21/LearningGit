package seleniumlearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		//First Approach
		/**
		 * if user wants to reuse any webElement then user needs to --
		 * again write the same code
		 */
		driver.findElement(By.id("input-email")).sendKeys("abc.gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("abc");
		
		// Second approach--- maintain WebElments
		/**
		 * Elements which are not usable at present , server is hit for those elements as well
		 */
		
		WebElement emailid = driver.findElement(By.id("input-email"));
		WebElement password = driver.findElement(By.id("input-password"));
		emailid.sendKeys("abc.gmail.com");
		password.sendKeys("abc");
		
		//Third approach -- Maintain By Locators
		/**
		 * for 100 elements , 100  locators or webElement will be created
		 * but again 100 times find elements and sendkeys method will be written
		 */
		
		By Username= By.id("input-email");
		By pwd=By.id("input-password");
		
		driver.findElement(Username).sendKeys("abc.gmail.com");
		driver.findElement(pwd).sendKeys("abc");
		
		//Fourth approach --- generic method without action
		/**
		 * 1for 100 element , 100 time action needs to be performed e.g. sendkeys
		 */
		getElement(Username);
		getElement(pwd);
		
		//Fifth approach - generic method with action
		doSendKeys(Username , "test@gmail.com");
		
		//Sixth approach - create a class with all the generic element util method
		
		// 7th approach 
		String UsernameId = "input-email";
		String passwordId = "input-password";
		
		doSendKeys("id",UsernameId,"test@gmail.com");
		doSendKeys("id",passwordId,"abc");
		
		
		
	}
	
	public static By getBy(String locatorType, String locatorValue ) {
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		default:
			System.out.println("Please pass the right locator type and value");
		}
			
		return locator;	
			
		
	}
		
		public static WebElement getElement(By locators) {
			return driver.findElement(locators);
			}
		
		public static WebElement getElement(String locatorType , String locatorValue) {
			return driver.findElement(getBy(locatorType,locatorValue));
			}
	 public static void doSendKeys(By locators , String Value) {
		 getElement(locators).sendKeys(Value);
		 
	 }
	 public static void doSendKeys(String locatorType , String locatorValue , String Value) {
		 getElement(locatorType,locatorValue).sendKeys(Value);

}
}