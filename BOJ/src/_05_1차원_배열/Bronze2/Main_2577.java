package _05_1차원_배열.Bronze2;

import java.util.Scanner;

public class Main_2577 {//숫자의 개수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int sum = A*B*C;
		String line = Integer.toString(sum);
		 
		for(int i=0; i<10; i++) {
			int cnt=0;
			for(int j=0; j<line.length(); j++) {
				if((line.charAt(j)-'0') == i) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}

}
