package 공부.Bronze5;

import java.util.Scanner;

public class Main_5597 { //과제 안내신분

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[31];
		for(int i=1; i<=28; i++) {
			arr[sc.nextInt()]++;
		}
		
		for(int i=1; i<arr.length; i++) {
			if(arr[i]==0) System.out.println(i);
		}
	}

}
