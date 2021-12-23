package seleniumlearning;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	private  WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	

	public static By getBy(String locatorType, String locatorValue ) {
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "className":
			locator = By.className(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "cssSelector":
			locator = By.cssSelector(locatorValue);
			break;
		case "linkText":
			locator = By.linkText(locatorValue);
			break;
		default:
			System.out.println("Please pass the right locator type and value");
		}
			
		return locator;	
			
		
	}
		
		public  WebElement getElement(By locator) {
			return driver.findElement(locator);
			}
		
		public  WebElement getElement(By locator , int timeOut) {
			return doPresenceOfElementLocated(locator , timeOut);
			}
		
		public  WebElement getElement(String locatorType , String locatorValue) {
			return driver.findElement(getBy(locatorType,locatorValue));
			}
		
	    public  void doSendKeys(By locator , String Value) {
		 getElement(locator).sendKeys(Value);
		 
	 }
	    
	 public void doSendKeys(String locatorType , String locatorValue , String Value) {
		 getElement(locatorType,locatorValue).sendKeys(Value);
	 }
		 
		 public  void doclick(By locator) {
			 getElement(locator).click();
			 }
		 
		 public  void doclick(By locator , int timeOut) {
			 doPresenceOfElementLocated(locator , timeOut).click();
			 }
		 
		 public  void doclick(String locatorType , String locatorValue) {
			 getElement(locatorType,locatorValue).click();
			 }
		 
		 public String doGetText(By locator) {
			 return getElement(locator).getText();
			 
		 }
		 
		 public String doGetText(String locatorType , String locatorValue) {
			 return getElement(locatorType,locatorValue).getText();
			 
		 }
		 
		 public boolean doIsDispalayed(By locator) {
			 return getElement(locator).isDisplayed();
			 
		 }
		 
		 public boolean isElementExist(By locator) {
				
				int elementCount = getElementsCount(locator);
				System.out.println("total count is " +elementCount);
				
				if (elementCount>0) {
					System.out.println("element is present on the page " +locator);
					return true;
				}
				
				else {
					System.out.println("element is not present on the page "  +locator);
					return false;
					
				}
		 }
		 
		 public List<WebElement> getElements(By locator) {
			 return driver.findElements(locator);
		 }
		 
		 public List<String> getElementTextList(By locator) {
				List<WebElement>eleList =getElements(locator);
				List<String> eleTextList = new ArrayList<String>();
				
				for(WebElement e : eleList) {
					String eleText = e.getText();
					if(!eleText.isEmpty()) {
						eleTextList.add(eleText);
					}
				}
				return eleTextList;
			}
			
			
			 public int getElementsCount(By locator) {
				 return getElements(locator).size();
			 }
			 
			 public void printElements(List<String> eleList) {
					
					for (String e : eleList)
					{
						System.out.println(e);
					}
					
				}
				
				public List<String> getAttributeList(By locator , String attributeName) {
					List<WebElement> eleList = getElements(locator);
					List<String> attList = new ArrayList<String>();
					
					for(WebElement e : eleList) {
						String attrValue= e.getAttribute(attributeName);
						attList.add(attrValue);
					}
					
					return attList;
					
				}
				public String getAttributeValue(By locator, String attributeName) {
					 String attrVal= getElement(locator).getAttribute(attributeName);
					 System.out.println(attrVal);
					 return attrVal;	
				}	
				
				
				
				//**********************************DropDown Utilities ******************
				
				public void doDropdownSelectByIndex(By locator , int index) {
					//WebElement element=getElement(locator);
					Select sc = new Select(getElement(locator));
					sc.selectByIndex(index);
			}
				
				public void doDropdownSelectByValue(By locator , String value) {
					//WebElement element=getElement(locator);
					Select sc = new Select(getElement(locator));
					sc.selectByValue(value);
			}
				
				public void doDropdownSelectByVisibleText(By locator , String visibleText) {
					//WebElement element=getElement(locator);
					Select sc = new Select(getElement(locator));
					sc.selectByVisibleText(visibleText);

  }
				
                public void doSelectDropdownValue(By locator , String Value) {
					
					
					Select sc = new Select(getElement(locator));
					List <WebElement> OptionsList = sc.getOptions();
					
					for ( WebElement e :OptionsList ) {
						String text = e.getText();
						System.out.println(text);
						if (text.equals(Value)) {
							e.click();
							break;
						}
					}
				}
                
                public void doSelectDropdownValueWithoutSelectClass(By locator , String Value) {
            		
            		
                    List<WebElement> optionsList =getElements(locator);
            		
            		System.out.println(optionsList.size());
            		
            		for ( WebElement e :optionsList ) {
            			String text = e.getText();
            			if (text.equals(Value)) {
            				e.click();
            				break;
            			
            		}
            		}
                }
            	
   //************************************Links Util **************************
            		public  List<String> getLinkTextList(By locator) {
            			
            			List <WebElement> langlist= getElements(locator);
            			
            			List<String> linksTextList =  new ArrayList<String>();
            			
            			for(WebElement e : langlist) {
            				String linkText = e.getText().trim();
            				
            				linksTextList.add(linkText);
            				
            			}
            			
            			return linksTextList;
            			
            			
            			
            		}
            		
            		public  void clickOnElement(By locator , String Value) {
            			List <WebElement> langlist= getElements(locator);
            			System.out.println(langlist.size());
            			
            			for(WebElement e : langlist) {
            				String linkText = e.getText().trim();
            				System.out.println(linkText);
            				
            				if(linkText.contains(Value)) {
            					e.click();
            					break;
            					
            				}
            			}
            }
            		//**************************************Actions utils *********************//
            		public void doMoveToElement(By locator) {
            			Actions act = new Actions(driver);
            			act.moveToElement(getElement(locator)).perform();
            		}
            		
            		public void doClickOnChildMenu(By parentMenuLocator , By childMenuLocator) throws InterruptedException {
            			doMoveToElement(parentMenuLocator);
            			Thread.sleep(3000);
            			doclick(childMenuLocator);
            		}
            		public  void doActionSendKeys(By locator , String value) {
            			Actions act = new Actions(driver);
            			act.sendKeys(getElement(locator), value).build().perform();

            		}
            		
            		public  void doActionSendKeysOnActiveElement(By locator , String value) {
            			Actions act = new Actions(driver);
            			act.click(getElement(locator)).sendKeys(value).build().perform();

            		}
            		
            		public  void doActionsClick(By locator) {
            			Actions act = new Actions(driver);
            			act.click(getElement(locator)).build().perform();

            		}
            		
            		public void doActionsMoveToElementClick(By locator) {
            			Actions act = new Actions(driver);
            			act.moveToElement(getElement(locator)).click().build().perform();
}
            		
            		//********************************Waits Utils************************************
            		
            		public  void doSendKeys(By locator , int timeOut , String Value) {
            			doPresenceOfElementLocated(locator , timeOut).sendKeys(Value);
            			
            			
            		}
            		
            		public  WebElement doPresenceOfElementLocated(By locator , int timeOut) {
            			
            			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
            			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            		}
            		
            		public WebElement doPresenceOfElementLocated(By locator , int timeOut , long intervalTime) {
            			
            			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut), Duration.ofMillis(intervalTime));
            			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            		}
            		
            		public WebElement waitForElementToVisible(By locator , int timeOut) {
            			
            			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
            			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            		}
            		
            		public  List<WebElement> waitForElementsToVisible(By locator , int timeOut) {
            			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
            			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            			
            			
            		}

            		public List<WebElement> waitForElementsToVisible(By locator , int timeOut , long intervalTime) {
            			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut), Duration.ofMillis(intervalTime));
            			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
}
            		public  List<String> getElementsTextListWithWait(By locator , int timeOut) {
            			List<WebElement> eleList = waitForElementsToVisible(locator , timeOut);
            			List<String> eleTextList = new ArrayList<String>();
            			
            			for(WebElement e :eleList) {
            				String text = e.getText();
            				eleTextList.add(text);
            			}
            			
            			return eleTextList ;
            		}
            		
            		//******************Wait utils for non WebElements***************************
            		
            		public  Boolean waitForURLToBeContains(String urlFraction, int timeOut) {
            			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
            			return wait.until(ExpectedConditions.urlContains(urlFraction));
            			
            		}
            		
            		public  Boolean waitForURLToBe(String url, int timeOut) {
            			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
            			return wait.until(ExpectedConditions.urlContains(url));
            			
            		}
            		
            		public  String doGetTitleWithFraction(String titleFraction , int timeOut) {
            			if(waitForTitleContain(titleFraction , timeOut)) {
            				return driver.getTitle();		
            				}
            			return null;
            			
            		}
            		
            		public  String doGetTitle(String title , int timeOut) {
            			if(waitForTitleToBe(title , timeOut)) {
            				return driver.getTitle();		
            				}
            			return null;
            			
            		}
            		
            		public  Boolean waitForTitleContain(String titleFraction , int timeOut) {
            			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
            			return wait.until(ExpectedConditions.titleContains(titleFraction));
            			
            		}
            		
            		public  Boolean waitForTitleToBe(String title , int timeOut) {
            			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
            			return wait.until(ExpectedConditions.titleIs(title));
            			
            		}
            		
            		public  Alert waitForAlert(int timeOut) {
            			WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(timeOut));
            			return wait.until(ExpectedConditions.alertIsPresent());
            		}
            		
            		public  String getAlertText(int timeOut) {
            			return waitForAlert(timeOut).getText();
            			
            		}
            		
            		public  void doAlertAccept(int timeOut) {
            			 waitForAlert(timeOut).accept();
            			
            		}
            		
            		public  void doAlertDismiss(int timeOut) {
            			 waitForAlert(timeOut).dismiss();
            			
            		}
            		
            		public  void enterAlertText(String text , int timeOut) {
            			 waitForAlert(timeOut).sendKeys(text);
            			
            		}
            		
            		//******************** Wait for Frame Utils *************//
            		
            		public  void waitForFrameByNameOrID(String nameOrID , int timeOut) {
            		    WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(timeOut));
            			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrID));
            				
            			}

            			public  void waitForFrameByIndex(int frameindex , int timeOut) {
            			    WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(timeOut));
            				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameindex));
            					
            				}
            			public  void waitForFrameByLocator(String frameLocator , int timeOut) {
            			    WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(timeOut));
            				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
            					
            				}
            			
            			public  void waitForFrameByElement(WebElement frameElement , int timeOut) {
            			    WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(timeOut));
            				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
            					
            				}
            			
            			public  void clickElementWhenReady(By locator , int timeOut) {
            				WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(timeOut));
            				 wait.until(ExpectedConditions.elementToBeClickable(locator));
            				
            			}
            			
            			public void clickElementWhenReady(By locator , int timeOut , long intervalTime) {
            				WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(timeOut),Duration.ofMillis(intervalTime));
            				 wait.until(ExpectedConditions.elementToBeClickable(locator));
            				 
            			}
            			
            			public  WebElement waitForElementUsingFluentWait(By locator , int timeOut , int pollingTime) {
            				
            				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            						.withTimeout(Duration.ofSeconds(timeOut))
            						.pollingEvery(Duration.ofSeconds(pollingTime))
            						.ignoring(NoSuchElementException.class)
            						.withMessage("Element not available");
            				
            				return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            				
            			}
            			
            		public  WebElement waitForElementUsingWebDriverWait(By locator , int timeOut , int pollingTime) {
            				
            				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut),Duration.ofSeconds(pollingTime));
            				wait.ignoring(NoSuchElementException.class)
            					.withMessage("Element not available");
            				
            				return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            				
            			}
            		
            		//************************ Custom Wait **********************//
            		
            		public  WebElement retryingElement(By locator , int timeOut) {
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

            		public  WebElement retryingElement(By locator , int timeOut , long pillongtime) {
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


