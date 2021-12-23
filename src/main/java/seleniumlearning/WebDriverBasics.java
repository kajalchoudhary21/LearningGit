package seleniumlearning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABCD\\Desktop\\chromedriver.exe");

		WebDriver driver= new ChromeDriver(); // constructor will be called for chromedriver. inside constructor launch browser logic is written.
		
		driver.get("https:\\www.google.com");
		String title= driver.getTitle();
		System.out.println(title);
		
		driver.quit();
		
	
	
	}

}
