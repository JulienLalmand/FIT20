package be.odisee.fit20;

import static org.junit.Assert.*;

import java.security.SecureRandom;
import java.math.BigInteger;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import be.odisee.fit20.UI.*;
import cucumber.api.PendingException;
import cucumber.api.java.nl.*;


public class fakeLogin {
	
	HomePage homePage;
	WebDriver driver;
	SecureRandom random;
	
	@Gegeven("^een browser is open$")
	public void er_is_een_browser_open() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "C:/Users/Julien/Desktop/geckodriver.exe");
	    driver = new FirefoxDriver();
	}
	
	@Als("^deze persoon naar de loginpagina gaat$")
	public void deze_persoon_naar_de_loginpagina_gaat() throws Throwable {
	    homePage = new HomePage(driver);
	    homePage.navigateToHomePage();
	}
	
	@Als("^deze een onbestaande gebruikersnaam \"([^\"]*)\" en een onbestaande wachtwoord \"([^\"]*)\" invoert$")
	public void deze_een_onbestaande_gebruikersnaam_en_een_onbestaande_wachtwoord_invoert(String arg1, String arg2) throws Throwable {
		random = new SecureRandom();
	    homePage.enterTextInField("username", new BigInteger(130, random).toString(32));
	    homePage.enterTextInField("password", new BigInteger(130, random).toString(32));
	    homePage.clickLoginButton();
	}

	@Dan("^is deze persoon nog steeds op de loginpagina$")
	public void is_deze_persoon_nog_steeds_op_de_loginpagina() throws Throwable {
	    assertTrue("De pagina is niet de loginpagina", homePage.getCurrentUrl().equals("http://127.0.0.1:8080"));
	}

	@Dan("^kan hij zich steeds inloggen$")
	public void kan_hij_zich_steeds_inloggen() throws Throwable {
	    assertTrue("Kan niet inloggen", homePage.getPageText().contains("Log in"));
	}

	@Dan("^kan hij zich niet uitloggen$")
	public void kan_hij_zich_niet_uitloggen() throws Throwable {
	    assertTrue("Kan uitloggen", homePage.getPageText().contains("Log out"));
	}

}
