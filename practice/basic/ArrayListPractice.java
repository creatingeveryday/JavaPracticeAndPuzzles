package practice.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class ArrayListPractice {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		
		list.add("5");
		list.add(1,"4");
		
		list.add("3");
		list.add("2");
		list.add("1");
		
		ArrayList list2 = new ArrayList();
		list2.add("5");
		list2.add("4");
		list2.add("3");
		list2.add("2");
		list2.add("1");
//		list2.remove(2);  // 인덱스가 2인 객체 삭제 
//		list2.remove(new Integer(5));  // 5를 삭제 
		
		System.out.println(list2);
		Collections.sort(list2);
		System.out.println(list2);
		System.out.println(list2.indexOf(4));
	
//		for(int i = list2.size()-1;i>=0;i--) {
//			list2.remove(i);
//		}
		System.out.println(list2);
		System.out.println(list.contains(list2));
		//검색,탐색
//		System.out.println("검색결과:"+list.indexOf("15"));
//		System.out.println("검색결과:"+list.indexOf("b"));
		System.out.println(list.isEmpty());
//		System.out.println(list.contains("b"));
		
		
		//길이 
		System.out.println(list.size());
		System.out.println(list);
		//정렬
		Collections.sort(list);
		
		// 출력
		System.out.println(list);
		System.out.println(list.get(0));
		
		Object[] a = list.toArray();
		System.out.println(Arrays.toString(a));
		
		for(Object b : list) {
			System.out.print(b);
		}
		System.out.println();
		System.out.println("------------------");
		
		list.clear();
		list2.clear();
		
		list.add(new Integer(5));
		list.add(new Integer(4));
		list.add(new Integer(3));
		list.add(new Integer(2));
		list.add(new Integer(1));
		
		list2.add(new Integer(5));
		list2.add(new Integer(4));
		list2.add(new Integer(3));
		
		System.out.println("list컬렉션은 list2컬렉션의 모든요소를 포함하는가? "+list.containsAll(list2));
		System.out.println("list2컬렉션은 list컬렉션의 모든 요소를 포함하는가? "+list2.containsAll(list));
		System.out.println("문자 5를 포함하는가? "+list.contains("5"));
		System.out.println("정수 5를 포함하는가? "+list.contains(5));
		
		list2.add("A");
		list2.add("B");
		list2.add("C");
		
		list2.set(4, "BB");
		
		List list5 = list2;
		
		
		System.out.println(list.retainAll(list2)); // list2 컬렉션과의 교집합만 list 컬렉션으로 변경
		
		for(int i = list2.size()-1; i >= 0; i--) {
			if(list.contains(list2.get(i))) {
				list2.remove(i);
			}
		}
		
		System.out.println(list);
		System.out.println(list2);
		
		System.out.println("-----------------");
		int limit = 10;
		String source ="0123456789jfko34jf3489r2hjr289fj2f8923hjf2uf9h24f8923h9fh2978fh4789fh9348fh98pfh983hjf93n9348ht3hg89fhg8934hf8934hf8943hf9843hf9834fh8934h";
		int length = source.length();
		
		ArrayList list3 = new ArrayList(length/limit + 10);
		
		for(int i = 0; i < length; i+=limit) {
			if(i+limit < length) {
				list.add(source.substring(i, i+limit));
			} else {
				list.add(source.substring(i));
			}
		}
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("--------------------------");
		
		Vector v = new Vector(7);
		v.add("1");
		v.add("2");
		v.add("3");
		v.add("4");
		v.add("5");
		v.trimToSize();
		v.ensureCapacity(10);
		v.setSize(7);
		
		v.clear();
		
		System.out.println(v);
		System.out.println(v.size());
		System.out.println(v.capacity());
		

	}

}
