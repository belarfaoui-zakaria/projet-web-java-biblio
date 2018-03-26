package associations;

import java.util.ArrayList;

import model.Abonne;
import model.Auteur;

public class Auteurs extends Base<Auteur>{
	
	
	public Auteur find(String id){ 
		try {
			System.out.println(get( e -> e.getId().equals(id)));
			return get( e -> e.getId().equals(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		return null;
	}
	
	public Auteurs(){
		super(Auteur.class);
		
		
		try {
			this.list = this.loadList(); 
		} catch (Exception e) {
		 
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.list =  new ArrayList<Auteur>();  
		}
	}
}
