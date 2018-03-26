package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.jmx.snmp.Timestamp;

public class Emprunt extends Base {
	String id;
	String date_retour;
	String date_emprunt;
	String abonne;
	String oeuvre;
	
	public Emprunt(){}
	public Emprunt(String date_retour, String date_emprunt, String abonne, String oeuvre) {
		this.id = "emp_" + new Timestamp(System.currentTimeMillis()).toString();
		this.date_retour = date_retour;
		this.date_emprunt = date_emprunt;
		this.abonne = abonne;
		this.oeuvre = oeuvre;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setToday(){
		this.date_emprunt = new SimpleDateFormat("dd/MM/yyyy").format(new Date()).toString();
	}

	public void setRandomId(){
		 this.id = "auteur_" + new Date().getTime();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((abonne == null) ? 0 : abonne.hashCode());
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
		Emprunt other = (Emprunt) obj;
		if (abonne == null) {
			if (other.abonne != null)
				return false;
		} else if (!abonne.equals(other.abonne))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getDate_retour() {
		return date_retour;
	}
	public void setDate_retour(String date_retour) {
		this.date_retour = date_retour;
	}
	public String getDate_emprunt() {
		return date_emprunt;
	}
	public void setDate_emprunt(String date_emprunt) {
		this.date_emprunt = date_emprunt;
	}
	public String getAbonne() {
		return abonne;
	}
	public void setAbonne(String abonne) {
		this.abonne = abonne;
	}
	public String getOeuvre() {
		return oeuvre;
	}
	public void setOeuvre(String oeuvre) {
		this.oeuvre = oeuvre;
	}
}
