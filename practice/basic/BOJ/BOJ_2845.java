package practice.basic.BOJ;

import java.util.Scanner;

public class BOJ_2845 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String n = sc.nextLine();
		String guess = sc.nextLine();
		sc.close();
		
		String[] sum = n.split(" ");
		String[] guessArr = guess.split(" ");
		
		long man = 1;
		
		for(String i : sum) {
			man *= Long.parseLong(i);
		}
		
		
		
		String result = "";
		for(String i : guessArr) {
			result +=( Long.parseLong(i) - man)+" ";
		}
		
		System.out.println(result);
		

	}

}
