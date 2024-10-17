package com.shinhan.day09.exercise_09;

interface Action {
	public void work();
}

public class ActionExample {
	public static void main(String[] args) {
		Action action = new Action() {
			@Override
			public void work() {
				System.out.println("복사를 합니다.");
			}
		};
		action.work();
	}
}
