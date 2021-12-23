package dropdownHanler;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownValuesWithoutSelectClass {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		//List<WebElement> optionsList =driver.findElements(By.xpath("//select[@id='Form_submitForm_Country']/option"));
		
		
		
		//System.out.println(optionsList.size());
		
		//for ( WebElement e :optionsList ) {
			//String text = e.getText();
			//System.out.println(text);
			//if (text.equals("India")) {
				//e.click();
				//break;
			//}
		//}
		
		By Options = By.xpath("//select[@id='Form_submitForm_Country']/option");
		
		
		doSelectDropdownValueWithoutSelectClass(Options , "Cuba");
		
		

	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void doSelectDropdownValueWithoutSelectClass(By locator , String Value) {
		
		
        List<WebElement> optionsList =getElements(locator);
		
		System.out.println(optionsList.size());
		
		for ( WebElement e :optionsList ) {
			String text = e.getText();
			if (text.equals(Value)) {
				e.click();
				break;
			}
		}

}
}
