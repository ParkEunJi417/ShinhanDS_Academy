package com.shinhan.day11;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
//import java.util.Date;
import java.util.StringTokenizer;

import com.shinhan.util.DateUtil;

public class JavaAPITest {
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
//		f8();
//		f9();
//		f10();
//		f11();
//		f12();
//		f13();
//		f14();
//		f15();
//		f16();
		f17();
	}

	private static void f17() {
		SimpleDateFormat sdf = new SimpleDateFormat("오늘은 yyyy년도 E요일");
		java.util.Date d = new java.util.Date();
		String s = sdf.format(d);
		System.out.println(s);
		
		String s2 = "2024-11-15";
		
		java.util.Date d1 = DateUtil.convertDate(s2);
		System.out.println(d1);
		
		String s3 = DateUtil.convertString(d1);
		System.out.println(s3);
		
		java.sql.Date d2 = DateUtil.convertSqlDate(d1);
		System.out.println(d2);
	}

	private static void f16() {
		java.util.Date d1 = new java.util.Date();
		System.out.println(d1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String s = sdf.format(d1);
		System.out.println(s);
		
		String s2 = "2024/11/15";
		SimpleDateFormat sdf2 = new SimpleDateFormat();
		java.util.Date d2;
		
		try {
			d2 = sdf2.parse(s2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void f15() {
		double a = 12345678.9;
		DecimalFormat df = new DecimalFormat("###,###,###.0");
		String result = df.format(a);
		System.out.println(result);
	}

	private static void f14() {
		LocalDateTime d1 = LocalDateTime.now();
		System.out.println(d1);
		
		String[] arr = d1.toString().split("T");
		System.out.println("일자:"+arr[0]);
		System.out.println("시간:"+arr[1]);
		
		LocalDateTime d2 = d1.plusHours(5);
		System.out.println(d2);
	}

	private static void f13() {
		// day10 - DiceGame
	}
	
	private static void f12() {
		Calendar cal = Calendar.getInstance();
		
		System.out.println(cal);
		System.out.println(cal.get(cal.YEAR));
		System.out.println(cal.get(cal.MONTH)+1);
		System.out.println(cal.get(cal.DATE));
		System.out.println(cal.get(cal.DAY_OF_MONTH));
		System.out.println(cal.get(cal.DAY_OF_YEAR));
		System.out.println(cal.get(cal.DAY_OF_WEEK));
		
		int week = cal.get(Calendar.DAY_OF_WEEK);
		String weekName = null;
		switch(week) {
		case Calendar.MONDAY:{weekName="월"; break;}
		case Calendar.TUESDAY:{weekName="화"; break;}
		case Calendar.WEDNESDAY:{weekName="수"; break;}
		case Calendar.THURSDAY:{weekName="목"; break;}
		case Calendar.FRIDAY:{weekName="금"; break;}
		case Calendar.SATURDAY:{weekName="토"; break;}
		case Calendar.SUNDAY:{weekName="일"; break;}
		}
		System.out.println(weekName);
	}

	private static void f11() {
		Date d1 = new Date();
		java.util.Date d2 = new java.util.Date();
		java.sql.Date d3 = new java.sql.Date(d2.getTime());
		
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
	}

	private static void f10() {
		double a = Math.ceil(5.1);
		double b = Math.ceil(5.9);
		System.out.println(a);
		System.out.println(b);
	}

	private static void f9() {
		Integer a = 127;
		Integer b = 127;
		Integer c = 130;
		Integer d = 130;
		
		// AutoBoxing
		// Integer는 -128~127 byte범위는 같은 주소
		System.out.println(a==b?"주소같음":"주소다름");
		System.out.println(c==d?"주소같음":"주소다름");
		System.out.println(a.equals(b)?"내용같음":"내용다름");
		System.out.println(c.equals(d)?"내용같음":"내용다름");
	}

	private static void f8() {
		// 기본형(8가지) : boolean, byte, short, char, int, long, float, double
		int score = 100;
		
		score = score + 99;
		System.out.println(score>100);
		
		// Wrapper Class = 기본형 + 기능
		// AutoBoxing → Integer score2 = new Integer(100);
		Integer score2 = 100;
		
		// UnBoxing → score2.inValue();
		score2 = score2 + 99;
		System.out.println(score2>100);
		float f = score2.floatValue(); // 기능 사용
		
		String score3 = "100";
		Integer score4 = Integer.parseInt(score3)+100; // AutoBoxing
		double score5 = Double.parseDouble(score3)+100;
		System.out.println(score4); // UnBoxing
		System.out.println(score5);
	}

	private static void f7() {
		String names = "자바/Oracle-HTML/CSS#JavaScript Spring*Framework";
		
		StringTokenizer st = new StringTokenizer(names,"/-#\\* "); // → | 로 구분하지 않아도 가능
		StringTokenizer st2 = new StringTokenizer(names); // default는 공백
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

	private static void f6() {
		String names = "자바/Oracle-HTML/CSS#JavaScript Spring*Framework";
		
		// *는 정규표현식에서 의미가 있음(모든의 의미)
		// \* → * ▶ *라는 문자의 의미로 바뀜
		// \\ → \
		// \\* → \* ▶ *문자라는 의미
		String[] arr = names.split("/|-|#| |\\*"); // → | 로 구분해서 작성해야만 됨
		System.out.println(Arrays.toString(arr));
	}

	private static void f5() {
		// String : 고정문자열
		// StringBuffer, StringBuilder : 가변문자열
		
		// 객체 생성 후 사용
//		StringBuilder sb = new StringBuilder("자바");
		StringBuffer sb = new StringBuffer("자바");
		sb.append("--뒤에 추가");
		sb.insert(0, "앞부분에 추가--");
		
		System.out.println(sb);
	}

	private static void f4() {
		String s1="자바";
		String s2="자바";
		
		// String 변경 불가 → 변경이 아니고 새로운 주소가 생김. 메모리 낭비!
		s1=s1+"정복";
		s2=s2+"정복";
		String s3 = new String("자바");
		String s4 = new String("자바");
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
	}

	private static void f3() {
		// String
		String s1="자바";
		String s2="자바";
		String s3= new String("자바");
		byte[] arr1= {97,98,99};
		char[] arr2= {'a','b','c'};
		String s4= call(arr1);
		String s5= call2(arr2);
		
		System.out.println(s4);
		System.out.println(s5);
		
		byte[] arr3 = s1.getBytes();
		System.out.println("문자를 byte[]로 변경"+Arrays.toString(arr3));
		System.out.println(call(arr3));
		
		try {
			// 문자를 byte로 변경(charset:1문자를 2byte(EUC-KR), 3byte(UTF-8) ...)
			byte[] arr4 = s1.getBytes("EUC-KR");
			System.out.println("문자를 byte[]로 변경(EUC-KR):"+Arrays.toString(arr4));
			System.out.println(call(arr4,"EUC-KR"));
			
			byte[] arr5 = s1.getBytes("UTF-8");
			System.out.println("문자를 byte[]로 변경(UTF-8):"+Arrays.toString(arr5));
			System.out.println(call(arr5,"UTF-8"));
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	private static String call(byte[] arr4, String charset) throws UnsupportedEncodingException {
		return new String(arr4,charset);
	}

	private static String call2(char[] arr) {
		return new String(arr);
	}
	
	private static String call(byte[] arr) {
		return new String(arr);
	}

	private static void f2() {
		long a = System.currentTimeMillis();
		for(int i=0; i<1000000; i++) {
			
		}
		long b = System.currentTimeMillis();
		System.out.println(b-a);
	}

	private static void f1() {
		// 표준출력(기본:모니터)
		PrintStream a = System.out;
		a.println("표준출력(기본:모니터)");
		
		PrintStream a2 = System.err;
		a2.println("표준출력(기본:모니터)");
		
		// 표준입력(기본:키보드)
		// IOException : Checked Exception이므로 컴파일시에 check, 반드시 처리 OR throw
		InputStream is = System.in;
		int i=0;
		try {
			i = is.read(); // 1byte씩 읽음 → 한글은 2byte이므로 깨지게 되어버림
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println((char)i);
	}
}
