
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
public class HomeController {

    @Autowired
    protected Fit20Service fit20Service; // dependency injection
    
    
    //Verwijst door naar de hoofdpagina van de webapplicatie
    @RequestMapping(value={"/", "/home.html"},method=RequestMethod.GET)
    public String index(ModelMap model){
        List<Persoon> deLijst = fit20Service.geefAllePersonen();
        model.addAttribute("personen", deLijst);
        //huidigeUser = null;
        return "/home";
    }
}
