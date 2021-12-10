package practice.basic.BOJ;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_10952 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			String str = sc.nextLine();
			StringTokenizer st = new StringTokenizer(str);
			
			int a = 0;
			int b = 0;
			
			while(st.hasMoreTokens()) {
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
			}
				
			if(a==0 && b==0) {
				break;
			}
			
			System.out.println(a+b);
			sc.close();
		}

	}

}
