package _03_for문.Bronze5;

import java.util.Scanner;

public class Main_25314 { //코딩은 체육과목 입니다.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt()/4;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append("long ");
			
			if(i==N-1) {
				sb.append("int");
			}
		}
		System.out.println(sb);
	}

}
