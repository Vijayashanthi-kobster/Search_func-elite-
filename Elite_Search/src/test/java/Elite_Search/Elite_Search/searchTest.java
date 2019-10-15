package Elite_Search.Elite_Search;

import java.awt.AWTException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class searchTest {

    @BeforeTest()
	public static void launch()
    {
		searchmethod.launching();
	}

	@Test(priority=0)
	public void login() throws InterruptedException
	{
		searchmethod.login();
	}

	@Test(priority=1)
	public void search() throws InterruptedException, AWTException
	{
		searchmethod.pagescroll();//for loading all the products
	
		//elite.regionselection();
		searchmethod.search_key();
		searchmethod.printallproducts(); 
		searchmethod.totalcount_product();	
		System.out.println("##################################################################");	
	}
	
	@Test(priority=2)
	public void catagory() throws InterruptedException, AWTException
	{
		  System.out.println("Case 2: Verify the catagory filter func");
		  searchmethod.catagory_selection(); 
		  searchmethod.pagescroll();//for loading all the products
		  searchmethod.catagoryresult();
		  searchmethod.totalcount_product();
		  searchmethod.refresh();
		  System.out.println("##################################################################");
		  	
	}
	
	
	  @Test(priority=3) 
	  public void Brand() throws InterruptedException,	  AWTException 

	  { 
		  System.out.println("Case 3: Verify the Brand filter func");
		  searchmethod.pagescroll();//for loading all the products
		  searchmethod.Brand_selection(); 
		  searchmethod.pagescroll();//for loading all   the products 
		  searchmethod.brandresult(); 
		  searchmethod.totalcount_product();
		  searchmethod.refresh();
		  System.out.println("##################################################################");
	 
	  
	  }
	  
	  @Test(priority=4)
	  public void pricefilter() throws InterruptedException, AWTException 

	  { 
		  System.out.println("Case 4: Verify the price filter func");
		  searchmethod.price_filter();
		  searchmethod.price_filter_result(); 
		  searchmethod.totalcount_product();
		  searchmethod.refresh();
		  System.out.println("##################################################################"); }
	  
	  
	  @Test(priority=5) 
	  public void sortfilter() throws InterruptedException,AWTException 

	  { 
		  System.out.println("Case 5: Verify the Sort filter func");
		  searchmethod.sort_low2high(); 
		  searchmethod.pagescroll();
		  searchmethod.low2high_result();
		  searchmethod.totalcount_product();//
		  //searchmethod.sorting_filter(); 
		  System.out.println("##################################################################");
		  searchmethod.refresh();
	  
	  }
	  
	  @Test(priority=6) public void ALLfiltercases() throws InterruptedException,AWTException
	   {
	  
	  
		  //Price ,Sort & Brand filters 
		  System.out.println("Case 6: Verify within the price amount of products only displayed ,if user apply brand filter");
	  
	   
		  searchmethod.price_filter();
		  searchmethod.Brand_selection();
		  searchmethod.sort_low2high(); 
		  searchmethod.price_filter_result(); 
		  searchmethod.low2high_result();

		  searchmethod.totalcount_product();
          searchmethod.refresh();
		  System.out.println("##################################################################");
	  
	  
	  }
	  
	  @Test(priority=7) 
	  public void Price_Brand() throws InterruptedException,
	  AWTException 
	  { 
		  System.out.println("Case 7: Verifying the results ,if user apply brand And price filter");
				  

	  
		  searchmethod.price_filter(); 
		  searchmethod.Brand_selection();
		  
		  searchmethod.price_filter_result();
		  searchmethod.brandresult(); 

		  
		  Thread.sleep(2000); 
		  searchmethod.totalcount_product(); 
          searchmethod.refresh();
		  System.out.println("##################################################################");
		  
	  
	  }
	  
	  @Test(priority=8)
	  public void Price_Sort() throws InterruptedException,AWTException
	  
	  { 
		  System.out.println("Case 8: Verifying the results ,if user apply price and Sort  filter");
		  
		  
		  searchmethod.price_filter(); 
		  searchmethod.sort_low2high();

		  searchmethod.price_filter_result();
		  searchmethod.low2high_result();		  
		  searchmethod.totalcount_product();
          searchmethod.refresh();
		  System.out.println("##################################################################");
	  
	  
	  }
	  
	  @Test(priority=9)
	  public void Brand_Price() throws InterruptedException,
	  AWTException 
	  { 
		  
		  System.out.println("Case 9: Verifying the results ,if user apply Brand and Price filter");
	  
	  
		  searchmethod.Brand_selection(); 
		  searchmethod.price_filter();
		  
		  searchmethod.price_filter_result();
		  searchmethod.brandresult();

		  
		  Thread.sleep(2000); 
		  searchmethod.totalcount_product(); 
          searchmethod.refresh();
		  System.out.println("##################################################################");
		  
	  
	  }
	  
	  @Test(priority=10) 
	  public void Brand_Sort() throws InterruptedException,
	  AWTException
	  
	  { 
		  
		  System.out.println("Case 10: Verifying the results ,if user apply Brand and Price filter");
	  
	  
		  searchmethod.Brand_selection(); 
		  searchmethod.sort_low2high();
		  searchmethod.pagescroll();

		  searchmethod.low2high_result();		  
		  searchmethod.brandresult(); 
		  searchmethod.totalcount_product();
          searchmethod.refresh();
		  
		  System.out.println("##################################################################"); }
		  
	  
	  @Test(priority=11) 
	  public void Sort_Brand() throws InterruptedException,
	  AWTException
	  { 
		  
		  System.out.println("Case 11: Verifying the results ,if user apply Brand and Price filter");
	  
	  
		  searchmethod.sort_low2high(); 
		  searchmethod.Brand_selection(); 
		  searchmethod.pagescroll();

		  searchmethod.brandresult();
		  searchmethod.low2high_result();
		  searchmethod.totalcount_product(); 
		  searchmethod.refresh(); 

		  System.out.println("##################################################################"); }
		  
	  
	  @Test(priority=12) 
	  public void Sort_Price() throws InterruptedException,AWTException
	   
	  { 
		  searchmethod.refresh(); 
		  
		  System.out.println("Case 12: Verifying the results ,if user apply Brand and Price filter");
	  
	  
		  searchmethod.sort_low2high(); 
		  searchmethod.price_filter(); 

		  searchmethod.price_filter_result();
		  searchmethod.low2high_result();
		  
		  searchmethod.totalcount_product(); 
		  System.out.println("##################################################################");
		  
	  
	  }
	  
	  
	 
}
