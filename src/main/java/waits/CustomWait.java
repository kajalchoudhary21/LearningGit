package waits;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomWait {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
		
		public static WebElement getElement(By locator) {
			return driver.findElement(locator);
		}
		
		public static WebElement retryingElement(By locator , int timeOut) {
			WebElement element = null;
			int attempt =0;
			
			while(attempt< timeOut) {
				try {
				element = getElement(locator);
				break;
			}catch(NoSuchElementException e) {
				System.out.println("element is not found in attempts:" +attempt+" : "+locator);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
				attempt++;
			}
			
			if(element == null) {
				try {
				throw new Exception("ELEMENTNOTFOUNDEXCEPTION");
				}
				catch (Exception e) {
					System.out.println("Element not found");
				}
			}
			
			return element;
		}

		public static WebElement retryingElement(By locator , int timeOut , long pillongtime) {
			WebElement element = null;
			int attempt =0;
			
			while(attempt< timeOut) {
				try {
				element = getElement(locator);
				break;
			}catch(NoSuchElementException e) {
				System.out.println("element is not found in attempts:" +attempt+" : "+locator);
				try {
					Thread.sleep(pillongtime);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
				attempt++;
			}
			
			if(element == null) {
				try {
				throw new Exception("ELEMENTNOTFOUNDEXCEPTION");
				}
				catch (Exception e) {
					System.out.println("Element not found");
				}
			}
			
			return element;
		}


}
