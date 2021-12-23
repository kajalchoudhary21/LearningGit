package seleniumlearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		driver.switchTo().frame("main");

		String header = driver.findElement(By.xpath("/html/body/h2")).getText();
		
		System.out.println(header);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("content");
		
        String header2 = driver.findElement(By.xpath("/html/body/p[5]/a")).getText();
		
		System.out.println(header2);
		
		
		
		
	}

}
