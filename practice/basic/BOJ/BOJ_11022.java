package practice.basic.BOJ;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_11022 {

	public static void main(String[] args) {
		
		//Case #x: A + B = C
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i = 1; i<=n;i++) {
			
			if(i==1) sc.nextLine();
			
			String str = sc.nextLine().trim();
			StringTokenizer st = new StringTokenizer(str);
			
			int a = 0;
			int b = 0;
			while(st.hasMoreTokens()) {
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
			}
			System.out.println("Case #"+i+": "+a+" + "+b+" = "+(a+b));
			
		}

	}

}
