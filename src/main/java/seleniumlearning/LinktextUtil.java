package seleniumlearning;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinktextUtil {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		By links = By.tagName("a");
		System.out.println("Total count is " +getElementsCount(links));
		
		List<String> actList = getElementTextList(links);
		System.out.println(actList.size());
		for (String e : actList) {
			System.out.println(e);
			
		}
		
		

	}
	
	public static List<String> getElementTextList(By locator) {
		List<WebElement>eleList =getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		
		for(WebElement e : eleList) {
			String eleText = e.getText();
			if(!eleText.isEmpty()) {
				eleTextList.add(eleText);
			}
		}
		return eleTextList;
	}
	
	
	 public static int getElementsCount(By locator) {
		 return getElements(locator).size();
	 }
	 
	 public static List<WebElement> getElements(By locator) {
		 return driver.findElements(locator);
	 }


}
