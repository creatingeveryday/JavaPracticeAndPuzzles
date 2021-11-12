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
		
		
		System.out.println((short)(sMin - 1));
		System.out.println((short)(sMax + 1));
		
		char cMin = 0;
		char cMax = 65535;
		
		System.out.println((int)(++cMax));
		System.out.println((int)(--cMin));
		
		int sam = 300;
		int sam2 = -300;
		System.out.println((byte)sam); //44 
		System.out.println(Integer.toBinaryString(sam));
		System.out.println(Integer.toBinaryString(sam2));
		
		char a = '7';
		int ab = 7;
		char abb = (char) (ab + '0');
		System.out.println(a);
		System.out.println(ab);
		
		int aa = abb-'0';
		System.out.println(aa); 
		
		String s1 ="h";
		char s2 = s1.charAt(0);
		String s3 = String.valueOf(s2);
		String s4 = Character.toString(s2);
		
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
//		public char charAt(int index) {
//	        if ((index < 0) || (index >= value.length)) {
//	            throw new StringIndexOutOfBoundsException(index);
//	        }
//	        return value[index];
//	    }
		
		byte by = (byte)7;
		byte by2 = (byte)10;
		short sh = (short) (by + by2);
		System.out.println(sh);
		int intege$_$ = sh +5;
		System.out.println(intege$_$);
		long ong = intege$_$ + 40;
		System.out.println(ong);
		float oat = ong + 33;
		System.out.println(oat);
		double ble = oat +88;
		System.out.println(ble);
		
		
	}

}
