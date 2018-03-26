package associations;

import java.util.ArrayList;

import model.Emprunt;
import model.Oeuvre;

public class Emprunts extends Base<Emprunt> {
	
	public Emprunts(){
		super(Emprunt.class);
		
		try {
			this.list = this.loadList(); 
		} catch (Exception e) {
		 
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.list =  new ArrayList<Emprunt>();  
		}
	}
}
