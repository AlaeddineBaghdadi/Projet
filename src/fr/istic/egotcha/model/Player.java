package fr.istic.egotcha.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Player {
	private int id;
	private String pseudo;
	private String password;
	private String firstname;
	private String lastname;
	private Date birthday;
	private String mail;


	private Set<PlayerLocation> playerLocations = new HashSet<PlayerLocation>();
	
	
	public Player(String pseudo, String password, String firstname,
			String lastname, Date birthday, String mail) {
		this.pseudo = pseudo;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.mail=mail;
		this.playerLocations = new HashSet<PlayerLocation>();
	}


	public Player() {
		this.pseudo = "";
		this.password = "";
		this.firstname = "";
		this.lastname = "";
		this.birthday = new Date();
		this.mail="";
		this.playerLocations = new HashSet<PlayerLocation>();
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPseudo() {
		return pseudo;
	}


	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public Set<PlayerLocation> getPositions() {
		return playerLocations;
	}


	public void setPositions(Set<PlayerLocation> playerLocations) {
		this.playerLocations = playerLocations;
	}
	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	@Override
	public String toString() {
		return "Player [id=" + id + ", pseudo=" + pseudo + ", password="
				+ password + ", firstname=" + firstname + ", lastname="
				+ lastname + ", birthday=" + birthday + ", mail=" + mail
				+ ", playerLocations=" + playerLocations + "]";
	}


	
	
	
	
	
	
	
	
	

	
	
}
