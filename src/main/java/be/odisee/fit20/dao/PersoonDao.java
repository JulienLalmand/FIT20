package be.odisee.fit20.dao;

import java.util.List;

import be.odisee.fit20.domain.*;

public interface PersoonDao {

    public Persoon savePersoon(String voornaam, String naam, String accountnaam, String email, String rol, String status, String wachtwoord);

    public Persoon getPersoonById(int persoonId);

    public List<Persoon> getAllPersons();
    
    public List<Persoon> getAllTrainers();

}
