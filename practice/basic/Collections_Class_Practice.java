package practice.basic;

import java.util.*;


public class Collections_Class_Practice {

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
		

	}

}
