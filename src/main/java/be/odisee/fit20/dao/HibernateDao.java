
package be.odisee.fit20.dao;

import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import be.odisee.fit20.domain.TrainingSlot;

class HibernateDao {

    SessionFactory sessionFactory;

    protected HibernateDao() {
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
    //Object opslaan
    protected void sessionSaveObject(Object o){
        try{
            sessionFactory.getCurrentSession().save(o);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    
    //retourneert een object met een gegeven ID
    protected Object sessionGetObjectById(String classname, int id){
        Object result = null;
        try{
            result = sessionFactory.getCurrentSession().createQuery("from "+classname+" where id="+id).uniqueResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    //retourneerd een lijst met alle objecten 
    @SuppressWarnings("rawtypes")
	protected List sessionGetAllObjects(String classname) {
        Query query = null;
 		List result = null;
        try{
            query = sessionFactory.getCurrentSession().createQuery("from "+classname);
            result = query.list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    //retourneerd een lijst met alle objecten 
    @SuppressWarnings("rawtypes")
	protected List sessionGetAllTrainingSlotsVoltooid() {
        Query query = null;
 		List result = null;
        try{
            query = sessionFactory.getCurrentSession().createQuery("from TrainingSlot WHERE status= 'Voltooid'");
            result = query.list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    
     int sessionGetPersoonID(String name){
        Query queryID = null;
 		List<Integer> resultQueryID = new ArrayList<Integer>();
 		int persoonID=0;
 		try{
         	
         	//user logt in, en zijn accountnaam wordt bijgehouden
         	//Volgend stukje code zoekt wat de ID is van de account
         	//query returnt een lijst met ID,s omdat we een WHERE doen wordt er maar 1 item geretourneerd
         	//dit is de ID die we nodig hebben, en slaan we op doormiddel van een FOR lus
         	queryID = sessionFactory.getCurrentSession().createQuery("select id from Persoon where accountnaam='"+name+"'"); 
            resultQueryID = queryID.list();
            
            for (int i = 0; i < resultQueryID.size(); i++) {
            	persoonID = resultQueryID.get(i);
     		}
         }

 		catch (Exception e){
 			e.printStackTrace();
 		}
 		
 		return persoonID;
    }
    
    
    //retourneert een lijst met alle trainingslotobjecten van een trainer (GEFILTERD MET WHERE)
    @SuppressWarnings("rawtypes")
	protected List sessionGetAllTrainingSlotsTrainer(String classname, int id) {
        Query query = null;
 		List result = null;

        try{

        	query = sessionFactory.getCurrentSession().createQuery("from "+classname+" where trainer='" +id+"' AND status NOT IN ('Voltooid')");
            result = query.list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    //retourneert een lijst met alle trainingslotobjecten van een fitnesser (met status gepland) (GEFILTERD MET WHERE)
    @SuppressWarnings("rawtypes")
	protected List sessionGetAllTrainingSlotsFitnesser(String classname, int id) {
        Query query = null;
 		List result = null;

        try{

        	query = sessionFactory.getCurrentSession().createQuery("from "+classname+" where fitnesser='" +id+"' AND status NOT IN ('Voltooid')");
            result = query.list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    //retourneert een lijst met alle trainingslotobjecten van een fitnesser (met status VOltooid voor review) (GEFILTERD MET WHERE)
    @SuppressWarnings("rawtypes")
	protected List sessionGetAllTrainingSlotsVoltooidFitnesser(String classname, int id) {
        Query query = null;
 		List result = null;

        try{

        	query = sessionFactory.getCurrentSession().createQuery("from "+classname+" where fitnesser='" +id+"' AND status ='Voltooid' AND klantentevredenheid = null");
            result = query.list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    //retourneert een lijst met alle trainingslotobjecten van een fitnesser (met status VOltooid voor review) (GEFILTERD MET WHERE)
    @SuppressWarnings("rawtypes")
	protected List sessionGetAllTrainingSlotsVoltooidTrainer(String classname, int id) {
        Query query = null;
 		List result = null;

        try{

        	query = sessionFactory.getCurrentSession().createQuery("from "+classname+" where trainer='" +id+"' AND status ='Voltooid'");
            result = query.list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    //retourneert een lijst met alle objecten (GEFILTERD MET WHERE)
    @SuppressWarnings("rawtypes")
	protected List sessionGetAllBeschikbaarheden(String classname, int id) {
        Query query = null;
 		List result = null;

        try{        	
        	query = sessionFactory.getCurrentSession().createQuery("from "+classname+" where fitnesserid='" +id+"'");
            result = query.list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
  //retourneert een lijst met alle trainers
    @SuppressWarnings("rawtypes")
	protected List sessionGetAllTrainers(String classname, String rol) {
        Query query = null;
 		List result = null;
        try{
            query = sessionFactory.getCurrentSession().createQuery("from "+classname+" where rol='1'");
            result = query.list();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
   
    
    //gebruikt om traininsglots te verwijderen
    protected void sessionDeleteObjectById(String classname, int id) {
 	   try {
 		   	Session session = sessionFactory.getCurrentSession();
 		    
 		    String hql = "delete " + classname + " where id =" +id ;
 		    Query q = session.createQuery(hql);
 		    q.executeUpdate();
 	   	}
 	   	catch (Exception e) {
 	   		e.printStackTrace();
 	   	}
    }
    
    protected void sessionCancelTrainingSlotById(int id){
    	try {
 		   	Session session = sessionFactory.getCurrentSession();
 		    
 		    String hql = "UPDATE TrainingSlot SET fitnesser = null, status = 'Openstaand' WHERE id =" +id;
 		    Query q = session.createQuery(hql);
 		    q.executeUpdate();
    		
    	}
 	   	catch (Exception e) {
 	   		e.printStackTrace();
 	   	}
    }
    
    
    //Update van een trainingSlot
    protected void sessionUpdateObjectById(String classname, int id, String datum) {
  	   try {
  		   	Session session = sessionFactory.getCurrentSession();
  		    
  		    String hql = "update " + classname + " set datum ='" +datum +"' where id=" +id ;
  		    Query q = session.createQuery(hql);
  		    q.executeUpdate();
  	   	}
  	   	catch (Exception e) {
  	   		e.printStackTrace();
  	   	}
     }
    
    //Update van een trainingSlot
    protected void sessionSetKlantentevredenheid(int id, String klantentevredenheid) {
  	   try {
  		   	Session session = sessionFactory.getCurrentSession();
  		    
  		    String hql = "update TrainingSlot set klantentevredenheid ='" + klantentevredenheid + "' where id=" +id ;
  		    Query q = session.createQuery(hql);
  		    q.executeUpdate();
  	   	}
  	   	catch (Exception e) {
  	   		e.printStackTrace();
  	   	}
     }
    
    

}
