package com.shinhan.day03;

import java.util.Arrays;

public class LAB5 {
	public static void main(String[] args) {
		/* 1번 문제
		int temp;
		int[] arr= {3,24,1,55,17,43,5};
		
		System.out.println("Before:"+ Arrays.toString(arr));
		
		// 선택정렬(Selection Sort) 오름차순
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length-1;j++) {
				if(arr[i] > arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		
		System.out.println("After:"+ Arrays.toString(arr));
		
		
		//for(int num:arr)
		//	System.out.println(num);
        */
		
		// 2번 문제
		int[][] arr1 = new int[][] {{30,30,30,30}, {40,40,40,40}, {50,50,50,50}};
		int[][] arr2 = new int[][] {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
		int[][] arr3 = new int[3][4];
		
		//static이 없는 경우
		LAB5 aa = new LAB5(); // 객체 생성
		aa.sub(arr1, arr2, arr3);
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
			for(int j=0;j<c[i].length;j++) {
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
	}
}
