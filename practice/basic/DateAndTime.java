package practice.basic;

import java.text.ChoiceFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

class DayAfter3Days implements TemporalAdjuster {

	@Override  //
	public Temporal adjustInto(Temporal temporal) {
		
		return temporal.plus(3, ChronoUnit.DAYS);
	}
	
}

public class DateAndTime {

	public static void main(String[] args) {
		
		LocalDate today2 = LocalDate.now();
		LocalDate date1 = LocalDate.of(2015, 12, 31);
		LocalTime time1 = LocalTime.of(12, 34,56);
		
		LocalDate dateParse = LocalDate.parse("2016-07-07",DateTimeFormatter.ISO_LOCAL_DATE);
		System.out.println(dateParse);
		
		
		
		String yyyymmdd = DateTimeFormatter.ISO_LOCAL_DATE.format(today2);
		String yyyymmdd2 = today2.format(DateTimeFormatter.ISO_LOCAL_DATE);
		System.out.println(yyyymmdd);  // "2021-11-30"
		System.out.println(yyyymmdd2);  // "2021-11-30"
		
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		DateTimeFormatter mFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		String shortFormat = formatter.format(LocalDate.now());
		String mediumFormat = mFormatter.format(LocalDate.now());
		System.out.println(shortFormat);  //21. 11. 30
		System.out.println(mediumFormat); // 2021. 11. 30
		
		
		Period pe = Period.between(date1, today2);
		System.out.println(pe); //P 5Y 10M 29D
		System.out.println("pe.toTotalMonths() :  "+pe.toTotalMonths()); //??? ????????? ?????????.
		
		boolean sameday = Period.between(date1, today2).isZero();
		System.out.println(sameday); //false
		LocalTime tnow = LocalTime.now();
		Duration du = Duration.between(time1, tnow);
		System.out.println(du);
		LocalTime tempTime = LocalTime.of(0, 0).plusSeconds(du.getSeconds());
		int hour = tempTime.getHour();
		int minute = tempTime.getMinute();
		int second = tempTime.getSecond();
		System.out.println(hour+" "+minute+" "+second);
		
		
		System.out.println("du.toDays() : "+du.toDays());
		System.out.println("du.toHours() : "+du.toHours());
		
		LocalDateTime dt1 = LocalDateTime.of(date1, time1);
		
		ZoneId zid1 = ZoneId.of("Asia/Seoul");
		ZonedDateTime zdt1 = dt1.atZone(zid1);
		System.out.println(zdt1.getZone().getId()); //	Asia/Seoul
		
		ZonedDateTime seoulTime = ZonedDateTime.now();
		System.out.println(seoulTime);
		ZoneId nyId = ZoneId.of("America/New_York");
		ZonedDateTime nyTime = ZonedDateTime.now().withZoneSameInstant(nyId);
		System.out.println(nyTime);
		
		OffsetDateTime odt = zdt1.toOffsetDateTime();
		System.out.println(odt);
		
		
		
		System.out.println("=======================");
		
//		Set <String> a = ZoneId.getAvailableZoneIds();
//		Iterator<String> i2 = a.iterator();
//		while(i2.hasNext()) {
//			System.out.println(i2.next());
//		}
//		//    Asia/Seoul
		
		LocalDateTime dt = LocalDateTime.of(2020, 5, 5, 12, 10);
		System.out.println("dt : "+ dt);
		ZoneId zid = ZoneId.of("Asia/Seoul");
		ZonedDateTime zdt = dt.atZone(zid);
		System.out.println(zdt);
		
		ZonedDateTime nyTime2 = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("America/New_York"));
		System.out.println(nyTime2);
		
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		OffsetDateTime ofd = OffsetDateTime.of(ld, lt, ZoneOffset.of("+9"));
		System.out.println(ofd);
		
		System.out.println("==========================================");
		LocalDate date = LocalDate.now();
		System.out.println(date);
		LocalTime time = LocalTime.now();
		System.out.println(time);
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
		
		date = LocalDate.of(2002, 7, 7);
		date = date.withYear(2021);  //????????? ???????????? ???????????? ?????? ????????? ????????? ???????????? ????????????. 
		date = date.withDayOfYear(365);
		time = LocalTime.of(3, 33, 33, 777_777_777);
		
		dateTime = LocalDateTime.of(date, time);
		System.out.println(dateTime);
		
		int minute2 = time.get(ChronoField.MINUTE_OF_HOUR);
		System.out.println(minute2);
		LocalDateTime tomorrow = dateTime.plus(1, ChronoUnit.DAYS);
		System.out.println(tomorrow);
		time = time.truncatedTo(ChronoUnit.HOURS);
		System.out.println(time);//3:00
		
		System.out.println(date.getMonth());
		System.out.println(date.getMonth().getValue());
		System.out.println(ChronoField.HOUR_OF_DAY.range());
		
		Instant now = Instant.now();
		now.getEpochSecond();
		
		Date date3 = new Date();
		date3 = date3.from(now);
		Instant i3 = date3.toInstant();
		
		
		System.out.println("=================================");
		// ?????????????????? ????????? ???????????? ?????? ??? ??????.
		Object[] arguments = {"?????????","010-1111-2222","30","08-09","????????????"};
		
		String msg = "Name:{0} Name::::{0} \nTel:{1} \nAge:{2} \nBirth:{3} \nNation:{4}";
		
		String result = MessageFormat.format(msg, arguments);
		System.out.println(result);
		System.out.println("====================================");
		
		String tableName = "CUST_INFO";
		
		String msg2 = "INSERT INTO "+tableName+" VALUES (''{0}'',''{1}'',''{2}'',''{3}'',''{4}'')";
		
		Object[][] arguments2 = {
				{"?????????","010-1111-2222","30","08-09","????????????"},
				{"??????","010-3333-5555","25","01-01","??????"},
		};
		
		for(int i=0;i<arguments2.length;i++) {
			result = MessageFormat.format(msg2, arguments2[i]);
			System.out.println(result);
		}
		
		System.out.println("===================================");
		
		String[] data2 = {
				"INSERT INTO CUST_INFO VALUES ('?????????','010-1111-2222','30','08-09','????????????')",
				"INSERT INTO CUST_INFO VALUES ('??????','010-3333-5555','25','01-01','??????')",
		};		
		
		String pattern2 = "INSERT INTO CUST_INFO VALUES ({0},{1},{2},{3},{4})";
		
		MessageFormat mff = new MessageFormat(pattern2);
		
		for(int i =0;i<data2.length;i++) {
			Object[] o=null;
			try {
				o = mff.parse(data2[i]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int j=0;j< o.length;j++) {
				System.out.print(o[j]+", ");
			}
			System.out.println();
		}
		
		
//		double[] limits = {50,60,70,85,95,98};
//		String[] grades = {"D","C","C+","B","A","A+"};
//		int[] scores= new int[200];
//		for(int i=0; i<scores.length; i++) {
//			scores[i] = (int)(Math.random()*100)+1;
//		}
//		System.out.println(Arrays.toString(scores));
//		
//		String pattern = "60#D|70#C|80<B|90#A";
//		ChoiceFormat form = new ChoiceFormat(limits,grades);
//		ChoiceFormat form2 = new ChoiceFormat(pattern);
//		
//		for(int i=0; i<scores.length;i++) {
//			System.out.print(" "+scores[i]+":"+form.format(scores[i]));
//			if(i%10==0) {
//				System.out.println();
//			}
//		}
//		System.out.println("========================================");
//		for(int i=0; i<scores.length;i++) {
//			System.out.print(" "+scores[i]+":"+form2.format(scores[i]));
//			if(i%10==0) {
//				System.out.println();
//			}
//		}
		
		
		
		
		
//		Calendar cal = Calendar.getInstance();
//		cal.set(2021, 2, 2);
//		Date date = cal.getTime();
//		
//		System.out.println(cal.get(Calendar.YEAR));
//		Date today = new Date();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat df2 = new SimpleDateFormat("yyyy??? MM??? dd???");
//		System.out.println(df.format(today));
//		
//		System.out.println(df.format(date));
//	
//		try {
//			Date d = df.parse("2019-09-18");
//			System.out.println(df2.format(d));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//		System.out.println("====================================");

//		Calendar today = Calendar.getInstance();
//		
//		Date d = new Date();
//		
//		System.out.println(today.get(Calendar.YEAR));
//		System.out.println(today.get(Calendar.MONTH));
//		System.out.println(today.get(Calendar.WEEK_OF_YEAR));
//		System.out.println(today.get(Calendar.WEEK_OF_MONTH));
//		System.out.println(today.get(Calendar.DATE));
//		System.out.println(today.get(Calendar.DAY_OF_MONTH));
//		System.out.println(today.get(Calendar.DAY_OF_YEAR));
//		System.out.println(today.get(Calendar.DAY_OF_WEEK));
//		System.out.println(today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
//		System.out.println();
//		System.out.println(today.get(Calendar.HOUR));
//		System.out.println(today.get(Calendar.HOUR_OF_DAY));
//		System.out.println(today.get(Calendar.MINUTE));
//		System.out.println(today.get(Calendar.SECOND));
//		System.out.println(today.get(Calendar.AM_PM));
//		System.out.println(today.get(Calendar.ZONE_OFFSET)/(60*60*1000));
//		System.out.println(today.getActualMaximum(Calendar.DATE));
//		
//		
//		Calendar date1 = Calendar.getInstance();
//		Calendar date2 = Calendar.getInstance();
//		
//		date1.set(2015, 7, 15); //2015-8-15
//		date1.set(Calendar.YEAR, 2015);
//		date1.set(Calendar.MONTH, 7);
//		date1.set(Calendar.DATE, 15);
//		
//		System.out.println("date1:"+toString(date1));
//		System.out.println("date2:"+toString(date2));
//		
//		long difference = (date2.getTimeInMillis() - date1.getTimeInMillis())/1000;
//		System.out.println(difference/(24*60*60));
//		
//		date1.add(Calendar.DATE, 1);
//		System.out.println(toString(date1));
//		date1.roll(Calendar.DATE,31);
//		System.out.println(toString(date1));
//		date1.add(Calendar.DATE, 30);
//		System.out.println(toString(date1));
		
		
		
		
		
		
		
		
		
		
//		System.out.println("============================");
//		String str = "??????, ?????????, ??????, ?????????, ?????????, ??????, ??????";
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
//		System.out.println("==============??????????????????=============");
//		StringTokenizer st = new StringTokenizer(str);
//		System.out.println("st.countTokens() : "+st.countTokens());
//		while(st.hasMoreTokens()) {
//			System.out.println(st.nextToken(",").trim());
//		}
//		System.out.println("==============??????????????????=============");
//		StringTokenizer st2 = new StringTokenizer(str,",");
//		System.out.println("st.countTokens() : "+st2.countTokens());
//		while(st2.hasMoreTokens()) {
//			System.out.println(st2.nextToken().trim());
//		}
//		
//		System.out.println("==============?????????=============");
//		String money = "???????????????????????????";
//		final String UNIT = "??????????????????";
//		final String NUM = "??????????????????????????????";
//		final long[] UNIT_NUM = {10,100,1000,10000,(long) 1e8,(long)1e12};
//		long result =0;
//		long tempResult = 0;
//		long num = 0;
//		
//		
//		StringTokenizer st3 = new StringTokenizer(money,UNIT,true); //???????????????.
//		StringTokenizer st4 = new StringTokenizer(money,UNIT,true);
//		StringTokenizer st5 = new StringTokenizer(money,UNIT,true);
//		while(st3.hasMoreTokens()) {
//			System.out.print(st4.nextToken());
//			String token = st3.nextToken();
//			int check = NUM.indexOf(st5.nextToken());
//			
//			if(check==-1) {
//				if("?????????".indexOf(token)==-1) {
//					//????????????????????????
//					tempResult += (num!=0 ? num :1) * UNIT_NUM[UNIT.indexOf(token)];
//					System.out.println();
//				}else {
//					//???????????????????????? 
//					System.out.print(" @");
//					tempResult += num;
//					result += (tempResult!=0 ? tempResult : 1 )* UNIT_NUM[UNIT.indexOf(token)];
//					tempResult = 0;
//				}
//				num = 0; //?????????
//			}else {
//				//???????????????
//				num = check;
//			}	
//		}//while 
//		System.out.println();
//		System.out.println(result+tempResult+num);
//		System.out.println("===========================");
		
		
		
	}

	private static String toString(Calendar date) {
		
		return date.get(Calendar.YEAR) + "??? "+(date.get(Calendar.MONTH)+1)+" ???"+ date.get(Calendar.DATE)+" ???"; 
	}

}
