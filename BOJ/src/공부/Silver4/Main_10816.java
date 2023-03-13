package 공부.Silver4;

import java.io.*;
import java.util.*;

public class Main_10816 { //숫자 카드 2

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		/* 카운팅 방식
		int arr[] = new int[20000001];
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken())+10000000;
			arr[num]++;
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken())+10000000;
			sb.append(arr[num]).append(" ");
		}
		System.out.println(sb);
		*/
		
		/*이분탐색 방식*/
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<M; i++) {
			int key = Integer.parseInt(st.nextToken());
			
			sb.append(upperBound(arr,key) - lowerBound(arr,key)).append(" ");
		}
		System.out.println(sb);
		
	}

	private static int lowerBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;
		
		while(lo<hi) {
			int mid = (lo+hi)/2;
			if(key <= arr[mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}

	private static int upperBound(int[] arr, int key) {
		int lo = 0;
		int hi = arr.length;
		
		while(lo < hi) {
			int mid = (lo + hi) / 2;
			
			if(key < arr[mid]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}

}
