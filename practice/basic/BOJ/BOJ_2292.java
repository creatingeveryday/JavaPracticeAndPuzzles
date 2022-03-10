package practice.basic.BOJ;

import java.util.Scanner;

public class BOJ_2292 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int count = 1;
		int i = 2; 
		
		if(n ==1 ) {
			
			count =1;
			System.out.print(count);
			
		}else {
			
			while (i <= n) {	
				i = i + (6 * count);	
				count++;	
			}
			
			System.out.print(count);
		}
		

	}

}
