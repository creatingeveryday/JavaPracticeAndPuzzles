package practice.basic.BOJ;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_10951 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

		while (sc.hasNextInt()) {

			StringBuffer sbf = new StringBuffer(sc.nextLine());

			StringTokenizer st = new StringTokenizer(sbf.toString());

			if (st.hasMoreTokens()) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				System.out.println(a + b);
			}

		}

	}

}
