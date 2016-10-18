package be.odisee.fit20.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.odisee.fit20.domain.*;

import org.springframework.transaction.annotation.Propagation;

@Repository("trainingslotDao")
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class TrainingSlotHibernateDao extends HibernateDao implements TrainingSlotDao {

    @SuppressWarnings("unchecked")
    public List<TrainingSlot> getAllTrainingSlotsTrainer(int trainerID) {
    	return (List<TrainingSlot>) sessionGetAllTrainingSlotsTrainer("TrainingSlot", trainerID);
    }
    
    @SuppressWarnings("unchecked")
    public List<TrainingSlot> getAllTrainingSlotsFitnesser(int fitnesserID) {
    	return (List<TrainingSlot>) sessionGetAllTrainingSlotsFitnesser("TrainingSlot", fitnesserID);
    }
    
    @SuppressWarnings("unchecked")
    public List<TrainingSlot> getAllTrainingSlotsVoltooidFitnesser(int fitnesserID) {
    	return (List<TrainingSlot>) sessionGetAllTrainingSlotsVoltooidFitnesser("TrainingSlot", fitnesserID);
    }
    
    @SuppressWarnings("unchecked")
    public List<TrainingSlot> getAllTrainingSlotsVoltooidTrainer(int fitnesserID) {
    	return (List<TrainingSlot>) sessionGetAllTrainingSlotsVoltooidTrainer("TrainingSlot", fitnesserID);
    }
    
    @SuppressWarnings("unchecked")
	public List<TrainingSlot> getAllTrainingSlotsVoltooid(){
    	return (List<TrainingSlot>) sessionGetAllTrainingSlotsVoltooid();
    
    }
    
    public TrainingSlot getTrainingSlotById(int trainingSlotId) {
        return (TrainingSlot) sessionGetObjectById("TrainingSlot", trainingSlotId);
    }
    
    public void setTrainingSlotKlantentevredenheid(int id, String klantentevredenheid)
    {
    	sessionSetKlantentevredenheid(id, klantentevredenheid);
    }

    public void deleteTrainingSlotById(int id) {
    	sessionDeleteObjectById("TrainingSlot", id);
    }
    
    public void updateTrainingSlotById(int id, String datum){
    	sessionUpdateObjectById("TrainingSlot", id, datum);
    }
    
    public void annuleerTrainingSlotById(int id){
    	sessionCancelTrainingSlotById(id);
    }
    
    public TrainingSlot saveTrainingSlot(String datum, int trainer){
    	TrainingSlot trainingSlot = new TrainingSlot(datum, trainer);
    	sessionSaveObject(trainingSlot);
    	return trainingSlot;
    }
    
    public int getTrainerID(String accountNaam){
    	return sessionGetPersoonID(accountNaam);
    }
    
}
