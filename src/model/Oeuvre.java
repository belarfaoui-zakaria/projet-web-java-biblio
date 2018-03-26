package model;

public class Oeuvre extends Base {
	
	public Oeuvre(){
		
	}
	
	public Oeuvre(String reference){
		this.reference = reference;
	}
	
	private String reference;
	private String titre;
	private String auteur;
	private String annee;
	private String nombre_page;
	
	@Override
	public String toString() {
		return  titre;
	}

	public Oeuvre(String reference, String titre, String auteur, String annee, String nombre_page) {

			this.reference = reference;
			this.titre = titre;
			this.auteur = auteur;
			this.annee = annee;
			this.nombre_page = nombre_page;
	}	

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getNombrePage() {
		return nombre_page;
	}

	public void setNombrePage(String nombre_page) {
		this.nombre_page = nombre_page;
	}

	//	@XmlElement
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
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
		Oeuvre other = (Oeuvre) obj;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		return true;
	}
	
	
}
