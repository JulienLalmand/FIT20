package be.odisee.fit20.dao;

import java.util.List;

import be.odisee.fit20.domain.*;

public interface TrainingSlotDao {

	public List<TrainingSlot> getAllTrainingSlotsTrainer(int trainerID);
	
	public List<TrainingSlot> getAllTrainingSlotsFitnesser(int fitnesserID);
	
	public List<TrainingSlot> getAllTrainingSlotsVoltooidFitnesser(int fitnesserID);
	
	public List<TrainingSlot> getAllTrainingSlotsVoltooidTrainer(int trainerID);
	
	public List<TrainingSlot> getAllTrainingSlotsVoltooid();
	
	public TrainingSlot getTrainingSlotById(int trainingSlotId);
	
	public void deleteTrainingSlotById(int id);
	
	public void updateTrainingSlotById(int id, String datum);
	
	public void setTrainingSlotKlantentevredenheid(int id, String klantentevredenheid);
	
	public void annuleerTrainingSlotById(int id);
	
	public TrainingSlot saveTrainingSlot(String datum, int trainer);
	
    public int getTrainerID(String accountNaam);
}
