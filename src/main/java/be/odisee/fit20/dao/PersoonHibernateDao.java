package be.odisee.fit20.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.odisee.fit20.domain.Persoon;
import be.odisee.fit20.domain.TrainingSlot;

import org.springframework.transaction.annotation.Propagation;

@Repository("persoonDao")
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class PersoonHibernateDao extends HibernateDao implements PersoonDao {

	public Persoon savePersoon(String voornaam, String naam, String accountnaam, String email, String rol, String status, String wachtwoord) {
        Persoon persoon = new Persoon(voornaam, naam, accountnaam, email, rol, status, wachtwoord);
        sessionSaveObject(persoon);
        return persoon;
    }

    public Persoon getPersoonById(int persoonId) {
        return (Persoon) sessionGetObjectById("Persoon", persoonId);
    }

    @SuppressWarnings("unchecked")
	public List<Persoon> getAllPersons() {
        return (List<Persoon>) sessionGetAllObjects("Persoon");
    }
    
    @SuppressWarnings("unchecked")
	public List<Persoon> getAllTrainers() {
        return (List<Persoon>) sessionGetAllTrainers("Persoon", "Trainer");
    }

}
