package practice.basic.BOJ;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1330 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		StringTokenizer st = new StringTokenizer(str);
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		if(a>b) {
			System.out.println(">");
		}else if(a==b) {
			System.out.println("==");
		}else {
			System.out.println("<");
		}
		

	}

}
