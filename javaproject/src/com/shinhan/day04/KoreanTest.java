package com.shinhan.day04;

public class KoreanTest {

	public static void main(String[] args) {
		Korean k1 = new Korean("홍길동","12345");

//		System.out.println(k1.nation); → private 선언으로 정보은닉되어있기 때문에 불가
		System.out.println(k1.getNation()); // 함수를 이용하기
		
		k1.setNation("미국");
		k1.setName("홍길동2");
		k1.setSsn("1234567890");
		System.out.println(k1.getNation());
		System.out.println(k1.getName());
		System.out.println(k1.getSsn());
	}

}
