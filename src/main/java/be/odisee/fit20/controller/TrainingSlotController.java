
package be.odisee.fit20.controller;

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
public class TrainingSlotController {

    @Autowired
    protected Fit20Service fit20Service; // dependency injection
    
    //locale variabele die de huidige ingelogde trainer bijhoudt
    public String huidigeUser;   
    public int huidigeUserID;
    
    //REST GET breng toestand van trainingslot van de server naar de client
    @RequestMapping(value={"/TrainingSlot/{id}"},method=RequestMethod.GET)
    public @ResponseBody TrainingSlot getTrainingSlot(@PathVariable("id") Integer id){
    	
    	TrainingSlot trainingSlot = fit20Service.zoekTrainingSlotMetId(id);
    	return trainingSlot;
    }
    
    //REST GET breng toestand van trainingslot van de server naar de client
    @RequestMapping(value={"/TrainingSlots"},method=RequestMethod.GET)
    public @ResponseBody List<TrainingSlot> getTrainingSlots(){
    	
    	List<TrainingSlot> trainingSlot = fit20Service.geefAlleTrainingSlotsVoltooid();
    	return trainingSlot;
    }
    
    //toont een lijst van alle trainingsloten van een trainer
    @RequestMapping(value={"/trainingSlotOverzicht.html"},method=RequestMethod.GET)
    public String trainingSlotList(@RequestParam(value = "naam", required = false) String naam, ModelMap model){
    	
    	//indien terug naar overzicht pagina, wanneer je je bevond op een detail pagina
    	if (naam == null)
    	{
    		List<TrainingSlot> deLijst = fit20Service.geefAlleTrainingSlotsTrainer(huidigeUserID);
    		List<TrainingSlot> trainingSlotVoltooidLijst = fit20Service.geefAlleTrainingSlotsVoltooidTrainer(huidigeUserID);
            TrainingSlot trainigSlot = new TrainingSlot();
            model.addAttribute("trainingSlot", trainigSlot);
            model.addAttribute("trainingslots", deLijst);
            model.addAttribute("trainingslotsVoltooid", trainingSlotVoltooidLijst);
            model.addAttribute("naam", huidigeUser);
            model.addAttribute("trainerid", huidigeUserID);
            return "/trainingSlotOverzicht";
    	}
    	
    	//Indien naar overzicht pagina, wanneer je komt van de inlog pagina
    	else
    	{
    		huidigeUser = naam;
    		huidigeUserID = fit20Service.getTrainerID(naam);
            List<TrainingSlot> deLijst = fit20Service.geefAlleTrainingSlotsTrainer(huidigeUserID);
            List<TrainingSlot> trainingSlotVoltooidLijst = fit20Service.geefAlleTrainingSlotsVoltooidTrainer(huidigeUserID);
            TrainingSlot trainigSlot = new TrainingSlot();
            model.addAttribute("trainingSlot", trainigSlot);
            model.addAttribute("trainingslots", deLijst);
            model.addAttribute("trainingslotsVoltooid", trainingSlotVoltooidLijst);
            model.addAttribute("naam", huidigeUser);
            model.addAttribute("trainerid", huidigeUserID);
            return "/trainingSlotOverzicht";
    	}
    	
    }
    
    // post methode van de trainingSlotOverzicht pagina
    @RequestMapping(value={"/trainingSlotOverzicht.html"},method=RequestMethod.POST)
    public String trainerInloggen(@ModelAttribute("detrainer") Persoon persoon, ModelMap model){
    	
    	return "redirect:trainingSlotOverzicht.html?naam="+persoon.getNaam();
    }
    
    
    //geeft de details terug van een trainingslot met ID...
    @RequestMapping(value={"/trainingSlotDetailTrainer.html"},method=RequestMethod.GET)
    public String trainingSlotDetailTrainer(@RequestParam("id") Integer id, ModelMap model){
        TrainingSlot trainigSlot = fit20Service.zoekTrainingSlotMetId(id);
        model.addAttribute("trainingSlot", trainigSlot);
        return "/trainingSlotDetailTrainer";
    }
    
    //geeft de details terug van een trainingslot met ID...
    @RequestMapping(value={"/trainingSlotDetailFitnesser.html"},method=RequestMethod.GET)
    public String trainingSlotDetailFitnesser(@RequestParam("id") Integer id, ModelMap model){
        TrainingSlot trainigSlot = fit20Service.zoekTrainingSlotMetId(id);
        model.addAttribute("trainingSlot", trainigSlot);
        return "/trainingSlotDetailFitnesser";
    }
    
    //geeft de details terug van een trainingslot met ID...
    @RequestMapping(value={"/trainingSlotDetailVoltooid.html"},method=RequestMethod.GET)
    public String trainingSlotReviewTrainer(@RequestParam("id") Integer id, ModelMap model){
        TrainingSlot trainigSlot = fit20Service.zoekTrainingSlotMetId(id);
        model.addAttribute("trainingSlot", trainigSlot);
        return "/trainingSlotKlantentevredenheidTrainer";
    }
    
    //geeft de details terug van een trainingslot met ID...
    @RequestMapping(value={"/trainingSlotReviewFitnesser.html"},method=RequestMethod.GET)
    public String trainingSlotReviewFitnesser(@RequestParam("id") Integer id, ModelMap model){
        TrainingSlot trainigSlot = fit20Service.zoekTrainingSlotMetId(id);
        model.addAttribute("trainingSlot", trainigSlot);
        return "/trainingSlotKlantentevredenheidFitnesser";
    }
    
    
    //Methode voor update van trainingSlot
    @RequestMapping(value={"/trainingSlot/update.html"},method=RequestMethod.POST)
    public String updateTrainingSlot(@RequestParam("trainingSlot") int id, @RequestParam("datum") String datum) {
    	fit20Service.updateTrainingSlotMetId(id, datum);
    	
    	return "redirect:/trainingSlotDetailTrainer.html?id="+id;
    }
    
    
    //Methode voor delete van trainingSlot
    @RequestMapping(value={"/trainingSlot/delete.html"},method=RequestMethod.POST)
    public String verwijderTrainingSlot(@RequestParam("trainingSlot") int id) {
    	fit20Service.verwijderTrainingSlotMetId(id);
    	
    	return "redirect:/trainingSlotOverzicht.html";
    }
    
    //Methode voor annuleer van trainingSlot
    @RequestMapping(value={"/trainingSlot/annuleer.html"},method=RequestMethod.POST)
    public String annuleerTrainingSlot(@RequestParam("trainingSlot") int id) {
    	fit20Service.annuleerTrainingSlotMetId(id);
    	
    	return "redirect:/fitnesserHome.html";
    }
    
    //Methode voor annuleer van trainingSlot
    @RequestMapping(value={"/trainingSlot/klantentevredenheid.html"},method=RequestMethod.POST)
    public String updateKlantenTevredenheid(@RequestParam("trainingSlot") int id, @RequestParam("klantentevredenheid") String klantentevredenheid) {
    	fit20Service.setTrainingSlotKlantentevredenheid(id, klantentevredenheid);
    	
    	return "redirect:/fitnesserHome.html";
    }
    
        
    //Methode voor create van trainingSlot
    @RequestMapping(value={"/nieuwTrainingSlot.html"},method=RequestMethod.POST)
    public String trainingSlotToevoegen(@ModelAttribute("trainingSlot") TrainingSlot trainingSlot, ModelMap model){
    	
        TrainingSlot toegevoegdTrainingSlot = fit20Service.voegTrainingSlotToe(trainingSlot.getDatum(),
        																	huidigeUserID);
        
        //return "redirect:trainingSlotOverzicht.html?naam="+huidigeUser;
        return "redirect:trainingSlotDetailTrainer.html?id=" + toegevoegdTrainingSlot.getId();
    }
  

}
