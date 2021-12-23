package seleniumlearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Queries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1.in amazon with below xpath -
		//wants to usee contain function 
		//(//table[@class='navFooterMoreOnAmazon']//td)[last()]//a
		
		//2.In Static Webtable if wants to capture 
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com");
		
		
	}

}
