package practice.basic.BOJ;

import java.util.Scanner;

public class BOJ_10870 {
	
	public static int loop(int n) {
		
		if(n == 0) {   //0번째
			return 0;
		}
		
		if(n ==1) {    //첫번쨰
			return 1;
		}
		
		return loop(n-2)+loop(n-1);
		
		//n번째 피보나치수는?
		
//		1 1 2 3 5 8 13 21 34 55
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int al = loop(sc.nextInt());
		
		System.out.println(al);

	}

}
