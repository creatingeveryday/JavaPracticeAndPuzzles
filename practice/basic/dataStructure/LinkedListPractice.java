package practice.basic.dataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListPractice {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(new Integer(5));
		list.add(new Integer(4));
		list.add(new Integer(4));
		list.add(new Integer(3));
		list.add(new Integer(2));
		list.add(new Integer(2));
		list.add(new Integer(1));
		list.add(new Integer(0));
		
		List list2 = new LinkedList(list.subList(0, 3));
		list2.add("처");
		list2.add("음");
		
		System.out.println(list.contains(new Integer(1)));
		System.out.println(list.containsAll(list2));
		System.out.println(list.get(0));
		System.out.println(list.indexOf(new Integer(2)));
		System.out.println(list.isEmpty());
		System.out.println(list.lastIndexOf(new Integer(2)));
		System.out.println(list.getLast());
		System.out.println(list.element());
		System.out.println(list.offer(list2));
		System.out.println(list.pollLast());
		list.push(new Integer(-1));
		list.pop();
		System.out.println(list.removeFirstOccurrence(new Integer(4)));
		System.out.println(list.removeLastOccurrence(new Integer(2)));
		
		System.out.println(list);
		System.out.println(list2);
		System.out.println();
		System.out.println("----------------");
		
		ArrayList a = new ArrayList(10000000);
		for(int i=0; i<10000000; i++) {
			a.add(i+"");
		}
		
		LinkedList  l = new LinkedList(a);
		
		long start = System.currentTimeMillis();
		for(int i =0; i <100000;i++) {
			l.add(100,"x");
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
	}

}
