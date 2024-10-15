package com.shinhan.day07;

import java.util.Objects;

public class Pen extends Object {
	String model;
	int size;
	
	public Pen(String model, int size) {
		super();
		this.model = model;
		this.size = size;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pen [model=")
			   .append(model)
			   .append(", size=")
			   .append(size)
			   .append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(model, size);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) // Pen 내에서 this를 할 때 쓰임. new한 객체가 this
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pen other = (Pen) obj;
		return Objects.equals(model, other.model) && size == other.size;
	}
	
}