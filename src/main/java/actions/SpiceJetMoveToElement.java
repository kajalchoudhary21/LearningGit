package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJetMoveToElement {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		Thread.sleep(5000);
		
     
		moveTochildoptions("Add-ons" , "Student Discount");
        System.out.println("Flow runs");
		
		}
	public static By parentXpath(String Menu) {
		return By.xpath("//div[text()='"+Menu+"']");
	}
	
	
	public static By childXpath(String option) {
		return By.xpath("//div[text()='"+option+"']");
	}
	
	public static void moveToParentOptions(String Menu) throws InterruptedException {
		WebElement parentEle=driver.findElement(parentXpath(Menu));
		Actions act = new Actions(driver);
		act.moveToElement(parentEle).perform();
		Thread.sleep(5000);
		
		
	}
	
	public static void moveTochildoptions(String Menu,String option) throws InterruptedException {
		moveToParentOptions(Menu);
		WebElement childele = driver.findElement(childXpath(option));
		Actions act = new Actions(driver);
		Thread.sleep(5000);
		act.moveToElement(childele).click().build().perform();
	}
	

}
