package Elite_Search.Elite_Search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Locator {
	public static WebDriver driver;
	//Login locators
  		public static By username=By.id("login_email");
  		public static By password=By.id("login_passwd");
		public static By clicksubmit=By.id("SubmitDashLogin");
		public static By productname=By.className("sp-name");
	    public static By account=By.xpath("//*[@id=\"sticky\"]/div[3]/div[7]/a");
	    public static By accname=By.xpath("//*[@id=\"sticky\"]/div[3]/div[7]/div/div/div/p[1]");
	    
		
	//search locator
		public static By search=By.xpath("//*[@id=\"sticky\"]/div[3]/div[4]/div/input");
		public static By search_click=By.xpath("//*[@id=\"sticky\"]/div[3]/div[4]/div/div");
        public static By noresult=By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[2]/div/div/div/div/h2");
		
	//Sort filter 
		public static By sort=By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[1]/div/div[2]/div[6]/select");
		public static By price_text=By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div[1]/div[4]/div[1]/div[2]"); 
	//count of product     
    
		public static By count=By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[1]/div/div[1]/p");  
	//Location selection
		public static By region=By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[1]/div/div[2]/div[2]/p");
		public static By current_add=By.xpath("//*[@id=\"spLocaationContent\"]/div/div[2]");  
		public static By add_text=By.xpath("//*[@id=\"spLocaationContent\"]/div/div[1]/input");
    
		public static By select_add=By.xpath("//*[@id=\"spLocaationContent\"]/div/div[2]");
	//catagory selection
	  
		public static By catagory=By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[1]/div/div[2]/div[3]/div/button/span[1]");
       
		public static By drop1=By.xpath("//*[@id=\"react-select-2-option-0\"]");
		public static By drop2=By.xpath("//*[@id=\"react-select-2-option-3\"]");
		public static By catsearch=By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[1]/div/div[2]/div[3]/div/div[1]/div/div[1]/div[1]/div[1]");	  
		public static By drop2_result=By.xpath("//*[@id=\"react-select-3-option-0\"]");
        public static By colourpencil=By.id("react-select-2-option-7");
		public static By textcolour=By.xpath("//*[@id=\"react-select-2-option-0\"]");

	//Brand selection
		public static By brand=By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[1]/div/div[2]/div[4]/div/button");
		public static  By brand_camlin=By.xpath("//*[@id=\"react-select-2-option-1\"]");
		public static By brand_deselect=By.xpath("//*[@id=\"react-select-5-option-0\"]");
	  
	//price filter
		public static  By pricefilter=By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[1]/div/div[2]/div[5]/div/div/div/span/a");
		public static By filteredprice=By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div[1]/div/div[2]/div[5]/div/div/div/span/span/span");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
