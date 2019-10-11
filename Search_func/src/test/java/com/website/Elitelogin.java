package com.website;


import java.awt.AWTException;
//	import java.awt.List;
import java.util.ArrayList;
	//import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class Elitelogin {

		WebDriver driver;
		  @BeforeTest
		  public void beforeTest() 
		  {
			  
			  //ChromeOptions chromeOptions= new ChromeOptions();
			  //chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
			  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			  driver.get("https://www.kobster.website/elite-auth");
			  driver.manage().window().maximize();
			  
		  }
		  
		  @Test(priority = 0)
		  public void loginpage() {
			
			  WebElement uname=driver.findElement(By.xpath("//*[@id=\"login_email\"]"));
			  uname.sendKeys("vijayashanthi38@gmail.com");
			  
			  WebElement Password=driver.findElement(By.xpath("//*[@id=\"login_passwd\"]"));
			  Password.sendKeys("kobster123");
			  
			  WebElement log_button=driver.findElement(By.xpath("//*[@id=\"SubmitDashLogin\"]"));
			  log_button.click();
			  
			
		  }
		  
		  @Test(priority = 1)
		  public void search_bar() throws InterruptedException {
			  
			  Thread.sleep(3000);
			  
			  WebElement searchbox=driver.findElement(By.xpath("//*[@id=\"sticky\"]/div[3]/div[4]/div/input"));
			  searchbox.sendKeys("glass board marker");
			  
			  WebElement searchbutton=driver.findElement(By.xpath("//*[@id=\"sticky\"]/div[3]/div[4]/div/div"));
			  searchbutton.click();
		  
		  }
		  
		  @Test(priority = 2)
		  public void search_filter() throws InterruptedException {
			  
			/*  Thread.sleep(3000);
			  
			  WebElement loc_filter=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[1]/div/div[2]/div[2]"));
			  loc_filter.click();
			  
			  Thread.sleep(2000);
			 
			  String myWindowHandle = driver.getWindowHandle();
			  driver.switchTo().window(myWindowHandle);
			  
			  WebElement gps_id= driver.findElement(By.xpath("//*[@id=\"spLocaationContent\"]/div/div[2]"));
			  gps_id.click();*/
			  
			  Thread.sleep(3000);
			  
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			  
			  Thread.sleep(3000);
			  
			  WebElement pro_name=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[2]/div/div/div/div[5]/div[2]"));
			  String product_name=pro_name.getText();
			  
			  WebElement Ref_no=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[2]/div/div/div/div[5]/div[3]"));
			  String reference_no=Ref_no.getText();
			  
			  WebElement pro_price=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[2]/div/div/div/div[5]/div[4]/div[1]"));
			  String product_price=pro_price.getText();
			  
			  String prices = product_price.substring(17);

			  
			  System.out.println(product_name);
			  System.out.println(reference_no);
			  System.out.println(prices);
			  
			  WebElement pro_button=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[2]/div/div/div/div[5]/div[5]"));
			  pro_button.click();	 
			  
			  ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			  driver.switchTo().window(tabs2.get(1));
			  Thread.sleep(4000);
			  
			 /* WebElement loc_sel=driver.findElement(By.xpath("//*[@id=\"spLocaationContent\"]/div/div[2]"));
			  loc_sel.click();*/
			  
			  Thread.sleep(3000);
			  
			  driver.findElement(By.xpath("//*[@id=\"spArea\"]/div/div/div[1]/button")).click();
			  
			  String prodet_name=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div[2]/div/div[2]/div[1]/p[1]")).getText();
			  String prodet_refno=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div[2]/div/div[2]/div[1]/p[2]")).getText();
			  String prodet_price=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div[2]/div/div[2]/div[2]/div[1]")).getText();
			  
			  String prices_proddet = prodet_price.substring(19);
			  
			  if(product_name.equals(prodet_name)) {
				    System.out.println("Product name is Matching");
				} else {
				    System.out.println("Product name is not Matching");
				}
			  
			  if(reference_no.equals(prodet_refno)) {
				   System.out.println("Reference Number is Matching");
				} else {
					System.out.println("Reference Number is not Matching");
				}
			  
			  if(prices.equals(prices_proddet)) {
				   System.out.println("Price is Matching");
				} else {
					System.out.println("Price is not Matching");
				}
			  


		  }
		  
		  
		  @Test(priority=3)
		  public void supplier_quote() throws InterruptedException, AWTException 
		  {
			  
			     Thread.sleep(3000);  
			  	JavascriptExecutor je = (JavascriptExecutor) driver;
			  	WebElement element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div[3]/div/div[2]/div[1]/table/tbody/tr[15]/td[5]"));
			  	je.executeScript("arguments[0].scrollIntoView(true);",element);

			  	element.click();

			  
			  	Thread.sleep(2000);
			  	
		/*
		 * String beforexpath=
		 * "//*[@id=\"app\"]/div/div[1]/div/div[2]/div[3]/div/div[2]/div[1]/table/tbody/tr[";
		 * String afterxpath ="]/td[5]/div";
		 * 
		 * java.util.List<WebElement>
		 * elements=driver.findElements(By.className("sp-supplier-lists"));
		 * 
		 * int numberOfElements=elements.size(); System.out.println(numberOfElements);
		 * 
		 * Actions action = new Actions(driver);
		 * 
		 * for(int i=3;i<numberOfElements;i++){
		 * 
		 * 
		 * WebElement
		 * productprice=driver.findElement(By.xpath(beforexpath+i+afterxpath));
		 * action.moveToElement(productprice);
		 * 
		 * productprice.click();
		 * 
		 * 
		 * }
		 */			  
			  
			  
			  
		/*
		 * WebElement element = driver.findElement(By.xpath(
		 * "//*[@id=\"app\"]/div/div[1]/div/div[2]/div[3]/div/div[2]/div[4]/div/button")
		 * ); je.executeScript("arguments[0].scrollIntoView(true);",element);
		 * 
		 * WebElement
		 * elem=driver.findElement(By.xpath("//tr[12]//td[5]//div[1]//label[1]"));
		 * 
		 * elem.click();
		 * 
		 */Thread.sleep(5000);
	        
	       WebElement sup_nxt_btn=driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div[3]/div/div[2]/div[4]/div/button"));
	       sup_nxt_btn.click();
	        
		  }

		  @AfterTest
		  public void afterTest() {
			  
			  System.out.println("opened successfully");
		  }

	}	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
























