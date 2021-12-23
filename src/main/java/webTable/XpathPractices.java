package webTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathPractices {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//htmltag[@attribute1 ='value' and @attribute2='value']
		//driver.get("https://demo.opencart.com/index.php?route=account/login");
		//driver.get("https://classic.crmpro.com/index.html");
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		//driver.findElement(By.xpath("//input[@type='text' and @class='form-control']")).sendKeys("Test@gmail.com");
		
		//driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();  -->ElementNotInteractableException
		
		//Assignment- Print text and href value of all the elements
		
		 //List<WebElement> links = driver.findElements(By.xpath("//a[@class='list-group-item']"));
		 
		 //for(WebElement e : links)
		 //{
			 //System.out.println(e.getText());
			// System.out.println(e.getAttribute("href"));
		 //}
		
		//Thread.sleep(5000);
		
		//driver.findElement(By.xpath("//div[@aria-label='Dismiss']")).click();
		
		
         //driver.findElement(By.xpath("//a[text()='Register' and @class='list-group-item']")).click();
         
         //String text = driver.findElement(By.xpath("//h3[text()='Marketing Campaigns']")).getText();
         //System.out.println(text);
         
         /**
          * contains  is used to handle dynamic element with dynamic properties
          * contains with text() 
          *
          */
       //input[contains(@id, 'input')
         
       //driver.findElement(By.xpath("//input[contains(@id, 'input') and @name='email']"));
       //driver.findElement(By.xpath("//a[contains(text(), 'Address Book')]"));
         
         /**
          * starts-with(); function 
          */
         
         //driver.findElement(By.xpath("//input[starts-with(@id, 'input') and contains(@type,'text')]"));
         
         /**
          * Class with multiple class values
          * whenever having multiple class then by.class name should have only one single class name 
          */
         
         //tagname[@class=c1 c2 c3...cn]
         
        // List<WebElement> footerlinks =driver.findElements(By.xpath("((//div[@class='container'])[3]//ul)[1]//a"));
         
         //List<WebElement> footerlinks =driver.findElements(By.xpath("((//div[@class='container'])[position()=3]//ul)[1]//a"));
        
         List<WebElement> footerlinks =driver.findElements(By.xpath("((//div[@class='container'])[last()]//ul)[1]//a"));
         
         
         
         for(WebElement e :footerlinks) {
        	 System.out.println(e.getText());
         }
	}

}
