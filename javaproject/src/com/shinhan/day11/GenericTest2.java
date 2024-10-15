package com.shinhan.day11;

public class GenericTest2 {

	public static void main(String[] args) {
		makeGoods();
	}

	private static void makeGoods() {
		Goods<TV,String> aa = new Goods<>(new TV(),"A모델");
		Goods<Car,String> bb = new Goods<>(new Car(),"B모델");
		System.out.println(aa);
		System.out.println(bb);
	}

}
