package practice.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapPractice {
	
	static HashMap phoneBook = new HashMap();

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
		
		System.out.println("=======================================");
		
		addPhoneNo("친구","이자바","010-111-1111");
		addPhoneNo("친구","김자바","010-222-2222");
		addPhoneNo("회사","김대리","010-555-5555");
		
		printList();
	}
	
	static void addPhoneNo(String group,String name, String tel) {
		addGroup(group);
		HashMap groupType = (HashMap) phoneBook.get(group); // 그룹이름 키로 찾아와 HashMap 값 저장
		groupType.put(tel, name);
		
	}
	
	static void addGroup(String group) {
		if(!phoneBook.containsKey(group)) {
			phoneBook.put(group, new HashMap());  // ex) {친구={}}
		}
	}
	
	static void printList() {
		
		Set es = phoneBook.entrySet();
		Iterator ei = es.iterator();
		
		while(ei.hasNext()) {
			Map.Entry s1 = (Entry) ei.next();
			Set subSet = ((HashMap)s1.getValue()).entrySet();
			Iterator subIt = subSet.iterator();
			System.out.println(" * "+s1.getKey()+"["+subSet.size()+"]");
			
			while(subIt.hasNext()) {
				Map.Entry s2 = (Entry) subIt.next();
				String telNo = (String) s2.getKey();
				String name = (String) s2.getValue();
				System.out.println(name +"  "+telNo);
				
			}
			System.out.println();
		}
	}

}


