package com.shinhan.day05;
//선생님과 Review

// Controller : 사용자가 요청을 하면 처리, 업무는 service를 통해서 수행
public class BookTest_Review {
	public static void main(String[] args) {
		// 배열 생성 : 이름은 하나, 같은 타입의 여러개의 값을 저장, 개수 모르면 생성 불가
	    Book_Review[] b = new Book_Review[5];
		b[0] = new Book_Review("Java Program",30000);
		b[1] = new Book_Review("JSP Program",25000);
		b[2] = new Book_Review("SQL Fundamentals",20000);
		b[3] = new Book_Review("JDBC Program",32000);
		b[4] = new Book_Review("EJB Program",25000);
		
		BookMgr_Review bm = new BookMgr_Review(b);
		bm.printBookList();
		bm.printTotalPrice();
	}
}