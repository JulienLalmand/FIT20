package be.odisee.fit20;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import be.odisee.fit20.UI.*;
import cucumber.api.PendingException;
import cucumber.api.java.nl.*;

public class uilogin2 {
	
	WebDriver driver;
	
	/**
	 * Page Objects
	 */
	HomePage homePage;
	AddTrainingSlotPage addTrainingSlotPage;
	TrainingSlotDetailPage trainingSlotDetailPage;
	
	String ingegevenDatum;
		

	@Gegeven("^een browser open is$")
	public void er_is_een_browser_open2() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "C:/Users/Julien/Desktop/geckodriver.exe");
	    driver = new FirefoxDriver();
	}

	@Als("^een trainer naar de hoofdpagina gaat$")
	public void een_trainer_op_de_hoofdpagina_gaat2() throws Throwable {
		homePage = new HomePage(driver);
		homePage.navigateToHomePage();
		assertTrue("De pagina werd niet gevonden", homePage.getStatusCode() != 404);
	}

	@Als("^zich aanmeld met gebruikersnaam trainer1 en wachtwoord trainer1")
	public void zich_aanmeld_met_gebruikersnaam_en_wachtwoord2() throws Throwable {
	    homePage.enterTextInField("username", "trainer1");
	    homePage.enterTextInField("password", "trainer1");
	    
	    addTrainingSlotPage = homePage.submitFormTrainer();
	}

	@Dan("^komt deze op zijn dashboard terecht$")
	public void komt_hij_op_zijn_dashboard_terecht2() throws Throwable {
	    assertTrue("Pagina niet herkend of gewijzigd", addTrainingSlotPage.getPageText().contains("TrainingSlot Overzicht"));
	}

	@Als("^de ingelogde trainer 24/11/2016 18:00 invuld$")
	public void de_ingelogde_trainer_invuld2() throws Throwable {
		System.out.println(addTrainingSlotPage.getPageText());
	    addTrainingSlotPage.enterTextInField("datum", "24/11/2016 18:00");
	    ingegevenDatum = "24/11/2016 18:00";
	}

	@Als("^hij op save drukt$")
	public void hij_drukt_op_save2() throws Throwable {
	    trainingSlotDetailPage = addTrainingSlotPage.submitForm();
	}

	@Dan("^krijgt hij een overzicht van de trainingslot met de correcte gegevens$")
	public void krijgt_hij_een_overzicht_van_de_trainingslot_met_de_juiste_gegevens2() throws Throwable {
	    assertTrue("De gegevens werden niet gevonden", trainingSlotDetailPage.getPageText().contains("24/11/2016 18:00") && trainingSlotDetailPage.getPageText().contains("Details van trainingslot"));
	}


}
