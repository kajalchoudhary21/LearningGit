package seleniumlearning;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImagesUtil {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		By links = By.tagName("img");
		
		System.out.println(getElementsCounts(links));
		
		List<String> attrList = getAttributeList(links ,"src");
		
		printElements(attrList);
		

	}
	
	public static void printElements(List<String> eleList) {
		
		for (String e : eleList)
		{
			System.out.println(e);
		}
		
	}
	
	public static List<String> getAttributeList(By locator , String attributeName) {
		List<WebElement> eleList = getElements(locator);
		List<String> attList = new ArrayList<String>();
		
		for(WebElement e : eleList) {
			String attrValue= e.getAttribute(attributeName);
			attList.add(attrValue);
		}
		
		return attList;
		
	}
	
	public static int getElementsCounts(By locator) {
		return getElements(locator).size();
		
		
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
