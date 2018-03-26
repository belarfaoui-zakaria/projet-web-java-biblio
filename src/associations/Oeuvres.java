package associations;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import model.Oeuvre;



@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Oeuvres extends Base<Oeuvre> {

	public Oeuvre find(String ref){ 
		try {
			return get( e -> e.getReference().equals(ref));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		return null;
	}
 
	@SuppressWarnings("unchecked")
	public Oeuvres(){
		super(Oeuvre.class);
		
		
		try {
			this.list = this.loadList(); 
		} catch (Exception e) {
		 
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.list =  new ArrayList<Oeuvre>();  
		}
	}
	
	
	
	


}
