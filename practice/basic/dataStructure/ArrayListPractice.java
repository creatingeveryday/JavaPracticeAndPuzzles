package practice.basic.dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class ArrayListPractice {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		
		list.add("5");
		list.add("4");
		
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
		Iterator iter = list2.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next());
			System.out.println("이터레이터로 읽었음.");
		}
		iter = list2.iterator();  // 다시 쓸때는 iterator를 초기화해준후 사용해야 함. (hasNext 메서드가 false 리턴 )
		while(iter.hasNext()) {
			System.out.print(iter.next());
			System.out.print("두번째 시도 ");
			System.out.println("이터레이터로 읽었음.");
		}
		ListIterator it = list2.listIterator();
		while(it.hasNext()) {
			System.out.print("listIterator ");
			System.out.println(it.next());
		}
		while(it.hasPrevious()) {
			System.out.print("listIterator ");
			System.out.println(it.previous());
		}
		ArrayList original = new ArrayList(10); 
		ArrayList copy = new ArrayList(10);
		for(int i = 0; i<10;i++) {
			original.add(i+"");
		}
		System.out.println("오리지널출력"+original);
		Iterator lto = original.iterator();
		while(lto.hasNext()) {
			copy.add(lto.next());
			lto.remove();
		}
		System.out.println("오리지널출력"+original);
		System.out.println("카피배열"+copy);
		
		
		System.out.println(list2);
		Collections.sort(list2);
		System.out.println(list2);
		System.out.println(list2.indexOf(new Integer(2)));
	
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
