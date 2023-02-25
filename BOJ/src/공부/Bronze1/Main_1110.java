package 공부.Bronze1;

import java.util.Scanner;

public class Main_1110 { //더하기 사이클

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int count = 0;
		int copy = N;
		
		while(true) {
			N = (N%10)*10 + ((N/10)+(N%10))%10;
			count++;
		
			if(N == copy) break;
		}
		System.out.println(count);

	}

}
