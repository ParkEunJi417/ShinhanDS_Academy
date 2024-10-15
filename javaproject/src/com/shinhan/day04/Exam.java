package com.shinhan.day04;

import java.util.Scanner;

public class Exam {
	public static void main(String[] args) {
		//ex5_7();
		//ex5_8();
		ex5_9();
	}
	
	// java.lang 패키지가 아닌 곳에 있는 class들은 반드시 import 후 사용
	private static void ex5_9() {
		int studentCount=0;
		int[] score=null; // null은 아직 결졍된 값이 없음을 의미
		boolean isStop=false;
		Scanner sc = new Scanner(System.in);
		
		while(!isStop) {
			menuDisplay();
			System.out.print("선택>");
			
			int jobSelect = sc.nextInt();
			
//			if(jobSelect==5)
//				break;
			
			switch(jobSelect) {
				case 1->{ 
					studentCount=f_insertCount(sc);
					score=new int[studentCount];
					}
				case 2->{ f_insertScore(sc, score); }
				case 3->{ f_printScore(score); }
				case 4->{ f_display(score); }
				case 5->{ isStop=true;}
				default->{ System.out.println("잘못된 작업선택입니다. 다시 선택해주세요.");}
			}
		}
		
		sc.close();
		}

	private static void f_display(int[] score) {
		int total=0, max=Integer.MIN_VALUE;
		
		if(!f_countCheck(score)) return;
		
		System.out.print("분석>");
		
		for(int data:score) {
			total += data;
			max = data>max?data:max;
		}
		System.out.println("최고 점수:"+max);
		System.out.println("평균 점수:"+(double)total/score.length);
	}

	private static void f_printScore(int[] score) {
		if(!f_countCheck(score)) return;
		
		for(int i=0;i<score.length;i++)
			System.out.printf("score[%d]: %d\n",i,score[i]);
	}

	private static boolean f_countCheck(int[] score) {
		if(score==null) {
			System.out.println("학생수를 먼저 입력해야 합니다.");
			return false;
		}
		else
			return true;		
	}

	private static void f_insertScore(Scanner sc, int[] score) {
//		if(score == null) {
//			System.out.println("학생수를 먼저 입력해야 합니다.");
//			return;
//		}
		
		if(!f_countCheck(score)) return;
		
		for(int i=0;i<score.length;i++)
		{
			System.out.printf("score[%d]:",i);
			score[i]=sc.nextInt();
			sc.nextLine();
		}
		
		for(int num:score)
			System.out.println(num);
	}

	// f_insertCount는 함수 이름
	// Scanner sc2는 매개변수, argument, parameter
	// int는 return 값의 성격
	private static int f_insertCount(Scanner sc2) {
		System.out.print("학생수>");
		return sc2.nextInt();
	}

	private static void menuDisplay() {
		System.out.println("------------------------------------------------------");
		System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
		System.out.println("------------------------------------------------------");		
	}

	private static void ex5_8() {
		int total=0, cnt=0;
		int[][] array = {
				 {95, 86},
				 {83, 92, 96},
				 {78, 83, 93, 87, 88}
				};
		
		for(int[] arr:array) {
			for(int data:arr) {
				total += data;
				cnt++;
			}
		}
		System.out.println("총점:"+total);
		System.out.println("평균:"+(double)total/cnt);
	}

	private static void ex5_7() {
		int max = Integer.MIN_VALUE;
		int[] array = {1,5,3,8,2};
		
		for(int num:array) {
			max=num>max?max:num;
		}
		System.out.println(max);
	}
}
