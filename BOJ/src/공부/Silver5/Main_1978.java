package 공부.Silver5;

import java.util.*;

public class Main_1978 { // 소수 찾기

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			boolean isPrime = true;
			int num = sc.nextInt();
			
			if(num == 1) {
				continue;
			}
			
			for(int j=2; j<=Math.sqrt(num); j++) {
				if(num % j == 0) {
					isPrime = false;
					break;
				}
			}
			
			if(isPrime) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
