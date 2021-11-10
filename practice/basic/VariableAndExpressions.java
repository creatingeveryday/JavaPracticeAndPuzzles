package practice.basic;

public class VariableAndExpressions {

	public static void main(String[] args) {
		
		//특수문자 다루기
		System.out.println('\'');
		System.out.println("abc\t123\b456");
		System.out.println('\n');
		System.out.println("\"hello\"");
		System.out.println("abc\r");
		System.out.println("c:\\");
		
		//char 
		char ch = 'A';
		int uni= ch;
		System.out.println(uni);
		
		//값의 타입에 따라 출력 값 변화. 
		short s = 65;
		System.out.println(ch);  // A
		System.out.println(s); 	 // 65
		
		System.out.println("---------------");
		//overflow_p67
		short sMin = -32768;
		short sMax = 32767;
		char cMin = 0;
		char cMax = 65535;
		
		System.out.println(sMin);
		System.out.println((short)(sMin - 1));
		System.out.println((short)(sMax + 1));
		
		System.out.println(cMin);
		System.out.println((int)(++cMax));
		System.out.println((int)(--cMin));
		
		
	}

}
