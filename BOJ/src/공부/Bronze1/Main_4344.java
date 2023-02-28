package 공부.Bronze1;

import java.util.Scanner;

public class Main_4344 { //평균은 넘겠지

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		for(int tc=0; tc<C; tc++) {
			int N = sc.nextInt();
			
			int arr[] = new int[N];
			
			double sum = 0;
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			
			double mean = (sum/N);
			double cnt = 0;
			
			for(int j=0; j<N; j++) {
				if(arr[j] > mean) {
					cnt++;
				}
			}
			
			System.out.printf("%.3f%%\n",(cnt/N)*100);
		}
	}

}
