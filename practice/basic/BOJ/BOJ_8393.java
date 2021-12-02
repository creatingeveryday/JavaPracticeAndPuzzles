package practice.basic.BOJ;

import java.util.Scanner;

public class BOJ_8393 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1부터 n까지 합을구하는 프로그램
		int k=0;
		k = sc.nextInt();
		int sum = 0;
		for(int i=1;i<=k;i++) {
			sum +=i;
		}
		System.out.println(sum);
	}

}
