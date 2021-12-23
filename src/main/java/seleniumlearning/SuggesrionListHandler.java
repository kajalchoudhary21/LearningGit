package seleniumlearning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SuggesrionListHandler {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		
		driver.findElement(By.id("search_query_top")).sendKeys("Dresses");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//div[@class=\"ac_results\"]//li[contains(text(),'Casual Dresses > Printed Dress')]")).click();
		
		
		 List<WebElement> suggestionList = driver.findElements(By.xpath("//div[@class=\"ac_results\"]//li"));
		 
		 System.out.println(suggestionList.size());
		 
		 for(WebElement e : suggestionList) {
			 String text = e.getText();
			 if(text.contains("Casual Dresses")) {
				 e.click();
				 break;
			 }
		 }
		 

	}
	
	public static void selectOptionFromSuggestionList(String Value) {
		
		driver.findElement(By.xpath("//div[@class=\"ac_results\"]//li[contains(text(),'"+Value+"')]")).click();
		
		
	}

}
