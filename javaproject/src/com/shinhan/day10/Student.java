package com.shinhan.day10;

import lombok.*;

// 롬복 라이브러리는 컴파일시 자동으로 메서드들을 생성해줌
// JavaBeans기술 : 기본 생성자 필수, field는 private, Getter/Setter
@ToString(of = {"name","major"})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"name"})

public class Student {
	private String name;
	private int score;
	private String major;		
}
