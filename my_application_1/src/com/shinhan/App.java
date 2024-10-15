package com.shinhan;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import pack1.A;
import pack2.B;
// JSON(JavaScript Object Notation) : JS형태의 문자열 → """{"":""}"""
public class App {
	
	public static void main(String[] args) throws ParseException {
		String str = """
				{"name":"홍길동", "age":20}
				""";
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(str);
		String name = (String)obj.get("name");
		System.out.println(name);
		Long age = (Long)obj.get("age");
		System.out.println(age);
	}
	
	public static void main2(String[] args) {
		A a = new A();
		a.method();
		
		B b = new B();
		b.method();
	}
}