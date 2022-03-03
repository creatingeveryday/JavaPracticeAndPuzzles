package practice.basic.BOJ;

import java.util.Scanner;

public class BOJ_1152 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		
		
		String t = s.trim();
		
		if(t.length()==0) {
			System.out.println(0);
		}else {
			
			String[] arr = t.split(" ");
			System.out.println(arr.length);
		}
		
		

	}

}
