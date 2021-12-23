package AutomationPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchDresses {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		
		By searchBar=By.id("search_query_top");
		
		By optionXpath=By.xpath("//div[@class='ac_results']//li");

	    SearchDressesToAdd(searchBar, optionXpath , "Dresses","Printed Chiffon Dress");
	    
	    System.out.println(driver.getTitle());
	
	}
	
	
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
		
	}
	
	public static void SearchDressesToAdd(By locator ,By optnLocator ,String serachText , String OptionText) throws InterruptedException {
		getElement(locator).sendKeys(serachText);
		Thread.sleep(5000);
		List <WebElement> SerachList = driver.findElements(optnLocator);
		for(WebElement e : SerachList) {
			String Suggestion =e.getText();
			if(Suggestion.contains(OptionText)) {
				e.click();
				break;
			}
		}
		
				
		
	}
	
	
	

}
