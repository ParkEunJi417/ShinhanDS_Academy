package com.shinhan.day01;

public class 형변환 {
	public static void main(String[] args) {
		// typeTest();
		// typeTest2();
		// typeTest3();
		// typeTest4();
		//typeTest5();
		//typeTest6();
		typeTest7();
	}

	private static void typeTest7() {
		String score="99";
		/* 기본형 타입은 data를 저장, 정수와 실수타입은 연산 및 비교 가능
		 * Wrapper Class : 기본형 타입 + 기능 추가
		 * 1.byte	→ Byte
		 * 2.short	→ Short
		 * 3.char	→ Character
		 * 4.int	→ Integer
		 * 5.long	→ Long
		 * 6.float	→ Float
		 * 7.double	→ Double
		 * 8.boolean→ Boolean
		 */
		int result = Integer.parseInt(score);
		long result2 = Long.parseLong(score);
		double result3 = Double.parseDouble(score);
		String b = "true";
		
		System.out.println(result+1);
		System.out.println(result2+1);
		System.out.println(result3+1);
		System.out.println(Boolean.parseBoolean(b) == true);
		
		int score2 = 200;
		String score3 = score2 +"";
		String score4 = String.valueOf(score2);
		System.out.println(score3 + 1);
		System.out.println(score4 + 2);
		
		String str = "12.345";
		double f = Double.parseDouble(str);
		System.out.println(f + 10);
	}

	private static void typeTest6() {
		// TODO Auto-generated method stub
		int a=10, b=3;
		System.out.println("더하기:"+(a+b));
		System.out.println("빼기:"+(a-b));
		System.out.println("곱하기:"+a*b);
		System.out.println("몫:"+a/b);
		System.out.println("나머지:"+a%b);
		System.out.println("결과:"+(double)a/b); // 실수/정수 = 실수
	}

	private static void typeTest5() {
		// char는 java의 기본형 타입. 반드시 1문자만 가능. 반드시 '로 작성
		char ch = '자';
		/* String은 java의 class.
		   - java.base 모듈\java.lang 패키지\String.class 
		   - 변경 불가, 고정 문자열 */
		String s1 = "자바"; // 컴파일시점에 객체가 만들어짐, 이미 존재하는 리터럴은 다시 생성 안함
		String s2 = new String("자바"); // 실행 시점에 만들어짐
		String s3 = "자바";
		String s4 = new String("자바");
		String s5 = "이것이 \"자바\"다";
		// """은 17부터인거로
		String s6 = """
				이것이 "자바"다
				{"키":"값"}
				""";

		System.out.println("s1=s3?"+(s1 == s3)); // 주소가 같은가? → 컴파일 시점에 주소가 만들어지기 때문에 같음
		System.out.println("s2=s4?"+(s2 == s4)); // 주소가 같은가? → 실행 시점에 주소가 만들어지기 때문에 다름
		System.out.println("s1.equals(s3)?"+s1.equals(s3));
		
		s1 = s1 + "!!"; // 새로운 주소에 만들어짐
		s3 = s3 + "!!"; // 새로운 주소에 만들어짐
		System.out.println("바뀐 s1과 s3 같은가?"+(s1 == s3)); // 주소가 같은가? → 각자 새로운 주소에 만들어져서 다름
		
		System.out.println("s1의 주소값:"+System.identityHashCode(s1));
		System.out.println("s3의 주소값:"+System.identityHashCode(s3));
	}

	private static void typeTest4() {
		// 예외, char 타입보다 허용 범위가 작은 byte 타입은 char 타입으로 자동변환 될 수 없음
		char c;
		byte b = 97;
		c = (char) b;
		System.out.println(c);
	}

	private static void typeTest3() {
		// 수식에 있는 정수는 int로 변형됨
		byte a = 10, b = 20, c;
		int d;
		c = (byte) (a + b); // 강제형변환
		System.out.println(c);
	}

	private static void typeTest2() {
		// 1.자동형변환 : 큰 타입의 방 = 작은 값
		// 2.강제형변환 : 작은 타입의 방 = (작은타입)큰 값
		// → 데이터 손실 가능성 있음
		// byte(1)<short(2)<int(4)<long(8)<float(4)<double(8)
		// byte(1)<char(2)<int(4)<long(8)<float(4)<double(8)

		byte var1 = 97;
		short var2 = 97; // short, char는 자동 형변환 불가
		char var3 = 'a';
		int var4 = 98;
		long var5 = 97;
		float var6;
		double var7;

		var1 = (byte) var2;
		var3 = (char) var4;
		System.out.println(var1);
		System.out.println(var3);
	}

	private static void typeTest() {
		// 1.자동형변환 : 큰 타입의 방 = 작은 값
		// 2.강제형변환 : 작은 타입의 방 = (작은타입)큰 값
		// byte(1)<short(2)<int(4)<long(8)<float(4)<double(8)
		// <char(2) <

		byte var1 = 97;
		short var2 = 97; // short, char는 자동 형변환 불가
		char var3 = 97;
		int var4 = 97;
		long var5 = 97;
		float var6 = 97;
		double var7 = 97;

		var4 = var1;
		System.out.println(var4);
	}
}
