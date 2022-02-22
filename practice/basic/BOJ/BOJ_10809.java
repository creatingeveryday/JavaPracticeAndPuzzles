package practice.basic.BOJ;

import java.util.Scanner;

public class BOJ_10809 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();

		String a = "a";
		String z = "z";
		int aInt = (int) a.charAt(0);
		int zInt = (int) z.charAt(0);
		
		
		String sys = "";
		
		for(int j = aInt; j <= zInt; j++) {
			int p = s.indexOf(String.valueOf(Character.valueOf( (char) j)));
			sys += ""+p+" ";
		}

		
		System.out.println(sys.trim());
		
		

	}

}
