package com.shinhan.day08.lab;

public class VolTest {
	public static void main(String args[]) {
		// 배열선언+생성, 연속공간 3개, Volume만 담을 수 있음
		Volume[] v = new Volume[3];
		v[0] = new Speaker();
		v[1] = new Radio();
		v[2] = new TV();
		for (int i = 0; i < v.length; i++) {
			for (int j = 1; j <= 3; j++) {
				v[i].volumeUp(200);
			}
			for (int j = 1; j <= 3; j++) {
				v[i].volumeDown(300);
			}
		}
	}
}
