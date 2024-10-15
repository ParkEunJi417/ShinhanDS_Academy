package com.shinhan.day05;
// 선생님과 Review

public class BookMgr_Review {
	Book_Review[] booklist;

	public BookMgr_Review(Book_Review[] booklist) {
		//super();
		this.booklist = booklist;
	}
	
	void printBookList(){
		System.out.println("=== 책 목록 ===");
		
		for(Book_Review book:booklist) {
			System.out.println(book.getTitle());
		}
		System.out.println();
	}
	
	void printTotalPrice() {
		int total=0;
		
		System.out.println("=== 책 가격의 총합 ===");
		
		for(Book_Review book:booklist) 
			total += book.getPrice();
		System.out.printf("전체 책 가격의 합 : %d",total);
	}
}
