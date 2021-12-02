package practice.basic.BOJ;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_11021 {

	public static void main(String[] args) {
		
		//두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		//Case #1: 2
		String s = null;
		for(int i=0; i<x;i++) {
			if(i==0) sc.nextLine();
			
			String d = sc.nextLine().trim();
			StringTokenizer st = new StringTokenizer(d);
			
			int a = 0;
			int b = 0;
			while(st.hasMoreTokens()) {
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
			}
			s = "Case #"+(i+1)+": "+(a+b);
			System.out.println(s);
			
			
		}
		
		
	}

}
