package com.shinhan.day11.exercise_12;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex16 {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시 mm분");
		Date dte = new Date();
		
		System.out.println(sdf.format(dte));
	}
}
