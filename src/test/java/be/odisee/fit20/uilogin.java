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

public class uilogin {
	
	WebDriver driver;
	
	/**
	 * Page Objects
	 */
	HomePage homePage;
	AddTrainingSlotPage addTrainingSlotPage;
	TrainingSlotDetailPage trainingSlotDetailPage;
	
	String ingegevenDatum;
		

	@Gegeven("^er is een browser open$")
	public void er_is_een_browser_open() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "C:/Users/Julien/Desktop/geckodriver.exe");
	    driver = new FirefoxDriver();
	}

	@Als("^een trainer op de hoofdpagina gaat$")
	public void een_trainer_op_de_hoofdpagina_gaat() throws Throwable {
		homePage = new HomePage(driver);
		homePage.navigateToHomePage();
		assertTrue("De pagina werd niet gevonden", homePage.getStatusCode() != 404);
	}

	@Als("^zich aanmeld met gebruikersnaam \"([^\"]*)\" en wachtwoord \"([^\"]*)\"$")
	public void zich_aanmeld_met_gebruikersnaam_en_wachtwoord(String arg1, String arg2) throws Throwable {
	    homePage.enterTextInField("username", arg1);
	    homePage.enterTextInField("password", arg2);
	    
	    addTrainingSlotPage = homePage.submitFormTrainer();
	}

	@Dan("^komt hij op zijn dashboard terecht$")
	public void komt_hij_op_zijn_dashboard_terecht() throws Throwable {
	    assertTrue("Pagina niet herkend of gewijzigd", addTrainingSlotPage.getPageText().contains("TrainingSlot Overzicht"));
	}

	@Als("^de ingelogde trainer \"([^\"]*)\" invuld$")
	public void de_ingelogde_trainer_invuld(String arg1) throws Throwable {
		System.out.println(addTrainingSlotPage.getPageText());
	    addTrainingSlotPage.enterTextInField("datum", arg1);
	    ingegevenDatum = arg1;
	}

	@Als("^hij drukt op save$")
	public void hij_drukt_op_save() throws Throwable {
	    trainingSlotDetailPage = addTrainingSlotPage.submitForm();
	}

	@Dan("^krijgt hij een overzicht van de trainingslot met de juiste gegevens$")
	public void krijgt_hij_een_overzicht_van_de_trainingslot_met_de_juiste_gegevens() throws Throwable {
	    assertTrue("De gegevens werden niet gevonden", trainingSlotDetailPage.getPageText().contains(ingegevenDatum) && trainingSlotDetailPage.getPageText().contains("Details van trainingslot"));
	}


}
