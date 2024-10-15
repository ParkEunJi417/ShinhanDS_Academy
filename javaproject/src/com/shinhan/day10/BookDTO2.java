package com.shinhan.day10;

import lombok.*;

// DTO(Data Transfer Object)
// VO(Value Object)
// Beans(Java Beans → Object)

// @Data가 의미하는 바 : @NoArgsConstructor, @Getter, @Setter, @EqualsAndHashCode, @ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO2 {
	String title;
	int price;
}
