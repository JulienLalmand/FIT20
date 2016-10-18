package be.odisee.fit20.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import org.hibernate.annotations.Index;

@Entity
@Table(name="persoon")
public class Persoon implements Serializable {

	private final static String[] states = {"InAfwachting", "InRol"};
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@Column
	private String naam;
	@Column
	private String voornaam;
	@Column
	private String accountnaam;
	@Column
	private String email;
	@Column
	private String rol;
	@Column
	private String wachtwoord;
	@Column
	protected String status;

	
	/* constructors */
	public Persoon()
	{
		this.id = 0;
		this.status = states[0];
		this.accountnaam = "";
		this.wachtwoord = "";
	}
	
	public Persoon(int id, String accountnaam, String wachtwoord)
	{
		this.id = id;
		this.status = states[0];
		this.accountnaam = accountnaam;
		this.wachtwoord = wachtwoord;
	}
	
	
	public Persoon(int id, String voornaam, String naam, String accountnaam, String email, String rol, String status, String paswoord)
	{
		this.id = id;
		this.voornaam = voornaam;
		this.naam = naam;
		this.accountnaam = accountnaam;
		this.email = email;
		this.rol = rol;
		this.status = status;
		this.wachtwoord = wachtwoord;

	}
	
	
	public Persoon(String voornaam, String naam, String accountnaam, String email, String rol, String status, String paswoord)
	{
		this.voornaam = voornaam;
		this.naam = naam;
		this.accountnaam = accountnaam;
		this.email = email;
		this.rol = rol;
		this.status = status;
		this.wachtwoord = wachtwoord;

	}
	
	/* methodes */
	//account deactiveren
	public void deactiveerAccount()
	{
		System.gc(); //kan java objecten niet manueel verwijderen, System.gc() maakt klaar voor garbageCollector
	}
	

	/* getters & setters*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	public String getaccountnaam() {
		return accountnaam;
	}

	public void setaccountnaam(String accountnaam) {
		this.accountnaam = accountnaam;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static String[] getStates() {
		return states;
	}
		
	

	
}
