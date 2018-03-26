package model;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Base {

	
	
	public void setAttributes(HashMap<String, Object> fields) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		 for (@SuppressWarnings("rawtypes") Map.Entry entry : fields.entrySet()) {
			 this.setAttr(entry.getKey().toString(),  entry.getValue());  
	     }
	}
	
	public void setAttr(String name, Object value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class<?> clazz = this.getClass();
       Field field = clazz.getDeclaredField(name);
       field.setAccessible(true);
       field.set(this, value);
	}
	
}
