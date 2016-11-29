package be.odisee.fit20.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public AddFitnesserPage linkToAddFitnesserPage(String linkText) {
		driver.findElement(By.linkText(linkText)).click();
		return new AddFitnesserPage(driver);
	}
	
	public HomePage enterTextInField(String fieldName, String enteredText) {
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.id(fieldName)));
		driver.findElement(By.id(fieldName)).sendKeys(enteredText);
		return this;
	}
	
	public AddTrainingSlotPage submitFormTrainer(){
		driver.findElement(By.id("submit")).click();
		return new AddTrainingSlotPage(driver);
	}
	
	public String getPageText() {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.textToBePresentInElementLocated(By.tagName("body"), "Inloggen als Trainer")); 
		return(super.getPageText());
	}
	
	public void clickLoginButton() {
		driver.findElement(By.id("submit")).click();
	}
}

