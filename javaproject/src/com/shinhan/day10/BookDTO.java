package com.shinhan.day10;

import lombok.*;

// DTO(Data Transfer Object)
// VO(Value Object)
// Beans(Java Beans → Object)

/*@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookDTO {
	String title;
	int price;
}*/

// record : java16버전부터 생긴 기능 → Constructor, getter, setter, toString, equals 자동 생성
public record BookDTO(String title, int price) {
	
}
