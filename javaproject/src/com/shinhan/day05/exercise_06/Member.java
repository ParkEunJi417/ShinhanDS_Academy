package com.shinhan.day05.exercise_06;

// DTO(Data Transfer Object): data 전달
// VO(Value Object) : 값 저장

public class Member {
	String name;
	String id;
	String password;
	int age;
	
	public Member(String name, String id){
		this.name=name;
		this.id=id;
	}
}

class MemberService{
	boolean login(String id, String password){
		if(id.equals("hong") && password.equals("12345"))
			return true;
		else
			return false;
	}

	void logout(String id) {
		System.out.println(id+"님이 로그아웃 되었습니다");
	}
}
