package practice.basic.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2751 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] arr = new boolean[2000001];
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[Integer.parseInt(br.readLine()) + 1000000] = true;
		}
		
		for(int i =0; i< arr.length; i++) {
			if(arr[i]) {
				sb.append((i-1000000)).append("\n");
			}
		}
		System.out.println(sb);
	}
	
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		StringBuilder sb = new StringBuilder();
//		
//		int n = sc.nextInt();
//		
//		int i = 0 ;
//		
//		ArrayList arr = new ArrayList();
//		
//		while(i < n) {
//			arr.add(sc.nextInt());
//			i++;
//		}
//		
//		Collections.sort(arr);
//		
//		
//		arr.forEach(num -> sb.append(num +"\n"));
//		System.out.println(sb);
//		
//		
//		
//		
//	}

}
