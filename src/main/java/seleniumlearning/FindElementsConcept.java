package seleniumlearning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// find count all the links/images on the page 

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		List <WebElement> linklist =driver.findElements(By.tagName("a"));
		System.out.println("Total count is " +linklist.size());
		
		for(WebElement e : linklist) {
			String text = e.getText();
			if(!text.isEmpty()) {
				System.out.println(text);
			}
		}
		
		List <WebElement> images =driver.findElements(By.tagName("img"));
		System.out.println("Total count is " +images.size());
		for(WebElement e : images) {
			String text = e.getAttribute("alt");
			System.out.println(text);
			}
	}
}
