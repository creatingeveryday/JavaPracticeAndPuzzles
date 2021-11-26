package practice.basic.dataStructure;

import java.util.Objects;

public class BasicAlgorithm {

	public static void main(String[] args) {
		npira(9);
		

	}
	
	static void npira(int a) {
				// i  j  k 
		//000100   1  1  3
		//002220   2  3  2
		//033333   3  5  1
		for(int i = 1; i <= a; i++) {
			for(int k = 0; k < a-i; k++) {
				System.out.print(" ");
			}
			for(int j = 1; j <= (2*i)-1;j++) {
				System.out.print(i);
				
			}
			System.out.println();
		}
	}
	
	
	


}


