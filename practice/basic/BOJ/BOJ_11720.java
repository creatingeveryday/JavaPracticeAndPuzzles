package practice.basic.BOJ;

import java.util.Scanner;

public class BOJ_11720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String s = sc.next();
		
		int sum = 0;
		
		for(int i =0; i< s.length();i++) {
			String a = String.valueOf(s.charAt(i));
			sum += Integer.parseInt(a);
		}
		System.out.println(sum);
	}

}
