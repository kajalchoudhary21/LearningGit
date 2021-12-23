package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementConcept {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


        WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("http://mrbool.com/search/");
		
		By contactMenu = By.cssSelector(".menulink");
		By articleChildMenu = By.linkText("COURSES");
		
		doClickOnChildMenu(contactMenu,articleChildMenu);
		
	}
	
	public static WebElement getElement(By locator) {
		 return driver.findElement(locator);
	}
	
	public static void doMoveToElement(By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(locator)).perform();
	}
	
	public static void doClickOnChildMenu(By parentMenuLocator , By childMenuLocator) throws InterruptedException {
		doMoveToElement(parentMenuLocator);
		Thread.sleep(3000);
		getElement(childMenuLocator);
		
		
		
	}
	
	

}
