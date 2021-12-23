package dropdownHanler;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropdownWithoutUsingSelectMethod {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		//WebElement country = driver.findElement(By.id("Form_submitForm_Country"));
		
		By Country = By.id("Form_submitForm_Country");
		
		//Select sc = new Select(country);
		//List <WebElement> CountryList = sc.getOptions();
		
		//for ( WebElement e :CountryList ) {
			//String text = e.getText();
			//if (text.equals("India")) {
				//e.click();
				//break;
			//}
		//}
		
		doSelectDropdownValue(Country , "India");

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectDropdownValue(By locator , String Value) {
		
		
		Select sc = new Select(getElement(locator));
		List <WebElement> CountryList = sc.getOptions();
		
		for ( WebElement e :CountryList ) {
			String text = e.getText();
			if (text.equals(Value)) {
				e.click();
				break;
			}
		}
	}

}
