package seleniumlearning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebtablehandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		////*[@id="customers"]/tbody/tr[2]/td[1]
		////table[@id="customers"]/tbody/tr[2]/td[1]
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		Thread.sleep(5000);

		
		int rowCount = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
		int colCount = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th")).size();
		System.out.println(rowCount); //--count is showing as zero for me 
		
		
		
		String beforeXpath = "//table[@id=\"customers\"]/tbody/tr[";
		String afterXpath = "]/td[1]";
		
		for(int i=2; i<=rowCount; i++) {
			String actualXpath = beforeXpath+i+afterXpath;
			String text =driver.findElement(By.xpath(actualXpath)).getText();
			System.out.println(text);
			
			
		}
		
		

	}

}
