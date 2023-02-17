package 공부.Gold5;

import java.io.*;
import java.util.*;

public class Main_2023 { // 신기한 소수
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dfs(2,1);
		dfs(3,1);
		dfs(5,1);
		dfs(7,1);
		
	}

	private static void dfs(int num, int depth) {
		if(depth == N) {
			if(isPrime(num)) {
				System.out.println(num);
			}
			return;
		}
		
		for(int i=1; i<10; i++) {
			if(i%2 == 0) continue;
			if(isPrime(num*10+i)) {
				dfs(num*10+i,depth+1);
			}
		}
	}

	private static boolean isPrime(int num) {
		for(int i=2; i<=num/2; i++) {
			if(num%i == 0)
				return false;
		}
		return true;
	}

}
