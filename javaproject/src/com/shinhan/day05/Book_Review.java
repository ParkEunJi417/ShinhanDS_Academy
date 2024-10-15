package com.shinhan.day05;
//선생님과 Review

// DTO(Data Transfer Object) : data를 저장 후 이동시 사용하는 객체
// VO(Value Object) : data를 저장, C언어의 structure와 비슷
// field + constructor+getter/setter
public class Book_Review {
	private String title;
	private int price;
	
	public Book_Review(String title, int price) {
		//super();
		this.title = title;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
