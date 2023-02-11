package 공부.Silver3;

import java.util.*;
import java.io.*;

public class Main_11659 { //구간 합 구하기4

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int num[] = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			num[i] = num[i-1] +sc.nextInt();
		}
		
		for(int k=0; k<M; k++) {
			int i=sc.nextInt();
			int j=sc.nextInt();
			
			System.out.println(num[j]-num[i-1]);
		}
	}

}
