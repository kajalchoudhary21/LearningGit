package seleniumlearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementDisplayed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		ElementUtil eleutil = new ElementUtil(driver);
		
		By emaild = By.id("input-email");
		if(eleutil.doIsDispalayed(emaild)) {
			System.out.println("element is present");
		}
		
		
		

	}

}
