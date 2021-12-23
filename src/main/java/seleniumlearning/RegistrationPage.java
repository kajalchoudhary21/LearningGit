package seleniumlearning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BrowserUtil brutil = new BrowserUtil();
		WebDriver driver = brutil.launchBrowser("chrome");
		brutil.enterUrl("https://demo.opencart.com/index.php?route=account/register");
		String CurrentUrl= brutil.getAppCurrentUrl();
		System.out.println(CurrentUrl);
		
		By Firstname = By.id("input-firstname");
		By Lastname = By.id("input-lastname");
		By Email = By.id("input-email");
		
		ElementUtil eleutil = new ElementUtil(driver);
		eleutil.doSendKeys(Firstname, "kajal");
		eleutil.doSendKeys(Lastname, "choudhary");
		eleutil.doSendKeys(Email, "Kchoudhary@gmail.com");
		
		brutil.closeBrowser();
		
		
		
		

	}

}
