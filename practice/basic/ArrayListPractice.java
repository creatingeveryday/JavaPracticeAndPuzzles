package practice.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListPractice {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		
		list.add("15");
		list.add(0, "a");
		
		list.add("c");
		list.add("b");
		list.add("      ");
		
		ArrayList list2 = new ArrayList();
		list2.add(5);
		list2.add(4);
		list2.add(3);
		list2.remove(2);  // 인덱스가 2인 객체 삭제 
		list2.remove(new Integer(5));  // 5를 삭제 
		System.out.println(list2);
		Collections.sort(list2);
		System.out.println(list2);
		System.out.println(list2.indexOf(4));
	
		for(int i = list2.size()-1;i>=0;i--) {
			list2.remove(i);
		}
		System.out.println(list2);
		System.out.println(list.contains(list2));
		//검색,탐색
		System.out.println("검색결과:"+list.indexOf("15"));
		System.out.println("검색결과:"+list.indexOf("b"));
		System.out.println(list.isEmpty());
		System.out.println(list.contains("b"));
		
		
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

	}

}
