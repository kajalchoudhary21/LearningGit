package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGAnnotations {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
	}
	
	@Test
	public void loginTest() {
		System.out.println("login successful");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		
		
	}

}
