package be.odisee.fit20.UI;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebCrawl {
	
	/**
	 * Grab job titles from VDAB from ICT sector
	 * URL : https://www.vdab.be/jobs/vacatures?p=1&sinds=9000&jobdomein=JOBCAT10
	 */
	
	public static void main(String[] args) {
		
		/**
		 * URL for ICT sector
		 */
		final java.lang.String url = "https://www.vdab.be/jobs/vacatures?p=1&sinds=9000&jobdomein=JOBCAT10";
		
		/**
		 * Create our file for output.
		 */
		Date date = new Date();
		File file = new File("vdabcrawl_ict_" + date + ".txt");
		PrintWriter pw = null;
		
		try
		{
			FileWriter fw = new FileWriter(file, true);
			pw = new PrintWriter(fw);			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
		/**
		 * Initialize driver.
		 */
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Julien\\Desktop\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.navigate().to(url);
		
		/**
		 * Initialize wait driver for AJAX calls.
		 */
		WebDriverWait wait = new WebDriverWait(driver, 4);
		     		     
		/**
		 * Get elements for the first 3 pages.
		 */
		for(int i = 0; i <= 3; i++)
		{
			/**
			 * Start by retrieving the list of the first page.
			 */
			 List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("media-title")));
			 
			 /**
			  * Display what we retrieved.
			  */
			 for(WebElement el : elements)
			 {
				 System.out.println(el.getText());
			 }
			 
			 driver.findElement(By.linkText("Volgende")).click();
		}
				
		 /**
		  * Finally, close our connection with the driver and with our local file.
		  */
		 driver.close();
		 pw.close();		
		
	}

}
