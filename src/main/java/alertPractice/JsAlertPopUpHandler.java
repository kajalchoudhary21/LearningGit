package alertPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsAlertPopUpHandler {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		 
		driver.findElement(By.name("proceed")).click();
		
		Thread.sleep(5000);
		
		Alert alert =driver.switchTo().alert();
		String text= alert.getText();
		
		if (text.equals("Please enter a valid user name")) {
			System.out.println("alert is correct");
		}
		
		alert.accept();
		alert.dismiss();
		

	}

}
