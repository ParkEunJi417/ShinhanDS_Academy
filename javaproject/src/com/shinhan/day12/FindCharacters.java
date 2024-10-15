package com.shinhan.day12;

public class FindCharacters {
	public static void main(String[] args) {
		FindCharacters fc = new FindCharacters();
		int count = fc.countChar("Boys, be ambitious", 'b');
		System.out.println(count);
	}

	public int countChar(String str, char c) {
		int count=0;
		char[] arr = str.toCharArray();
		for(char ch:arr) {
//			if(ch==c) count++;
			if(Character.toLowerCase(c) == Character.toLowerCase(ch)) count++;
		}
		return count;
	}
}
