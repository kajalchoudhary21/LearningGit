package dropdownHanler;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAllDropdownValuesWithSelectTag {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		WebElement country = driver.findElement(By.id("Form_submitForm_Country"));
		
		Select sc = new Select(country);
		List <WebElement> CountryList = sc.getOptions();
		System.out.println(CountryList.size());
		
		if(CountryList.size()-1==231) {
			System.out.println("Country count is correct");
		}
		 int count = 0;
		for (WebElement e : CountryList ) {
			String Text = e.getText();
			System.out.println(Text);
			count++;
		}
		
		for (int i=0 ; i<CountryList.size(); i++) {
			String text = CountryList.get(i).getText();
			System.out.println(i+ "::" + text);
		}
	}

}
