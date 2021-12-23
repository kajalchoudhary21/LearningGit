package webTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablehandle {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://classic.crmpro.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.switchTo().frame("mainpanel");
		
		driver.findElement(By.linkText("CONTACTS")).click();
		
		//By xpath = By.xpath("//a[text()='deepti Gupta']/parent::td/preceding-sibling::td/input");
		
		//Thread.sleep(5000);
		
		//driver.findElement(xpath).click();
		
		//getCompanyName("Amar3 Singh3");
		
		//System.out.println(getPhoneNumber("Amar3 Singh3"));
		getEmailID("deepti Gupta");
		


	}
	
	public static void selectContact(String ContactName) {
		By xpath = By.xpath("//a[text()='"+ContactName+"']/parent::td/preceding-sibling::td/input");
		driver.findElement(xpath).click();
		}
	
	public static String getCompanyName(String ContactName) {
		By xpath = By.xpath("//a[text()='"+ContactName+"']/parent::td/following-sibling::td/a[@context='company']");
		String companyName= driver.findElement(xpath).getText();
		System.out.println(companyName);
		return companyName;
	}
	
	public static List<String> getPhoneNumber(String ContactName) {
		By xpath = By.xpath("//a[text()='"+ContactName+"']/parent::td/following-sibling::td/span");
		////a[text()='Amar3 Singh3']/parent::td/following-sibling::td/span
		List<WebElement> phoneList= driver.findElements(xpath);
		List<String> phoneValueList = new ArrayList<String>();
		System.out.println(phoneList.size());
		for(WebElement e : phoneList) {
			String text = e.getText();
			phoneValueList.add(text);
		}
		return phoneValueList;
	}
	
	public static String getEmailID(String ContactName) {
		By xpath = By.xpath("//a[text()='"+ContactName+"']/parent::td/following-sibling::td/a[contains(text(),'@outlook.com')]");
		String emailID= driver.findElement(xpath).getText();
		System.out.println(emailID);
		return emailID;
	}
	

}
