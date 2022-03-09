package practice.basic.BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2750 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt((sc.nextLine()));
		
		int[] arr = new int[n];
		for(int i =0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(Arrays.toString(arr));
		
		for(int i =0; i < n-1; i++) {
			for(int j = i; j < n-1; j++) {
				
				 if(arr[i] > arr[j+1]) {
					 int temp = arr[i];
					 arr[i] = arr[j+1];
					 arr[j+1] = temp;
				 }
				
			}
			
			
		}
		System.out.println(Arrays.toString(arr));
		
		for(int i : arr) {
			System.out.println(i);
		}
		

	}

}
