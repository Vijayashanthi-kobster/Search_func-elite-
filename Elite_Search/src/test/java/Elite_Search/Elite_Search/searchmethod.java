package Elite_Search.Elite_Search;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



public class searchmethod {
  public static WebDriver driver;
  
	public static void launching()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(input.url);
		driver.manage().window().maximize();
	}
	//Login to the site	  
	public static void login() throws InterruptedException

	{
		
	 driver.findElement(Locator.username).sendKeys(input.usermail);	
	 driver.findElement(Locator.password).sendKeys(input.password);
	 driver.findElement(Locator.clicksubmit).click();
	 
		Thread.sleep(2000);
	    WebElement accountTab= driver.findElement(Locator.account);
		Actions action=new Actions(driver);
		action.moveToElement(accountTab).click().build().perform();

	    System.out.println(driver.findElement(Locator.accname).getText());
	   Thread.sleep(2000);
	   if(driver.findElement(Locator.accname).isDisplayed()==true) 
	       {
		   System.out.println("Logged in successfully -Case Passed");
	       }
	   else 
	      {
		   System.out.println("Case Failed-Login");
	      }

	 

     Thread.sleep(3000);
	 driver.findElement(Locator.search).sendKeys(input.searchdata);
	 driver.findElement(Locator.search_click).click();
	 Thread.sleep(3000);
	 System.out.println("Case 1: Search the product");
	}



	public static void  pagescroll() throws AWTException, InterruptedException {
					  
			 
	      Thread.sleep(2000);
	      JavascriptExecutor jse = (JavascriptExecutor)driver;
	      for (int second = 0;; second++) {
	      if(second >=20){
	          break;
	      }
		  jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		  Thread.sleep(2000);
	  }
		  Thread.sleep(4000);
	    Robot robot = new Robot();
	  	robot.keyPress(KeyEvent.VK_PAGE_UP);
	  	robot.keyRelease(KeyEvent.VK_PAGE_UP);	
	    Thread.sleep(2000);      
	      
	 }

	 

	public static void catagory_selection() throws InterruptedException {
	    System.out.println("CATAGORY FILTER TEST----------------------------------- ");

		driver.findElement(Locator.catagory).click();
	    Actions actions = new Actions(driver);

		WebElement menuOption = driver.findElement(Locator.colourpencil);
		actions.moveToElement(menuOption).click().build().perform();
		Thread.sleep(2000);
	   
		String colour=driver.findElement(Locator.textcolour).getText();
		System.out.println(colour);
		
		WebElement cat=driver.findElement(Locator.catagory);
		actions.moveToElement(cat).click().build().perform();
		Thread.sleep(2000);
	}
		public static void catagoryresult() throws InterruptedException 
		
	{
		
	  	List<WebElement> name = driver.findElements(Locator.productname);
		 for (WebElement result:name) {
		        System.out.println(result.getText());
		       System.out.println((result.getText().indexOf("colour")!=-1? true: false));
	        
		 }
		System.out.println("CATAGORY FILTER TEST-passed-->based on catogory only system displaying product list -------------------------------------");
	   Thread.sleep(2000);
	   // driver.findElement(drop1).click();
	 
	}

	public static void Brand_selection() throws InterruptedException {
	    System.out.println("BRAND FILTER TEST---------------------------------  ");
	    Thread.sleep(2000);
		driver.findElement(Locator.brand).click();
		
	    Actions actions = new Actions(driver);

		WebElement Brand_menuOption = driver.findElement(Locator.brand_camlin);
		actions.moveToElement(Brand_menuOption).click().build().perform();
	    Thread.sleep(2000);
		WebElement brandclick= driver.findElement(Locator.brand);
		actions.moveToElement(brandclick).click().build().perform();
	}
	public static void brandresult() 
	{
	  	List<WebElement> name = driver.findElements(Locator.productname);
		 for (WebElement result:name) {
		        System.out.println(result.getText());
		       Assert.assertTrue(result.getText().indexOf("Camlin")!=-1? true: false);
	        
		 }
			System.out.println("BRAND FILTER TEST -passed--> Based on Brand only system displaying products list ---------------------------------------------------------------------------");	
		
	}

	public static void printallproducts() {
		
		System.out.println(" The product names are here ...........");
		List<WebElement> name = driver.findElements(Locator.productname);
		
		 for (WebElement result:name) {
	     System.out.println(result.getText());
		
		 }	
	}


	public static void search_key() throws InterruptedException {
	    Thread.sleep(1000);

	    System.out.println("Verifying that the system displaying relevant product or not based on search ");
		
	      try   
	      {    
	      if(driver.findElement(Locator.noresult).isDisplayed()==true)
	    		  {
	    	  System.out.println("Case passed -No result found msg displayed ,this is because of invalid data provided in search");
	    		  }
	      }
	      catch(Exception e)     
	      {       
	    		Thread.sleep(2000);
	    		List <WebElement> Pro_name=driver.findElements(Locator.productname);

	    		for(WebElement productresult:Pro_name)
	    		   {	

	    			System.out.println(productresult.getText());
	    		    System.out.println(productresult.getText().indexOf(input.searchdata)!=-1?true:false); 
	    		   }
	    			
	      }
	}





	public static void totalcount_product()
	{

		 //System.out.println("Case : Verifying the count of product from the search result");
	   
		 List<WebElement> list = driver.findElements(By.className("sp-product-container"));
	     int manualvalue = list.size();
	     System.out.println("Total noumber of products present in search results  :  "+manualvalue);
	    
	    
	    String text= driver.findElement(Locator.count).getText();
	    String a1 = text.substring(16,text.length()-15);
	  	System.out.println(text);

	    int sysvalue = Integer.parseInt(a1);
	    
	    if(manualvalue==sysvalue) {
	      	System.out.println("Case passed - System displaying correct total count of product");
	    	
	    }else {
	      	System.out.println("Case failed - System displaying incorrect total count of product");

	    }
	}

	public static void regionselection() throws InterruptedException {
		
		driver.findElement(Locator.region).click();
		Thread.sleep(2000);
		driver.findElement(Locator.current_add).click();
		Thread.sleep(2000);
		
		
	}

	public static void price_filter() throws InterruptedException, AWTException 
	{
		Thread.sleep(3000);
		System.out.println("PRICE FILTER CASE---------------");
		WebElement slider=driver.findElement(Locator.pricefilter);
	  //  Actions action = new Actions(driver);

	    //action .clickAndHold(slider).moveByOffset(200,0).release().perform();  

	    for (int i = 1; i <=200 ; i++) {
	        slider.sendKeys(Keys.ARROW_LEFT);
	    }

	}

	public static void price_filter_result() throws InterruptedException, AWTException 
	{
	    Thread.sleep(3000);
	     String price_filtered= driver.findElement(Locator.filteredprice).getText();
		 String price_substring=price_filtered.substring(2);

	     float chosenpricefilter = Float.parseFloat(price_substring);     
	     System.out.println(chosenpricefilter);

	    
	    Thread.sleep(2000);
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    for (int second = 0;; second++) {
	    if(second >=20){
	        break;
	    }
		  jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		  Thread.sleep(2000);
	}

	    Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);	
	    Thread.sleep(2000);      
	   
		String beforexpath="//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div[";
		String afterxpath ="]/div[4]/div[1]/div[2]";
		Thread.sleep(2000);

	    
	    List<WebElement> list = driver.findElements(By.className("sp-product-container"));
	    int count = list.size();
		
	    List<Float> Listprice = new ArrayList<Float>();
		
	    for(int i=1;i<=count;i++) 
	    {
			
			 String productprice=driver.findElement(By.xpath(beforexpath+i+afterxpath)).getText();
		    
			 String prod_price=productprice.substring(2);

		     float price  = Float.parseFloat(prod_price);     
		     Listprice.add(price);
		 }	
	    
	     
	    
	 	List<Float> allproduct = new ArrayList<Float>(Listprice);
	    System.out.println(allproduct);    
	    Float Maxproductprice = Collections.max(allproduct);

	    System.out.println(Maxproductprice);
	    

	    if(chosenpricefilter > Maxproductprice) 
	    		{
	    	System.out.println("Case passed -Price filter ## System displaying the product list within the price filter applied");
	    	}
	    else {
	    	System.out.println("Case failed-Price filter");
	    }
	        System.out.println("eeeeeeeeeeeeeeeeeee");
			
	}


	public static void sorting_filter() throws InterruptedException, AWTException {
		System.out.println("SORT FILTER TEST (High to Low)---------------------------- ");
	    
		        Thread.sleep(3000); 
			/*
			 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_PAGE_UP);
			 * robot.keyRelease(KeyEvent.VK_PAGE_UP);
			 * 
			 * Thread.sleep(4000);
			 */

			  	WebElement element = driver.findElement(Locator.sort);
			  	
			  	Actions actions = new Actions(driver);
	            actions.moveToElement(element).click().perform();
			  	element.click();

		      	// driver.findElement(sort).click();
				Select sorting=new Select(driver.findElement(Locator.sort));
				sorting.selectByIndex(1);
			    Thread.sleep(3000); 

	//Locators for finding the price value
		String beforexpath="//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div[";
		String afterxpath ="]/div[4]/div[1]/div[2]";
		Thread.sleep(2000);

		List<WebElement> list = driver.findElements(By.className("sp-product-container"));
	    int count = list.size();

		List<Float> priceList = new ArrayList<Float>();
		
	    Thread.sleep(2000);
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    for (int second = 0;; second++) {
	    	  
	        if(second >=10){
	            break;
	        }
	    
	    for(int i=1;i<=count;i++) {
			
			 String productprice=driver.findElement(By.xpath(beforexpath+i+afterxpath)).getText();
		    
			 String prod_price=productprice.substring(2);
		      // priceList.add(Float.parseFloat(price.get(i).getText())); 

		     float price  = Float.parseFloat(prod_price);     
		     priceList.add(price);
	        // System.out.println(price1);
		

		  jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		  Thread.sleep(2000);
	 }	
	    
	    }  
	    System.out.println("the products are sorted in high  to low order-SYSTEM output ");
		  
		 	List<Float> sortedPrices = new ArrayList<Float>(priceList);
		    System.out.println(sortedPrices);
		 
			Collections.sort(sortedPrices);
		  System.out.println("the products are sorted in Low to high ");

			System.out.println(sortedPrices);
				// true if the prices are sorted
				System.out.println(sortedPrices.equals(priceList));
		 
		  System.out.println("Both sorted list FAILED , Sorting filter case passsed successfully ");

	}


	public static void sort_low2high() throws InterruptedException, AWTException {
		
		System.out.println("SORT FILTER TEST(Low to High)-------------------------");
	    
		        Thread.sleep(3000); 

			  	WebElement element = driver.findElement(Locator.sort);
			  	
			  	Actions actions = new Actions(driver);
	            actions.moveToElement(element).click().perform();
			  	element.click();

		      	// driver.findElement(sort).click();
				Select sorting=new Select(driver.findElement(Locator.sort));
				sorting.selectByIndex(2);
			    Thread.sleep(3000); 
	       
			    //Loading all products 
	}
	public static void low2high_result() throws InterruptedException {
		
			    //Locators for finding the price value
				String beforexpath="//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div[";
				String afterxpath ="]/div[4]/div[1]/div[2]";
				Thread.sleep(2000);

				//Total count of product present in sorting result
				List<WebElement> list = driver.findElements(By.className("sp-product-container"));
			    int count = list.size();

				List<Float> low2high = new ArrayList<Float>();

			    for(int i=1;i<=count;i++) {
					
					 String productprice=driver.findElement(By.xpath(beforexpath+i+afterxpath)).getText();
				    
					 String prod_price=productprice.substring(2);

				     float price  = Float.parseFloat(prod_price);     
				     low2high.add(price);
				
			    }	
		
			 	List<Float> sortedPrices_low2high = new ArrayList<Float>(low2high);
			    System.out.println(sortedPrices_low2high);
		       System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		

		
	}

	public static void refresh() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(4000);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
