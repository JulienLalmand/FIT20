package be.odisee.fit20.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.odisee.fit20.domain.*;

import org.springframework.transaction.annotation.Propagation;

@Repository("beschikbaarheidDao")
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class BeschikbaarheidHibernateDao extends HibernateDao implements BeschikbaarheidDao {
    
    public Beschikbaarheid saveBeschikbaarheid(String datum, int fitnesser, int trainer){
    	Beschikbaarheid beschikbaarheid = new Beschikbaarheid(datum, fitnesser, trainer);
    	sessionSaveObject(beschikbaarheid);
    	return beschikbaarheid;
    }
    
    public List<Beschikbaarheid> getAlleBeschikbaarheden(int fitnesser){
    	return (List<Beschikbaarheid>) sessionGetAllBeschikbaarheden("Beschikbaarheid", fitnesser);
    }
    
    public int getFitnesserID(String accountNaam){
    	return sessionGetPersoonID(accountNaam);
    }
    
}
