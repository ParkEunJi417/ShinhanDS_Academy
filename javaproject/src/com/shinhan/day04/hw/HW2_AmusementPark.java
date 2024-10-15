package com.shinhan.day04.hw;

import java.util.Arrays;
import java.util.Comparator;

public class HW2_AmusementPark {

	public static void main(String[] args) {
		int[] tickets = { 10, 8, 20000 };
        int[][][] requests = { { { 2, 3 }, { 1, 7 }, { 2, 4 }, { 3, 5 } },
                { { 1, 9 }, { 3, 6 }, { 2, 5 } },
                { { 3, 1 }, { 2, 5 }, { 2, 10 }, { 3, 8 }, { 1, 2 } } };

        for (int testcast = 0; testcast < tickets.length; testcast++) {

            System.out.println("-------------------testcast[" + testcast + "]");
            int result = solution(tickets[testcast], requests[testcast]);
            System.out.println(result);

            for(int[] arr:requests[testcast]) {
                System.out.println(Arrays.toString(arr));
            }
        }


    }

    private static int solution(int tickets, int[][] requests) {
    	int total=tickets;
    	int cnt=0;
    	
    	Arrays.sort(requests, new Comparator<int[]>() {
    	    @Override
    	    public int compare(int[] arr1, int[] arr2) {
    	    	return arr1[0]-arr2[0]; 
    	    }
    	});
    	
    	for(int i=0;i<requests.length;i++) {
    		if(total-requests[i][1] >= 0) {
    			total -= requests[i][1];
				cnt += requests[i][1];
    		}
    	}    	
		return cnt;
	}
}
