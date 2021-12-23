package webTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrongLocatorSyntax {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By Name = By.xpath("//*[@id=\"Form_submitForm_Name\"]");
		driver.findElement(Name).sendKeys("Kajal");
		
		//if xpath/Css Selector is wrong then no Such Element Exception will be occured
		//instead InvalidSelectorException should occur which was part of selenium 3 bt not in selenium 4



}
}
