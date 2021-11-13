package practice.basic;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Arrays_class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list1 =Arrays.asList("홍길동","김자바");
		System.out.println(list1.get(0));
		List<Integer> list2 = Arrays.asList(3,6,9,5,1);
		System.out.println(list2.get(2));
		
		
		
		//list2전체 출력하기
		//for문 
		//향상된 for 문
		//iterator 사용
		
		int[] arr = {0,1,2,3,4};
		int[] arr2 = Arrays.copyOf(arr, 7);
		for (int a : arr2) {
			System.out.print(a+" ");
		}
		System.out.println();
		int[] arr3 = Arrays.copyOfRange(arr, 1, 3);
		for (int a : arr3) {
			System.out.print(a+" ");
		}
		System.out.println();
		int[] arr4 = new int[5];
		Arrays.setAll(arr4, (i) -> (int)(Math.random()*5)+1);
		for (int a : arr4) {
			System.out.print(a+" ");
		}
		System.out.println();
		
		System.out.println("----comparator and comparable interface------");
		String[] strArr = {"cat","Dog","lion","tiger"};
		Arrays.sort(strArr);
		System.out.println("기본정렬 :"+Arrays.toString(strArr)); //comparable 구현에 의한 정렬
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER );
		System.out.println("대소문자 :"+Arrays.toString(strArr));
		Arrays.sort(strArr, new Descending());  //역순으로 정렬
		System.out.println("역순정렬 :"+Arrays.toString(strArr));
		
		System.out.println("=========HashSet===================");
		Object[] objArr = {"1",new Integer(1), "2","2","3","3","4","4","4"};
		Set set = new HashSet();
		for(int i = 0; i < objArr.length;i++) {
			set.add(objArr[i]);
//			System.out.println(set.add(objArr[i]));
		}
		System.out.println("HashSet : "+set);
		System.out.println();
//		Set set2 = new HashSet();
		Set set2 = new TreeSet(); //TreeSet 컬렉션 사용시 정렬되어 저장됨. 
		for(int i =0; set2.size() < 6 ;i++) {
			int num = (int)(Math.random()*45)+1;
			set2.add(num);
		}
		System.out.println("로또"+set2);
		List list5 = new LinkedList(set2);
		Collections.sort(list5); //정렬은 순서가 유지되어야함을 의미한다.
		System.out.println(list5);
		
		System.out.println("--------------");
		
		HashSet hset = new HashSet();
		hset.add("abc");
		hset.add("abc");
		hset.add(new Person("David",10));
		hset.add(new Person("David",10)); //두 인스턴스를 같은 것으로 인식하게 하려면 equals() 와 hashCode()를 오버라이딩 해야함.
		
		System.out.println("hset:"+hset);
		
		System.out.println("--------------");
		HashSet setA = new HashSet();
		HashSet setB = new HashSet();
		HashSet setHap = new HashSet();
		HashSet setKyo = new HashSet();
		HashSet setCha = new HashSet();
		
		setA.add(1); setA.add(2); setA.add(3);
		setA.add(4); setA.add(5); setA.add(6);
		setB.add(4); setB.add(5); setB.add(6);
		setB.add(7); setB.add(8); setB.add(9);
		
		System.out.println("A : "+setA);
		System.out.println("B : "+setB);
		//교집합
		Iterator i = setB.iterator();
		while(i.hasNext()) {
			Object temp = i.next();
			if(setA.contains(temp)) {
				setKyo.add(temp);
			}
		}
		//합집합
		i = setA.iterator();
		while(i.hasNext()) {
			setHap.add(i.next());
		}
		i = setB.iterator();
		while(i.hasNext()) {
			setHap.add(i.next());
		}
		
		//차집합
		i = setA.iterator();
		while(i.hasNext()) {			
			Object temp = i.next();
			setCha.add(temp);
			
			if(setB.contains(temp)) {
				setCha.remove(temp);
			}
			
		}
//		while(i.hasNext()) {
//			Object temp = i.next();
//			if(!setB.contains(temp)) {
//				setCha.add(temp);
//			}
//			
//		}
		
		System.out.println("A ∩ B :"+setKyo);
		System.out.println("A ∪   B :"+setHap);
		System.out.println("A - B :"+setCha);
	
		HashSet alpa = new HashSet(setA);
//		alpa.retainAll(setB); 교집합  공통된 요소만 남기고 삭제.
//		alpa.removeAll(setB); 차집합  공통된 요소를 삭제. 
//		alpa.addAll(setB); 합집합   setB의 모든 요소만 추가. 중복은 제외됨. 
		System.out.println(alpa);
	}

}

class Person {
	int age;
	String name;
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return name+":"+age;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person temp = (Person)obj;
			return age == temp.age && name.equals(temp.name);
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		
//		return (name+age).hashCode();
		return Objects.hash(name);
	}
}

class Descending implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable ) {
			Comparable c1 = (Comparable) o1;
			Comparable c2 = (Comparable) o2;
			return c1.compareTo(c2) * -1;
		}
		
		return -1;
	}
	
}
