package practice.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class AddressMangement {

	public static void main(String[] args) {
		Map m = new HashMap();
		m.put("1", 1);
		m.put("8", 8);
		m.put("3", 5);
		m.put("4", 3);
		m.put("6", 5);
		ArrayList alist = new ArrayList();
		
		Iterator cc = m.entrySet().iterator();
		Iterator cc2 = m.keySet().iterator();
		while(cc.hasNext()) {
			System.out.print(" , "+cc.next());
			System.out.print(" , "+cc2.next());
		}
		System.out.println();
		System.out.println(m);
		
		
		Collection l = m.values();
		Set s = m.keySet();
		System.out.println("set값 "+s);
		System.out.println("key값 "+l);
		l.size();
		
		ArrayList al = new ArrayList(l);
		LinkedList link = new LinkedList(l);
		
		al.sort(null);
		System.out.println("정렬후 : "+al);
		System.out.println("linkedlist : "+link);
		
		Set s1 = new HashSet(l);
		System.out.println(s1);

	}

}
