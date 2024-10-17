package com.shinhan.day14;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
//		method1();
//		method2();
//		method3();
//		method4();
//		method5();
//		method6();
//		method7();
//		method8();
//		method9();
//		method10();
//		method11();
//		method12();
//		method13();
//		method14();
//		method15();
//		method16();
//		method17();
//		method18();
//		method19();
		method20();
	}
	
	private static void method20() {
		ArrayList<String> alist = new ArrayList<String>();
		alist.add("A");
		alist.add("BB");
		alist.add("CCC");
		alist.add("DDDD");
		alist.add("DDDDD");
		System.out.println(alist);
		
		// Set 바꾸기
		Set<String> aset = alist.stream().collect(Collectors.toSet());
		System.out.println(aset);
		
		// Map 바꾸기
//		Map<Integer,String> amap = alist.stream().collect(Collectors.toMap(s->s.length(), s->s+"*"));
		Map<Integer,String> amap = alist.stream().collect(Collectors.toMap(String::length, Function.identity()));
		System.out.println(amap);
	}
	
	private static void method19() {
		List<Student> alist = new ArrayList<>();
		alist.add(new Student("이A",10,20));
		alist.add(new Student("박B",20,20));
		alist.add(new Student("김C",30,20));
		alist.add(new Student("D",40,20));
		alist.add(new Student("신D",40,20));
		
		int total1 = alist.stream().mapToInt(s->s.getEnglishScore()).filter(a->a%2==0).sum();
		int total2 = alist.stream().mapToInt(s->s.getEnglishScore()).filter(a->a%2==0).reduce(0, (a,b)->a+b);
		
		System.out.println(total1);
		System.out.println(total2);
	}
	
	private static void method18() {
		int[] arr= {1,2,3,4,5,6,7,8,9,10};
		OptionalInt op = Arrays.stream(arr).filter(a->a%2==0).reduce((a,b)->a+b);
		int i = op.orElse(0);
		System.out.println(i);
	}
	
	private static void method17() {
		int[] arr= {21,41,61,7};
		
		// 짝수 몇개?
		long result = Arrays.stream(arr).filter(a->a%2==0).count();
		System.out.println("짝수개수:"+result);
		
		long result2 = Arrays.stream(arr).filter(a->a%2==0).sum();
		System.out.println("짝수합계:"+result2);
		
		OptionalDouble result3 = Arrays.stream(arr).filter(a->a%2==0).average();
		// double d = result3.getAsDouble(0); → 없을 경우 오류 발생
		double d = result3.orElse(0);
		System.out.println("짝수평균(OptionalDouble):"+result3);
		System.out.println("짝수평균:"+d);
		System.out.println("합계:"+(result3.isPresent()?result3.getAsDouble():0));
		
		// 최대
		OptionalInt result4 = Arrays.stream(arr).filter(a->a%2==0).max();
		int max = result4.orElse(0);
		System.out.println("최대 수:"+max);
		
		// 첫번째요소
		OptionalInt result5 = Arrays.stream(arr).findFirst();
		int first = result5.orElse(0);
		System.out.println("첫번째 요소:"+first);
	}
	
	private static void method16() {
		int[] arr= {2,4,6,7};
		
		boolean result = Arrays.stream(arr).allMatch(value->value%2==0);
		boolean result2 = Arrays.stream(arr).anyMatch(value->value%2==0);
		boolean result3 = Arrays.stream(arr).noneMatch(value->value%2==0);
		
		System.out.println(result);
		System.out.println(result2);
		System.out.println(result3);
	}

	private static void method15() {
		int[][] arr2 = {
                {10,20}, 
                {1,2,3,4,5,6,7,8,9,10},
                {1},
                {1,2,3}
                };
        Arrays.stream(arr2)
        .filter(aa->aa.length>=2)
        .forEach(row->Arrays.stream(row)
                .forEach(System.out::println));
		
		int[] arr= {1,2,3,4,5,6,7,8,9,10};
		
		int total = Arrays.stream(arr)
			  .filter(i->i%2==0)
			  .peek(i->System.out.println(i))
			  .sum();
		System.out.println(total);
	}
	
	private static void method14() {
		List<Student> alist = new ArrayList<>();
		alist.add(new Student("이A",10,20));
		alist.add(new Student("박B",20,20));
		alist.add(new Student("김C",30,20));
		alist.add(new Student("D",40,20));
		alist.add(new Student("신D",40,20));
		
		alist.stream().sorted().forEach(st->System.out.println(st));
		System.out.println("------------------------------------------------------");
		alist.stream().sorted(Comparator.reverseOrder()).forEach(st->System.out.println(st));
		System.out.println("------------------------------------------------------");
		alist.stream().sorted((a,b)->b.getName().compareTo(a.getName())).forEach(st->System.out.println(st));
	}

	private static void method13() {
		String account = "112-188845-1234-5";
		
		IntStream is = account.chars();
		account.chars().forEach(ch->System.out.println((char)ch));
		
		int total = IntStream.range(1, 11).sum();
		System.out.println(total);
		
	}

	private static void method12() {
		// 규칙 1 : 숫자와 -만 존재
		// 규칙 2 : 숫자는 11개 이상 14개 이하
		// 규칙 3,4 : 0는 0개 이상 3개 이하, 연속하지 않음, 시작과 끝에 없음
		
		String account = "112-188845-1234-5";
		if(!account.matches("[0-9-]+")) {
			System.out.println("규칙1 불만족");
		}

		long count = account.chars().filter(c->Character.isDigit(c)).count();
		if(count < 11L | count > 14L) {
			System.out.println("규칙2 불만족");
		}
		
		long dashCount = account.chars().filter(c->c=='-').count();
		if(dashCount < 0L | dashCount > 3L) {
			System.out.println("규칙3 불만족");
		}
		
		if(account.contains("--") | account.startsWith("-") | account.endsWith("-")) {
			System.out.println("규칙4 불만족");
		}
	}

	private static void method11() {
		List<String> list2 = Arrays.asList("10,20","30,40,50","60,70,80,90,100");
		
		// flatMapToInt : 들어간 값 펼치기, return은 int stream
		list2.stream().flatMapToInt(s->{
			String[] strArr = s.split(",");
			Arrays.stream(s.split(",")).mapToInt(a->Integer.parseInt(a.trim()));
			int[] intArr = new int[strArr.length];
			
			for(int i=0;i<intArr.length;i++) {
				intArr[i] = Integer.parseInt(strArr[i].trim() );
			}
			
			return Arrays.stream(intArr);
		}).forEach(i->System.out.println(i));
		
		double d2 = list2.stream().flatMapToInt(s->Arrays.stream(s.split(","))
								  .mapToInt(a->Integer.parseInt(a.trim()))).average().getAsDouble();
		System.out.println(d2);
	}
	
	private static void method10() {
		List<String> alist = new ArrayList<>();
		alist.add("this is java");
		alist.add("i am a best developer");
		
		String str = "this is java";
		String[] arr=str.split(" ");
		Stream<String> st = Arrays.stream(arr);
		
		alist.stream()
		//.mapToInt(s->s.length())
		.flatMap(s->Arrays.stream(s.split(" ")))
		.forEach(s->System.out.println(s));
	}

	private static void method9() {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		
		Arrays.stream(arr).asDoubleStream().forEach(i->System.out.println(i));
		
		// int → Integer 변환(Boxing)
		Arrays.stream(arr).boxed().forEach(i->System.out.println(i));
	}

	private static void method8() {
		List<Student> alist = new ArrayList<>();
		alist.add(new Student("이A",10,20));
		alist.add(new Student("박B",20,20));
		alist.add(new Student("김C",30,20));
		alist.add(new Student("D",40,20));
		alist.add(new Student("신D",40,20));
		
		alist.stream().mapToInt(st->st.getEnglishScore()).forEach(i->System.out.println("영어점수:"+i));
		alist.stream().mapToInt(st->st.getMathScore()).forEach(i->System.out.println("수학점수:"+i));
		
		// 스트림시작 : alist.stream()
		// 중간처리 : mapToInt(st->st.getEnglishScore()) → 들어간 객체를 int로 변경되어 return
		// 최종처리 : average()
		// Optional ▶ 기본형으로 변경 : getAsDouble()
		double d = alist.stream().mapToInt(st->st.getEnglishScore()).average().getAsDouble();
		System.out.println(d);
	}

	private static void method7() {
		Predicate<Integer> p = a-> a>90;
		System.out.println(p.test(80));
		
		Predicate<Student> p2 = st-> st.getName().length()==3;
		boolean result = p2.test(new Student("bcd",1,2));
		System.out.println(result);
		
		IntPredicate p3 = a-> a>90;
		System.out.println(p3.test(50));
	}
	
	private static void method6() {
		List<Student> alist = new ArrayList<>();
		alist.add(new Student("이A",10,20));
		alist.add(new Student("박B",20,20));
		alist.add(new Student("김C",30,20));
		alist.add(new Student("D",40,20));
		alist.add(new Student("신D",40,20));
		
//		alist.stream().distinct().forEach(st->System.out.println(st));
		
		// filter : 이름이 "신"으로 시작
		alist.stream().filter(st->st.getName().startsWith("신")).forEach(st->System.out.println(st));
		System.out.println("------------------------------------------------------");
		
		// filter : 영어점수가 30점 이상
		// predicate : 조건에 맞는가? return값은 true or false
		// filter : true인 것만 선택
		alist.stream().filter(st->st.getEnglishScore()>=30).forEach(st->System.out.println(st));
	}

	private static void method5() {
		List<Student> alist = new ArrayList<>();
		alist.add(new Student("A",10,20));
		alist.add(new Student("B",20,20));
		alist.add(new Student("C",30,20));
		alist.add(new Student("D",40,20));
		
//		alist.stream().forEach(st->System.out.println(st));
		
		alist.parallelStream().forEach(st->{
			System.out.println(Thread.currentThread().getName()+":"+st);
		});
		
		// 시작처리 : alist.stream()
		// 중간처리 : mapToInt() map은 변형
		// 최종처리 : average()
		OptionalDouble op = alist.stream().mapToInt(st->st.getEnglishScore()).average();
		double result=op.orElse(0);
		System.out.println(result);
	}

	private static void method4() {
		try {
			Path path = Paths.get(StreamTest.class.getResource("aa.txt").toURI());
			System.out.println(path);
			
			// 파일을 스트림으로 얻는 방법
			Files.lines(path).forEach(a->{
				System.out.println(a);
			});
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void method3() {
		// 1 <= IntStream.range(1, 11) < 11
		// 1 <= IntStream.rangeClosed(1, 10) <= 10
		IntStream.range(1, 11).forEach(i->System.out.println(i));
		IntStream.rangeClosed(1, 10).forEach(i->System.out.println(i));
	}

	private static void method2() {
		// 내부반복자
		String[] arr = {"A","B","C","D"};
		Integer[] arr2 = {10,20,30,40,50};
		List<Student> alist = new ArrayList<>();
		Set<Student> aset = new HashSet<>();
		
		alist.add(new Student("A",10,20));
		alist.add(new Student("B",20,20));
		alist.add(new Student("C",30,20));
		alist.add(new Student("D",40,20));
		
		aset.add(new Student("A",10,20));
		aset.add(new Student("B",20,20));
		aset.add(new Student("C",30,20));
		aset.add(new Student("D",40,20));
		
		Arrays.stream(arr).forEach(a->{
			System.out.println(a);
		});
		System.out.println("-----------------------------------");
		Arrays.stream(arr2).forEach(i->System.out.println(i));
		System.out.println("-----------------------------------");
		alist.stream().forEach(st->{
			System.out.println(st);
		});
		System.out.println("-----------------------------------");
		aset.stream().forEach(st->{
			System.out.println(st);
		});
	}

	private static void method1() {
		// 외부반복자
		String[] arr = {"A","B","C","D"};
		
		for(String s:arr) {
			System.out.println(s);
		}
		
		List<String> alist = List.of(arr);
		Iterator<String> it = alist.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
}
