package 공부.Silver5;

import java.util.*;
import java.io.*;

public class Main_2018 { //수들의 합 5

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	
		int cnt = 1;
		int sum = 1;
		
		int start = 1;
		int end = 1;
		
		while(end != N) {
			if(sum == N) {cnt++; end ++; sum += end;}
			else if(sum > N) {sum -= start; start++;}
			else {end++; sum += end;}
		}
		
		System.out.println(cnt);
		
	}

}
