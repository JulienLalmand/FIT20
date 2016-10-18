
package be.odisee.fit20.controller;

import be.odisee.fit20.domain.Beschikbaarheid;
import be.odisee.fit20.domain.Persoon;
import be.odisee.fit20.domain.TrainingSlot;
import be.odisee.fit20.service.Fit20Service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/")
public class FitnesserController {

    @Autowired
    protected Fit20Service fit20Service; // dependency injection
    
    //detail pagina van de fitnesser
    @RequestMapping(value={"/fitnesser.html"},method=RequestMethod.GET)
    public String persoonDetail(@RequestParam("id") Integer id, ModelMap model){
        Persoon persoon = fit20Service.zoekPersoonMetId(id);
        model.addAttribute("persoon", persoon);
        return "/fitnesser";
    }

    
    @RequestMapping(value={"/nieuweFitnesser.html"},method=RequestMethod.GET)
    public String persoonFormulier(ModelMap model){
        Persoon persoon = new Persoon();
        model.addAttribute("depersoon", persoon);
        return "/nieuweFitnesser";
    }


    //voegt nieuwe fitnesser toe, en verwijst door naar detail pagine van toegevoegde fitnesser
    @RequestMapping(value={"/nieuweFitnesser.html"},method=RequestMethod.POST)
    public String persoonToevoegen(@ModelAttribute("depersoon") Persoon persoon, ModelMap model){
        Persoon toegevoegdPersoon = fit20Service.voegPersoonToe(persoon.getVoornaam(),
                                                                            persoon.getNaam(),
                                                                            persoon.getaccountnaam(),
                                                                            persoon.getEmail(),
                                                                            persoon.getRol(),
                                                                            persoon.getStatus(),
                                                                            persoon.getWachtwoord());
        return "redirect:fitnesser.html?id="+toegevoegdPersoon.getId();
    }
    
    //locale variabele die de huidige ingelogde fitnesser bijhoudt
    public String huidigeUser; 
    public int huidigeUserID;
    
    //toon het  fitnesser-home scherm
    @RequestMapping(value={"/fitnesserHome.html"},method=RequestMethod.GET)
    public String loadFitnesserHome(@RequestParam(value = "naam", required = false) String naam, ModelMap model){
    	
    	//indien terug naar overzicht pagina, wanneer je je bevond op een detail pagina
    	if (naam == null)
    	{
    		List<Beschikbaarheid> beschikbaarheidLijst = fit20Service.geefAlleBeschikbaarheden(huidigeUserID);
    		List<Persoon> trainerLijst = fit20Service.geefAlleTrainers();
    		List<TrainingSlot> trainingSlotLijst = fit20Service.geefAlleTrainingSlotsFitnesser(huidigeUserID);
    		List<TrainingSlot> trainingSlotVoltooidLijst = fit20Service.geefAlleTrainingSlotsVoltooidFitnesser(huidigeUserID);
    		
    		Beschikbaarheid beschikbaarheid = new Beschikbaarheid();
            
            model.addAttribute("beschikbaarheid", beschikbaarheid);
    		model.addAttribute("trainerLijst", trainerLijst);
    		model.addAttribute("trainingslots", trainingSlotLijst);
    		model.addAttribute("trainingslotsVoltooid", trainingSlotVoltooidLijst);
            model.addAttribute("naam", huidigeUser);
            model.addAttribute("fitnesserid", huidigeUserID);
            model.addAttribute("beschikbaarheidLijst", beschikbaarheidLijst);
            
            return "/fitnesserHome";
    	}
    	
    	//Indien naar overzicht pagina, wanneer je komt van de inlog pagina
    	else
    	{
    		huidigeUser = naam;
    		huidigeUserID = fit20Service.getTrainerID(naam);
    		List<Beschikbaarheid> beschikbaarheidLijst = fit20Service.geefAlleBeschikbaarheden(huidigeUserID);
            List<Persoon> trainerLijst = fit20Service.geefAlleTrainers();
    		List<TrainingSlot> trainingSlotLijst = fit20Service.geefAlleTrainingSlotsFitnesser(huidigeUserID);
    		List<TrainingSlot> trainingSlotVoltooidLijst = fit20Service.geefAlleTrainingSlotsVoltooidFitnesser(huidigeUserID);
            Beschikbaarheid beschikbaarheid = new Beschikbaarheid();
            model.addAttribute("beschikbaarheid", beschikbaarheid);
            model.addAttribute("naam", huidigeUser);
            model.addAttribute("trainingslots", trainingSlotLijst);
            model.addAttribute("trainingslotsVoltooid", trainingSlotVoltooidLijst);
            model.addAttribute("trainerLijst", trainerLijst);
            model.addAttribute("fitnesserid", huidigeUserID);
            model.addAttribute("beschikbaarheidLijst", beschikbaarheidLijst);
            
            return "/fitnesserHome";
    	}
    }
    
    //post methode van de fitnesserHome pagina
    @RequestMapping(value={"/fitnesserHome.html"}, method=RequestMethod.POST)
    public String trainerInloggen(@ModelAttribute("defitnesser") Persoon persoon, ModelMap model){

    	
    	return "redirect:trainingSlotOverzicht.html?naam="+huidigeUser;
    }
    
    //Methode voor create van beschikbaarheid
    @RequestMapping(value={"/nieuweBeschikbaarheid.html"},method=RequestMethod.POST)
    public String beschikbaarheidToevoegen(@ModelAttribute("beschikbaarheid") Beschikbaarheid beschikbaarheid, ModelMap model){
    	
        Beschikbaarheid toeTeVoegenBeschikbaarheid = fit20Service.voegBeschikbaarheidToe(beschikbaarheid.getDatum(),
        																	huidigeUserID, beschikbaarheid.getVoorkeurtrainerid());
        
        return "redirect:fitnesserHome.html?naam="+huidigeUser;
    }
    	

}
