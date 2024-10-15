package com.shinhan.day09.inner;

public class App {
	public static void main(String[] args) {
		Button 조회 = new Button();
		Button 닫기 = new Button();
		
		Button.ClickListener aa= new SearchButtonListener();
		Button.ClickListener bb= new CloseButtonListener();
		
		action(aa);
		action(bb);
		action(new SearchButtonListener());
		
		// 익명 구현 클래스
		Button.ClickListener cc =
				new Button.ClickListener() {
					void call() {
						System.out.println("익명 구현 class에서 함수 추가");
					}
					
					@Override
					public void onClick() {
						System.out.println("익명 구현 class 만들기 → onClick() 재정의");
						call(); // 내부에서만 사용 가능
					}
				};
		action(cc);
		action(new Button.ClickListener() {
			@Override
			public void onClick() {
				System.out.println("익명 구현 class 만들기2 → onClick() 재정의");
			}
		});
		
		/* new 객체 생성 후 부르기
		Button.ClickListener aa= new SearchButtonListener();
		조회.setClickListener(aa);
		조회.click();
		
		Button.ClickListener bb= new CloseButtonListener();
		조회.setClickListener(bb);
		조회.click();
		*/
	}
	
	public static void action(Button.ClickListener listener) {
		Button random = new Button();
		random.setClickListener(listener);
		random.click();
	}
}
