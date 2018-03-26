package associations;

import java.util.ArrayList;

import model.Abonne;
import model.Auteur;
import model.Oeuvre;

public class Abonnes extends Base<Abonne> {

	
	public Abonne find(String id){ 
		try {
			return get( e -> e.getId().equals(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		return null;
	}
	
	public Abonnes(){
		super(Abonne.class);
		
		
		try {
			this.list = this.loadList(); 
		} catch (Exception e) {
		 
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.list =  new ArrayList<Abonne>();  
		}
	}
}
