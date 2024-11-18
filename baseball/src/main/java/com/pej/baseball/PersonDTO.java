package com.pej.baseball;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString
@Builder
public class PersonDTO {
	String person_id;		// 아이디(pk)
	String person_pw;		// 패스워드
	String person_phone;	// 핸드폰번호
	String person_email;	// 이메일
}
