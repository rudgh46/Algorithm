package 공부.Silver4;

import java.util.*;
import java.io.*;

public class Main_1940 { //주몽

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int num[] = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		int cnt = 0;
		int start = 0;
		int end = N-1;
		
		while(start < end) {
			if(num[start] + num[end] < M) {start++;}
			else if(num[start] + num[end] > M) {end--;}
			else {cnt++; start++; end--;}
		}
		
		System.out.println(cnt);
	}

}
