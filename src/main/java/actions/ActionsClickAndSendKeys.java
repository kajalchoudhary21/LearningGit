package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClickAndSendKeys {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
        WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		
		//WebElement firstName = driver.findElement(By.id("input-firstname"));
		
		/**
		 * Equivalent to calling: Actions.click(element).sendKeys(keysToSend).This method is different from WebElememt sendKeys
		 */
		
		Actions act = new Actions(driver);
		
		//act.sendKeys(firstName, "Tom").build().perform();
		
		//act.click(firstName).sendKeys("Tom").build().perform();
		
		By firstName = By.id("input-firstname");
		By lastName =  By.id("input-lastname");
		doActionSendKeys(firstName , "Kajal");
		doActionSendKeysOnActiveElement(lastName ,"Choudhary");
		
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doActionSendKeys(By locator , String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).build().perform();

	}
	
	public static void doActionSendKeysOnActiveElement(By locator , String value) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).sendKeys(value).build().perform();

	}
	
	public static void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).build().perform();

	}
	
	public static void doActionsMoveToElementClick(By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(locator)).click().build().perform();

	}


}
