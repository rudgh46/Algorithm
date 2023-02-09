package IM_Test.Bronze2;

import java.util.Scanner;

/*
  [입력]
첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.

  [출력]
만들 수 있는 직사각형의 개수를 출력한다.
 */
public class Main_8320 {//직사각형을 만드는 방법

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int cnt = 0;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				if(i*j <= n) cnt++;
			}
		}
		System.out.println(cnt);
	}

}
