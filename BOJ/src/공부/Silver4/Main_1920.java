package 공부.Silver4;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1920 { //수 찾기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int M = sc.nextInt();
		
		for(int i=0; i<M; i++) {
			int num = sc.nextInt();
			if(binarySearch(arr, num) >= 0) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
	}

	private static int binarySearch(int[] arr, int num) {
		int left = 0;
		int right = arr.length-1;
		
		while(left <= right) {
			int mid = (left + right)/2;
			
			if(num < arr[mid]) {
				right = mid - 1;
				
			} else if(num > arr[mid]) {
				left = mid + 1;
				
			}else {
				return mid;
			}
		}
		return -1;
	}

}
