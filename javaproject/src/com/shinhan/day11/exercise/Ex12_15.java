package com.shinhan.day11.exercise;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class Ex12_15 {
	public static void main(String[] args) {
		LocalDateTime today = LocalDateTime.now();
		LocalDateTime lastDay = LocalDateTime.of(today.getYear(), 12, 31,0,0,0);
		
		long remainDay = today.until(lastDay, ChronoUnit.DAYS);
		System.out.println(remainDay);
	}
}
