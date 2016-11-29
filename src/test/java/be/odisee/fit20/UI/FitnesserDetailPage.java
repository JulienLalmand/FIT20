package be.odisee.fit20.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FitnesserDetailPage extends AbstractPage {

	public FitnesserDetailPage(WebDriver driver) {
		super(driver);
	}

	public HomePage linkTohomePage(String linkText) {
		driver.findElement(By.linkText(linkText)).click();
		return new HomePage(driver);
	}
	
	public String getPageText() {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.textToBePresentInElementLocated(By.tagName("body"), "Details of person")); 
		return(super.getPageText());
	}
	
}
