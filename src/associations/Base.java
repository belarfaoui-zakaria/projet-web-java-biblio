package associations;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.Oeuvre;
 



public class Base<T> {
	
 
	protected String path; 
	protected List<T> list;	
	private Class<?> _class;
	public List<T> getList() {
		return list;
	}

	
 
	@SuppressWarnings("unchecked")
	public Base(Class<?> type){
		
		this._class = type;	 
		path =  _class.getSimpleName()+".xml";
 
	}
	
	@SuppressWarnings("unchecked")
	public List<T> loadList() throws Exception{
		XMLDecoder decoder=null;
		try{
			decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)));
		}
		catch(FileNotFoundException fileNotFound){
			fileNotFound.printStackTrace();
			System.out.println("ERROR: While Creating or Opening the File");
			throw new Exception("ERROR: While Creating or Opening the File");
		}
		
		Object result =  decoder.readObject();
		decoder.close(); 
		return new ArrayList<T>(Arrays.asList((T[])result));
		
		
	}
	
	public T get(Predicate<? super T> predicate) throws Exception{
		Optional<T> op = list.stream().filter(predicate).findFirst();
		if(op.isPresent())
			return op.get();
		else
			throw new Exception("Oeuvre not found");
	}
	

	
	public List<T> where(Predicate<? super T> predicate){
		return list.stream().filter(predicate).collect(Collectors.toList());
	}
	
	
	public void delete(Predicate<? super T> predicate){
		List<T> result = where(predicate);
		if(!result.isEmpty()) list.removeAll(result);
	}
	public void add(T object) throws Exception{
		if(!list.contains(object)){
			list.add(object);
		}else{
			throw new Exception("Object already exist!!");
		}
			
	}
	
	public void save(){
		
		System.out.println("Saving");
 
		XMLEncoder encoder=null;
		try{
			encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)));
		}
		catch(FileNotFoundException fileNotFound){
			fileNotFound.printStackTrace();

			
		}
 
		encoder.writeObject(this.list.toArray());
		encoder.close();
 
 
	}
}
