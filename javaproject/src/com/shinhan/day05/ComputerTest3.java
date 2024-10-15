package com.shinhan.day05;

public class ComputerTest3 {
	public static void main(String[] args) {
		Computer c1 = new Computer();
		Computer c2 = new Computer("abc","win");
		Computer c3 = new Computer("ddd","linux",1000);
		System.out.println(Computer.count + "대");
	}
}
