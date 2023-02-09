package 공부.Bronze5;

import java.util.Scanner;

public class Main_2475 { //검증수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int ans = 0;
		int res = 0;
		for(int i=0; i<5; i++) {
			ans = sc.nextInt();
			res += ans*ans;
		}
		System.out.println(res%10);
	}

}
