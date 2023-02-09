package _05_1차원_배열.Bronze2;

import java.util.Scanner;

public class Main_2562 { //최댓값

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = Integer.MIN_VALUE;
		int num = 0;
		
		for(int i=0; i<9; i++) {
			int a = sc.nextInt();
			
			if(max < a) {
				max = a;
				num = i+1;
			}
		}
		System.out.println(max);
		System.out.println(num);
	}

}
