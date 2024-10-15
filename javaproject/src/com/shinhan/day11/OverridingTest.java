package com.shinhan.day11;

public class OverridingTest {
	public static void main(String args[]) {
		int i = 10;
		int j = 20;

		MySum ms1 = new MySum(i, j);
		MySum ms2 = new MySum(i, j);

		System.out.println(ms1);
		System.out.println(ms2);

		if (ms1.equals(ms2))
			System.out.println("ms1과 ms2의 합계는 동일합니다.");
		else
			System.out.println("ms1과 ms2의 합계는 동일하지 않습니다.");
	}
}

class MySum {
	int first;
	int second;

	MySum(int first, int second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString() {
		return String.valueOf(first+second);
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof MySum)) return false;
		MySum mySum = (MySum) obj;
		
		return toString().equals(mySum.toString());
//		return first+second == mySum.first+mySum.second;
//		return this.equals(mySum); → StackOverflowError
	}
}