package com.shinhan.day04;

public class BookMgr {
	Book[] booklist;

	public BookMgr(Book[] booklist) {
		this.booklist = booklist;
	}
	
	void printBookList() {
		System.out.println("=== 책 목록 ===");
		
		for(Book b:booklist) {
			System.out.println(b.getTitle());
		}
		System.out.println();
	}
	
	void printTotalPrice() {
		int total=0;
		
		System.out.println("=== 책 가격의 총합 ===");
		
		for(Book b:booklist) 
			total += b.getPrice();
		System.out.println("전체 책 가격의 합 : "+total);
	}
}
