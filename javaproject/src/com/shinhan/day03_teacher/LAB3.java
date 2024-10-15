package com.shinhan.day03_teacher;

import java.util.Arrays;

public class LAB3 {

	public static void main(String[] args) {
		 
	    int[][] arr1 = {{30,30,30,30},{40,40,40,40},{50,50,50,50}};
		int[][] arr2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int[][] arr3 = new int[3][4];
		
		LAB3 aa = new LAB3();
		aa.sub(arr1, arr2,arr3);
		aa.prn(arr3);
	}
	public int[][] sub(int[][] a, int[][] b, int[][] c){
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				c[i][j] = a[i][j] - b[i][j];
			}
		}
		return null;
	}
	public void prn(int[][] c) {
		for(int i=0;i<c.length;i++) {
			/*for(int j=0;j<c[i].length;j++) {
				System.out.print(c[i][j] +" "); 
			}
			System.out.println();
			*/
			System.out.println(Arrays.toString(c[i]));
		}
	}
	private static void f1() {
		//int[] arr = new int[] {3, 24, 1, 55, 17, 43, 5};
		int[] arr = {3, 24, 1, 55, 17, 43, 5};
		System.out.println("before:" + Arrays.toString(arr));		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println("after:" + Arrays.toString(arr));
		/*
		 * 문제1. 주어진 일차원 배열의 내용을 오름차순으로 정렬하는 로직을 작성하시오.
		(단, 로직은 main() 메서드에 작성하고 반드시 이중 for문을 사용하여 구현해야 한다.) 
		[클래스 실행결과]
		1, 3, 5, 17, 24, 43, 55
		 */
		
	}

}
