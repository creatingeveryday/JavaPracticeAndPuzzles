package practice.basic;

import java.util.StringTokenizer;
import java.util.function.BinaryOperator;

public class operator {

	public static void main(String[] args) {
		float f = 3.67f;
		f++;
		System.out.println(f++);
		System.out.println(++f);
		System.out.println(f);
		
		int a = 1_000_000;
		int b = 2_000_000;
		long c = (long)a * b;
		System.out.println(c);
		
		char c1 = 'a';
		//char c2 = c1+1; // 변수의 덧셈연산은 형변환필요.  컴파일러가 미리 계산할 수 없음. 변수에 어떤 값이 올지 모르기 때문이다. 
		char c3 = 'a'+1;  // 상수와 리터럴과의 연산은 컴파일러가 미리 계산해서 결과 대체. 덧셈연산이 수행되지 않음. 
		int sec = 60 * 60 * 24 ; //풀어써도 컴파일러가 미리 계산하므로 실행시 성능차이 없고 가독성과 유지보수하기 좋음. 
		
		char cc = 'a';
		for(int i =0; i<26; i++) {
			System.out.print(cc++);
		}
		char cc1 = 'A';
		for(int i =0; i<26; i++) {
			System.out.print(cc1++);
		}
		char cc2 = '0';
		for(int i =0; i<10; i++) {
			System.out.print(cc2++);
		}
		System.out.println();
		char ca1 = 'a';
		char ca2 = (char)(ca1-32);
		System.out.println(ca2);
		char ca11 = 'A';
		char ca22 = (char)(ca11+32);
		System.out.println(ca22);
		
		double pi = 3.141592;
		double shortPi = Math.round(pi*1000)/1000.0;
		System.out.println(shortPi);
		
		System.out.println(0.1==0.1f);
		float f1 = 0.1f;
		double d = 0.1;
		double d2 = (double)f1;
		float f2 = (float)d; //비교를 위해 double형을 float 형으로 변환 
		System.out.printf("%19.17f%n",f1);
		System.out.printf("%19.17f%n",d);
		System.out.printf("%19.17f%n",d2);
		System.out.printf("%19.17f%n",f2);
		System.out.println(f1==d);
		System.out.println(f1==d2);
		System.out.println(d==d2);
		System.out.println(f2==f1); // true
		
		System.out.println("대소문자구분없이 내용비교 : "+"abc".equalsIgnoreCase("ABC"));
		int t =3, r=0;
		System.out.println(t!=0||++r!=0); //효율적인 연산 (short circuit evaluation) 
		System.out.println(r);
		
		int x = 13;
		System.out.println(10<x && x<20);
		char x1 = 'a';
		System.out.println(!(x1==' '||x1=='\t'));
		char x2 = 'x';
		System.out.println(x2=='x'||x2=='X');
		int year = 2020;
		System.out.println((year%400==0||year%4==0) && year%100!=0);
		String str ="yes";
		System.out.println(str.equals("yes"));
		int sum = 0;
		for(int i=1; i<=20;i++) {
			if(!(i%2==0||i%3==0)) {
				sum +=i;
			}
		}
		System.out.println(sum);
		int sum2 = 0;
		for(int i = 1; i<=10;i++ ) {
			for(int j = i;j>=1;j--) {
				sum2 +=j;
			}
		}
		System.out.println(sum2);
		int sum3 =0;
		int s1 = 0;
		while(true) {
			s1++;
			if(s1%2!=0)
				sum3+=s1;
			else
				sum3+= -(s1);
			
			if(sum3>=100)
				break;
		}
		System.out.println(s1);
		System.out.println("----------------");
		int xb = 0xAB;
		int yb = 0xF;
		System.out.printf("%d%n",xb);
		System.out.printf("%10s%n",Integer.toBinaryString(xb));
		System.out.printf("%10s%n",Integer.toBinaryString(yb));
		
		int xb2 = xb|yb;
		System.out.printf("%10s%n",Integer.toBinaryString(xb2));
		
		int xb3 = xb&yb;
		System.out.printf("%10s%n",Integer.toBinaryString(xb3));
		
		int xb4 = xb^yb;
		System.out.printf("%10s%n",Integer.toBinaryString(xb4));
		int xb5 = xb4^yb;
		System.out.printf("%10s%n",Integer.toBinaryString(xb5));
		
	}

}
