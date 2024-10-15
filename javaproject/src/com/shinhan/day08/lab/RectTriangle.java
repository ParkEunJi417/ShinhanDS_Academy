package com.shinhan.day08.lab;

public class RectTriangle extends Shape {
	double width, height;

	RectTriangle(double w, double h) {
		super(3);
		width = w;
		height = h;
	}

	@Override
	double getArea() {
		return width * height / 2;
	}

	@Override
	double getPerimeter() {
		return width + height + Math.sqrt((width * width) + (height * height));
	}

}
