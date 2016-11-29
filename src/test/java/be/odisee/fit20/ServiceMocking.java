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

import static org.mockito.Mockito.*;

import fit20config.Fit20SbApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Fit20SbApplication.class)
@WebAppConfiguration
public class ServiceMocking {
	
	
	@Test
	public void testGeefFeedback(){
		
		Fit20ServiceImpl service = mock(Fit20ServiceImpl.class);
		Persoon trainer = mock(Persoon.class);
		List feedbackLijst = mock(List.class);
		feedbackLijst.add("Goed");
		feedbackLijst.add("Niet goed");
		
		when(service.geefAlleFeedbackVanTrainer(trainer)).thenReturn(feedbackLijst);


		System.out.println(service.geefAlleFeedbackVanTrainer(trainer));
		
		
	}



}
