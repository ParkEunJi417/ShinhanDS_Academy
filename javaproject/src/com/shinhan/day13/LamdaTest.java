package com.shinhan.day13;

import com.shinhan.day13.exercise_15.Board;

// lamda표현식이 가능한지를 컴파일시에 체크해주는 annotation
// lamda표현식은 Interface가 하나의 추상메서드만 가지고 있는 경우에 가능
@FunctionalInterface
interface MyInterface {
	void method1();
}

// 1.구현class 만들어서 사용하기
class MyClassImpl implements MyInterface {
	public void method1() {
		System.out.println("1.구현class 만들어서 사용하기");
	}
}
//////////////////////////////////////////////////////////////
interface Workable {
	void work(String name, String job);
}

interface Speakable {
	void speak(String content);
}

interface MyCalculator {
	int add(int x, int y);
}

class Person3 {
	// 1. 구현class 2.익명 3.람다
	public void action(Workable workable) {
		workable.work("홍길동", "프로그래밍");
	}

	public void action2(Speakable speakable) {
		speakable.speak("안녕하세요");
	}
}
//////////////////////////////////////////////////////////////
@FunctionalInterface
interface Calculable{
	double calc(double a, double b);
}

class Person4{
	public void action(Calculable calculable) {
		double result = calculable.calc(10, 4);
		System.out.println("result="+result);
	}
}

class Computer2{
	public static double staticMethod(double x, double y) {
		return x+y;
	}
	
	public double instanceMethod(double x, double y) {
		return x*y;
	}
}
//////////////////////////////////////////////////////////////
interface Creatable{
	public abstract Board create(String title, String content);
}

//-----------M A I N-----------
public class LamdaTest {
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
		f5();
	}

	private static void f5() {
		Creatable f = (a,b)->new Board(a,b);
		Creatable f2 = Board::new;
		Board b = f.create("수요일", "마지막 시간");
		System.out.println(b.getTitle()+" / "+b.getContent());
	}

	private static void f4() {
		Person4 p = new Person4();
		p.action((x,y)->x+y);
		p.action((x,y)->x-y);
		p.action(Computer2::staticMethod);
		p.action(Math::max);
		
		Computer2 aa = new Computer2();
		p.action(aa::instanceMethod);
		p.action(Math::max);
	}

	private static void f3() {
		MyCalculator cal = new MyCalculator() {

			@Override
			public int add(int x, int y) {
				return x + y;
			}
		};

		MyCalculator cal2 = (int x, int y)->{
			return x+y;
		};
		
		MyCalculator cal3 = (x,y)->x+y;
		
		System.out.println(cal.add(1, 2));
		System.out.println(cal2.add(1, 2));
		System.out.println(cal3.add(1, 2));
	}

	private static void f2() {
		Person3 p1 = new Person3();
		p1.action((a, b) -> {
			System.out.println(a + "님 ");
			System.out.println(b + " 열심히");
		});

		p1.action((a, b) -> {
			System.out.printf("%s님 %s 열심히\n", a, b);
		});

		p1.action2(a -> System.out.println(a + "!!!"));
		p1.action2(a -> {
			System.out.println(a + "##");
			System.out.println(a + "^^");
		});
	}

	public static void f1(String[] args) {
		work(new MyClassImpl());

		// 2.익명 구현 class 만들기
		work(new MyInterface() {

			@Override
			public void method1() {
				System.out.println("2.익명 구현 class 만들기");
			}

		});

		work(() -> System.out.println("3.람다표현식"));
	}

	private static void work(MyInterface my) {
		my.method1();
	}
}
