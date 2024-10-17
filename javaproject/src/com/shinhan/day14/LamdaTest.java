package com.shinhan.day14;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
class Student implements Comparable<Student> {
	private String name;
	private int englishScore;
	private int mathScore;

	public Student(String name, int englishScore, int mathScore) {
		this.name = name;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}

	public String getName() {
		return name;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	@Override
	public int compareTo(Student o) {
		return name.compareTo(o.name);
	}
}

@FunctionalInterface
interface MyConsumer<T> {
	public void accept(T t);
}

interface MySupplier<T>{
	public T get();
}

public class LamdaTest {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f4();
//		f5();
		f6();
	}

	private static void f6() {
		// BiFunction<T,U,R> : T와 U를 연산해서 R을 return 해줌
		BiFunction<Student, String, Double> f = (a,b)->{
			System.out.println(b);
			return (double)(a.getMathScore()+a.getEnglishScore())/2;
		};
		Student s = new Student("kim",100,90);
		double result = f.apply(s, "***");
		System.out.println(result);
	}

	private static void f5() {
		// Function<T,U> : T를 연산해서 U를 return 해줌
		Function<Student, String> f = (st)->st.getName();
		Function<Student, Integer> f2 = (st)->st.getEnglishScore()+st.getMathScore();
		
		Student s = new Student("kim",100,90);
		String result = f.apply(s);
		System.out.println(result);
		
		int result2 = f2.apply(s);
		System.out.println(result2);
	}

	private static void f4() {
		MySupplier<Integer> a = ()->{
			Student s = new Student("kim",100,90);
			return s.getEnglishScore();
		};
		
		Supplier<Integer> b = ()->{
			Student s = new Student("kim",100,90);
			return s.getEnglishScore();
		};
		
		int result = b.get();
		System.out.println(result);
		
		Supplier<String> b2 = ()->{
			Student s = new Student("kim",100,90);
			return s.getName();
		};
		
		String result2 = b2.get();
		System.out.println(result2);
	}

	private static void f2() {
		BiConsumer<String, Student> consumer = (s,st)->{
			System.out.println(s);
			System.out.println(st.getName()+"수학:"+st.getMathScore());
		};
		consumer.accept("*****", new Student("홍길동",100,90));
	}

	private static void f1() {
		MyConsumer<Integer> a1= new MyConsumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t/10);
			}
		};
		MyConsumer<Integer> a2 = (x)->System.out.println(x/5);
		MyConsumer<String> a3 = (x)->System.out.println(x+"**");
		
		a1.accept(100);
		a2.accept(100);
		a3.accept("test");
		///////////////////////////////////////////////////////////////
		Consumer<String> a4 = (x)->System.out.println(x+"**");
		Consumer<Student> a5 = (x)->System.out.println(x+"**");
		a5.accept(new Student("홍길동",100,80));
	}
}
