package be.odisee.fit20.UI;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AbstractPage {
	
	protected WebDriver driver;
	
	public AbstractPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage navigateToHomePage() {
		driver.navigate().to("http://127.0.0.1:8080");
		return new HomePage(driver);
	}
	
	public String getPageText(){
		return driver.findElement(By.tagName("body")).getText();
	}
	
	/**
	 * Selenium ondersteund geen status code.
	 */
	public int getStatusCode(){
		try {
		URL url = new URL(driver.getCurrentUrl());
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();

		return connection.getResponseCode();
		}
		catch (IOException ioe) {
			throw new RuntimeException(ioe);
		}
	}
	
	public String getCurrentUrl(){
		return driver.getCurrentUrl();
	}
	
	public void closeBrowser(){
		driver.quit();
	}
}
