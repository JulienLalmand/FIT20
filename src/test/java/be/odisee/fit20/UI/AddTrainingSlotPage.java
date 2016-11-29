package be.odisee.fit20.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddTrainingSlotPage extends AbstractPage {

	public AddTrainingSlotPage(WebDriver driver) {
		super(driver);
	}
		
	public AddTrainingSlotPage enterTextInField(String fieldName, String enteredText) {
		new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.id(fieldName)));
		driver.findElement(By.id(fieldName)).sendKeys(enteredText);
		return this;
	}
		
	public TrainingSlotDetailPage submitForm(){	
		driver.findElement(By.name("submit")).click();
		return new TrainingSlotDetailPage(driver);
	}
	
	public String getPageText() {
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.textToBePresentInElementLocated(By.tagName("body"), "TrainingSlot Overzicht")); 
		return(super.getPageText());
	}
}
