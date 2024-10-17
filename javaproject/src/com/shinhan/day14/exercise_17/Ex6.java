package com.shinhan.day14.exercise_17;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Member {
	private String name;
	private int age;

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}

public class Ex6 {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(new Member("홍길동", 30), new Member("신용권", 40), new Member("감자바", 26));
		double avg = list.stream().collect(Collectors.averagingDouble(s->s.getAge()));

		System.out.println("평균 나이: " + avg);
	}
}
