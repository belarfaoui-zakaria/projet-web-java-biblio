package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.jmx.snmp.Timestamp;

public class Abonne extends Base {
	
	String id;
	String nom;
	String prenom;
	String date_naissance;
	String date_inscription;
	String numero_telephone;
	String ville;
	
	public Abonne(){
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Abonne( String nom, String prenom, String date_naissance, String date_inscription,
			String numero_telephone, String ville) {

		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
		this.date_inscription = date_inscription;
		this.numero_telephone = numero_telephone;
		this.ville = ville;
	}
	

	

 
	@Override
	public String toString() {
		return nom + " " + prenom;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_inscription == null) ? 0 : date_inscription.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	public void setRandomId(){
		 this.id = "abonne_" + new Date().getTime();
	}
	public void setToday(){
		this.date_inscription = new SimpleDateFormat("dd/MM/yyyy").format(new Date()).toString();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abonne other = (Abonne) obj;
		if (date_inscription == null) {
			if (other.date_inscription != null)
				return false;
		} else if (!date_inscription.equals(other.date_inscription))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}
	public String getDate_inscription() {
		return date_inscription;
	}
	public void setDate_inscription(String date_inscription) {
		this.date_inscription = date_inscription;
	}
	public String telephone() {
		return numero_telephone;
	}
	public void set_telephone(String numero_telephone) {
		this.numero_telephone = numero_telephone;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		ville = ville;
	}
}
