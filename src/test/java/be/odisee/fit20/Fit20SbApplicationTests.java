package be.odisee.fit20;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import be.odisee.fit20.service.*;
import be.odisee.fit20.domain.*;

import fit20config.Fit20SbApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Fit20SbApplication.class)
@WebAppConfiguration
public class Fit20SbApplicationTests {

	

	@Test
	public void coverageTesten(){
		Fit20ServiceImpl fit20 = new Fit20ServiceImpl();
		assertEquals(200.00, fit20.berekenPrijs(15, "Brussel"),0.00);
		assertEquals(225.00, fit20.berekenPrijs(17, "Brussel"),0.00);
		assertEquals(150.00, fit20.berekenPrijs(15, "Aalst"),0.00);
		assertEquals(175.00, fit20.berekenPrijs(17, "Aalst"),0.00);
	}
	
	
	
	@Test
	public void beschikbaarheidInstellen() {
		Beschikbaarheid b;
		Fit20ServiceImpl fit20 = new Fit20ServiceImpl();
		b = fit20.voegBeschikbaarheidToe("12/10/20160", 27, 24);
	    assertThat(Arrays.asList(fit20.geefAlleBeschikbaarheden(27)), hasItems(b));
		
	}
	
	@Test 
	public void persoonToevoegen(){
		Fit20ServiceImpl fit20 = new Fit20ServiceImpl();
		
		Persoon P = fit20.voegPersoonToe("Jan", "Piet", "Jan-piet", "Jean@piet.be", "Trainer", "Actief", "test123");
		 assertThat(Arrays.asList(fit20.geefAllePersonen()), hasItems(P));
	}
	
	@Test
	public void verschillendeTrainingsslotReserveren(){
		Fit20ServiceImpl fit20 = new Fit20ServiceImpl();
		TrainingSlot t = new TrainingSlot("26/10/2016", 1);
		TrainingSlot t2 = new TrainingSlot("28/10/2016", 1);
		assertThat(fit20.geefAlleTrainingSlotsTrainer(1).contains(t));
		assertThat(fit20.geefAlleTrainingSlotsTrainer(1).contains(t2));
		
	}
	@Test
	public void heeftTrainingsslotEenLocatie(){
		Fit20ServiceImpl fit20 = new Fit20ServiceImpl();
		TrainingSlot t = new TrainingSlot("26/10/2016", 1);
		//assertThat(t.getLocatie == true );
		// Methode is niet aanwezig 
	}
	@Test
	public void heeftTrainerTrainingsslot(){
		Fit20ServiceImpl fit20 = new Fit20ServiceImpl();
		fit20.voegPersoonToe("Thibault", "Lesuisse", "TLesuisse", "Lesuisse.be", "Trainer", "Trainer", "123456");
		int id = fit20.getTrainerID("TLesuisse");
		fit20.voegTrainingSlotToe("12/10/2016", id);
		fit20.voegTrainingSlotToe("13/10/2016", id);
		assertThat(fit20.geefAlleTrainingSlotsTrainer(id).size() >= 2);
	}
	@Test
	public void nietInHetVerleden(){
		TrainingSlot t = new TrainingSlot("10/10/2014", 1);
		Fit20ServiceImpl fit20 = new Fit20ServiceImpl();
		fit20.voegTrainingSlotToe(t);
		assertThat(fit20.geefAlleTrainingSlotsTrainer(1).contains(t));
		
	}
	
	@Test
	public void stressTesten(){
		for (int i = 0; i < 1000000; i++) {
		
			Fit20ServiceImpl fit20 = new Fit20ServiceImpl();
			fit20.voegPersoonToe("Thibault", "Lesuisse", "TLesuisse", "Lesuisse.be", "Trainer", "Trainer", "123456");
		}
	}
	
	
}
