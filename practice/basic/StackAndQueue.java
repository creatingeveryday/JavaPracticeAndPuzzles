package practice.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueue {
	
	public static Stack back = new Stack();
	public static Stack forward = new Stack();
	
	public static void main(String[] args) {
		
		goURL("1.밴드");
		goURL("2.유튭");
		goURL("3.다찾아");
		goURL("4.음악들어");
		goURL("5.뉴스모음사이트");
		
		printStatus();
		
		goBack();
		System.out.println("---뒤로 버튼 누른후---");
		printStatus();
		
		goBack();
		System.out.println("---뒤로 버튼 누른후---");
		printStatus();
		
		goForward();
		System.out.println("---앞으로 버튼 누른후---");
		printStatus();
		
		goForward();
		System.out.println("---앞으로 버튼 누른후---");
		printStatus();
		
		goURL("포스팃");
		System.out.println("---새주소이동 버튼 누른후---");
		printStatus();
		
		
		System.out.println("---최초화면으로 이동 ---");
		int backSize = back.size();
		for(int i =0; i < backSize-1 ;i++) {//최초화면으로 이동 
			goBack();
//			printStatus();
		}
		
		printStatus();
		
		
		
		
//		Stack st = new Stack();
//		st.push("0");
//		st.push("1");
//		st.push("2");
//		
//		Queue q = new LinkedList();
//		q.offer("0");
//		q.offer("1");
//		q.offer("2");
//		q.offer("3");
//		
//		
//		while(!st.empty()) {
//			System.out.println(st.pop());
//		}
//		
//		System.out.println("--------");
//		
//		while(!q.isEmpty()) {
//			System.out.println(q.poll());
//		}
//		
//		System.out.println("---------------------");
		
		
		

	}

	public static void goForward() {
		if(!forward.empty()) {
			back.push(forward.pop());
		}
		
	}

	public static void goBack() {
		if(!back.empty()) {
			forward.push(back.pop());
		}
		
		
	}

	public static void printStatus() {
		System.out.println("back : "+ back);
		System.out.println("forward : "+forward);
		System.out.println("현재 화면 위치는 "+ back.peek()+" 입니다.");
		System.out.println();
	}

	public static void goURL(String url) {
		back.push(url);
		if(!forward.empty()) {
			forward.clear();
		}
	}

}
