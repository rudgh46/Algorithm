package 공부.Gold4;

import java.util.*;
import java.io.*;

public class Main_1253 { //좋다

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long num[] = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(num);
		
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			
			int start = 0;
			int end = N-1;
			
			while(true) {
				if(start == i) {
					start++;
				} else if(end == i) {
					end--;
				} if(start >= end) {
					break;
				}
				if(num[start] + num[end] > num[i]) end--;
				else if(num[start] + num[end] < num[i]) start++;
				else {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}

}
