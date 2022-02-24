package practice.basic.BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		String up = s.toUpperCase();
		
		char al = 'A';
		char zl = 'Z';
		
		int a = (int)al;
		int z = (int)zl;
		
		int[] arr = new int[z-a+1];
		
		for(int j =0; j < up.length(); j++) {
			
			char pointer = up.charAt(j);
			
			for(int i = 0; i< arr.length; i++) {
				
				if(pointer == (char)(i+a)  ) {
					arr[i] += 1;   					
				}		
			}
		}
		
		int max = -1;
		char letter = 'A';
		
		
		for(int i =0; i < 26; i++) {
			if(max < arr[i]) {
				max = arr[i];
				letter = (char)(i+65);
			}else if(arr[i] == max) {
				letter = '?';
			}
		}
		
		
		
//		System.out.println(Arrays.toString(arr));
//		System.out.println(max);
		System.out.println(letter);

	}

}

//문제
//알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
//
//입력
//첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
//
//출력
//첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
//
//예제 입력 1 
//Mississipi
//예제 출력 1 
//?
//예제 입력 2 
//zZa
//예제 출력 2 
//Z
