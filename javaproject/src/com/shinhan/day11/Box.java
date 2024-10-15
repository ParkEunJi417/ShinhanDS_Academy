package com.shinhan.day11;

// 제네릭스 : <T>
// 영문자 대문자 아무거나 사용
// 구체적인 타입은 사용시 결정
public class Box<T,A> {
	// field
	T content;
	A size;
	
	// constructor
	public Box() {
	}
	
	public Box(T content, A size) {
		super();
		this.content = content;
		this.size = size;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public A getSize() {
		return size;
	}

	public void setSize(A size) {
		this.size = size;
	}
	
	Box<T,A> boxing(T content, A size) {
		Box<T,A> aa = new Box<>(content,size);
		return aa;
	}
	
}
