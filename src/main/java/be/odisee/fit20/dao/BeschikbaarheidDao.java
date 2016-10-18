package be.odisee.fit20.dao;

import java.util.List;

import be.odisee.fit20.domain.*;

public interface BeschikbaarheidDao {
	
	public Beschikbaarheid saveBeschikbaarheid(String datum, int fitnesser, int trainer);
	
	public List<Beschikbaarheid> getAlleBeschikbaarheden(int fitnesser);
	
    public int getFitnesserID(String accountNaam);
}
