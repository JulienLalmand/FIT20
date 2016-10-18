package be.odisee.fit20.service;

import be.odisee.fit20.dao.*;
import be.odisee.fit20.domain.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

@Service("fit20Service")
@Transactional(propagation = Propagation.SUPPORTS, readOnly=true)
public class Fit20ServiceImpl implements Fit20Service {

    private PersoonDao persoonDao;
    private TrainingSlotDao trainingSlotDao;
    private BeschikbaarheidDao beschikbaarheidDao;

    public Fit20ServiceImpl(){}

    @Autowired
    public void setPersoonDao(PersoonDao persoonDao) {
        this.persoonDao = persoonDao;
    }
    
    @Autowired
    public void setTrainingSlotDao(TrainingSlotDao trainingSlotDao) {
        this.trainingSlotDao = trainingSlotDao;
    }
    
    @Autowired
    public void setBeschikbaarheidDao(BeschikbaarheidDao beschikbaarheidDao) {
        this.beschikbaarheidDao = beschikbaarheidDao;
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public Persoon voegPersoonToe(String voornaam, String naam, String accountnaam, String email, String rol, String status, String wachtwoord) {
        return persoonDao.savePersoon(voornaam,naam,accountnaam,email, rol, status, wachtwoord);
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public Persoon zoekPersoonMetId(int id){
        return persoonDao.getPersoonById(id);
    }

    public List<Persoon> geefAllePersonen() {
        return persoonDao.getAllPersons();
    }
    
    public List<Persoon> geefAlleTrainers() {
        return persoonDao.getAllTrainers();
    }
    
    public List<TrainingSlot>geefAlleTrainingSlotsVoltooid(){
    	return trainingSlotDao.getAllTrainingSlotsVoltooid();
    }
    
    public List<TrainingSlot> geefAlleTrainingSlotsTrainer(int trainerID){
    	return trainingSlotDao.getAllTrainingSlotsTrainer(trainerID);
    }
    
    public List<TrainingSlot> geefAlleTrainingSlotsFitnesser(int fitnesserID){
    	return trainingSlotDao.getAllTrainingSlotsFitnesser(fitnesserID);
    }
    
    public List<TrainingSlot> geefAlleTrainingSlotsVoltooidFitnesser(int fitnesserID){
    	return trainingSlotDao.getAllTrainingSlotsVoltooidFitnesser(fitnesserID);
    }
    
    public List<TrainingSlot> geefAlleTrainingSlotsVoltooidTrainer(int fitnesserID){
    	return trainingSlotDao.getAllTrainingSlotsVoltooidTrainer(fitnesserID);
    }
    
    public void setTrainingSlotKlantentevredenheid(int id, String klantentevredenheid){
    	trainingSlotDao.setTrainingSlotKlantentevredenheid(id, klantentevredenheid);
    }
    
    public List<Beschikbaarheid> geefAlleBeschikbaarheden(int fitnesser){
    	return beschikbaarheidDao.getAlleBeschikbaarheden(fitnesser);
    }
    
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public TrainingSlot zoekTrainingSlotMetId(int id){
    	return trainingSlotDao.getTrainingSlotById(id);
    }
    
    public void verwijderTrainingSlotMetId(int id){
    	trainingSlotDao.deleteTrainingSlotById(id);
    }
    
    public void annuleerTrainingSlotMetId(int id){
    	trainingSlotDao.annuleerTrainingSlotById(id);
    }
    
    public void updateTrainingSlotMetId(int id, String datum){
    	trainingSlotDao.updateTrainingSlotById(id, datum);
    }
    
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public TrainingSlot voegTrainingSlotToe(String datum, int trainer){
    	return trainingSlotDao.saveTrainingSlot(datum, trainer);
    }
    
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public Beschikbaarheid voegBeschikbaarheidToe(String datum, int fitnesser, int trainer){
    	return beschikbaarheidDao.saveBeschikbaarheid(datum, fitnesser, trainer);
    }
    
    public int getTrainerID(String accountNaam){
    	return trainingSlotDao.getTrainerID(accountNaam);
    }

	@Override
	public void voegTrainingSlotToe(TrainingSlot t) {
		this.voegTrainingSlotToe(t.getDatum(), t.getId());
	}
    
}