package dropdownHanler;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryDropDownHandle {
	
	static WebDriver driver ;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("justAnInputBox")).click();
		
		By choices = By.cssSelector("span.comboTreeItemTitle");
		
		//Single select
		//selectChoice(choices , "choice 3");
		
		
		//Multi select
		//selectChoice(choices , "choice 1" , "choice 3", "choice 6 2 3");
		
		// Select all values from dropdown
		selectChoice(choices , "all");

		
	}
	
	// String... this is array list of type String
	
	public static void selectChoice(By locator , String... Value) {
		
      List<WebElement> choiceList = driver.findElements(locator);
      
      if(!Value[0].equals("all")) {
      
      for(WebElement e : choiceList) {
			String text =e.getText();
			//System.out.println(text);
      
      for (int i=0;i<Value.length;i++) {
    	  if(text.equals(Value[i])) {
    		  e.click();
    		  break;
    	  }
    	  
      }
	}
		
}
      else {
    	  try {
    	  
    	  for(WebElement e :choiceList) {
    		  e.click();
    	  }
    	  }catch(ElementNotInteractableException e) {
    		  System.out.println("All choices are over");
    	  }
    	  
      }

}
}
