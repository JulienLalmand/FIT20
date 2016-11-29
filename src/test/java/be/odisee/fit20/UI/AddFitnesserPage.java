package be.odisee.fit20.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddFitnesserPage extends AbstractPage {

	public AddFitnesserPage(WebDriver driver) {
		super(driver);
	}
		
	public AddFitnesserPage enterTextInField(String fieldName, String enteredText) {
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.id(fieldName)));
		driver.findElement(By.id(fieldName)).sendKeys(enteredText);
		return this;
	}
		
	public FitnesserDetailPage submitForm(){	
		driver.findElement(By.name("submit")).click();
		return new FitnesserDetailPage(driver);
	}

}
