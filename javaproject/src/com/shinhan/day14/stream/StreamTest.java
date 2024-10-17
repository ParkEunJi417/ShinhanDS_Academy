package com.shinhan.day14.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class StreamTest {
	static List<Student> studentList = List.of(
			new Student("홍길동1","남",92),
			new Student("홍길동3","여",88),
			new Student("홍길동2","여",93),
			new Student("홍길동4","남",77),
			new Student("홍길동5","남",50)
			);

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
		f4();
	}
	
	private static void f4() {
		Random random = new Random();
		
		List<Long> scores = new ArrayList<>();
		LongStream.rangeClosed(1, 100000000).forEach(i->{
			scores.add(random.nextLong());
		});
		
		double avg=0;
		long startTime=0;
		long endTime=0;
		long time=0;
		
		startTime=System.nanoTime();
		avg = scores.stream().mapToLong(i->i.longValue()).average().getAsDouble();
		endTime=System.nanoTime();
		time = endTime-startTime;
		// stream():188807300ns
		// parallelStream():110985900ns
		System.out.println("스트림:"+time); 
	}

	private static void f3() {
		Map<String,Double> result = studentList.stream()
				.collect(Collectors.groupingBy(
						s->s.getGender(),Collectors.averagingDouble(s->s.getScore())
						));
		System.out.println(result);
	}

	private static void f2() {
		// 그룹
		Map<String,List<Student>> result = studentList.stream().collect(Collectors.groupingBy(s->s.getGender()));
		List<Student> maleList = result.get("남");
		List<Student> femaleList = result.get("여");
		
		maleList.stream().forEach(s->System.out.println(s));
		System.out.println("------------------------------------------------");
		femaleList.stream().forEach(s->System.out.println(s));
		
		/*for(String key:result.keySet()) {
			System.out.println(result.get(key));
		}*/
	}

	public static void f1() {
		
		studentList.stream()
		.filter(st->st.getGender().equals("남"))
		.forEach(st->System.out.println(st));
		
		
		// 남학생만 map으로 만들기
		Map<String,Integer> map =  studentList.stream()
		.filter(st->st.getGender().equals("남"))
		.collect(Collectors.toMap(st->st.getName(), st->st.getScore()));
		
		Set<Student> set = studentList.stream()
		.filter(st->st.getGender().equals("남"))
		.collect(Collectors.toSet());
		System.out.println(set);
	}
}
