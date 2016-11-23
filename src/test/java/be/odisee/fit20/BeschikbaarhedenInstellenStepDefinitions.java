package be.odisee.fit20;
import cucumber.api.java.nl.Gegeven;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.validation.constraints.AssertTrue;

import be.odisee.fit20.domain.*;
import be.odisee.fit20.service.*;
import cucumber.api.PendingException;

public class BeschikbaarhedenInstellenStepDefinitions {
	
	Fit20ServiceImpl fit20service;
	Persoon p;
	Persoon p2;
	Beschikbaarheid b1;
	Beschikbaarheid b2;
	@Als("^een Trainer wordt toegevoegd met naam \"([^\"]*)\", voornaam \"([^\"]*)\", accountnaam \"([^\"]*)\", email 'hans@vdb\\.com', rol \"([^\"]*)\", wachtwoord \"([^\"]*)\", status \"([^\"]*)\" ;$")
	public void een_Trainer_wordt_toegevoegd_met_naam_voornaam_accountnaam_email_hans_vdb_com_rol_wachtwoord_status(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   p = fit20service.voegPersoonToe(arg1, arg2, arg3, arg4, arg5, arg6, arg6);
	   assertNotNull(p);
	}

	@Dan("^komt \"([^\"]*)\" voor in de lijst van trainers$")
	public void komt_voor_in_de_lijst_van_trainers(String arg1) throws Throwable {
	    assertTrue(fit20service.geefAllePersonen().contains(p)); 
	}

	@Dan("^kan \"([^\"]*)\" inloggen met het wachtwoord \"([^\"]*)\"$")
	public void kan_inloggen_met_het_wachtwoord(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(fit20service.geefAllePersonen().contains(p)); 
	}


	@Dan("^\"([^\"]*)\" komt voor in de lijst van de personen opgeslaan in de database$")
	public void komt_voor_in_de_lijst_van_de_personen_opgeslaan_in_de_database(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(fit20service.geefAllePersonen().contains(p)); 
	}

	@Als("^\"([^\"]*)\" een beschikbaarheid toevoegd op \"([^\"]*)\"$")
	public void een_beschikbaarheid_toevoegd_op(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   Beschikbaarheid b1 = new Beschikbaarheid(arg2, p.getId(), 1);
	   assertNotNull(b1);
	}

	@Als("^nog een beschikbaarheid toevoegd op \"([^\"]*)\"$")
	public void nog_een_beschikbaarheid_toevoegd_op(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		   Beschikbaarheid b2 = new Beschikbaarheid(arg1, p.getId(), 1);
		   assertNotNull(b2);
	}

	@Dan("^komt de beschikbaarheid \"([^\"]*)\" en \"([^\"]*)\" voor in de lijst die wordt opgevraagd$")
	public void komt_de_beschikbaarheid_en_voor_in_de_lijst_die_wordt_opgevraagd(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(fit20service.geefAlleBeschikbaarheden(p.getId()).contains(b1));
		assertTrue(fit20service.geefAlleBeschikbaarheden(p.getId()).contains(b2));
	}

	@Als("^een Fitnesser wordt toegevoegd met naam \"([^\"]*)\", voornaam \"([^\"]*)\", accountnaam \"([^\"]*)\", email 'jan@db\\.com', rol \"([^\"]*)\", wachtwoord \"([^\"]*)\", status \"([^\"]*)\" ;$")
	public void een_Fitnesser_wordt_toegevoegd_met_naam_voornaam_accountnaam_email_jan_db_com_rol_wachtwoord_status(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    p2 = new Persoon(arg1, arg2, arg3, arg4, arg5, arg6, arg6);
	}

	@Dan("^komt \"([^\"]*)\" voor in de lijst van fitnessers$")
	public void komt_voor_in_de_lijst_van_fitnessers(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(fit20service.geefAllePersonen().contains(p2)); 
	}

	@Als("^\"([^\"]*)\" het trainingsslot \"([^\"]*)\" selecteert$")
	public void het_trainingsslot_selecteert(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Dan("^wordt een trainingsslot in naam van \"([^\"]*)\" aangemaakt met \"([^\"]*)\" als trainer, met programma \"([^\"]*)\", Status \"([^\"]*)\", op  \"([^\"]*)\", met klanttevredenheid \"([^\"]*)\"$")
	public void wordt_een_trainingsslot_in_naam_van_aangemaakt_met_als_trainer_met_programma_Status_op_met_klanttevredenheid(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
}
