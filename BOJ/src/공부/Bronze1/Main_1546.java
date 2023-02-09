package 공부.Bronze1;

import java.util.Scanner;

public class Main_1546 {//평균

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double arr[] = new double[N];
		double max = -1;
		double sum = 0;
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextDouble();
			max = Math.max(max, arr[i]);
		}
		for(int i=0; i<N; i++) {			
			arr[i] = arr[i]/max*100;
			sum += arr[i];
		}
		
		System.out.println(sum/N);
		
	}

}
