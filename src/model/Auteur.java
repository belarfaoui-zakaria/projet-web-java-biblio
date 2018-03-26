package model;

import java.util.Date;

import com.sun.jmx.snmp.Timestamp;

public class Auteur extends Base{
	@Override
	public String toString() {
		return   nom + " " + prenom ;
	}
	String id;
	String nom;
	String prenom;

	public void setRandomId(){
		 this.id = "auteur_" + new Date().getTime();
	}
	
	public Auteur(){
		
	}
	
	public Auteur( String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auteur other = (Auteur) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
