package com.shinhan.day10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest {
	public static void main(String[] args) {
		// Stream : 1byte씩
		// Reader,Writer : 2byte씩
		try (FileInputStream fi = new FileInputStream("src/com/shinhan/day10/Student.java")) {

			int i;
			while ((i = fi.read()) != -1) {
				System.out.println((char) i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main5(String[] args) {
		FileInputStream fi = null;
		try {
			int a = 10 / 0;
			fi = new FileInputStream("src/com/shinhan/day10/Student.java");

			// 파일 읽기
//			fi.read();
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없음");
		} catch (FileNotFoundException e) {

		} finally {
			// 자원 반납(file은 close, DB close)
			try {
				if (fi != null)
					fi.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// throws : Exception 처리하지 않고 떠넘기기, 호출한 곳으로 감
	public static void main4(String[] args) throws ClassNotFoundException {
		Class cls = Class.forName("com.shinhan.day10.Student2");

		System.out.println(cls.getModifiers());
		System.out.println(cls.getSimpleName());
	}

	// try~catch~finally : Exception 처리함
	public static void main3(String[] args) {
		try {
			Class cls = Class.forName("com.shinhan.day10.Student");

			System.out.println(cls.getModifiers());
			System.out.println(cls.getSimpleName());
		} catch (ClassNotFoundException e) {

		}
	}

	public static void main2(String[] args) {
//		f1();
//		f2();
//		f3(10);
//		f4();
		try {
			f5();
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않음 → 이름 확인");
		} catch (IOException e) {
			System.out.println("IO 오류");
		}
		System.out.println("---------main END(정상종료)---------");
	}

	private static void f5() throws IOException {
		// 1.RuntimeException(예외처리 필수 아님)
		// 2.일반 Exception(필수) : 컴파일시 Exception 처리가 되어있는지 체크함
		// 1) 내가 처리 2)떠넘김 : 함수의 선언부에 throws 키워드 사용(이 함수를 부른 곳으로 떠넘김)
		FileReader fr = new FileReader("src/com/shinhan/day10/Student.java");
		int i;

		while ((i = fr.read()) != -1) {
			System.out.print((char) i);
		}

		fr.close();
	}

	private static void f4() {
		// 1.RuntimeException(예외처리 필수 아님) : NumberFormatException,
		// ArrayIndexOutOfBoundsException, NullPointerException, ArithmeticException
		// 2.일반 Exception
		// 하위Exception(상단 작성) → 상위Exception(하단 작성) 순서로 작성해야 함
		int a = 10;
		int[] arr = new int[5];
		String score = "100점";

		try {
			int iScore = Integer.parseInt(score);
			arr[5] = 100;
			arr[0] = 100;
			System.out.println(a / 0);
		} catch (NumberFormatException ex) {
			System.out.println("반드시 숫자형태의 문자열이여야 함");
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("index 범위 벗어남");
		} catch (NullPointerException ex) {
			System.out.println("null은 객체가 생성되지 않음을 의미 → 사용 불가");
		} catch (ArithmeticException ex) {
			System.out.println("0으로 나누기 불가");
		} catch (Exception ex) {
			System.out.println("기타 Exception");
		} finally {
			System.out.println("반드시 수행하는 문장들~");
		}
	}

	private static void f3(int b) {
		// 프로그램은 실행하다가 오류가 날 수 있음. 프로그램이 중단됨
		// Exception
		// 1)RuntimeException : 컴파일 시 Exception 처리를 check 하지 않음
		// 2)일반 Exception
		int a = 10;

		// 예외가 발생하면
		try {
			// 예외가 발생할 가능성이 있는 문장들
			System.out.println(a / b);
		} catch (ArithmeticException ex) {
			// 예외처리함
			System.out.println("정수는 0으로 나눌 수 없음" + ex.getMessage());
		} finally {
			System.out.println("예외 발생 여부와 상관없이 항상 수행");
		}

		System.out.println("method END");
	}

	private static void f2() {
		// 프로그램은 실행하다가 오류가 날 수 있음. 프로그램이 중단됨
		// Exception
		// 1)RuntimeException : 컴파일 시 Exception 처리를 check 하지 않음
		// 2)일반 Exception
		int a = 10;
		int b = 0;

		if (b != 0) { // 예외가 발생하지 않도록 로직 수정(오류 처리 로직과 업무 로직이 섞여 있음)
			System.out.println(a / b); // 오류발생(Exception) → 프로그램 중단을 막을 수 있음
		}

		System.out.println("method END");
	}

	private static void f1() {
		// 프로그램은 실행하다가 오류가 날 수 있음. 프로그램이 중단됨
		// Exception
		// 1)RuntimeException : 컴파일 시 Exception 처리를 check 하지 않음
		// 2)일반 Exception
		int a = 10;
		int b = 0;

		System.out.println(a / b);
		System.out.println("method END");
	}

}
