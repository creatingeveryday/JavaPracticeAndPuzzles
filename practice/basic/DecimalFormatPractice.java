package practice.basic;

import java.text.DecimalFormat;
import java.text.ParseException;

public class DecimalFormatPractice {

	public static void main(String[] args) {
		double number = 1234567.89;
		
		DecimalFormat df = new DecimalFormat("0");
		System.out.println(df.format(number));
		DecimalFormat df2 = new DecimalFormat("0000000000.0000");
		System.out.println(df2.format(number));
		DecimalFormat df3 = new DecimalFormat("######.#####");
		System.out.println(df3.format(number));
		DecimalFormat df4 = new DecimalFormat(",000.00000");
		System.out.println(df4.format(number));
		DecimalFormat df5 = new DecimalFormat("0000.00000E0");
		System.out.println(df5.format(number));
		DecimalFormat df6 = new DecimalFormat("######.##E0");
		System.out.println(df6.format(number));
		
		System.out.println("==============================");
		DecimalFormat df7 = new DecimalFormat("#,###.##");
		DecimalFormat df8 = new DecimalFormat("#,###E0");
		
		try {
			Number num = df7.parse("1,234,567.89");
			double d = num.doubleValue();
			System.out.println(d);
			System.out.println(df8.format(num));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		

	}

}
