package com.shinhan.day15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
class Member1 implements Serializable {
	private String name;
	private int age;
}

@AllArgsConstructor
@Getter @ToString
class Member2 {
	private String name;
	private String job;
}

public class Review {

	public static void main(String[] args) {
//		f1_ex17_5();
//		f2_ex17_6();
//		f3_ex17_7();
//		f4_ex17_8();
	}

	private static void f4_ex17_8() {
		List<Member2> list = Arrays.asList(new Member2("홍길동", "개발자"), new Member2("김나리", "디자이너"),
				new Member2("신용권", "개발자"));

		Map<String, List<Member2>> groupingMap = list.stream().collect(Collectors.groupingBy(s -> s.getJob()));

		System.out.println("[개발자]");
		groupingMap.get("개발자").stream().forEach(i -> System.out.println(i));

		System.out.println();

		System.out.println("[디자이너]");
		groupingMap.get("디자이너").stream().forEach(i -> System.out.println(i));

	}

	private static void f3_ex17_7() {
		List<Member2> list = Arrays.asList(new Member2("홍길동", "개발자"), new Member2("김나리", "디자이너"),
				new Member2("신용권", "개발자"));

		List<Member2> developers = list.stream().filter(s -> s.getJob().equals("개발자")).toList();

		developers.stream().forEach(m -> System.out.println(m.getName()));
	}

	private static void f2_ex17_6() {
		List<Member1> list = Arrays.asList(new Member1("홍길동", 30), new Member1("신용권", 40), new Member1("감자바", 26));
		double avg = list.stream().mapToInt(m -> m.getAge()).average().orElse(0);
		double avg2 = list.stream().collect(Collectors.averagingDouble(s -> s.getAge()));

		System.out.println("평균 나이: " + avg);
	}

	private static void f1_ex17_5() {
		String[] arr = { "This is a java book", "Lambda Expressions", "Java8 supports lambda expressions" };
		List<String> list2 = Arrays.asList(arr); // Array to List

		List<String> list = Arrays.asList("This is a java book", "Lambda Expressions",
				"Java8 supports lambda expressions");
		list.stream().filter(s -> s.toLowerCase().contains("java")).forEach(s -> System.out.println(s));

	}
}
