package practice.basic.BOJ;

import java.util.Scanner;

public class BOJ_2798 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String t = sc.nextLine();
		String[] t1 = t.split(" ");
		
		int n = Integer.parseInt(t1[0]);
		
		int target = Integer.parseInt(t1[1]);
		
		
		String card = sc.nextLine();
		String[] cardArr = card.split(" ");
		
		int[] numberArr = new int[n];
		
		for(int i =0; i < n; i++) {
			numberArr[i] = Integer.parseInt(cardArr[i]);
		}
		
		int sum = 0;
		int foundSum = 0;
		int max = 0;
		boolean isFound = false;
		
		for(int i = 0; i < n-2; i++) {
			
			
			
			for(int j = i+1; j < n-1; j++) {
				
				
				
				for(int k = j+1; k < n; k++) {
					
					
					
					sum = numberArr[i] + numberArr[j] + numberArr[k] ; 
					
//					System.out.println(""+i+","+j+","+k);
					
					if(sum == target) {
						isFound = true; 
						foundSum = sum;
					}
//					result < temp && temp < M
					if(max < sum && sum < target ) {
						
						max = sum;
						
						
					}
					
				}//k,
			}//j
		}//i,
		
		
		if(isFound) {
			System.out.println(foundSum);
		}else {
			System.out.println(max);
		}
		

	}

}
//5 21
//5 6 7 8 9