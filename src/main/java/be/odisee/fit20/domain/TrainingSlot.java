package be.odisee.fit20.domain;
import java.util.Date;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import org.hibernate.annotations.Index;

@Entity
@Table(name="trainingslot")
public class TrainingSlot implements Serializable {
	private final static String[] states = {"Openstaand", "Gepland", "In Training"};
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@Column
	private String fitnesser;
	
	@Column
	private int trainer;
	
	@Column
	private String programma;
	
	@Column
	private String status;
	
	@Column
	private String datum;	
	
	@Column
	private String klantentevredenheid;	
	
	
	public String getKlantentevredenheid() {
		return klantentevredenheid;
	}

	public void setKlantentevredenheid(String klantentevredenheid) {
		this.klantentevredenheid = klantentevredenheid;
	}

	/* constructors */
	public TrainingSlot()
	{
		this.id = 0;
		this.status = states[0];
	}
	
	public TrainingSlot(String datum, int trainer)
	{
		this.datum = datum;
		this.trainer = trainer;
		this.status = states[0];
	}
	

	
	/*getters & setters*/
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFitnesser() {
		return fitnesser;
	}

	public void setFitnesser(String fitnesser) {
		this.fitnesser = fitnesser;
	}

	public int getTrainer() {
		return trainer;
	}

	public void setTrainer(int trainer) {
		this.trainer = trainer;
	}

	public String getProgramma() {
		return programma;
	}

	public void setProgramma(String programma) {
		this.programma = programma;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}
	
	/* methodes */
	public void startTraining()
	{
		this.status = states[2]; //startTraining verandert de status van het object
	}
	
	public void stopTraining()
	{
		System.gc(); //bij afloop van training mag het trainingSlot verwijderd worden
	}
	
	public void annuleerTraining()
	{
		System.gc(); //bij afloop van training mag het trainingSlot verwijderd worden
	}
	
	public void wijzigProgramma(String programma)
	{
		this.programma = programma;
	}
	
	public boolean zoekMatch()
	{
		return false;
	}
	
}

