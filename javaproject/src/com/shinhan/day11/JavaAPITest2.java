package com.shinhan.day11;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.shinhan.day10.Student;



public class JavaAPITest2 {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
//		method1();
//		method2();
//		method3();
//		method4();
//		method5();
//		method6();
		method7();
		method8();
	}

	private static void method8() throws IOException {
		Class cls = JavaAPITest2.class;
		URL url = cls.getResource("img/image.png");
		System.out.println(url.getPath());
		
		InputStream is = cls.getResourceAsStream("img/한글 연습.txt");
		int i;
		
		while((i=is.read())!=-1) {
			System.out.print((char)i);
		}
	}

	private static void method7() {
		method6(CellPhone.class);
		System.out.println("----------------");
		method6(Student.class);
	}

	private static void method6(Class aa) {
//		Class phoneClass = CellPhone.class;
		Field[] arrField = aa.getDeclaredFields();
		for(Field field:arrField) {
			System.out.println(field.getName());
			field.getType();
		}
	}

	private static void method5() {
		String email = "eungiv@naver.com대구=허행운 기자 lucky77@sportsworldi.com";
		String regExp = "\\w+@\\w+.\\w+";
		
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(email);
		
		while(matcher.find()) {
			System.out.println(matcher.group());
		}
	}

	private static void method4() throws ClassNotFoundException {
		// 리플렉션 : class의 메타정보 얻기
		Class<?> cls1 = CellPhone.class;
		Class<?> cls2 = Class.forName("com.shinhan.day11.CellPhone");
		CellPhone phone = new CellPhone("ABC");
		Class<?> cls3 = phone.getClass();
		
		Constructor[] arr1 = cls1.getDeclaredConstructors();
		for(Constructor cons:arr1) {
			System.out.println(cons.getParameterCount());
			
			Class[] aa = cons.getParameterTypes();
			for(Class bb:aa) {
				System.out.println(bb.getName());
			}
			System.out.println("---------------------------");
		}
	}

	private static void method3() {
		String subject = "JavaD";
		// ^ : 시작
		// [^] : 제외
		// $ : 끝
		String regExp1 = "^J\\w+[^ABC]D$";
		boolean result = Pattern.matches(regExp1, subject);
		System.out.println(result);
	}

	private static void method2() {
		String email="eungiv@naver.com";
		String regExp1 = "\\w+[@#]?\\w{5,}\\.\\w*";
		boolean result = Pattern.matches(regExp1, email);
		System.out.println(result);
	}

	private static void method1() {
		// 정규 표현식
		String phoneNumber = "010-1234-5678";
		String regExp1 = "([01]{3})-([0-9]{3,4})-(\\d{4})"; // \\ → \
		
		boolean result = Pattern.matches(regExp1, phoneNumber);
		
		// [] : 선택
		// - : 범위
		// + : 1개 이상
		// * : 0개 이상
		// ? : 0 또는 1개
		// [0-9a-zA-Z] = \w
		// [0-9] = \d
		// . : 임의의 1개 문자
		// () : 그룹
		String email="eungiv@naver.com";
		String regExp2 = "(\\w+)@(\\w+\\.\\w+)";
		result = Pattern.matches(regExp2, email);
		System.out.println(result);
		
		Pattern pattern1 = Pattern.compile(regExp1);
		Pattern pattern2 = Pattern.compile(regExp2);
		
		Matcher matcher1 = pattern1.matcher(phoneNumber);
		Matcher matcher2 = pattern2.matcher(email);	
		
		if(matcher1.find()) {
			System.out.println(matcher1.group()); // 전체
			System.out.println(matcher1.group(1)); // 첫번째 ()
			System.out.println(matcher1.group(2)); // 두번째 ()
			System.out.println(matcher1.group(3)); // 세번째 ()
		}
		while(matcher2.find()) {
			System.out.println(matcher2.group()); // 전체
			System.out.println(matcher2.group(1)); // 첫번째 ()
			System.out.println(matcher2.group(2)); // 두번째 ()
		}
	}
}
