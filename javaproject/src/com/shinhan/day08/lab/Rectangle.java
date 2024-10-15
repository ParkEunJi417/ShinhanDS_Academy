package com.shinhan.day08.lab;

public class Rectangle extends Shape implements Resizable {
	double width, height;

	Rectangle(double w, double h) {
		super(4);
		width = w;
		height = h;
	}

	@Override
	double getArea() {
		return width * height;
	}

	@Override
	double getPerimeter() {
		return 2 * (width + height);
	}

	@Override
	public void resize(double s) {
		width *= s;
		height *= s;
	}

}
