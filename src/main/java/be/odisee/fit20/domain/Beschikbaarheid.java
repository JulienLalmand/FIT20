package be.odisee.fit20.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import org.hibernate.annotations.Index;

@Entity
@Table(name="beschikbaarheid")
public class Beschikbaarheid implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@Column
	private int fitnesserid;
	@Column
	private int voorkeurtrainerid;
	@Column
	private String datum;
	
	/* constructors */
	public Beschikbaarheid()
	{
	}
	
	public Beschikbaarheid(String datum, int fitnesserid, int voorkeurtrainerid)
	{
		this.datum = datum;
		this.fitnesserid = fitnesserid;
		this.voorkeurtrainerid = voorkeurtrainerid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFitnesserid() {
		return fitnesserid;
	}

	public void setFitnesserid(int fitnesserid) {
		this.fitnesserid = fitnesserid;
	}



	public int getVoorkeurtrainerid() {
		return voorkeurtrainerid;
	}

	public void setVoorkeurtrainerid(int voorkeurtrainerid) {
		this.voorkeurtrainerid = voorkeurtrainerid;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

}
