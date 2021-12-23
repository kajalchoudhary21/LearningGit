package waits;

public class WaitsTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * there is are 2 types of waits 
		 * 1.Static wait -hold the script for few second 
		 * example- Thread.Sleep(2000)--available in java
		 * Decrease the performance of code
		 * 
		 * 
		 * 2.Dynamic Wait - if element found in 2 sec then rest of time will ignored
		 * ImplicitWait 
		 * ExplicitWait(concept) - a.WebDriverWait b.FluentWait
		 * 
		 * Wait Interface is implemented by Fluent class and extended by WebDriverWait
		 * Wait(I)<-----FluentWait(C)<-----WebDriverWait(C)
		 * Element max time given in 10sec
		 * fount in 2 sec-- 8 sec will be ignore
		 * found in 10 sec --0 sec will be ignore 
		 * found in 11 sec-- noSuchelementException
		 * This concept is called as Synchronization in selenium - sync b/w script and webpageor elements
		 */

	}

}
