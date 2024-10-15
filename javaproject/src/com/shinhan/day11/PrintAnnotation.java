package com.shinhan.day11;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD}) // 적용대상 : method
@Retention(RetentionPolicy.RUNTIME) // 유지정책 : RUNTIME
public @interface PrintAnnotation {
	int number() default 10;
	String value() default "-";
	
}
