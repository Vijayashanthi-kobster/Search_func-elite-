package com.searchtest;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterTest;
public class Searchinputs {
	
    public  WebDriver driver; 

	//WebDriver driver;
	WebDriverWait wait;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;

	 
	@Test
	 public void ReadData() throws IOException, InterruptedException, Exception
	 {

         File src=new File("G:\\TestData.xlsx");

    	 FileInputStream finput = new FileInputStream(src);
	 	 
	 	 // Load the workbook.
	 	workbook = new XSSFWorkbook(finput);

	     // Load the sheet in which data is stored.
	 	 sheet= workbook.getSheetAt(0);
	 	 int a=sheet.getLastRowNum();
	     //System.out.println(a);
	     
	 	 for(int i=0; i<=a; i++)
	 	 {
				
	 		cell = sheet.getRow(i).getCell(0);
	 		
	 		cell.setCellType(Cell.CELL_TYPE_STRING);
	 		Thread.sleep(1000);
   	     
	 		System.out.println("Searching product name is :" +cell.getStringCellValue());
	 		
	        driver.findElement(By.xpath("//*[@id=\"sticky\"]/div[3]/div[4]/div/input")).sendKeys(cell.getStringCellValue());
			
	        driver.findElement(By.xpath("//*[@id=\"sticky\"]/div[3]/div[4]/div/div")).click();
	               Thread.sleep(2000);
           
	               
	               JavascriptExecutor jse = (JavascriptExecutor)driver;
            for (int second = 0;; second++)
            {
               if(second >=60)
               {
                   break;
               }
    		  jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    		  Thread.sleep(1000);
           }
           
        List<WebElement> name = driver.findElements(By.className("sp-name"));
       	 for (WebElement result:name) 
       	 {
             System.out.println(result.getText());
             System.out.println(result.getText().indexOf(cell.getStringCellValue())!=-1? true: false);
        

       	 }

          
           
			/*
			 * boolean keyword = driver.getPageSource().contains(cell.getStringCellValue());
			 * if (keyword == true) {
			 * System.out.println("System displaying only relevant data"); } else {
			 * System.out.println("System displaying IRRELEVANT data "); }
			 * 
		
			 */ 
	     System.out.println("*************************************************************");
       	 List<WebElement> list = driver.findElements(By.className("sp-product-container"));
    	     int itemsCount = list.size();
    	     System.out.println("Number of products present in a page :" +itemsCount);
    	     
    	     System.out.println("*************************************************************");
    
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"sticky\"]/div[3]/div[4]/div/input")).clear();

	 	 
	      
	      
	      
	 	 
	 	 
	 	 }		  
  
        
	 }

	@BeforeTest
  public void beforeTest() throws InterruptedException {
		
			// Set the path of the Chromedriver 
				System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
				 driver = new ChromeDriver();
				Thread.sleep(3000);
				driver.manage().window().maximize();
			
			// Enter url.
			driver.get("https://www.kobster.website/dash-login.php");
			driver.manage().window().maximize();
			
			 driver.findElement(By.id("login_email")).sendKeys("vijayashanthi38@gmail.com");	
			 driver.findElement(By.id("login_passwd")).sendKeys("kobster123");
			 driver.findElement(By.id("SubmitDashLogin")).click();
  }
 
}
	



/*
	 * @AfterTest public void afterTest() { }
	 * 
	 */
