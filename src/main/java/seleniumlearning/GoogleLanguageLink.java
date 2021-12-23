package seleniumlearning;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleLanguageLink {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		
		By langLink = By.xpath("//div[@id=\"SIvCob\"]/a");
		//clickOnElement(langLink , "मराठी");
		
		List<String> actualLinkText= getLinkTextList(langLink);
		
		if(actualLinkText.contains("मराठी")) {
			System.out.println("मराठी is present");
		}

	}
	
	public static List<String> getLinkTextList(By locator) {
		
		List <WebElement> langlist= driver.findElements(locator);
		
		List<String> linksTextList =  new ArrayList<String>();
		
		for(WebElement e : langlist) {
			String linkText = e.getText().trim();
			
			linksTextList.add(linkText);
			
		}
		
		return linksTextList;
		
		
		
	}
	
	public static void clickOnElement(By locator , String Value) {
		List <WebElement> langlist= driver.findElements(locator);
		System.out.println(langlist.size());
		
		for(WebElement e : langlist) {
			String linkText = e.getText().trim();
			System.out.println(linkText);
			
			if(linkText.contains(Value)) {
				e.click();
				break;
				
			}
		}
	}

}
