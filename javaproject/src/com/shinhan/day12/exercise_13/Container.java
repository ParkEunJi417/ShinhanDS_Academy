package com.shinhan.day12.exercise_13;

public class Container<T, V> {
	private T t;
	private V v;

	public void set(T t,V v) {
		this.t=t;
		this.v=v;
	}

	public T getKey() {
		return this.t;
	}

	public V getValue() {
		return this.v;
	}	
}
