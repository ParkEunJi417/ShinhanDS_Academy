package com.shinhan.day11;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationTest {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class cls = Service.class;
		
		Method[] arr = cls.getDeclaredMethods();
		for(Method method:arr) {
			PrintAnnotation print = method.getAnnotation(PrintAnnotation.class);
			System.out.println(method.getName());
			display(print);
//			method.invoke(new Service()); // 함수 호출
		}
	}

	private static void display(PrintAnnotation print) {
		int count = print.number();
		String ch = print.value();
		
		for(int i=1;i<=count;i++) {
			System.out.print(ch);
		}
		System.out.println();
	}
}
