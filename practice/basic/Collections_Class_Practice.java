package practice.basic;

import java.util.*;


public class Collections_Class_Practice {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// Collection 인터페이스는 list와 set인터페이스의 부모인터페이스. 
		
		ArrayList<String> alist = new ArrayList<String>();
		Collection c = new ArrayList();
		
		alist.add("가");
		alist.add("나");
		alist.add("다");
		alist.add("라");
		alist.add("마");
		alist.add("바");
		
		LinkedList linked = new LinkedList(alist);
		System.out.println(alist);
		alist.addAll(alist);
		alist.addAll(2, alist);
		
		Collections.sort(alist);
		System.out.println(alist);
		
		int p = 0;
		for(int i=alist.size()-1;i>=0;i--) {
			alist.remove(i);
			System.out.println(alist);
			++p;
		}
		System.out.println("p: "+p);
		System.out.println(alist);
		
		System.out.println("==================");
		System.out.println(linked);
		System.out.println(linked.remove());
		System.out.println(linked.size());
		System.out.println(linked.peek());
		System.out.println(linked.poll());
		System.out.println(linked);
		System.out.println(linked.poll());
		System.out.println(linked);
		System.out.println(linked.poll());
		System.out.println(linked);
		System.out.println(linked.poll());
		System.out.println(linked);
		System.out.println(linked.poll());
		System.out.println(linked.poll());
		System.out.println(linked.poll());//null
		System.out.println(linked.poll());//null
		
		System.out.println("==================");
		
		Queue pq = new PriorityQueue();
		pq.offer(3);
		pq.offer(1);
		pq.offer(5);
		pq.offer(2);
		pq.offer(4);
		Iterator it = pq.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
			it.remove();
		}
		System.out.println(pq);
		Object obj = null;
		while((obj=pq.poll())!=null) {
			System.out.println(obj);
		}
		
		System.out.println("+===================================+");
		
		int[] arr = {0,1,2,3,4};
		int[] arr2  = Arrays.copyOf(arr, arr.length);
		int[] arr3  = Arrays.copyOf(arr, 9);
		int[] arr4 = new int[10];
		Arrays.setAll(arr4, (i)->(int)(Math.random()*5)+1) ;
		
		
		System.out.println(Arrays.toString(arr4));
		
		Arrays.sort(arr4);
		
		System.out.println(Arrays.toString(arr4));
		int x = Arrays.binarySearch(arr4, 3);
		System.out.println(x);
		
		List list = Arrays.asList(1,2,3,4,5);
		List list2 = new ArrayList(Arrays.asList(1,2,3,4,5));
		list2.add(7);
		System.out.println(list2);
		
		System.out.println("+===================================+");
		
		String[] ars = {"a","v","b","D","DDDD","ddddd","EEEEE","9","0"};
		Arrays.sort(ars,new Rule1());
		System.out.println("ars: "+Arrays.toString(ars));
		
		String[] ars2 = {"a","v","b","D","DDDD","ddddd","EEEEE","9","0"};
		Arrays.sort(ars2, null);
		System.out.println("ars2: "+Arrays.toString(ars2));
		
		Note n1 = new Note(40,"독일");
		Note n3 = new Note(40,"독일");
		Note n2 = new Note(50,"서울") {
			int price =2000;
			
			@Override
			public int get() {
				
				return price*this.page;
			}
		};
		System.out.println(n1.page);
		System.out.println(n2.page);
		System.out.println(n2.get());
		System.out.println(n2.addr);
		
		
		int condition = comp1.compare(n1, n2);
		System.out.println(condition);
		
		Note[] noteArr = new Note[10];
		for(int i =0; i<10;i++) {
			noteArr[i] = new Note((int)((Math.random()*30)+1),"서울시에서");
		}
		//정렬전
		for(int i =0; i<10;i++) {
			System.out.print(noteArr[i].page+" ");
			
		}
		
		Arrays.sort(noteArr,comp1);
		System.out.println();
		//정렬후
		for(int i =0; i<10;i++) {
			System.out.print(noteArr[i].page+" ");
			
		}
		System.out.println();
		System.out.println(n1.equals(n3));
		
		

	} //main 
	
	//익명클래스로 comparator 구현  노트의 페이지수 비교.
	public static Comparator<Note> comp1 = new Comparator<Note>() {

		@Override
		public int compare(Note o1, Note o2) {
			
			return o1.page - o2.page;
		}
		
	};
}

class Rule1 implements Comparator{
	
	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			return c1.compareTo(c2)*-1;
		}
		return -1;
	}
	
}

class Note {
	int page;
	String addr;
	
	public int get() {
		return page;
	}
	
	public Note(int page,String addr) {
		this.page = page;
		this.addr = addr;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Note) {
			Note temp = (Note)obj;
			return this.page==temp.page;
		}
		return false;
		
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(page,addr);
	}
}



