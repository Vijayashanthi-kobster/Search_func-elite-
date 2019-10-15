package com.website;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Search_execution {

     WebDriver driver;
	     
@BeforeTest
public void login() throws Exception 
{
	
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
		driver.get("https://www.kobster.website/dash-login.php");
}
@Test(priority=0)
public void Searchcases() throws Exception 
{

		Search_test elite = new Search_test(driver);

		// Verify login functionality
		elite.login("vijayashanthi38@gmail.com", "kobster123");
		elite.pagescroll();//for loading all the products
		
		//elite.regionselection();

	
		//Category filter case:
		
		  System.out.println("Case 1: Verify the catagory filter func");
		  elite.catagory_selection(); 
		  elite.pagescroll();//for loading all the products
		  elite.catagoryresult();
		  elite.totalcount_product();
		  driver.navigate().refresh(); 
		  System.out.println("##################################################################");
		  
		  
		  
		  //Brand filter case:
		  System.out.println("Case 2: Verify the Brand filter func");
		  elite.pagescroll();//for loading all the products 
		  elite.Brand_selection();
		  elite.pagescroll();//for loading all the products 
		  elite.brandresult();
		  elite.totalcount_product(); 
		  driver.navigate().refresh(); 
		  System.out.println("##################################################################");
		  
		  
		  //price filter cases::
		  System.out.println("Case 3: Verify the price filter func");
		  driver.navigate().refresh(); 
		  elite.price_filter();
		  elite.price_filter_result(); 
		  elite.totalcount_product(); 
		  System.out.println("##################################################################");
		  
		  //Sort filter case ::
		  System.out.println("Case 4: Verify the Sort filter func");
		  elite.sort_low2high();
		  elite.low2high_result();
		  elite.totalcount_product();// 
		  
		  //elite.sorting_filter(); 
		  System.out.println("##################################################################");
		 
		
		  //Search results case:
		  
		  elite.pagescroll();//for loading all the products 
		  elite.search_key();
		  elite.printallproducts(); 
		  elite.totalcount_product(); //check total count of
		  //product matches with count present in page
		 
		 
	}       		
		 
	
	
	  @Test(priority=1) 
	  public void ALLfiltercases() throws 	  InterruptedException,AWTException 

	  { 
		  Search_test elite = new Search_test(driver);
	  
	  //driver.navigate().refresh();
	  
	  //Price ,Sort & Brand filters 
		 System.out.println("Case 5: Verify within the price amount of products only displayed ,if user apply brand filter");
		 elite.price_filter(); 
		 elite.Brand_selection(); 
		  elite.sort_low2high();
		  elite.low2high_result();
	     elite.price_filter_result(); 
	     elite.totalcount_product();
	     System.out.println("##################################################################");
	  
	  
	  }
	  
	  @Test(priority=2) 
	  public void Price_Brand() throws InterruptedException,AWTException

	  
	  { 
	  Search_test elite = new Search_test(driver); 
	  driver.navigate().refresh();
	  System.out.println("Case 6: Verifying the results ,if user apply brand And price filter");
	  
	  elite.price_filter(); 
	  elite.Brand_selection();
	  
	  elite.brandresult(); 
	  elite.price_filter_result();
	  
	  Thread.sleep(2000); 
	  elite.totalcount_product(); 
	  Thread.sleep(2000);
	  System.out.println("##################################################################");
	  
	  
	  }
	  
	  @Test(priority=4) 
	  public void Price_Sort() throws InterruptedException,AWTException
	  {
	  
	  Search_test elite = new Search_test(driver); 
	  driver.navigate().refresh();
	  System.out.println("Case 6: Verifying the results ,if user apply price and Sort  filter");
	  
	  elite.price_filter(); 
	  elite.sort_low2high();
	  elite.low2high_result();
	  
	  elite.price_filter_result(); 
	  elite.totalcount_product(); 
	  Thread.sleep(2000);
	  System.out.println("##################################################################");
	  
	  
	  }
	  
	  @Test(priority=5) 
	  public void Brand_Price() throws InterruptedException, AWTException

	  
	  { 
		  Search_test elite = new Search_test(driver); 
		  driver.navigate().refresh();
	  System.out.println("Case 7: Verifying the results ,if user apply Brand and Price filter");
	  
	  elite.Brand_selection(); 
	  elite.price_filter();
	  
	  elite.brandresult(); 
	  elite.price_filter_result();
	  
	  Thread.sleep(2000); 
	  elite.totalcount_product(); 
	  Thread.sleep(2000);
	  System.out.println("##################################################################");
	  
	  
	  }
	  
	  @Test(priority=6) 
	  public void Brand_Sort() throws InterruptedException,AWTException

	  
	  { 
		  Search_test elite = new Search_test(driver); 
		  driver.navigate().refresh();
	  System.out.println("Case 8: Verifying the results ,if user apply Brand and Price filter");
	  
	  elite.Brand_selection(); 
	  elite.sort_low2high();
	  elite.low2high_result();
	  
	  elite.brandresult(); 
	  elite.totalcount_product();
	  
	  System.out.println("##################################################################");
	  
	  }
	  
	  @Test(priority=7) 
	  public void Sort_Brand() throws InterruptedException, AWTException

	  
	  { 
		  Search_test elite = new Search_test(driver); 
		  driver.navigate().refresh();
	      System.out.println("Case 9: Verifying the results ,if user apply Brand and Price filter");
	  
		  elite.sort_low2high();
		  elite.low2high_result();
		  elite.Brand_selection();
	      elite.brandresult();
	      elite.totalcount_product(); 
	  System.out.println("##################################################################"); 
	  }
	  
	  @Test(priority=8) 
	  public void Sort_Price() throws InterruptedException,AWTException

	  
	  { 
		  Search_test elite = new Search_test(driver); 
		  driver.navigate().refresh();
	  System.out.println("Case 10: Verifying the results ,if user apply Brand and Price filter");
	  
	  elite.sort_low2high();
	  elite.low2high_result();
	  
	  elite.price_filter(); 
	  elite.price_filter_result();
	  
	  elite.totalcount_product(); 
	  System.out.println("##################################################################"); }
	 	  
	
}

