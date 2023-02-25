package 공부.Silver3;

import java.util.Scanner;
/*
  [입력]
첫째 줄에는 수열의 길이 N이 주어지고, 둘째 줄에는 N개의 숫자가 빈칸을 사이에 두고 주어진다. N은 1 이상 100,000 이하의 정수이다.

  [출력]
첫째 줄에 가장 긴 길이를 출력한다.
 */
public class Main_2491 {//수열

	public static void main(String[] args) {
//		================  입력   ===============
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int max = 1;
		int max2 = 1;
		int len = 1;
		int len2 = 1;
		int arr[]= new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
//		================  풀이   ===============
		for(int i=0; i<N-1; i++) { //증가
			if(arr[i]<=arr[i+1]) len++;
			else len = 1;
			max = Math.max(max, len);
		}
		
		for(int i=0; i<N-1; i++) { //감소
			if(arr[i]>=arr[i+1]) len2++;
			else len2 = 1;
			max2 = Math.max(max2, len2);
			
		}
		
//		================  출력   ===============
		System.out.println(Math.max(max, max2));
	}

}
