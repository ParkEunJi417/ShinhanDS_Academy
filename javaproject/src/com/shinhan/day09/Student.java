package com.shinhan.day09;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// 이미 존재하는 Sort 기준 바꾸기 위해 2개 비교 : Comparator 인터페이스를 구현해야함

// 기본적으로 Object는 비교불가
// 비교 가능한 class 만드려면 반드시 Comparable 인터페이스를 구현해야함
public class Student extends Object implements Comparable<Student>{
	String name;
	int score;
	
//	public Student(String name, int score) {
//		super();
//		this.name=name;
//		this.score=score;
//	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [name=").append(name).append(", score=").append(score).append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Student obj) {
		
		// 1.점수순으로 asc
//		return score-obj.score;
		
		// 2.점수순으로 desc
//		return (score-obj.score)*-1;
		
		// 3.점수가 같으면 이름으로 asc
		int result = (score - obj.score)*-1;
		if(result==0) return name.compareTo(obj.name);
		return result;
	}
	
	
}
