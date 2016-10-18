package be.odisee.fit20.service;

import java.util.List;

import be.odisee.fit20.domain.*;

public interface Fit20Service {

	public Persoon voegPersoonToe(String voornaam, String naam, String accountnaam, String email, String rol, String status, String wachtwoord);

    public Persoon zoekPersoonMetId(int id);

    public List<Persoon> geefAllePersonen();
    
    public List<Persoon> geefAlleTrainers();
    
    public List<TrainingSlot>geefAlleTrainingSlotsVoltooid();
    
    public List<TrainingSlot> geefAlleTrainingSlotsTrainer(int trainerID);
    
    public List<TrainingSlot> geefAlleTrainingSlotsFitnesser(int fitnesserID);
    
    public List<TrainingSlot> geefAlleTrainingSlotsVoltooidFitnesser(int fitnesserID);
    
    public List<TrainingSlot> geefAlleTrainingSlotsVoltooidTrainer(int fitnesserID);
    
    public void setTrainingSlotKlantentevredenheid(int id, String klantentevredenheid);
    
    public List <Beschikbaarheid> geefAlleBeschikbaarheden(int fitnesser);
    
    public TrainingSlot zoekTrainingSlotMetId(int id);
    
    public void verwijderTrainingSlotMetId(int id);
    
    public void updateTrainingSlotMetId(int id, String datum);
    
    public void annuleerTrainingSlotMetId(int id);
    
    public TrainingSlot voegTrainingSlotToe(String datum, int trainer);
    public void voegTrainingSlotToe(TrainingSlot t);
    
    public Beschikbaarheid voegBeschikbaarheidToe(String datum, int fitnesser, int trainer);
    
    public int getTrainerID(String accountNaam);

}