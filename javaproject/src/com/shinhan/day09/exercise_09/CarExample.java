package com.shinhan.day09.exercise_09;

class Car {
	class Tire {
	}

	static class Engine {
	}
}

public class CarExample {
	public static void main(String[] args) {
		Car myCar = new Car();
		Car.Tire tire = myCar.new Tire();
		Car.Engine engine = new Car.Engine();
	}
}
