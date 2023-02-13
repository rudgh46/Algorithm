package 공부.Gold3;

import java.util.*;
import java.io.*;

public class Main_10986 { //나머지 합

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long cnt = 0;
		long ans[] = new long[N];
		long comb[] = new long[M];
		
		st = new StringTokenizer(br.readLine());
		ans[0] = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<N; i++) {
			ans[i] = ans[i-1] + Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			int idx = (int) (ans[i] % M); 
			
			if(idx == 0) cnt++;
			
			comb[idx]++;
			
		}
		
		for(int i=0; i<M; i++) {
			if(comb[i]>1) {
				cnt = cnt+ (comb[i] *(comb[i]-1)/2);
			}
		}
		
		System.out.println(cnt);
	}

}
