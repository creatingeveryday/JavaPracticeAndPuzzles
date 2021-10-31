package practice.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueue {

	public static void main(String[] args) {
		Stack st = new Stack();
		st.push(0);
		st.push(1);
		st.push(2);
		
		Queue q = new LinkedList();
		q.offer(0);
		q.offer(1);
		q.offer(2);
		q.offer(3);
		
		
		while(!st.empty()) {
			System.out.println(st.pop());
		}
		
		System.out.println("--------");
		
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}

	}

}
