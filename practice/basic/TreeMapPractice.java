package practice.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapPractice {

	public static void main(String[] args) {
		String[] data = {"A","K","B","B","B","B","B","B","G","G","G","B","G","A","B","K","K"};
		
		TreeMap tmap = new TreeMap();
		for(int i = 0; i<data.length;i++) {
			if(tmap.containsKey(data[i])) {
				Integer Value = (Integer) tmap.get(data[i]);
				tmap.put(data[i], Value+1);
			}else {
				tmap.put(data[i], 1);
			}
			
		}//for
		System.out.println(tmap);
		
		System.out.println("===========기본 정렬===============");
		
		Iterator it = tmap.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			int value = ((Integer)entry.getValue()).intValue();
			System.out.println(entry.getKey()+": "+printBar('#',value)+" "+value);
		}
		
		System.out.println("=============값의 크기가 큰 순서로 정렬==================");
		
		Set s = tmap.entrySet();
		List list = new ArrayList(s);
		Collections.sort(list, new ValueCompartor());
		
		it = list.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			int value = ((Integer)entry.getValue()).intValue();
			System.out.println(entry.getKey()+": "+printBar('#',value)+" "+value);
		}
		
		
	} // main

	public static String printBar(char ch , int value) {
		char[] bar = new char[value];
		for(int i=0;i<bar.length;i++) {
			bar[i]= ch;
		}
		return new String(bar);
	}
	
	
}

class ValueCompartor implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Map.Entry && o2 instanceof Map.Entry) {
			Map.Entry e1 = (Map.Entry)o1;
			Map.Entry e2 = (Map.Entry)o2;
			int v1 = ((Integer)e1.getValue()).intValue();
			int v2 = ((Integer)e2.getValue()).intValue();
			return v2 - v1;
		}
		return -1;
	}
	
}

