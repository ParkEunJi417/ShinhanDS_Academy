package com.shinhan.day01;

/*	프로그램의 시작점은 main()메서드이다.
	format : ctrl + shift + f
	cmd>java FirstClass
 	모듈화 :
*/
public class FirstClass {
	public static void main(String[] args) {
		System.out.println("main시작");
		//함수호출
		f1(); //함수로 갔다가 반드시 돌아옴
		System.out.println("main끝");
	}
	//함수정의
	public static void f1() {
		System.out.println("------------");
		System.out.println("f1시작");
		System.out.println("f1끝");
		System.out.println("------------");
		//return; 안해도 자동으로 리턴됨
	}
}
