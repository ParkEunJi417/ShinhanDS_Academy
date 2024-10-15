package com.shinhan.day09.inner;

// 구현class 만들기
class SearchButtonListener implements Button.ClickListener {

	@Override
	public void onClick() {
		System.out.println("조회합니다");
	}
	
}

class CloseButtonListener implements Button.ClickListener {

	@Override
	public void onClick() {
		System.out.println("창을 닫습니다");
	}
	
}

public class Button {
	private ClickListener myListener;
	
	void setClickListener(ClickListener myListener) {
		this.myListener=myListener;
	}
	
	void click() {
		myListener.onClick();
	}
	
	// 정적 중첩 인터페이스 (static inner interface)
	// static:Button.ClickListener
	// 구현class는 Button.ClickListener 를 구현함
	// 구현class는 반드시 추상메서드들을 구현해야함
	public static interface ClickListener{
		public abstract void onClick();
	}
}
