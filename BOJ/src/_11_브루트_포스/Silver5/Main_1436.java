package _11_브루트_포스.Silver5;

import java.util.Scanner;

public class Main_1436 { // 영화감독 숌

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int end = 666;
		int count = 1;
		
		while (count != N) { //count가 N일때까지 end(666) 증가
			end++;
			
			if (Integer.toString(end).contains("666")) { //증가된 end에 666이 포함되어 있는 경우 count 증가
				count++;
			}
		}
		System.out.println(end);

	}
}
