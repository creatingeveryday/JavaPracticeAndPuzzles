package practice.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public class PropertiesPractice {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Properties prop = new Properties();
		
		prop.setProperty("timeout", "30");
		prop.setProperty("language", "kr");
		prop.setProperty("size", "10");
		prop.setProperty("capacity", "10");
		
		Enumeration e = prop.propertyNames();
		
		while(e.hasMoreElements()) {
			 String element =  (String) e.nextElement();
			 System.out.println(element +"="+prop.getProperty(element));
		}
		System.out.println(prop.getProperty("loadfactor","0.75"));
		
		System.out.println(prop);
		
		prop.list(System.out);
		
		Properties sysprop = System.getProperties();
		sysprop.list(System.out);
		
		ArrayList arlist = new ArrayList();
		arlist.add(1);
		arlist.add(2);
		arlist.add(3);
		
		List synList = Collections.synchronizedList(arlist);
		
		List unmodList = Collections.unmodifiableList(new ArrayList(arlist));
		// unmodList.add(4);    변경 불가능. 
		System.out.println(unmodList);
		
		String str ="";
		System.out.println(str);
	
		

	}

}
