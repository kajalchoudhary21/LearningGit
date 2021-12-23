package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitilyWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		//global wait - it will be applicable for all the elements by default
		//implicitely wait is with driver
		//UN-5 sec password - 0 sec 
		//Every time you need to override implicitly wait if 0 sec given then it will be nullify the implicit wait
		//applicable only for WebElements not for non WebElements means alert , urls , getTitle
		
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://classic.crmpro.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("Kajal");
		

	}

}
