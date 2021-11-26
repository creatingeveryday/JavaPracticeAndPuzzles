package practice.basic;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DateAndTime {

	public static void main(String[] args) {

		Calendar today = Calendar.getInstance();
		
		Date d = new Date();
		
		System.out.println(today.get(Calendar.YEAR));
		System.out.println(today.get(Calendar.MONTH));
		System.out.println(today.get(Calendar.WEEK_OF_YEAR));
		System.out.println(today.get(Calendar.WEEK_OF_MONTH));
		System.out.println(today.get(Calendar.DATE));
		System.out.println(today.get(Calendar.DAY_OF_MONTH));
		System.out.println(today.get(Calendar.DAY_OF_YEAR));
		System.out.println(today.get(Calendar.DAY_OF_WEEK));
		System.out.println(today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println();
		System.out.println(today.get(Calendar.HOUR));
		System.out.println(today.get(Calendar.HOUR_OF_DAY));
		System.out.println(today.get(Calendar.MINUTE));
		System.out.println(today.get(Calendar.SECOND));
		System.out.println(today.get(Calendar.AM_PM));
		System.out.println(today.get(Calendar.ZONE_OFFSET)/(60*60*1000));
		System.out.println(today.getActualMaximum(Calendar.DATE));
		
		
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
		date1.set(2015, 7, 15); //2015-8-15
		date1.set(Calendar.YEAR, 2015);
		date1.set(Calendar.MONTH, 7);
		date1.set(Calendar.DATE, 15);
		
		System.out.println("date1:"+toString(date1));
		System.out.println("date2:"+toString(date2));
		
		long difference = (date2.getTimeInMillis() - date1.getTimeInMillis())/1000;
		System.out.println(difference/(24*60*60));
		
		date1.add(Calendar.DATE, 1);
		System.out.println(toString(date1));
		date1.roll(Calendar.DATE,31);
		System.out.println(toString(date1));
		date1.add(Calendar.DATE, 30);
		System.out.println(toString(date1));
		
		
		
		
		
		
		
		
		
		
//		System.out.println("============================");
//		String str = "사과, 바나나, 참치, 고등어, 냉장고, 태양, 지구";
//		
//		Scanner sc = new Scanner(str);
//		Scanner sc2 = new Scanner(str).useDelimiter(",");
//		System.out.println(sc);
//
//		while(sc.hasNext()) {
//			System.out.println(sc.next());
//			
//		}
//		System.out.println("============================");
//		while(sc2.hasNext()) {
//			System.out.println(sc2.next().trim());
//		}
//		System.out.println("==============구분자테스트=============");
//		StringTokenizer st = new StringTokenizer(str);
//		System.out.println("st.countTokens() : "+st.countTokens());
//		while(st.hasMoreTokens()) {
//			System.out.println(st.nextToken(",").trim());
//		}
//		System.out.println("==============구분자테스트=============");
//		StringTokenizer st2 = new StringTokenizer(str,",");
//		System.out.println("st.countTokens() : "+st2.countTokens());
//		while(st2.hasMoreTokens()) {
//			System.out.println(st2.nextToken().trim());
//		}
//		
//		System.out.println("==============테스트=============");
//		String money = "오십칠만이천백십칠";
//		final String UNIT = "십백천만억조";
//		final String NUM = "영일이삼사오육칠팔구";
//		final long[] UNIT_NUM = {10,100,1000,10000,(long) 1e8,(long)1e12};
//		long result =0;
//		long tempResult = 0;
//		long num = 0;
//		
//		
//		StringTokenizer st3 = new StringTokenizer(money,UNIT,true); //구분자포함.
//		StringTokenizer st4 = new StringTokenizer(money,UNIT,true);
//		StringTokenizer st5 = new StringTokenizer(money,UNIT,true);
//		while(st3.hasMoreTokens()) {
//			System.out.print(st4.nextToken());
//			String token = st3.nextToken();
//			int check = NUM.indexOf(st5.nextToken());
//			
//			if(check==-1) {
//				if("만억조".indexOf(token)==-1) {
//					//십백천단위일경우
//					tempResult += (num!=0 ? num :1) * UNIT_NUM[UNIT.indexOf(token)];
//					System.out.println();
//				}else {
//					//만억조단위일경우 
//					System.out.print(" @");
//					tempResult += num;
//					result += (tempResult!=0 ? tempResult : 1 )* UNIT_NUM[UNIT.indexOf(token)];
//					tempResult = 0;
//				}
//				num = 0; //초기화
//			}else {
//				//숫자일경우
//				num = check;
//			}	
//		}//while 
//		System.out.println();
//		System.out.println(result+tempResult+num);
//		System.out.println("===========================");
		
		
		
	}

	private static String toString(Calendar date) {
		
		return date.get(Calendar.YEAR) + "년 "+(date.get(Calendar.MONTH)+1)+" 월"+ date.get(Calendar.DATE)+" 일"; 
	}

}
